package ma.zs.easystock.dao.facade.core.reglement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.reglement.ReglementAchat;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.reglement.ReglementAchat;
import java.util.List;


@Repository
public interface ReglementAchatDao extends AbstractRepository<ReglementAchat,Long>  {
    ReglementAchat findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<ReglementAchat> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);

    @Query("SELECT NEW ReglementAchat(item.id,item.reference) FROM ReglementAchat item")
    List<ReglementAchat> findAllOptimized();

}
