package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.Client;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.commun.Client;
import java.util.List;


@Repository
public interface ClientDao extends AbstractRepository<Client,Long>  {
    Client findByTelephone(String telephone);
    int deleteByTelephone(String telephone);

    Client findByUsername(String username);

    @Query("SELECT NEW Client(item.id,item.telephone) FROM Client item")
    List<Client> findAllOptimized();

}
