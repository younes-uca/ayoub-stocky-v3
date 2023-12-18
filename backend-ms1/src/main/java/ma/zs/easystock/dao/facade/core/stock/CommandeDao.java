package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.Commande;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.Commande;
import java.util.List;


@Repository
public interface CommandeDao extends AbstractRepository<Commande,Long>  {
    Commande findByNumeroCommande(String numeroCommande);
    int deleteByNumeroCommande(String numeroCommande);

    List<Commande> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientTelephone(String telephone);
    List<Commande> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);
    long countByEtatCommandeId(Long id);

    @Query("SELECT NEW Commande(item.id,item.numeroCommande) FROM Commande item")
    List<Commande> findAllOptimized();

}
