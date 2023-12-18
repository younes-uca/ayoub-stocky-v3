package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.AvoirVenteItem;
import ma.zs.easystock.dao.criteria.core.stock.AvoirVenteItemCriteria;
import ma.zs.easystock.dao.facade.core.stock.AvoirVenteItemDao;
import ma.zs.easystock.dao.specification.core.stock.AvoirVenteItemSpecification;
import ma.zs.easystock.service.facade.admin.stock.AvoirVenteItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.bean.core.commun.Depot ;
import ma.zs.easystock.service.facade.admin.stock.AvoirVenteAdminService ;
import ma.zs.easystock.bean.core.stock.AvoirVente ;
import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.bean.core.stock.Produit ;
import ma.zs.easystock.service.facade.admin.stock.TaxeAdminService ;
import ma.zs.easystock.bean.core.stock.Taxe ;

import java.util.List;
@Service
public class AvoirVenteItemAdminServiceImpl extends AbstractServiceImpl<AvoirVenteItem, AvoirVenteItemCriteria, AvoirVenteItemDao> implements AvoirVenteItemAdminService {





    public AvoirVenteItem findByReferenceEntity(AvoirVenteItem t){
        return  dao.findByBarCode(t.getBarCode());
    }

    public List<AvoirVenteItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }
    public List<AvoirVenteItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitReference(String reference){
        return dao.countByProduitReference(reference);
    }
    public List<AvoirVenteItem> findByTaxeId(Long id){
        return dao.findByTaxeId(id);
    }
    public int deleteByTaxeId(Long id){
        return dao.deleteByTaxeId(id);
    }
    public long countByTaxeId(Long id){
        return dao.countByTaxeId(id);
    }
    public List<AvoirVenteItem> findByAvoirVenteId(Long id){
        return dao.findByAvoirVenteId(id);
    }
    public int deleteByAvoirVenteId(Long id){
        return dao.deleteByAvoirVenteId(id);
    }
    public long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        return dao.countByAvoirVenteNumeroFactureAvoirVente(numeroFactureAvoirVente);
    }

    public List<AvoirVenteItem> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(AvoirVenteItem.class, AvoirVenteItemSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private AvoirVenteAdminService avoirVenteService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private TaxeAdminService taxeService ;

    public AvoirVenteItemAdminServiceImpl(AvoirVenteItemDao dao) {
        super(dao);
    }

}
