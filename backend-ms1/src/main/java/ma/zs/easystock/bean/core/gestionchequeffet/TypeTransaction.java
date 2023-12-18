package ma.zs.easystock.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "type_transaction")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_transaction_seq",sequenceName="type_transaction_seq",allocationSize=1, initialValue = 1)
public class TypeTransaction   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;



    public TypeTransaction(){
        super();
    }

    public TypeTransaction(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypeTransaction(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="type_transaction_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeTransaction typeTransaction = (TypeTransaction) o;
        return id != null && id.equals(typeTransaction.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

