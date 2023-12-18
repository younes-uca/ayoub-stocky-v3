package ma.zs.easystock.bean.core.stock;

import java.util.Objects;





import ma.zs.easystock.bean.core.entree.SortieProduit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "sortie_produit_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sortie_produit_item_seq",sequenceName="sortie_produit_item_seq",allocationSize=1, initialValue = 1)
public class SortieProduitItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Produit produit ;
    private SortieProduit sortieProduit ;


    public SortieProduitItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="sortie_produit_item_seq")
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
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public SortieProduit getSortieProduit(){
        return this.sortieProduit;
    }
    public void setSortieProduit(SortieProduit sortieProduit){
        this.sortieProduit = sortieProduit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortieProduitItem sortieProduitItem = (SortieProduitItem) o;
        return id != null && id.equals(sortieProduitItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

