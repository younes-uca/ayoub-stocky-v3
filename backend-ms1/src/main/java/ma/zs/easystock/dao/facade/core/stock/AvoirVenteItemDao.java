package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.AvoirVenteItem;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.AvoirVenteItem;
import java.util.List;


@Repository
public interface AvoirVenteItemDao extends AbstractRepository<AvoirVenteItem,Long>  {
    AvoirVenteItem findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<AvoirVenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<AvoirVenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitReference(String reference);
    List<AvoirVenteItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<AvoirVenteItem> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente);

    @Query("SELECT NEW AvoirVenteItem(item.id,item.barCode) FROM AvoirVenteItem item")
    List<AvoirVenteItem> findAllOptimized();

}
