package ma.zs.easystock.dao.facade.core.entree;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.entree.SortieProduit;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.entree.SortieProduit;
import java.util.List;


@Repository
public interface SortieProduitDao extends AbstractRepository<SortieProduit,Long>  {
    SortieProduit findByReference(String reference);
    int deleteByReference(String reference);

    List<SortieProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);

    @Query("SELECT NEW SortieProduit(item.id,item.reference) FROM SortieProduit item")
    List<SortieProduit> findAllOptimized();

}
