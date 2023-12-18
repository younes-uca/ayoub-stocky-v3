package  ma.zs.easystock.dao.specification.core.stock;

import ma.zs.easystock.dao.criteria.core.stock.TacheCriteria;
import ma.zs.easystock.bean.core.stock.Tache;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TacheSpecification extends  AbstractSpecification<TacheCriteria, Tache>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateDebut", criteria.getDateDebut(), criteria.getDateDebutFrom(), criteria.getDateDebutTo());
        addPredicate("dateFin", criteria.getDateFin(), criteria.getDateFinFrom(), criteria.getDateFinTo());
        addPredicateFk("collaborateur","id", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getId());
        addPredicateFk("collaborateur","id", criteria.getCollaborateurs());
        addPredicateFk("collaborateur","telephone", criteria.getCollaborateur()==null?null:criteria.getCollaborateur().getTelephone());
    }

    public TacheSpecification(TacheCriteria criteria) {
        super(criteria);
    }

    public TacheSpecification(TacheCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
