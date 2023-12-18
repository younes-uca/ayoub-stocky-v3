package ma.zs.easystock.bean.core.stock;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "inventaire_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="inventaire_item_seq",sequenceName="inventaire_item_seq",allocationSize=1, initialValue = 1)
public class InventaireItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantiteEstime = BigDecimal.ZERO;
    private BigDecimal quantiteReelle = BigDecimal.ZERO;

    private Produit produit ;
    private Inventaire inventaire ;


    public InventaireItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="inventaire_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public BigDecimal getQuantiteEstime(){
        return this.quantiteEstime;
    }
    public void setQuantiteEstime(BigDecimal quantiteEstime){
        this.quantiteEstime = quantiteEstime;
    }
    public BigDecimal getQuantiteReelle(){
        return this.quantiteReelle;
    }
    public void setQuantiteReelle(BigDecimal quantiteReelle){
        this.quantiteReelle = quantiteReelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Inventaire getInventaire(){
        return this.inventaire;
    }
    public void setInventaire(Inventaire inventaire){
        this.inventaire = inventaire;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventaireItem inventaireItem = (InventaireItem) o;
        return id != null && id.equals(inventaireItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

