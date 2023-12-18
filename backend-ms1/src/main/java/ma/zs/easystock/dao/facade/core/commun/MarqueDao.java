package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.Marque;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.commun.Marque;
import java.util.List;


@Repository
public interface MarqueDao extends AbstractRepository<Marque,Long>  {
    Marque findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW Marque(item.id,item.libelle) FROM Marque item")
    List<Marque> findAllOptimized();

}
