package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.EtatVente;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EtatVenteDao extends AbstractRepository<EtatVente,Long>  {


    @Query("SELECT NEW EtatVente(item.id,item.libelle) FROM EtatVente item")
    List<EtatVente> findAllOptimized();

}
