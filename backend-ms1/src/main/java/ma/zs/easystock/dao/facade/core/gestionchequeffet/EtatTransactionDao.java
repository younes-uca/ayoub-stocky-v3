package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.EtatTransaction;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EtatTransactionDao extends AbstractRepository<EtatTransaction,Long>  {


    @Query("SELECT NEW EtatTransaction(item.id,item.libelle) FROM EtatTransaction item")
    List<EtatTransaction> findAllOptimized();

}
