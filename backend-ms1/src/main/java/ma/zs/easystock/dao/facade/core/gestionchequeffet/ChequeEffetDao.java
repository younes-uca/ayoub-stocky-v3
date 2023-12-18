package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.ChequeEffet;
import org.springframework.stereotype.Repository;
import ma.zs.easystock.bean.core.gestionchequeffet.ChequeEffet;
import java.util.List;


@Repository
public interface ChequeEffetDao extends AbstractRepository<ChequeEffet,Long>  {
    ChequeEffet findByNumero(String numero);
    int deleteByNumero(String numero);

    List<ChequeEffet> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurTelephone(String telephone);

    @Query("SELECT NEW ChequeEffet(item.id,item.numero) FROM ChequeEffet item")
    List<ChequeEffet> findAllOptimized();

}
