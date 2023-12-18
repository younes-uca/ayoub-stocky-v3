package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.Commande;
import ma.zs.easystock.dao.criteria.core.stock.CommandeCriteria;
import ma.zs.easystock.dao.facade.core.stock.CommandeDao;
import ma.zs.easystock.dao.specification.core.stock.CommandeSpecification;
import ma.zs.easystock.service.facade.admin.stock.CommandeAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.service.facade.admin.commun.ClientAdminService ;
import ma.zs.easystock.bean.core.commun.Client ;
import ma.zs.easystock.service.facade.admin.stock.CommandeItemAdminService ;
import ma.zs.easystock.bean.core.stock.CommandeItem ;
import ma.zs.easystock.service.facade.admin.commun.EtatCommandeAdminService ;
import ma.zs.easystock.bean.core.commun.EtatCommande ;

import java.util.List;
@Service
public class CommandeAdminServiceImpl extends AbstractServiceImpl<Commande, CommandeCriteria, CommandeDao> implements CommandeAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Commande create(Commande t) {
    
        if (t.getCommandeItems() != null) {
                t.getCommandeItems().forEach(element-> {
                    element.setCommande(t);
                    commandeItemService.create(element);
            });
        }
        return t;

    }

    public Commande findWithAssociatedLists(Long id){
        Commande result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setCommandeItems(commandeItemService.findByCommandeId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        commandeItemService.deleteByCommandeId(id);
    }


    public void updateWithAssociatedLists(Commande commande){
    if(commande !=null && commande.getId() != null){
            List<List<CommandeItem>> resultCommandeItems= commandeItemService.getToBeSavedAndToBeDeleted(commandeItemService.findByCommandeId(commande.getId()),commande.getCommandeItems());
            commandeItemService.delete(resultCommandeItems.get(1));
            ListUtil.emptyIfNull(resultCommandeItems.get(0)).forEach(e -> e.setCommande(commande));
            commandeItemService.update(resultCommandeItems.get(0),true);
    }
    }



    public Commande findByReferenceEntity(Commande t){
        return  dao.findByNumeroCommande(t.getNumeroCommande());
    }

    public List<Commande> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientTelephone(String telephone){
        return dao.countByClientTelephone(telephone);
    }
    public List<Commande> findByEtatCommandeId(Long id){
        return dao.findByEtatCommandeId(id);
    }
    public int deleteByEtatCommandeId(Long id){
        return dao.deleteByEtatCommandeId(id);
    }
    public long countByEtatCommandeId(Long id){
        return dao.countByEtatCommandeId(id);
    }

    public List<Commande> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Commande.class, CommandeSpecification.class);
    }


    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private CommandeItemAdminService commandeItemService ;
    @Autowired
    private EtatCommandeAdminService etatCommandeService ;

    public CommandeAdminServiceImpl(CommandeDao dao) {
        super(dao);
    }

}
