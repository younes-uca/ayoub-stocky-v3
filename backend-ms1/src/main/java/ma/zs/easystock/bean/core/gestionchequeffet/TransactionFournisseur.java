package ma.zs.easystock.bean.core.gestionchequeffet;

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
@Table(name = "transaction_fournisseur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="transaction_fournisseur_seq",sequenceName="transaction_fournisseur_seq",allocationSize=1, initialValue = 1)
public class TransactionFournisseur   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateEmission ;
    private BigDecimal montant = BigDecimal.ZERO;
    private LocalDateTime dateTransaction ;
    private LocalDateTime dateEncaissement ;
    @Column(length = 500)
    private String pathPhoto;
    @Column(length = 500)
    private String description;

    private TypeInstrument typeInstrument ;
    private TypeTransaction typeTransaction ;
    private Compte compte ;
    private EtatTransaction etatTransaction ;


    public TransactionFournisseur(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="transaction_fournisseur_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeInstrument getTypeInstrument(){
        return this.typeInstrument;
    }
    public void setTypeInstrument(TypeInstrument typeInstrument){
        this.typeInstrument = typeInstrument;
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
    public LocalDateTime getDateTransaction(){
        return this.dateTransaction;
    }
    public void setDateTransaction(LocalDateTime dateTransaction){
        this.dateTransaction = dateTransaction;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeTransaction getTypeTransaction(){
        return this.typeTransaction;
    }
    public void setTypeTransaction(TypeTransaction typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Compte getCompte(){
        return this.compte;
    }
    public void setCompte(Compte compte){
        this.compte = compte;
    }
    public LocalDateTime getDateEncaissement(){
        return this.dateEncaissement;
    }
    public void setDateEncaissement(LocalDateTime dateEncaissement){
        this.dateEncaissement = dateEncaissement;
    }
    public String getPathPhoto(){
        return this.pathPhoto;
    }
    public void setPathPhoto(String pathPhoto){
        this.pathPhoto = pathPhoto;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatTransaction getEtatTransaction(){
        return this.etatTransaction;
    }
    public void setEtatTransaction(EtatTransaction etatTransaction){
        this.etatTransaction = etatTransaction;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionFournisseur transactionFournisseur = (TransactionFournisseur) o;
        return id != null && id.equals(transactionFournisseur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

