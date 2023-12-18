package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.AvoirAchatItem;
import ma.zs.easystock.dao.criteria.core.stock.AvoirAchatItemCriteria;
import ma.zs.easystock.dao.facade.core.stock.AvoirAchatItemDao;
import ma.zs.easystock.dao.specification.core.stock.AvoirAchatItemSpecification;
import ma.zs.easystock.service.facade.admin.stock.AvoirAchatItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.bean.core.commun.Depot ;
import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.bean.core.stock.Produit ;
import ma.zs.easystock.service.facade.admin.stock.AvoirAchatAdminService ;
import ma.zs.easystock.bean.core.stock.AvoirAchat ;
import ma.zs.easystock.service.facade.admin.stock.TaxeAdminService ;
import ma.zs.easystock.bean.core.stock.Taxe ;

import java.util.List;
@Service
public class AvoirAchatItemAdminServiceImpl extends AbstractServiceImpl<AvoirAchatItem, AvoirAchatItemCriteria, AvoirAchatItemDao> implements AvoirAchatItemAdminService {





    public AvoirAchatItem findByReferenceEntity(AvoirAchatItem t){
        return  dao.findByBarCode(t.getBarCode());
    }

    public List<AvoirAchatItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }
    public List<AvoirAchatItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitReference(String reference){
        return dao.countByProduitReference(reference);
    }
    public List<AvoirAchatItem> findByTaxeId(Long id){
        return dao.findByTaxeId(id);
    }
    public int deleteByTaxeId(Long id){
        return dao.deleteByTaxeId(id);
    }
    public long countByTaxeId(Long id){
        return dao.countByTaxeId(id);
    }
    public List<AvoirAchatItem> findByAvoirAchatId(Long id){
        return dao.findByAvoirAchatId(id);
    }
    public int deleteByAvoirAchatId(Long id){
        return dao.deleteByAvoirAchatId(id);
    }
    public long countByAvoirAchatNumeroFactureAvoirFournisseur(String numeroFactureAvoirFournisseur){
        return dao.countByAvoirAchatNumeroFactureAvoirFournisseur(numeroFactureAvoirFournisseur);
    }

    public List<AvoirAchatItem> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(AvoirAchatItem.class, AvoirAchatItemSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;
    @Autowired
    private TaxeAdminService taxeService ;

    public AvoirAchatItemAdminServiceImpl(AvoirAchatItemDao dao) {
        super(dao);
    }

}
