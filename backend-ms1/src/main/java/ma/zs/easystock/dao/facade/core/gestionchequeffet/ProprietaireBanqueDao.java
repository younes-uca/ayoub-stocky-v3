package ma.zs.easystock.dao.facade.core.gestionchequeffet;

import ma.zs.easystock.zynerator.repository.AbstractRepository;
import ma.zs.easystock.bean.core.gestionchequeffet.ProprietaireBanque;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProprietaireBanqueDao extends AbstractRepository<ProprietaireBanque,Long>  {

    List<ProprietaireBanque> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireTelephone(String telephone);
    List<ProprietaireBanque> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueId(Long id);
    List<ProprietaireBanque> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);


}
