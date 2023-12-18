package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.Proprietaire;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.gestionchequeffet.Proprietaire;
import java.util.List;


@Repository
public interface ProprietaireDao extends AbstractRepository<Proprietaire,Long>  {
    Proprietaire findByTelephone(String telephone);
    int deleteByTelephone(String telephone);

    Proprietaire findByUsername(String username);

    @Query("SELECT NEW Proprietaire(item.id,item.telephone) FROM Proprietaire item")
    List<Proprietaire> findAllOptimized();

}
