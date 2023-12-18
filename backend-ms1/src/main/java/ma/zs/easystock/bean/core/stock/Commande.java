package ma.zs.easystock.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.bean.core.commun.Client;
import ma.zs.easystock.bean.core.commun.EtatCommande;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "commande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="commande_seq",sequenceName="commande_seq",allocationSize=1, initialValue = 1)
public class Commande   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String numeroCommande;
    private LocalDateTime dateCommande ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Client client ;
    private EtatCommande etatCommande ;

    private List<CommandeItem> commandeItems ;

    public Commande(){
        super();
    }

    public Commande(Long id,String numeroCommande){
        this.id = id;
        this.numeroCommande = numeroCommande ;
    }
    public Commande(String numeroCommande){
        this.numeroCommande = numeroCommande ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="commande_seq")
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
    public String getNumeroCommande(){
        return this.numeroCommande;
    }
    public void setNumeroCommande(String numeroCommande){
        this.numeroCommande = numeroCommande;
    }
    public LocalDateTime getDateCommande(){
        return this.dateCommande;
    }
    public void setDateCommande(LocalDateTime dateCommande){
        this.dateCommande = dateCommande;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatCommande getEtatCommande(){
        return this.etatCommande;
    }
    public void setEtatCommande(EtatCommande etatCommande){
        this.etatCommande = etatCommande;
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
    @OneToMany(mappedBy = "commande")

    public List<CommandeItem> getCommandeItems(){
        return this.commandeItems;
    }
    public void setCommandeItems(List<CommandeItem> commandeItems){
        this.commandeItems = commandeItems;
    }

    @Transient
    public String getLabel() {
        label = numeroCommande;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return id != null && id.equals(commande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

