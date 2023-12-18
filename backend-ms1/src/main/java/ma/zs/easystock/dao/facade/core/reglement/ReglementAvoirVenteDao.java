package ma.zs.easystock.dao.facade.core.reglement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.reglement.ReglementAvoirVente;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.reglement.ReglementAvoirVente;
import java.util.List;


@Repository
public interface ReglementAvoirVenteDao extends AbstractRepository<ReglementAvoirVente,Long>  {
    ReglementAvoirVente findByReference(String reference);
    int deleteByReference(String reference);

    List<ReglementAvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);
    List<ReglementAvoirVente> findByModeReglementId(Long id);
    int deleteByModeReglementId(Long id);
    long countByModeReglementId(Long id);
    List<ReglementAvoirVente> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente);

    @Query("SELECT NEW ReglementAvoirVente(item.id,item.reference) FROM ReglementAvoirVente item")
    List<ReglementAvoirVente> findAllOptimized();

}
