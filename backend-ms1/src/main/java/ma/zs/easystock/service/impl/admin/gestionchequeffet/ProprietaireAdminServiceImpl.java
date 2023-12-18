package ma.zs.easystock.service.impl.admin.gestionchequeffet;


import ma.zs.easystock.bean.core.gestionchequeffet.Proprietaire;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.easystock.dao.facade.core.gestionchequeffet.ProprietaireDao;
import ma.zs.easystock.dao.specification.core.gestionchequeffet.ProprietaireSpecification;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ProprietaireAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import ma.zs.easystock.zynerator.security.service.facade.UserService;
import ma.zs.easystock.zynerator.security.service.facade.RoleService;
import ma.zs.easystock.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class ProprietaireAdminServiceImpl extends AbstractServiceImpl<Proprietaire, ProprietaireCriteria, ProprietaireDao> implements ProprietaireAdminService {





    public Proprietaire findByReferenceEntity(Proprietaire t){
        return  dao.findByTelephone(t.getTelephone());
    }


    public List<Proprietaire> findAllOptimized() {
        return dao.findAllOptimized();
    }




    @Override
    public Proprietaire create(Proprietaire t) {
        if (findByUsername(t.getUsername()) != null || t.getPassword() == null) return null;
        t.setPassword(userService.cryptPassword(t.getPassword()));
        t.setEnabled(true);
        t.setAccountNonExpired(true);
        t.setAccountNonLocked(true);
        t.setCredentialsNonExpired(true);
        t.setPasswordChanged(false);
        if (t.getRoles() != null) {
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : t.getRoles()) {
                roles.add(roleService.save(role));
            }
            t.setRoles(roles);
        }
        Proprietaire mySaved = super.create(t);

        return mySaved;
     }

    public Proprietaire findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Proprietaire.class, ProprietaireSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    public ProprietaireAdminServiceImpl(ProprietaireDao dao) {
        super(dao);
    }

}
