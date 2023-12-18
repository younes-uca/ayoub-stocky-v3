package  ma.zs.easystock.ws.dto.gestionchequeffet;

import ma.zs.easystock.zynerator.audit.Log;
import ma.zs.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionFournisseurDto  extends AuditBaseDto {

    private String dateEmission ;
    private BigDecimal montant  ;
    private String dateTransaction ;
    private String dateEncaissement ;
    private String pathPhoto  ;
    private String description  ;

    private TypeInstrumentDto typeInstrument ;
    private TypeTransactionDto typeTransaction ;
    private CompteDto compte ;
    private EtatTransactionDto etatTransaction ;



    public TransactionFournisseurDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(String dateEmission){
        this.dateEmission = dateEmission;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateTransaction(){
        return this.dateTransaction;
    }
    public void setDateTransaction(String dateTransaction){
        this.dateTransaction = dateTransaction;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEncaissement(){
        return this.dateEncaissement;
    }
    public void setDateEncaissement(String dateEncaissement){
        this.dateEncaissement = dateEncaissement;
    }

    @Log
    public String getPathPhoto(){
        return this.pathPhoto;
    }
    public void setPathPhoto(String pathPhoto){
        this.pathPhoto = pathPhoto;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public TypeInstrumentDto getTypeInstrument(){
        return this.typeInstrument;
    }

    public void setTypeInstrument(TypeInstrumentDto typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    public TypeTransactionDto getTypeTransaction(){
        return this.typeTransaction;
    }

    public void setTypeTransaction(TypeTransactionDto typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    public CompteDto getCompte(){
        return this.compte;
    }

    public void setCompte(CompteDto compte){
        this.compte = compte;
    }
    public EtatTransactionDto getEtatTransaction(){
        return this.etatTransaction;
    }

    public void setEtatTransaction(EtatTransactionDto etatTransaction){
        this.etatTransaction = etatTransaction;
    }






}
