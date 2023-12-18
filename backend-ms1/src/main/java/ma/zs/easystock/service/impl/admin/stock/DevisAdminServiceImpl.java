package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.Devis;
import ma.zs.easystock.dao.criteria.core.stock.DevisCriteria;
import ma.zs.easystock.dao.facade.core.stock.DevisDao;
import ma.zs.easystock.dao.specification.core.stock.DevisSpecification;
import ma.zs.easystock.service.facade.admin.stock.DevisAdminService;
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
import ma.zs.easystock.service.facade.admin.stock.DevisItemAdminService ;
import ma.zs.easystock.bean.core.stock.DevisItem ;

import java.util.List;
@Service
public class DevisAdminServiceImpl extends AbstractServiceImpl<Devis, DevisCriteria, DevisDao> implements DevisAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Devis create(Devis t) {
    
        if (t.getDevisItems() != null) {
                t.getDevisItems().forEach(element-> {
                    element.setDevis(t);
                    devisItemService.create(element);
            });
        }
        return t;

    }

    public Devis findWithAssociatedLists(Long id){
        Devis result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setDevisItems(devisItemService.findByDevisId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        devisItemService.deleteByDevisId(id);
    }


    public void updateWithAssociatedLists(Devis devis){
    if(devis !=null && devis.getId() != null){
            List<List<DevisItem>> resultDevisItems= devisItemService.getToBeSavedAndToBeDeleted(devisItemService.findByDevisId(devis.getId()),devis.getDevisItems());
            devisItemService.delete(resultDevisItems.get(1));
            ListUtil.emptyIfNull(resultDevisItems.get(0)).forEach(e -> e.setDevis(devis));
            devisItemService.update(resultDevisItems.get(0),true);
    }
    }



    public Devis findByReferenceEntity(Devis t){
        return  dao.findByNumero(t.getNumero());
    }

    public List<Devis> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientTelephone(String telephone){
        return dao.countByClientTelephone(telephone);
    }

    public List<Devis> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Devis.class, DevisSpecification.class);
    }


    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private DevisItemAdminService devisItemService ;

    public DevisAdminServiceImpl(DevisDao dao) {
        super(dao);
    }

}
