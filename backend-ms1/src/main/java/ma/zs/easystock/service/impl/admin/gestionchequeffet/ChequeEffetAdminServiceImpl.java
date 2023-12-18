package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.ChequeEffet;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.ChequeEffetDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.ChequeEffetSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ChequeEffetAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.commun.FournisseurAdminService ;
import ma.zs.easystock.bean.core.commun.Fournisseur ;

import java.util.List;
@Service
public class ChequeEffetAdminServiceImpl extends AbstractServiceImpl<ChequeEffet, ChequeEffetCriteria, ChequeEffetDao> implements ChequeEffetAdminService {





    public ChequeEffet findByReferenceEntity(ChequeEffet t){
        return  dao.findByNumero(t.getNumero());
    }

    public List<ChequeEffet> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public long countByFournisseurTelephone(String telephone){
        return dao.countByFournisseurTelephone(telephone);
    }

    public List<ChequeEffet> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(ChequeEffet.class, ChequeEffetSpecification.class);
    }


    @Autowired
    private FournisseurAdminService fournisseurService ;

    public ChequeEffetAdminServiceImpl(ChequeEffetDao dao) {
        super(dao);
    }

}
