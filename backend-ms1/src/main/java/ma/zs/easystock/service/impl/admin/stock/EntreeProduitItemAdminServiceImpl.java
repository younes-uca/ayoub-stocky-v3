package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.EntreeProduitItem;
import ma.zs.easystock.dao.criteria.core.stock.EntreeProduitItemCriteria;
import ma.zs.easystock.dao.facade.core.stock.EntreeProduitItemDao;
import ma.zs.easystock.dao.specification.core.stock.EntreeProduitItemSpecification;
import ma.zs.easystock.service.facade.admin.stock.EntreeProduitItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.bean.core.stock.Produit ;
import ma.zs.easystock.service.facade.admin.entree.EntreeProduitAdminService ;
import ma.zs.easystock.bean.core.entree.EntreeProduit ;

import java.util.List;
@Service
public class EntreeProduitItemAdminServiceImpl extends AbstractServiceImpl<EntreeProduitItem, EntreeProduitItemCriteria, EntreeProduitItemDao> implements EntreeProduitItemAdminService {






    public List<EntreeProduitItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitReference(String reference){
        return dao.countByProduitReference(reference);
    }
    public List<EntreeProduitItem> findByEntreeProduitId(Long id){
        return dao.findByEntreeProduitId(id);
    }
    public int deleteByEntreeProduitId(Long id){
        return dao.deleteByEntreeProduitId(id);
    }
    public long countByEntreeProduitReference(String reference){
        return dao.countByEntreeProduitReference(reference);
    }






    public void configure() {
        super.configure(EntreeProduitItem.class, EntreeProduitItemSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private EntreeProduitAdminService entreeProduitService ;

    public EntreeProduitItemAdminServiceImpl(EntreeProduitItemDao dao) {
        super(dao);
    }

}
