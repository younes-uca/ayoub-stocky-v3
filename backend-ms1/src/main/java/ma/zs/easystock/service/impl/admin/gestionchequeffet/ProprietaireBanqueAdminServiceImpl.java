package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.ProprietaireBanque;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ProprietaireBanqueCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.ProprietaireBanqueDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.ProprietaireBanqueSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ProprietaireBanqueAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.gestionchequeffet.BanqueAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.Banque ;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ProprietaireAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.Proprietaire ;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.CompteAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.Compte ;

import java.util.List;
@Service
public class ProprietaireBanqueAdminServiceImpl extends AbstractServiceImpl<ProprietaireBanque, ProprietaireBanqueCriteria, ProprietaireBanqueDao> implements ProprietaireBanqueAdminService {






    public List<ProprietaireBanque> findByProprietaireId(Long id){
        return dao.findByProprietaireId(id);
    }
    public int deleteByProprietaireId(Long id){
        return dao.deleteByProprietaireId(id);
    }
    public long countByProprietaireTelephone(String telephone){
        return dao.countByProprietaireTelephone(telephone);
    }
    public List<ProprietaireBanque> findByBanqueId(Long id){
        return dao.findByBanqueId(id);
    }
    public int deleteByBanqueId(Long id){
        return dao.deleteByBanqueId(id);
    }
    public long countByBanqueId(Long id){
        return dao.countByBanqueId(id);
    }
    public List<ProprietaireBanque> findByCompteId(Long id){
        return dao.findByCompteId(id);
    }
    public int deleteByCompteId(Long id){
        return dao.deleteByCompteId(id);
    }
    public long countByCompteId(Long id){
        return dao.countByCompteId(id);
    }






    public void configure() {
        super.configure(ProprietaireBanque.class, ProprietaireBanqueSpecification.class);
    }


    @Autowired
    private BanqueAdminService banqueService ;
    @Autowired
    private ProprietaireAdminService proprietaireService ;
    @Autowired
    private CompteAdminService compteService ;

    public ProprietaireBanqueAdminServiceImpl(ProprietaireBanqueDao dao) {
        super(dao);
    }

}
