package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.dao.criteria.core.stock.ProduitCriteria;
import ma.zs.easystock.dao.facade.core.stock.ProduitDao;
import ma.zs.easystock.dao.specification.core.stock.ProduitSpecification;
import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.service.facade.admin.commun.MarqueAdminService ;
import ma.zs.easystock.bean.core.commun.Marque ;
import ma.zs.easystock.service.facade.admin.commun.CategorieAdminService ;
import ma.zs.easystock.bean.core.commun.Categorie ;
import ma.zs.easystock.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete ;
import ma.zs.easystock.service.facade.admin.commun.UniteMesureAdminService ;
import ma.zs.easystock.bean.core.commun.UniteMesure ;
import ma.zs.easystock.service.facade.admin.stock.StockAdminService ;
import ma.zs.easystock.bean.core.stock.Stock ;

import java.util.List;
@Service
public class ProduitAdminServiceImpl extends AbstractServiceImpl<Produit, ProduitCriteria, ProduitDao> implements ProduitAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Produit create(Produit t) {
    
        if (t.getStocks() != null) {
                t.getStocks().forEach(element-> {
                    element.setProduit(t);
                    stockService.create(element);
            });
        }
        return t;

    }

    public Produit findWithAssociatedLists(Long id){
        Produit result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setStocks(stockService.findByProduitId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        stockService.deleteByProduitId(id);
    }


    public void updateWithAssociatedLists(Produit produit){
    if(produit !=null && produit.getId() != null){
            List<List<Stock>> resultStocks= stockService.getToBeSavedAndToBeDeleted(stockService.findByProduitId(produit.getId()),produit.getStocks());
            stockService.delete(resultStocks.get(1));
            ListUtil.emptyIfNull(resultStocks.get(0)).forEach(e -> e.setProduit(produit));
            stockService.update(resultStocks.get(0),true);
    }
    }



    public Produit findByReferenceEntity(Produit t){
        return  dao.findByReference(t.getReference());
    }

    public List<Produit> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Produit> findByCategorieId(Long id){
        return dao.findByCategorieId(id);
    }
    public int deleteByCategorieId(Long id){
        return dao.deleteByCategorieId(id);
    }
    public long countByCategorieLibelle(String libelle){
        return dao.countByCategorieLibelle(libelle);
    }
    public List<Produit> findByMarqueId(Long id){
        return dao.findByMarqueId(id);
    }
    public int deleteByMarqueId(Long id){
        return dao.deleteByMarqueId(id);
    }
    public long countByMarqueLibelle(String libelle){
        return dao.countByMarqueLibelle(libelle);
    }
    public List<Produit> findByUniteMesureId(Long id){
        return dao.findByUniteMesureId(id);
    }
    public int deleteByUniteMesureId(Long id){
        return dao.deleteByUniteMesureId(id);
    }
    public long countByUniteMesureLibelle(String libelle){
        return dao.countByUniteMesureLibelle(libelle);
    }

    public List<Produit> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Produit.class, ProduitSpecification.class);
    }


    @Autowired
    private MarqueAdminService marqueService ;
    @Autowired
    private CategorieAdminService categorieService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private UniteMesureAdminService uniteMesureService ;
    @Autowired
    private StockAdminService stockService ;

    public ProduitAdminServiceImpl(ProduitDao dao) {
        super(dao);
    }

}
