package ma.zs.easystock.dao.facade.core.entree;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.entree.EntreeProduit;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.entree.EntreeProduit;
import java.util.List;


@Repository
public interface EntreeProduitDao extends AbstractRepository<EntreeProduit,Long>  {
    EntreeProduit findByReference(String reference);
    int deleteByReference(String reference);

    List<EntreeProduit> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurTelephone(String telephone);
    List<EntreeProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);

    @Query("SELECT NEW EntreeProduit(item.id,item.reference) FROM EntreeProduit item")
    List<EntreeProduit> findAllOptimized();

}
