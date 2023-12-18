package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ModeReglementDao extends AbstractRepository<ModeReglement,Long>  {


    @Query("SELECT NEW ModeReglement(item.id,item.libelle) FROM ModeReglement item")
    List<ModeReglement> findAllOptimized();

}
