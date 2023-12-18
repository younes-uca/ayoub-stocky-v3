package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.Depot;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DepotDao extends AbstractRepository<Depot,Long>  {


    @Query("SELECT NEW Depot(item.id,item.libelle) FROM Depot item")
    List<Depot> findAllOptimized();

}
