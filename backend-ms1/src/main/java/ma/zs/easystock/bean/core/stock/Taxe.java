package ma.zs.easystock.bean.core.stock;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "taxe")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="taxe_seq",sequenceName="taxe_seq",allocationSize=1, initialValue = 1)
public class Taxe   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    private BigDecimal montant = BigDecimal.ZERO;



    public Taxe(){
        super();
    }

    public Taxe(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Taxe(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="taxe_seq")
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
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
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
        Taxe taxe = (Taxe) o;
        return id != null && id.equals(taxe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

