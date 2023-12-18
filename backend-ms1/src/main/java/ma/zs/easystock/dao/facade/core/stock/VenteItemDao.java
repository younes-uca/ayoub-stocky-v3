package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.VenteItem;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.VenteItem;
import java.util.List;


@Repository
public interface VenteItemDao extends AbstractRepository<VenteItem,Long>  {
    VenteItem findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<VenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<VenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitReference(String reference);
    List<VenteItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<VenteItem> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);

    @Query("SELECT NEW VenteItem(item.id,item.barCode) FROM VenteItem item")
    List<VenteItem> findAllOptimized();

}
