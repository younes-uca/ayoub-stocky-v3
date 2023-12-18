package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.Collaborateur;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.commun.Collaborateur;
import java.util.List;


@Repository
public interface CollaborateurDao extends AbstractRepository<Collaborateur,Long>  {
    Collaborateur findByTelephone(String telephone);
    int deleteByTelephone(String telephone);

    Collaborateur findByUsername(String username);

    @Query("SELECT NEW Collaborateur(item.id,item.prenom) FROM Collaborateur item")
    List<Collaborateur> findAllOptimized();

}
