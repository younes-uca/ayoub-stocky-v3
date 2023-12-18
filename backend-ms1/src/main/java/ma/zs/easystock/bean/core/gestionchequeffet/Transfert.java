package ma.zs.easystock.bean.core.gestionchequeffet;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.bean.core.stock.Produit;
import ma.zs.easystock.bean.core.Transfert.Raison;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "transfert")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="transfert_seq",sequenceName="transfert_seq",allocationSize=1, initialValue = 1)
public class Transfert   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateTransfert ;
    @Column(length = 500)
    private String description;

    private Raison raison ;

    private List<TransfertItem> transfertItems ;

    public Transfert(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="transfert_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Raison getRaison(){
        return this.raison;
    }
    public void setRaison(Raison raison){
        this.raison = raison;
    }
    public LocalDateTime getDateTransfert(){
        return this.dateTransfert;
    }
    public void setDateTransfert(LocalDateTime dateTransfert){
        this.dateTransfert = dateTransfert;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @OneToMany(mappedBy = "transfert")

    public List<TransfertItem> getTransfertItems(){
        return this.transfertItems;
    }
    public void setTransfertItems(List<TransfertItem> transfertItems){
        this.transfertItems = transfertItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfert transfert = (Transfert) o;
        return id != null && id.equals(transfert.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

