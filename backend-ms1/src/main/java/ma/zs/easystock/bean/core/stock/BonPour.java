package ma.zs.easystock.bean.core.stock;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.easystock.bean.core.commun.Client;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "bon_pour")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bon_pour_seq",sequenceName="bon_pour_seq",allocationSize=1, initialValue = 1)
public class BonPour   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String numero;
    private LocalDateTime dateBonPour ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Client client ;

    private List<BonPourItem> bonPourItems ;

    public BonPour(){
        super();
    }

    public BonPour(Long id,String numero){
        this.id = id;
        this.numero = numero ;
    }
    public BonPour(String numero){
        this.numero = numero ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="bon_pour_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNumero(){
        return this.numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public LocalDateTime getDateBonPour(){
        return this.dateBonPour;
    }
    public void setDateBonPour(LocalDateTime dateBonPour){
        this.dateBonPour = dateBonPour;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
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
    @OneToMany(mappedBy = "bonPour")

    public List<BonPourItem> getBonPourItems(){
        return this.bonPourItems;
    }
    public void setBonPourItems(List<BonPourItem> bonPourItems){
        this.bonPourItems = bonPourItems;
    }

    @Transient
    public String getLabel() {
        label = numero;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonPour bonPour = (BonPour) o;
        return id != null && id.equals(bonPour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

