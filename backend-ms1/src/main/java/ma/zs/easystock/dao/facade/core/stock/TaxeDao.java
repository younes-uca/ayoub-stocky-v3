package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.Taxe;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TaxeDao extends AbstractRepository<Taxe,Long>  {


    @Query("SELECT NEW Taxe(item.id,item.libelle) FROM Taxe item")
    List<Taxe> findAllOptimized();

}
