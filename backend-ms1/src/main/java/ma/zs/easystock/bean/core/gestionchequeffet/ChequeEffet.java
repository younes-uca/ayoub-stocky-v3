package ma.zs.easystock.bean.core.gestionchequeffet;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.bean.core.commun.Fournisseur;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "cheque_effet")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="cheque_effet_seq",sequenceName="cheque_effet_seq",allocationSize=1, initialValue = 1)
public class ChequeEffet   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String numero;
    private LocalDateTime dateEmission ;
    private BigDecimal montant = BigDecimal.ZERO;

    private Fournisseur fournisseur ;


    public ChequeEffet(){
        super();
    }

    public ChequeEffet(Long id,String numero){
        this.id = id;
        this.numero = numero ;
    }
    public ChequeEffet(String numero){
        this.numero = numero ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="cheque_effet_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNumero(){
        return this.numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public LocalDateTime getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(LocalDateTime dateEmission){
        this.dateEmission = dateEmission;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Fournisseur getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }

    @Transient
    public String getLabel() {
        label = numero;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChequeEffet chequeEffet = (ChequeEffet) o;
        return id != null && id.equals(chequeEffet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

