package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.Compte;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CompteDao extends AbstractRepository<Compte,Long>  {

    List<Compte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<Compte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireTelephone(String telephone);

    @Query("SELECT NEW Compte(item.id,item.numeroCompte) FROM Compte item")
    List<Compte> findAllOptimized();

}
