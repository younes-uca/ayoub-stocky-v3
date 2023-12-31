package ma.zs.easystock.bean.core.reglement;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.bean.core.stock.AvoirAchat;
import ma.zs.easystock.bean.core.stock.Achat;
import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "reglement_avoir_achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="reglement_avoir_achat_seq",sequenceName="reglement_avoir_achat_seq",allocationSize=1, initialValue = 1)
public class ReglementAvoirAchat   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateReglement ;
    private BigDecimal montant = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Achat achat ;
    private ModeReglement modeReglement ;
    private AvoirAchat avoirAchat ;


    public ReglementAvoirAchat(){
        super();
    }

    public ReglementAvoirAchat(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public ReglementAvoirAchat(String reference){
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="reglement_avoir_achat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDateReglement(){
        return this.dateReglement;
    }
    public void setDateReglement(LocalDateTime dateReglement){
        this.dateReglement = dateReglement;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Achat getAchat(){
        return this.achat;
    }
    public void setAchat(Achat achat){
        this.achat = achat;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ModeReglement getModeReglement(){
        return this.modeReglement;
    }
    public void setModeReglement(ModeReglement modeReglement){
        this.modeReglement = modeReglement;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public AvoirAchat getAvoirAchat(){
        return this.avoirAchat;
    }
    public void setAvoirAchat(AvoirAchat avoirAchat){
        this.avoirAchat = avoirAchat;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReglementAvoirAchat reglementAvoirAchat = (ReglementAvoirAchat) o;
        return id != null && id.equals(reglementAvoirAchat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

