package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.EtatAvoirVente;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EtatAvoirVenteDao extends AbstractRepository<EtatAvoirVente,Long>  {


    @Query("SELECT NEW EtatAvoirVente(item.id,item.libelle) FROM EtatAvoirVente item")
    List<EtatAvoirVente> findAllOptimized();

}
