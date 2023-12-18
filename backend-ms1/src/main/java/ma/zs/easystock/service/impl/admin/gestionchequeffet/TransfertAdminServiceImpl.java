package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.Transfert;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TransfertCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.TransfertDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.TransfertSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TransfertAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.easystock.service.facade.admin.gestionchequeffet.TransfertItemAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.TransfertItem ;
import ma.zs.easystock.service.facade.admin.Transfert.RaisonAdminService ;
import ma.zs.easystock.bean.core.Transfert.Raison ;

import java.util.List;
@Service
public class TransfertAdminServiceImpl extends AbstractServiceImpl<Transfert, TransfertCriteria, TransfertDao> implements TransfertAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Transfert create(Transfert t) {
    
        if (t.getTransfertItems() != null) {
                t.getTransfertItems().forEach(element-> {
                    element.setTransfert(t);
                    transfertItemService.create(element);
            });
        }
        return t;

    }

    public Transfert findWithAssociatedLists(Long id){
        Transfert result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setTransfertItems(transfertItemService.findByTransfertId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        transfertItemService.deleteByTransfertId(id);
    }


    public void updateWithAssociatedLists(Transfert transfert){
    if(transfert !=null && transfert.getId() != null){
            List<List<TransfertItem>> resultTransfertItems= transfertItemService.getToBeSavedAndToBeDeleted(transfertItemService.findByTransfertId(transfert.getId()),transfert.getTransfertItems());
            transfertItemService.delete(resultTransfertItems.get(1));
            ListUtil.emptyIfNull(resultTransfertItems.get(0)).forEach(e -> e.setTransfert(transfert));
            transfertItemService.update(resultTransfertItems.get(0),true);
    }
    }




    public List<Transfert> findByRaisonId(Long id){
        return dao.findByRaisonId(id);
    }
    public int deleteByRaisonId(Long id){
        return dao.deleteByRaisonId(id);
    }
    public long countByRaisonId(Long id){
        return dao.countByRaisonId(id);
    }






    public void configure() {
        super.configure(Transfert.class, TransfertSpecification.class);
    }


    @Autowired
    private TransfertItemAdminService transfertItemService ;
    @Autowired
    private RaisonAdminService raisonService ;

    public TransfertAdminServiceImpl(TransfertDao dao) {
        super(dao);
    }

}
