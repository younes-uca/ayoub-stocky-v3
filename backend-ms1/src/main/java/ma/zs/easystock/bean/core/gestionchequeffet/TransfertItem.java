package ma.zs.easystock.bean.core.gestionchequeffet;

import java.util.Objects;





import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.bean.core.stock.Produit;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "transfert_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="transfert_item_seq",sequenceName="transfert_item_seq",allocationSize=1, initialValue = 1)
public class TransfertItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;

    private Depot depot ;
    private Produit produit ;
    private Transfert transfert ;


    public TransfertItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="transfert_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Depot getDepot(){
        return this.depot;
    }
    public void setDepot(Depot depot){
        this.depot = depot;
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Transfert getTransfert(){
        return this.transfert;
    }
    public void setTransfert(Transfert transfert){
        this.transfert = transfert;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransfertItem transfertItem = (TransfertItem) o;
        return id != null && id.equals(transfertItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

