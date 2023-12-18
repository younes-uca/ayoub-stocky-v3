package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.AvoirAchat;
import ma.zs.easystock.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.easystock.dao.facade.core.stock.AvoirAchatDao;
import ma.zs.easystock.dao.specification.core.stock.AvoirAchatSpecification;
import ma.zs.easystock.service.facade.admin.stock.AvoirAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.service.facade.admin.commun.EtatAvoirAchatAdminService ;
import ma.zs.easystock.bean.core.commun.EtatAvoirAchat ;
import ma.zs.easystock.service.facade.admin.stock.AvoirAchatItemAdminService ;
import ma.zs.easystock.bean.core.stock.AvoirAchatItem ;
import ma.zs.easystock.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete ;
import ma.zs.easystock.service.facade.admin.commun.FournisseurAdminService ;
import ma.zs.easystock.bean.core.commun.Fournisseur ;
import ma.zs.easystock.service.facade.admin.stock.AchatAdminService ;
import ma.zs.easystock.bean.core.stock.Achat ;

import java.util.List;
@Service
public class AvoirAchatAdminServiceImpl extends AbstractServiceImpl<AvoirAchat, AvoirAchatCriteria, AvoirAchatDao> implements AvoirAchatAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public AvoirAchat create(AvoirAchat t) {
    
        if (t.getAvoirAchatItems() != null) {
                t.getAvoirAchatItems().forEach(element-> {
                    element.setAvoirAchat(t);
                    avoirAchatItemService.create(element);
            });
        }
        return t;

    }

    public AvoirAchat findWithAssociatedLists(Long id){
        AvoirAchat result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setAvoirAchatItems(avoirAchatItemService.findByAvoirAchatId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        avoirAchatItemService.deleteByAvoirAchatId(id);
    }


    public void updateWithAssociatedLists(AvoirAchat avoirAchat){
    if(avoirAchat !=null && avoirAchat.getId() != null){
            List<List<AvoirAchatItem>> resultAvoirAchatItems= avoirAchatItemService.getToBeSavedAndToBeDeleted(avoirAchatItemService.findByAvoirAchatId(avoirAchat.getId()),avoirAchat.getAvoirAchatItems());
            avoirAchatItemService.delete(resultAvoirAchatItems.get(1));
            ListUtil.emptyIfNull(resultAvoirAchatItems.get(0)).forEach(e -> e.setAvoirAchat(avoirAchat));
            avoirAchatItemService.update(resultAvoirAchatItems.get(0),true);
    }
    }



    public AvoirAchat findByReferenceEntity(AvoirAchat t){
        return  dao.findByNumeroFactureAvoirFournisseur(t.getNumeroFactureAvoirFournisseur());
    }

    public List<AvoirAchat> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<AvoirAchat> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public long countByFournisseurTelephone(String telephone){
        return dao.countByFournisseurTelephone(telephone);
    }
    public List<AvoirAchat> findByEtatAvoirAchatId(Long id){
        return dao.findByEtatAvoirAchatId(id);
    }
    public int deleteByEtatAvoirAchatId(Long id){
        return dao.deleteByEtatAvoirAchatId(id);
    }
    public long countByEtatAvoirAchatId(Long id){
        return dao.countByEtatAvoirAchatId(id);
    }
    public List<AvoirAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }

    public List<AvoirAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(AvoirAchat.class, AvoirAchatSpecification.class);
    }


    @Autowired
    private EtatAvoirAchatAdminService etatAvoirAchatService ;
    @Autowired
    private AvoirAchatItemAdminService avoirAchatItemService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private FournisseurAdminService fournisseurService ;
    @Autowired
    private AchatAdminService achatService ;

    public AvoirAchatAdminServiceImpl(AvoirAchatDao dao) {
        super(dao);
    }

}
