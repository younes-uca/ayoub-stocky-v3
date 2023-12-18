package ma.zs.easystock.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.stock.Produit;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.stock.Produit;
import java.util.List;


@Repository
public interface ProduitDao extends AbstractRepository<Produit,Long>  {
    Produit findByReference(String reference);
    int deleteByReference(String reference);

    List<Produit> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Produit> findByCategorieId(Long id);
    int deleteByCategorieId(Long id);
    long countByCategorieLibelle(String libelle);
    List<Produit> findByMarqueId(Long id);
    int deleteByMarqueId(Long id);
    long countByMarqueLibelle(String libelle);
    List<Produit> findByUniteMesureId(Long id);
    int deleteByUniteMesureId(Long id);
    long countByUniteMesureLibelle(String libelle);

    @Query("SELECT NEW Produit(item.id,item.designation) FROM Produit item")
    List<Produit> findAllOptimized();

}
