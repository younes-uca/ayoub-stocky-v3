package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.BonPour;
import ma.zs.easystock.dao.criteria.core.stock.BonPourCriteria;
import ma.zs.easystock.dao.facade.core.stock.BonPourDao;
import ma.zs.easystock.dao.specification.core.stock.BonPourSpecification;
import ma.zs.easystock.service.facade.admin.stock.BonPourAdminService;
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
import ma.zs.easystock.service.facade.admin.stock.BonPourItemAdminService ;
import ma.zs.easystock.bean.core.stock.BonPourItem ;

import java.util.List;
@Service
public class BonPourAdminServiceImpl extends AbstractServiceImpl<BonPour, BonPourCriteria, BonPourDao> implements BonPourAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public BonPour create(BonPour t) {
    
        if (t.getBonPourItems() != null) {
                t.getBonPourItems().forEach(element-> {
                    element.setBonPour(t);
                    bonPourItemService.create(element);
            });
        }
        return t;

    }

    public BonPour findWithAssociatedLists(Long id){
        BonPour result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setBonPourItems(bonPourItemService.findByBonPourId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        bonPourItemService.deleteByBonPourId(id);
    }


    public void updateWithAssociatedLists(BonPour bonPour){
    if(bonPour !=null && bonPour.getId() != null){
            List<List<BonPourItem>> resultBonPourItems= bonPourItemService.getToBeSavedAndToBeDeleted(bonPourItemService.findByBonPourId(bonPour.getId()),bonPour.getBonPourItems());
            bonPourItemService.delete(resultBonPourItems.get(1));
            ListUtil.emptyIfNull(resultBonPourItems.get(0)).forEach(e -> e.setBonPour(bonPour));
            bonPourItemService.update(resultBonPourItems.get(0),true);
    }
    }



    public BonPour findByReferenceEntity(BonPour t){
        return  dao.findByNumero(t.getNumero());
    }

    public List<BonPour> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientTelephone(String telephone){
        return dao.countByClientTelephone(telephone);
    }

    public List<BonPour> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(BonPour.class, BonPourSpecification.class);
    }


    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private BonPourItemAdminService bonPourItemService ;

    public BonPourAdminServiceImpl(BonPourDao dao) {
        super(dao);
    }

}
