package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.UniteMesure;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.commun.UniteMesure;
import java.util.List;


@Repository
public interface UniteMesureDao extends AbstractRepository<UniteMesure,Long>  {
    UniteMesure findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW UniteMesure(item.id,item.libelle) FROM UniteMesure item")
    List<UniteMesure> findAllOptimized();

}
