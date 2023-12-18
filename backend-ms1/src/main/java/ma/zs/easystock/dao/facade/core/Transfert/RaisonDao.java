package ma.zs.easystock.dao.facade.core.Transfert;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.Transfert.Raison;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RaisonDao extends AbstractRepository<Raison,Long>  {


    @Query("SELECT NEW Raison(item.id,item.libelle) FROM Raison item")
    List<Raison> findAllOptimized();

}
