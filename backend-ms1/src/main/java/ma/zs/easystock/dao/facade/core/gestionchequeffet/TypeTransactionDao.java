package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.TypeTransaction;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TypeTransactionDao extends AbstractRepository<TypeTransaction,Long>  {


    @Query("SELECT NEW TypeTransaction(item.id,item.libelle) FROM TypeTransaction item")
    List<TypeTransaction> findAllOptimized();

}
