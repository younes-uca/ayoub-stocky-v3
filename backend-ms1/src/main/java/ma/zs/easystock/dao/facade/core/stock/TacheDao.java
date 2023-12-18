package ma.zs.easystock.dao.facade.core.stock;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.Tache;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TacheDao extends AbstractRepository<Tache,Long>  {

    List<Tache> findByCollaborateurId(Long id);
    int deleteByCollaborateurId(Long id);
    long countByCollaborateurTelephone(String telephone);


}
