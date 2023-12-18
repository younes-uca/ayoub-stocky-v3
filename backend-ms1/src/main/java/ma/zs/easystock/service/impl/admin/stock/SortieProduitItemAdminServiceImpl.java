package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.SortieProduitItem;
import ma.zs.easystock.dao.criteria.core.stock.SortieProduitItemCriteria;
import ma.zs.easystock.dao.facade.core.stock.SortieProduitItemDao;
import ma.zs.easystock.dao.specification.core.stock.SortieProduitItemSpecification;
import ma.zs.easystock.service.facade.admin.stock.SortieProduitItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.entree.SortieProduitAdminService ;
import ma.zs.easystock.bean.core.entree.SortieProduit ;
import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.bean.core.stock.Produit ;

import java.util.List;
@Service
public class SortieProduitItemAdminServiceImpl extends AbstractServiceImpl<SortieProduitItem, SortieProduitItemCriteria, SortieProduitItemDao> implements SortieProduitItemAdminService {






    public List<SortieProduitItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitReference(String reference){
        return dao.countByProduitReference(reference);
    }
    public List<SortieProduitItem> findBySortieProduitId(Long id){
        return dao.findBySortieProduitId(id);
    }
    public int deleteBySortieProduitId(Long id){
        return dao.deleteBySortieProduitId(id);
    }
    public long countBySortieProduitReference(String reference){
        return dao.countBySortieProduitReference(reference);
    }






    public void configure() {
        super.configure(SortieProduitItem.class, SortieProduitItemSpecification.class);
    }


    @Autowired
    private SortieProduitAdminService sortieProduitService ;
    @Autowired
    private ProduitAdminService produitService ;

    public SortieProduitItemAdminServiceImpl(SortieProduitItemDao dao) {
        super(dao);
    }

}
