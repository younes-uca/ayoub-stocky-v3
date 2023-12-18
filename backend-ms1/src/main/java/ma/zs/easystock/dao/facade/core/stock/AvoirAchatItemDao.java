package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.AvoirAchatItem;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.AvoirAchatItem;
import java.util.List;


@Repository
public interface AvoirAchatItemDao extends AbstractRepository<AvoirAchatItem,Long>  {
    AvoirAchatItem findByBarCode(String barCode);
    int deleteByBarCode(String barCode);

    List<AvoirAchatItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotId(Long id);
    List<AvoirAchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitReference(String reference);
    List<AvoirAchatItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<AvoirAchatItem> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatNumeroFactureAvoirFournisseur(String numeroFactureAvoirFournisseur);

    @Query("SELECT NEW AvoirAchatItem(item.id,item.barCode) FROM AvoirAchatItem item")
    List<AvoirAchatItem> findAllOptimized();

}
