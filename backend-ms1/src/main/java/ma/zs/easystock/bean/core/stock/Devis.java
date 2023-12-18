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
@Table(name = "devis")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="devis_seq",sequenceName="devis_seq",allocationSize=1, initialValue = 1)
public class Devis   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String numero;
    private LocalDateTime dateDevis ;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Client client ;

    private List<DevisItem> devisItems ;

    public Devis(){
        super();
    }

    public Devis(Long id,String numero){
        this.id = id;
        this.numero = numero ;
    }
    public Devis(String numero){
        this.numero = numero ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="devis_seq")
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
    public LocalDateTime getDateDevis(){
        return this.dateDevis;
    }
    public void setDateDevis(LocalDateTime dateDevis){
        this.dateDevis = dateDevis;
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
    @OneToMany(mappedBy = "devis")

    public List<DevisItem> getDevisItems(){
        return this.devisItems;
    }
    public void setDevisItems(List<DevisItem> devisItems){
        this.devisItems = devisItems;
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
        Devis devis = (Devis) o;
        return id != null && id.equals(devis.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

