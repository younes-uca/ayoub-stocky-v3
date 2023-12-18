package ma.zs.easystock.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.easystock.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "mode_reglement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="mode_reglement_seq",sequenceName="mode_reglement_seq",allocationSize=1, initialValue = 1)
public class ModeReglement   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;



    public ModeReglement(){
        super();
    }

    public ModeReglement(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public ModeReglement(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="mode_reglement_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeReglement modeReglement = (ModeReglement) o;
        return id != null && id.equals(modeReglement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

