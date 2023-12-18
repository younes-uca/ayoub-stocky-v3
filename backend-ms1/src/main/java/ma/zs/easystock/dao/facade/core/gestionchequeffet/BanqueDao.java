package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.Banque;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BanqueDao extends AbstractRepository<Banque,Long>  {


    @Query("SELECT NEW Banque(item.id,item.libelle) FROM Banque item")
    List<Banque> findAllOptimized();

}
