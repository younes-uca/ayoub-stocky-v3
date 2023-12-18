package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.EtatAvoirAchat;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EtatAvoirAchatDao extends AbstractRepository<EtatAvoirAchat,Long>  {


    @Query("SELECT NEW EtatAvoirAchat(item.id,item.libelle) FROM EtatAvoirAchat item")
    List<EtatAvoirAchat> findAllOptimized();

}
