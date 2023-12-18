package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.DevisItem;
import ma.zs.easystock.dao.criteria.core.stock.DevisItemCriteria;
import ma.zs.easystock.dao.facade.core.stock.DevisItemDao;
import ma.zs.easystock.dao.specification.core.stock.DevisItemSpecification;
import ma.zs.easystock.service.facade.admin.stock.DevisItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.DevisAdminService ;
import ma.zs.easystock.bean.core.stock.Devis ;
import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.bean.core.stock.Produit ;
import ma.zs.easystock.service.facade.admin.stock.TaxeAdminService ;
import ma.zs.easystock.bean.core.stock.Taxe ;

import java.util.List;
@Service
public class DevisItemAdminServiceImpl extends AbstractServiceImpl<DevisItem, DevisItemCriteria, DevisItemDao> implements DevisItemAdminService {






    public List<DevisItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitReference(String reference){
        return dao.countByProduitReference(reference);
    }
    public List<DevisItem> findByTaxeId(Long id){
        return dao.findByTaxeId(id);
    }
    public int deleteByTaxeId(Long id){
        return dao.deleteByTaxeId(id);
    }
    public long countByTaxeId(Long id){
        return dao.countByTaxeId(id);
    }
    public List<DevisItem> findByDevisId(Long id){
        return dao.findByDevisId(id);
    }
    public int deleteByDevisId(Long id){
        return dao.deleteByDevisId(id);
    }
    public long countByDevisNumero(String numero){
        return dao.countByDevisNumero(numero);
    }






    public void configure() {
        super.configure(DevisItem.class, DevisItemSpecification.class);
    }


    @Autowired
    private DevisAdminService devisService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private TaxeAdminService taxeService ;

    public DevisItemAdminServiceImpl(DevisItemDao dao) {
        super(dao);
    }

}
