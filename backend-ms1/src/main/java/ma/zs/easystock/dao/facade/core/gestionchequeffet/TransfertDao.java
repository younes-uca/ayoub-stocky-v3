package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.Transfert;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TransfertDao extends AbstractRepository<Transfert,Long>  {

    List<Transfert> findByRaisonId(Long id);
    int deleteByRaisonId(Long id);
    long countByRaisonId(Long id);


}
