package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.Proprietaire;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class ProprietaireSpecification extends  AbstractSpecification<ProprietaireCriteria, Proprietaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("telephone", criteria.getTelephone(),criteria.getTelephoneLike());
        addPredicateBigDecimal("creance", criteria.getCreance(), criteria.getCreanceMin(), criteria.getCreanceMax());
        addPredicateBool("credentialsNonExpired", criteria.getCredentialsNonExpired());
        addPredicateBool("enabled", criteria.getEnabled());
        addPredicateBool("accountNonExpired", criteria.getAccountNonExpired());
        addPredicateBool("accountNonLocked", criteria.getAccountNonLocked());
        addPredicateBool("passwordChanged", criteria.getPasswordChanged());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
    }

    public ProprietaireSpecification(ProprietaireCriteria criteria) {
        super(criteria);
    }

    public ProprietaireSpecification(ProprietaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
