package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.Fournisseur;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.commun.Fournisseur;
import java.util.List;


@Repository
public interface FournisseurDao extends AbstractRepository<Fournisseur,Long>  {
    Fournisseur findByTelephone(String telephone);
    int deleteByTelephone(String telephone);

    Fournisseur findByUsername(String username);

    @Query("SELECT NEW Fournisseur(item.id,item.telephone) FROM Fournisseur item")
    List<Fournisseur> findAllOptimized();

}
