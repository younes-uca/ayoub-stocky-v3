package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.AvoirVente;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.AvoirVente;
import java.util.List;


@Repository
public interface AvoirVenteDao extends AbstractRepository<AvoirVente,Long>  {
    AvoirVente findByNumeroFactureAvoirVente(String numeroFactureAvoirVente);
    int deleteByNumeroFactureAvoirVente(String numeroFactureAvoirVente);

    List<AvoirVente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirVente> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientTelephone(String telephone);
    List<AvoirVente> findByEtatAvoirVenteId(Long id);
    int deleteByEtatAvoirVenteId(Long id);
    long countByEtatAvoirVenteId(Long id);
    List<AvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteNumeroFacture(String numeroFacture);

    @Query("SELECT NEW AvoirVente(item.id,item.numeroFactureAvoirVente) FROM AvoirVente item")
    List<AvoirVente> findAllOptimized();

}
