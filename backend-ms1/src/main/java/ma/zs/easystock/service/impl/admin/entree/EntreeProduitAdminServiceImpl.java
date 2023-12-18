package ma.zs.easystock.service.impl.admin.entree;


import ma.zs.easystock.bean.core.entree.EntreeProduit;
import ma.zs.easystock.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zs.easystock.dao.facade.core.entree.EntreeProduitDao;
import ma.zs.easystock.dao.specification.core.entree.EntreeProduitSpecification;
import ma.zs.easystock.service.facade.admin.entree.EntreeProduitAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.bean.core.commun.Depot ;
import ma.zs.easystock.service.facade.admin.commun.FournisseurAdminService ;
import ma.zs.easystock.bean.core.commun.Fournisseur ;
import ma.zs.easystock.service.facade.admin.stock.EntreeProduitItemAdminService ;
import ma.zs.easystock.bean.core.stock.EntreeProduitItem ;

import java.util.List;
@Service
public class EntreeProduitAdminServiceImpl extends AbstractServiceImpl<EntreeProduit, EntreeProduitCriteria, EntreeProduitDao> implements EntreeProduitAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EntreeProduit create(EntreeProduit t) {
    
        if (t.getEntreeProduitItems() != null) {
                t.getEntreeProduitItems().forEach(element-> {
                    element.setEntreeProduit(t);
                    entreeProduitItemService.create(element);
            });
        }
        return t;

    }

    public EntreeProduit findWithAssociatedLists(Long id){
        EntreeProduit result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setEntreeProduitItems(entreeProduitItemService.findByEntreeProduitId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        entreeProduitItemService.deleteByEntreeProduitId(id);
    }


    public void updateWithAssociatedLists(EntreeProduit entreeProduit){
    if(entreeProduit !=null && entreeProduit.getId() != null){
            List<List<EntreeProduitItem>> resultEntreeProduitItems= entreeProduitItemService.getToBeSavedAndToBeDeleted(entreeProduitItemService.findByEntreeProduitId(entreeProduit.getId()),entreeProduit.getEntreeProduitItems());
            entreeProduitItemService.delete(resultEntreeProduitItems.get(1));
            ListUtil.emptyIfNull(resultEntreeProduitItems.get(0)).forEach(e -> e.setEntreeProduit(entreeProduit));
            entreeProduitItemService.update(resultEntreeProduitItems.get(0),true);
    }
    }



    public EntreeProduit findByReferenceEntity(EntreeProduit t){
        return  dao.findByReference(t.getReference());
    }

    public List<EntreeProduit> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public long countByFournisseurTelephone(String telephone){
        return dao.countByFournisseurTelephone(telephone);
    }
    public List<EntreeProduit> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }

    public List<EntreeProduit> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EntreeProduit.class, EntreeProduitSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private FournisseurAdminService fournisseurService ;
    @Autowired
    private EntreeProduitItemAdminService entreeProduitItemService ;

    public EntreeProduitAdminServiceImpl(EntreeProduitDao dao) {
        super(dao);
    }

}
