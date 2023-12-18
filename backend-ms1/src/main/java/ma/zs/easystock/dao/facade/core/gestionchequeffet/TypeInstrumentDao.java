package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.TypeInstrument;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TypeInstrumentDao extends AbstractRepository<TypeInstrument,Long>  {


    @Query("SELECT NEW TypeInstrument(item.id,item.libelle) FROM TypeInstrument item")
    List<TypeInstrument> findAllOptimized();

}
