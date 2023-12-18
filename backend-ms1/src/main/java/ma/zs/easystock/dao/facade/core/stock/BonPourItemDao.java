package ma.zs.easystock.dao.facade.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.BonPourItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BonPourItemDao extends AbstractRepository<BonPourItem,Long>  {

    List<BonPourItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitReference(String reference);
    List<BonPourItem> findByTaxeId(Long id);
    int deleteByTaxeId(Long id);
    long countByTaxeId(Long id);
    List<BonPourItem> findByBonPourId(Long id);
    int deleteByBonPourId(Long id);
    long countByBonPourNumero(String numero);


}
