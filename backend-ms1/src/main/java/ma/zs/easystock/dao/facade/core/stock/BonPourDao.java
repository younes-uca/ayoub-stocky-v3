package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.BonPour;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.BonPour;
import java.util.List;


@Repository
public interface BonPourDao extends AbstractRepository<BonPour,Long>  {
    BonPour findByNumero(String numero);
    int deleteByNumero(String numero);

    List<BonPour> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientTelephone(String telephone);

    @Query("SELECT NEW BonPour(item.id,item.numero) FROM BonPour item")
    List<BonPour> findAllOptimized();

}
