package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.Devis;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.Devis;
import java.util.List;


@Repository
public interface DevisDao extends AbstractRepository<Devis,Long>  {
    Devis findByNumero(String numero);
    int deleteByNumero(String numero);

    List<Devis> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientTelephone(String telephone);

    @Query("SELECT NEW Devis(item.id,item.numero) FROM Devis item")
    List<Devis> findAllOptimized();

}
