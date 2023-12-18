package ma.zs.easystock.dao.facade.core.reglement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.reglement.ReglementAvoirAchat;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.reglement.ReglementAvoirAchat;
import java.util.List;


@Repository
public interface ReglementAvoirAchatDao extends AbstractRepository<ReglementAvoirAchat,Long>  {
    ReglementAvoirAchat findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<ReglementAvoirAchat> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);
    List<ReglementAvoirAchat> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatNumeroFactureAvoirFournisseur(String numeroFactureAvoirFournisseur);

    @Query("SELECT NEW ReglementAvoirAchat(item.id,item.reference) FROM ReglementAvoirAchat item")
    List<ReglementAvoirAchat> findAllOptimized();

}
