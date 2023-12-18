package ma.zs.easystock.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.bean.core.commun.Client;
import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.bean.core.commun.EtatAvoirVente;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "avoir_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_vente_seq",sequenceName="avoir_vente_seq",allocationSize=1, initialValue = 1)
public class AvoirVente   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String codeAvoirVente;
    @Column(length = 500)
    private String numeroFactureAvoirVente;
    private LocalDateTime dateFactureAvoirVente ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Client client ;
    private EtatAvoirVente etatAvoirVente ;
    private Vente vente ;

    private List<AvoirVenteItem> avoirVenteItems ;

    public AvoirVente(){
        super();
    }

    public AvoirVente(Long id,String numeroFactureAvoirVente){
        this.id = id;
        this.numeroFactureAvoirVente = numeroFactureAvoirVente ;
    }
    public AvoirVente(String numeroFactureAvoirVente){
        this.numeroFactureAvoirVente = numeroFactureAvoirVente ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="avoir_vente_seq")
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
    public String getCodeAvoirVente(){
        return this.codeAvoirVente;
    }
    public void setCodeAvoirVente(String codeAvoirVente){
        this.codeAvoirVente = codeAvoirVente;
    }
    public String getNumeroFactureAvoirVente(){
        return this.numeroFactureAvoirVente;
    }
    public void setNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        this.numeroFactureAvoirVente = numeroFactureAvoirVente;
    }
    public LocalDateTime getDateFactureAvoirVente(){
        return this.dateFactureAvoirVente;
    }
    public void setDateFactureAvoirVente(LocalDateTime dateFactureAvoirVente){
        this.dateFactureAvoirVente = dateFactureAvoirVente;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatAvoirVente getEtatAvoirVente(){
        return this.etatAvoirVente;
    }
    public void setEtatAvoirVente(EtatAvoirVente etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
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
    public Vente getVente(){
        return this.vente;
    }
    public void setVente(Vente vente){
        this.vente = vente;
    }
    @OneToMany(mappedBy = "avoirVente")

    public List<AvoirVenteItem> getAvoirVenteItems(){
        return this.avoirVenteItems;
    }
    public void setAvoirVenteItems(List<AvoirVenteItem> avoirVenteItems){
        this.avoirVenteItems = avoirVenteItems;
    }

    @Transient
    public String getLabel() {
        label = numeroFactureAvoirVente;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirVente avoirVente = (AvoirVente) o;
        return id != null && id.equals(avoirVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

