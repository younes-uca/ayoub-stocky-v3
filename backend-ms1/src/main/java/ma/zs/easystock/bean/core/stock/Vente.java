package ma.zs.easystock.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.bean.core.commun.Client;
import ma.zs.easystock.bean.core.reglement.ReglementVente;
import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement;
import ma.zs.easystock.bean.core.commun.EtatVente;
import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.bean.core.commun.EtatAvoirVente;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="vente_seq",sequenceName="vente_seq",allocationSize=1, initialValue = 1)
public class Vente   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String codeVente;
    private LocalDateTime dateFacture ;
    @Column(length = 500)
    private String numeroFacture;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Client client ;
    private EtatVente etatVente ;

    private List<VenteItem> venteItems ;
    private List<AvoirVente> avoirVentes ;
    private List<ReglementVente> reglementVentes ;

    public Vente(){
        super();
    }

    public Vente(Long id,String numeroFacture){
        this.id = id;
        this.numeroFacture = numeroFacture ;
    }
    public Vente(String numeroFacture){
        this.numeroFacture = numeroFacture ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="vente_seq")
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
    public String getCodeVente(){
        return this.codeVente;
    }
    public void setCodeVente(String codeVente){
        this.codeVente = codeVente;
    }
    public LocalDateTime getDateFacture(){
        return this.dateFacture;
    }
    public void setDateFacture(LocalDateTime dateFacture){
        this.dateFacture = dateFacture;
    }
    public String getNumeroFacture(){
        return this.numeroFacture;
    }
    public void setNumeroFacture(String numeroFacture){
        this.numeroFacture = numeroFacture;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatVente getEtatVente(){
        return this.etatVente;
    }
    public void setEtatVente(EtatVente etatVente){
        this.etatVente = etatVente;
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
    @OneToMany(mappedBy = "vente")

    public List<VenteItem> getVenteItems(){
        return this.venteItems;
    }
    public void setVenteItems(List<VenteItem> venteItems){
        this.venteItems = venteItems;
    }
    @OneToMany(mappedBy = "vente")

    public List<AvoirVente> getAvoirVentes(){
        return this.avoirVentes;
    }
    public void setAvoirVentes(List<AvoirVente> avoirVentes){
        this.avoirVentes = avoirVentes;
    }
    @OneToMany(mappedBy = "vente")

    public List<ReglementVente> getReglementVentes(){
        return this.reglementVentes;
    }
    public void setReglementVentes(List<ReglementVente> reglementVentes){
        this.reglementVentes = reglementVentes;
    }

    @Transient
    public String getLabel() {
        label = numeroFacture;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vente vente = (Vente) o;
        return id != null && id.equals(vente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

