package ma.zs.easystock.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.commun.Categorie;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.commun.Categorie;
import java.util.List;


@Repository
public interface CategorieDao extends AbstractRepository<Categorie,Long>  {
    Categorie findByLibelle(String libelle);
    int deleteByLibelle(String libelle);


    @Query("SELECT NEW Categorie(item.id,item.libelle) FROM Categorie item")
    List<Categorie> findAllOptimized();

}
