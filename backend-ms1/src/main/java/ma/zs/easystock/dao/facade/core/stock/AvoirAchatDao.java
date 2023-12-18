package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.AvoirAchat;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.AvoirAchat;
import java.util.List;


@Repository
public interface AvoirAchatDao extends AbstractRepository<AvoirAchat,Long>  {
    AvoirAchat findByNumeroFactureAvoirFournisseur(String numeroFactureAvoirFournisseur);
    int deleteByNumeroFactureAvoirFournisseur(String numeroFactureAvoirFournisseur);

    List<AvoirAchat> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirAchat> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurTelephone(String telephone);
    List<AvoirAchat> findByEtatAvoirAchatId(Long id);
    int deleteByEtatAvoirAchatId(Long id);
    long countByEtatAvoirAchatId(Long id);
    List<AvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);

    @Query("SELECT NEW AvoirAchat(item.id,item.numeroFactureAvoirFournisseur) FROM AvoirAchat item")
    List<AvoirAchat> findAllOptimized();

}
