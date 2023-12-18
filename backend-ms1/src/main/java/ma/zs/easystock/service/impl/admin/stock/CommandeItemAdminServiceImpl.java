package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.CommandeItem;
import ma.zs.easystock.dao.criteria.core.stock.CommandeItemCriteria;
import ma.zs.easystock.dao.facade.core.stock.CommandeItemDao;
import ma.zs.easystock.dao.specification.core.stock.CommandeItemSpecification;
import ma.zs.easystock.service.facade.admin.stock.CommandeItemAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.bean.core.stock.Produit ;
import ma.zs.easystock.service.facade.admin.stock.CommandeAdminService ;
import ma.zs.easystock.bean.core.stock.Commande ;
import ma.zs.easystock.service.facade.admin.stock.TaxeAdminService ;
import ma.zs.easystock.bean.core.stock.Taxe ;

import java.util.List;
@Service
public class CommandeItemAdminServiceImpl extends AbstractServiceImpl<CommandeItem, CommandeItemCriteria, CommandeItemDao> implements CommandeItemAdminService {






    public List<CommandeItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitReference(String reference){
        return dao.countByProduitReference(reference);
    }
    public List<CommandeItem> findByTaxeId(Long id){
        return dao.findByTaxeId(id);
    }
    public int deleteByTaxeId(Long id){
        return dao.deleteByTaxeId(id);
    }
    public long countByTaxeId(Long id){
        return dao.countByTaxeId(id);
    }
    public List<CommandeItem> findByCommandeId(Long id){
        return dao.findByCommandeId(id);
    }
    public int deleteByCommandeId(Long id){
        return dao.deleteByCommandeId(id);
    }
    public long countByCommandeNumeroCommande(String numeroCommande){
        return dao.countByCommandeNumeroCommande(numeroCommande);
    }






    public void configure() {
        super.configure(CommandeItem.class, CommandeItemSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private CommandeAdminService commandeService ;
    @Autowired
    private TaxeAdminService taxeService ;

    public CommandeItemAdminServiceImpl(CommandeItemDao dao) {
        super(dao);
    }

}
