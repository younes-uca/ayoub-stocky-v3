package  ma.zs.easystock.dao.criteria.core.gestionchequeffet;



import ma.zs.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class TransactionFournisseurCriteria extends  BaseCriteria  {

    private LocalDateTime dateEmission;
    private LocalDateTime dateEmissionFrom;
    private LocalDateTime dateEmissionTo;
    private String montant;
    private String montantMin;
    private String montantMax;
    private LocalDateTime dateTransaction;
    private LocalDateTime dateTransactionFrom;
    private LocalDateTime dateTransactionTo;
    private LocalDateTime dateEncaissement;
    private LocalDateTime dateEncaissementFrom;
    private LocalDateTime dateEncaissementTo;
    private String pathPhoto;
    private String pathPhotoLike;
    private String description;
    private String descriptionLike;

    private TypeInstrumentCriteria typeInstrument ;
    private List<TypeInstrumentCriteria> typeInstruments ;
    private TypeTransactionCriteria typeTransaction ;
    private List<TypeTransactionCriteria> typeTransactions ;
    private CompteCriteria compte ;
    private List<CompteCriteria> comptes ;
    private EtatTransactionCriteria etatTransaction ;
    private List<EtatTransactionCriteria> etatTransactions ;


    public TransactionFournisseurCriteria(){}

    public LocalDateTime getDateEmission(){
        return this.dateEmission;
    }
    public void setDateEmission(LocalDateTime dateEmission){
        this.dateEmission = dateEmission;
    }
    public LocalDateTime getDateEmissionFrom(){
        return this.dateEmissionFrom;
    }
    public void setDateEmissionFrom(LocalDateTime dateEmissionFrom){
        this.dateEmissionFrom = dateEmissionFrom;
    }
    public LocalDateTime getDateEmissionTo(){
        return this.dateEmissionTo;
    }
    public void setDateEmissionTo(LocalDateTime dateEmissionTo){
        this.dateEmissionTo = dateEmissionTo;
    }
    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
    }
      
    public LocalDateTime getDateTransaction(){
        return this.dateTransaction;
    }
    public void setDateTransaction(LocalDateTime dateTransaction){
        this.dateTransaction = dateTransaction;
    }
    public LocalDateTime getDateTransactionFrom(){
        return this.dateTransactionFrom;
    }
    public void setDateTransactionFrom(LocalDateTime dateTransactionFrom){
        this.dateTransactionFrom = dateTransactionFrom;
    }
    public LocalDateTime getDateTransactionTo(){
        return this.dateTransactionTo;
    }
    public void setDateTransactionTo(LocalDateTime dateTransactionTo){
        this.dateTransactionTo = dateTransactionTo;
    }
    public LocalDateTime getDateEncaissement(){
        return this.dateEncaissement;
    }
    public void setDateEncaissement(LocalDateTime dateEncaissement){
        this.dateEncaissement = dateEncaissement;
    }
    public LocalDateTime getDateEncaissementFrom(){
        return this.dateEncaissementFrom;
    }
    public void setDateEncaissementFrom(LocalDateTime dateEncaissementFrom){
        this.dateEncaissementFrom = dateEncaissementFrom;
    }
    public LocalDateTime getDateEncaissementTo(){
        return this.dateEncaissementTo;
    }
    public void setDateEncaissementTo(LocalDateTime dateEncaissementTo){
        this.dateEncaissementTo = dateEncaissementTo;
    }
    public String getPathPhoto(){
        return this.pathPhoto;
    }
    public void setPathPhoto(String pathPhoto){
        this.pathPhoto = pathPhoto;
    }
    public String getPathPhotoLike(){
        return this.pathPhotoLike;
    }
    public void setPathPhotoLike(String pathPhotoLike){
        this.pathPhotoLike = pathPhotoLike;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public TypeInstrumentCriteria getTypeInstrument(){
        return this.typeInstrument;
    }

    public void setTypeInstrument(TypeInstrumentCriteria typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    public List<TypeInstrumentCriteria> getTypeInstruments(){
        return this.typeInstruments;
    }

    public void setTypeInstruments(List<TypeInstrumentCriteria> typeInstruments){
        this.typeInstruments = typeInstruments;
    }
    public TypeTransactionCriteria getTypeTransaction(){
        return this.typeTransaction;
    }

    public void setTypeTransaction(TypeTransactionCriteria typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    public List<TypeTransactionCriteria> getTypeTransactions(){
        return this.typeTransactions;
    }

    public void setTypeTransactions(List<TypeTransactionCriteria> typeTransactions){
        this.typeTransactions = typeTransactions;
    }
    public CompteCriteria getCompte(){
        return this.compte;
    }

    public void setCompte(CompteCriteria compte){
        this.compte = compte;
    }
    public List<CompteCriteria> getComptes(){
        return this.comptes;
    }

    public void setComptes(List<CompteCriteria> comptes){
        this.comptes = comptes;
    }
    public EtatTransactionCriteria getEtatTransaction(){
        return this.etatTransaction;
    }

    public void setEtatTransaction(EtatTransactionCriteria etatTransaction){
        this.etatTransaction = etatTransaction;
    }
    public List<EtatTransactionCriteria> getEtatTransactions(){
        return this.etatTransactions;
    }

    public void setEtatTransactions(List<EtatTransactionCriteria> etatTransactions){
        this.etatTransactions = etatTransactions;
    }
}
