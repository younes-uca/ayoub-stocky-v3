package  ma.zs.easystock.dao.specification.core.gestionchequeffet;

import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;
import ma.zs.easystock.bean.core.gestionchequeffet.TypeInstrument;
import ma.zs.easystock.zynerator.specification.AbstractSpecification;


public class TypeInstrumentSpecification extends  AbstractSpecification<TypeInstrumentCriteria, TypeInstrument>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypeInstrumentSpecification(TypeInstrumentCriteria criteria) {
        super(criteria);
    }

    public TypeInstrumentSpecification(TypeInstrumentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
