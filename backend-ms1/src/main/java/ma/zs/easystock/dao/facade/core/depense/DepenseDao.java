package ma.zs.easystock.dao.facade.core.depense;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.depense.Depense;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DepenseDao extends AbstractRepository<Depense,Long>  {



}
