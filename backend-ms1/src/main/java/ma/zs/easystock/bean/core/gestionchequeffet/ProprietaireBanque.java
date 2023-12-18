package ma.zs.easystock.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "proprietaire_banque")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="proprietaire_banque_seq",sequenceName="proprietaire_banque_seq",allocationSize=1, initialValue = 1)
public class ProprietaireBanque   extends AuditBusinessObject     {

    private Long id;


    private Proprietaire proprietaire ;
    private Banque banque ;
    private Compte compte ;


    public ProprietaireBanque(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="proprietaire_banque_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Proprietaire getProprietaire(){
        return this.proprietaire;
    }
    public void setProprietaire(Proprietaire proprietaire){
        this.proprietaire = proprietaire;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Banque getBanque(){
        return this.banque;
    }
    public void setBanque(Banque banque){
        this.banque = banque;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Compte getCompte(){
        return this.compte;
    }
    public void setCompte(Compte compte){
        this.compte = compte;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietaireBanque proprietaireBanque = (ProprietaireBanque) o;
        return id != null && id.equals(proprietaireBanque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

