package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.Vente;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.Vente;
import java.util.List;


@Repository
public interface VenteDao extends AbstractRepository<Vente,Long>  {
    Vente findByNumeroFacture(String numeroFacture);
    int deleteByNumeroFacture(String numeroFacture);

    List<Vente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Vente> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientTelephone(String telephone);
    List<Vente> findByEtatVenteId(Long id);
    int deleteByEtatVenteId(Long id);
    long countByEtatVenteId(Long id);

    @Query("SELECT NEW Vente(item.id,item.numeroFacture) FROM Vente item")
    List<Vente> findAllOptimized();

}
