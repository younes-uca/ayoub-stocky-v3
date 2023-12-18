package ma.zs.easystock.service.impl.admin.entree;


import ma.zs.easystock.bean.core.entree.SortieProduit;
import ma.zs.easystock.dao.criteria.core.entree.SortieProduitCriteria;
import ma.zs.easystock.dao.facade.core.entree.SortieProduitDao;
import ma.zs.easystock.dao.specification.core.entree.SortieProduitSpecification;
import ma.zs.easystock.service.facade.admin.entree.SortieProduitAdminService;
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
import ma.zs.easystock.service.facade.admin.stock.SortieProduitItemAdminService ;
import ma.zs.easystock.bean.core.stock.SortieProduitItem ;

import java.util.List;
@Service
public class SortieProduitAdminServiceImpl extends AbstractServiceImpl<SortieProduit, SortieProduitCriteria, SortieProduitDao> implements SortieProduitAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public SortieProduit create(SortieProduit t) {
    
        if (t.getSortieProduitItems() != null) {
                t.getSortieProduitItems().forEach(element-> {
                    element.setSortieProduit(t);
                    sortieProduitItemService.create(element);
            });
        }
        return t;

    }

    public SortieProduit findWithAssociatedLists(Long id){
        SortieProduit result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSortieProduitItems(sortieProduitItemService.findBySortieProduitId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        sortieProduitItemService.deleteBySortieProduitId(id);
    }


    public void updateWithAssociatedLists(SortieProduit sortieProduit){
    if(sortieProduit !=null && sortieProduit.getId() != null){
            List<List<SortieProduitItem>> resultSortieProduitItems= sortieProduitItemService.getToBeSavedAndToBeDeleted(sortieProduitItemService.findBySortieProduitId(sortieProduit.getId()),sortieProduit.getSortieProduitItems());
            sortieProduitItemService.delete(resultSortieProduitItems.get(1));
            ListUtil.emptyIfNull(resultSortieProduitItems.get(0)).forEach(e -> e.setSortieProduit(sortieProduit));
            sortieProduitItemService.update(resultSortieProduitItems.get(0),true);
    }
    }



    public SortieProduit findByReferenceEntity(SortieProduit t){
        return  dao.findByReference(t.getReference());
    }

    public List<SortieProduit> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }

    public List<SortieProduit> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(SortieProduit.class, SortieProduitSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private SortieProduitItemAdminService sortieProduitItemService ;

    public SortieProduitAdminServiceImpl(SortieProduitDao dao) {
        super(dao);
    }

}
