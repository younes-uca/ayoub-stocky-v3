package ma.zs.easystock.bean.core.stock;

import java.util.Objects;
import java.util.List;





import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.bean.core.commun.Marque;
import ma.zs.easystock.bean.core.commun.Categorie;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete;
import ma.zs.easystock.bean.core.commun.UniteMesure;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="produit_seq",sequenceName="produit_seq",allocationSize=1, initialValue = 1)
public class Produit   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String barCode;
    @Column(length = 500)
    private String designation;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal prixAchatMoyen = BigDecimal.ZERO;
    private BigDecimal prixVente = BigDecimal.ZERO;
    @Column(length = 500)
    private String pathPhoto;
    private BigDecimal seuilAlerte = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private EntrepriseSociete entrepriseSociete ;
    private Categorie categorie ;
    private Marque marque ;
    private UniteMesure uniteMesure ;

    private List<Stock> stocks ;

    public Produit(){
        super();
    }

    public Produit(Long id,String designation){
        this.id = id;
        this.designation = designation ;
    }
    public Produit(String designation){
        this.designation = designation ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="produit_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EntrepriseSociete getEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void setEntrepriseSociete(EntrepriseSociete entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getBarCode(){
        return this.barCode;
    }
    public void setBarCode(String barCode){
        this.barCode = barCode;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Categorie getCategorie(){
        return this.categorie;
    }
    public void setCategorie(Categorie categorie){
        this.categorie = categorie;
    }
    public String getDesignation(){
        return this.designation;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Marque getMarque(){
        return this.marque;
    }
    public void setMarque(Marque marque){
        this.marque = marque;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public UniteMesure getUniteMesure(){
        return this.uniteMesure;
    }
    public void setUniteMesure(UniteMesure uniteMesure){
        this.uniteMesure = uniteMesure;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public BigDecimal getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }
    public BigDecimal getPrixVente(){
        return this.prixVente;
    }
    public void setPrixVente(BigDecimal prixVente){
        this.prixVente = prixVente;
    }
    @OneToMany(mappedBy = "produit")

    public List<Stock> getStocks(){
        return this.stocks;
    }
    public void setStocks(List<Stock> stocks){
        this.stocks = stocks;
    }
    public String getPathPhoto(){
        return this.pathPhoto;
    }
    public void setPathPhoto(String pathPhoto){
        this.pathPhoto = pathPhoto;
    }
    public BigDecimal getSeuilAlerte(){
        return this.seuilAlerte;
    }
    public void setSeuilAlerte(BigDecimal seuilAlerte){
        this.seuilAlerte = seuilAlerte;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Transient
    public String getLabel() {
        label = designation;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id != null && id.equals(produit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

