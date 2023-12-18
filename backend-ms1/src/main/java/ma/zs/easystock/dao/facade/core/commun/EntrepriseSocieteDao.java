package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EntrepriseSocieteDao extends AbstractRepository<EntrepriseSociete,Long>  {


    @Query("SELECT NEW EntrepriseSociete(item.id,item.nom) FROM EntrepriseSociete item")
    List<EntrepriseSociete> findAllOptimized();

}
