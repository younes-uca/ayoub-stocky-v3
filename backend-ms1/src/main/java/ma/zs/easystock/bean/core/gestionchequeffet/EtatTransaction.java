package ma.zs.easystock.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "etat_transaction")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_transaction_seq",sequenceName="etat_transaction_seq",allocationSize=1, initialValue = 1)
public class EtatTransaction   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;



    public EtatTransaction(){
        super();
    }

    public EtatTransaction(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public EtatTransaction(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="etat_transaction_seq")
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
        EtatTransaction etatTransaction = (EtatTransaction) o;
        return id != null && id.equals(etatTransaction.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

