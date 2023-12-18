package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.Vente;
import ma.zs.easystock.dao.criteria.core.stock.VenteCriteria;
import ma.zs.easystock.dao.facade.core.stock.VenteDao;
import ma.zs.easystock.dao.specification.core.stock.VenteSpecification;
import ma.zs.easystock.service.facade.admin.stock.VenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.service.facade.admin.commun.EtatVenteAdminService ;
import ma.zs.easystock.bean.core.commun.EtatVente ;
import ma.zs.easystock.service.facade.admin.commun.ClientAdminService ;
import ma.zs.easystock.bean.core.commun.Client ;
import ma.zs.easystock.service.facade.admin.stock.VenteItemAdminService ;
import ma.zs.easystock.bean.core.stock.VenteItem ;
import ma.zs.easystock.service.facade.admin.stock.AvoirVenteAdminService ;
import ma.zs.easystock.bean.core.stock.AvoirVente ;
import ma.zs.easystock.service.facade.admin.reglement.ReglementVenteAdminService ;
import ma.zs.easystock.bean.core.reglement.ReglementVente ;
import ma.zs.easystock.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete ;

import java.util.List;
@Service
public class VenteAdminServiceImpl extends AbstractServiceImpl<Vente, VenteCriteria, VenteDao> implements VenteAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Vente create(Vente t) {
    
        if (t.getVenteItems() != null) {
                t.getVenteItems().forEach(element-> {
                    element.setVente(t);
                    venteItemService.create(element);
            });
        }
        if (t.getAvoirVentes() != null) {
                t.getAvoirVentes().forEach(element-> {
                    element.setVente(t);
                    avoirVenteService.create(element);
            });
        }
        if (t.getReglementVentes() != null) {
                t.getReglementVentes().forEach(element-> {
                    element.setVente(t);
                    reglementVenteService.create(element);
            });
        }
        return t;

    }

    public Vente findWithAssociatedLists(Long id){
        Vente result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setVenteItems(venteItemService.findByVenteId(id));
            result.setAvoirVentes(avoirVenteService.findByVenteId(id));
            result.setReglementVentes(reglementVenteService.findByVenteId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        venteItemService.deleteByVenteId(id);
        avoirVenteService.deleteByVenteId(id);
        reglementVenteService.deleteByVenteId(id);
    }


    public void updateWithAssociatedLists(Vente vente){
    if(vente !=null && vente.getId() != null){
            List<List<VenteItem>> resultVenteItems= venteItemService.getToBeSavedAndToBeDeleted(venteItemService.findByVenteId(vente.getId()),vente.getVenteItems());
            venteItemService.delete(resultVenteItems.get(1));
            ListUtil.emptyIfNull(resultVenteItems.get(0)).forEach(e -> e.setVente(vente));
            venteItemService.update(resultVenteItems.get(0),true);
            List<List<AvoirVente>> resultAvoirVentes= avoirVenteService.getToBeSavedAndToBeDeleted(avoirVenteService.findByVenteId(vente.getId()),vente.getAvoirVentes());
            avoirVenteService.delete(resultAvoirVentes.get(1));
            ListUtil.emptyIfNull(resultAvoirVentes.get(0)).forEach(e -> e.setVente(vente));
            avoirVenteService.update(resultAvoirVentes.get(0),true);
            List<List<ReglementVente>> resultReglementVentes= reglementVenteService.getToBeSavedAndToBeDeleted(reglementVenteService.findByVenteId(vente.getId()),vente.getReglementVentes());
            reglementVenteService.delete(resultReglementVentes.get(1));
            ListUtil.emptyIfNull(resultReglementVentes.get(0)).forEach(e -> e.setVente(vente));
            reglementVenteService.update(resultReglementVentes.get(0),true);
    }
    }



    public Vente findByReferenceEntity(Vente t){
        return  dao.findByNumeroFacture(t.getNumeroFacture());
    }

    public List<Vente> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Vente> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientTelephone(String telephone){
        return dao.countByClientTelephone(telephone);
    }
    public List<Vente> findByEtatVenteId(Long id){
        return dao.findByEtatVenteId(id);
    }
    public int deleteByEtatVenteId(Long id){
        return dao.deleteByEtatVenteId(id);
    }
    public long countByEtatVenteId(Long id){
        return dao.countByEtatVenteId(id);
    }

    public List<Vente> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Vente.class, VenteSpecification.class);
    }


    @Autowired
    private EtatVenteAdminService etatVenteService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private VenteItemAdminService venteItemService ;
    @Autowired
    private AvoirVenteAdminService avoirVenteService ;
    @Autowired
    private ReglementVenteAdminService reglementVenteService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;

    public VenteAdminServiceImpl(VenteDao dao) {
        super(dao);
    }

}
