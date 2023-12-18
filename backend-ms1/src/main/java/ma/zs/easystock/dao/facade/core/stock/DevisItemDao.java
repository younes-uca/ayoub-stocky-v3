package ma.zs.easystock.dao.facade.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.DevisItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DevisItemDao extends AbstractRepository<DevisItem,Long>  {

    List<DevisItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitReference(String reference);
    List<DevisItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<DevisItem> findByDevisId(Long id);
    int deleteByDevisId(Long id);
    long countByDevisNumero(String numero);


}
