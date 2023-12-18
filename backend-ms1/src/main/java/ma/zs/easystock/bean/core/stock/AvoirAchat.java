package ma.zs.easystock.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.bean.core.commun.Fournisseur;
import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.bean.core.commun.EtatAvoirAchat;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "avoir_achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_achat_seq",sequenceName="avoir_achat_seq",allocationSize=1, initialValue = 1)
public class AvoirAchat   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String codeAvoirAchat;
    @Column(length = 500)
    private String numeroFactureAvoirFournisseur;
    private LocalDateTime dateFactureAvoirFournisseur ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Fournisseur fournisseur ;
    private EtatAvoirAchat etatAvoirAchat ;
    private Achat achat ;

    private List<AvoirAchatItem> avoirAchatItems ;

    public AvoirAchat(){
        super();
    }

    public AvoirAchat(Long id,String numeroFactureAvoirFournisseur){
        this.id = id;
        this.numeroFactureAvoirFournisseur = numeroFactureAvoirFournisseur ;
    }
    public AvoirAchat(String numeroFactureAvoirFournisseur){
        this.numeroFactureAvoirFournisseur = numeroFactureAvoirFournisseur ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="avoir_achat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EntrepriseSociete getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSociete entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public String getCodeAvoirAchat(){
        return this.codeAvoirAchat;
    }
    public void setCodeAvoirAchat(String codeAvoirAchat){
        this.codeAvoirAchat = codeAvoirAchat;
    }
    public String getNumeroFactureAvoirFournisseur(){
        return this.numeroFactureAvoirFournisseur;
    }
    public void setNumeroFactureAvoirFournisseur(String numeroFactureAvoirFournisseur){
        this.numeroFactureAvoirFournisseur = numeroFactureAvoirFournisseur;
    }
    public LocalDateTime getDateFactureAvoirFournisseur(){
        return this.dateFactureAvoirFournisseur;
    }
    public void setDateFactureAvoirFournisseur(LocalDateTime dateFactureAvoirFournisseur){
        this.dateFactureAvoirFournisseur = dateFactureAvoirFournisseur;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Fournisseur getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatAvoirAchat getEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }
    public void setEtatAvoirAchat(EtatAvoirAchat etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
    }
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }
    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Achat getAchat(){
        return this.achat;
    }
    public void setAchat(Achat achat){
        this.achat = achat;
    }
    @OneToMany(mappedBy = "avoirAchat")

    public List<AvoirAchatItem> getAvoirAchatItems(){
        return this.avoirAchatItems;
    }
    public void setAvoirAchatItems(List<AvoirAchatItem> avoirAchatItems){
        this.avoirAchatItems = avoirAchatItems;
    }

    @Transient
    public String getLabel() {
        label = numeroFactureAvoirFournisseur;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirAchat avoirAchat = (AvoirAchat) o;
        return id != null && id.equals(avoirAchat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

