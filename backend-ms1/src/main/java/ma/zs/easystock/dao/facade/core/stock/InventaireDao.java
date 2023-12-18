package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.Inventaire;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.Inventaire;
import java.util.List;


@Repository
public interface InventaireDao extends AbstractRepository<Inventaire,Long>  {
    Inventaire findByReference(String reference);
    int deleteByReference(String reference);

    List<Inventaire> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Inventaire> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);

    @Query("SELECT NEW Inventaire(item.id,item.reference) FROM Inventaire item")
    List<Inventaire> findAllOptimized();

}
