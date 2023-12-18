package ma.zs.easystock.bean.core.depense;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;




import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "depense")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="depense_seq",sequenceName="depense_seq",allocationSize=1, initialValue = 1)
public class Depense   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateDepense ;
    @Column(length = 500)
    private String libelle;
    private BigDecimal montant = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;



    public Depense(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="depense_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateDepense(){
        return this.dateDepense;
    }
    public void setDateDepense(LocalDateTime dateDepense){
        this.dateDepense = dateDepense;
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
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depense depense = (Depense) o;
        return id != null && id.equals(depense.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

