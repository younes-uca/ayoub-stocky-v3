package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.gestionchequeffet.EtatTransactionConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.TypeTransactionConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.CompteConverter;
import ma.zs.easystock.ws.converter.gestionchequeffet.TypeInstrumentConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.gestionchequeffet.TransactionFournisseur;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransactionFournisseurDto;

@Component
public class TransactionFournisseurConverter extends AbstractConverter<TransactionFournisseur, TransactionFournisseurDto> {

    @Autowired
    private EtatTransactionConverter etatTransactionConverter ;
    @Autowired
    private TypeTransactionConverter typeTransactionConverter ;
    @Autowired
    private CompteConverter compteConverter ;
    @Autowired
    private TypeInstrumentConverter typeInstrumentConverter ;
    private boolean typeInstrument;
    private boolean typeTransaction;
    private boolean compte;
    private boolean etatTransaction;

    public  TransactionFournisseurConverter(){//EtatTransaction etatTransactionTypeTransaction typeTransactionCompte compteTypeInstrument typeInstrument,){
        super(TransactionFournisseur.class, TransactionFournisseurDto.class);
        //this.etatTransaction =  etatTransaction ;
        //this.typeTransaction =  typeTransaction ;
        //this.compte =  compte ;
        //this.typeInstrument =  typeInstrument ;
    }

    @Override
    public TransactionFournisseur toItem(TransactionFournisseurDto dto) {
        if (dto == null) {
            return null;
        } else {
        TransactionFournisseur item = new TransactionFournisseur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateEmission()))
                item.setDateEmission(DateUtil.stringEnToDate(dto.getDateEmission()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDateTransaction()))
                item.setDateTransaction(DateUtil.stringEnToDate(dto.getDateTransaction()));
            if(StringUtil.isNotEmpty(dto.getDateEncaissement()))
                item.setDateEncaissement(DateUtil.stringEnToDate(dto.getDateEncaissement()));
            if(StringUtil.isNotEmpty(dto.getPathPhoto()))
                item.setPathPhoto(dto.getPathPhoto());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.typeInstrument && dto.getTypeInstrument()!=null &&  dto.getTypeInstrument().getId() != null)
                item.setTypeInstrument(typeInstrumentConverter.toItem(dto.getTypeInstrument())) ;

            if(this.typeTransaction && dto.getTypeTransaction()!=null &&  dto.getTypeTransaction().getId() != null)
                item.setTypeTransaction(typeTransactionConverter.toItem(dto.getTypeTransaction())) ;

            if(this.compte && dto.getCompte()!=null &&  dto.getCompte().getId() != null)
                item.setCompte(compteConverter.toItem(dto.getCompte())) ;

            if(this.etatTransaction && dto.getEtatTransaction()!=null &&  dto.getEtatTransaction().getId() != null)
                item.setEtatTransaction(etatTransactionConverter.toItem(dto.getEtatTransaction())) ;




        return item;
        }
    }

    @Override
    public TransactionFournisseurDto toDto(TransactionFournisseur item) {
        if (item == null) {
            return null;
        } else {
            TransactionFournisseurDto dto = new TransactionFournisseurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateEmission()!=null)
                dto.setDateEmission(DateUtil.dateTimeToString(item.getDateEmission()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(item.getDateTransaction()!=null)
                dto.setDateTransaction(DateUtil.dateTimeToString(item.getDateTransaction()));
            if(item.getDateEncaissement()!=null)
                dto.setDateEncaissement(DateUtil.dateTimeToString(item.getDateEncaissement()));
            if(StringUtil.isNotEmpty(item.getPathPhoto()))
                dto.setPathPhoto(item.getPathPhoto());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.typeInstrument && item.getTypeInstrument()!=null) {
            dto.setTypeInstrument(typeInstrumentConverter.toDto(item.getTypeInstrument())) ;
        }
        if(this.typeTransaction && item.getTypeTransaction()!=null) {
            dto.setTypeTransaction(typeTransactionConverter.toDto(item.getTypeTransaction())) ;
        }
        if(this.compte && item.getCompte()!=null) {
            dto.setCompte(compteConverter.toDto(item.getCompte())) ;
        }
        if(this.etatTransaction && item.getEtatTransaction()!=null) {
            dto.setEtatTransaction(etatTransactionConverter.toDto(item.getEtatTransaction())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.typeInstrument = value;
        this.typeTransaction = value;
        this.compte = value;
        this.etatTransaction = value;
    }


    public EtatTransactionConverter getEtatTransactionConverter(){
        return this.etatTransactionConverter;
    }
    public void setEtatTransactionConverter(EtatTransactionConverter etatTransactionConverter ){
        this.etatTransactionConverter = etatTransactionConverter;
    }
    public TypeTransactionConverter getTypeTransactionConverter(){
        return this.typeTransactionConverter;
    }
    public void setTypeTransactionConverter(TypeTransactionConverter typeTransactionConverter ){
        this.typeTransactionConverter = typeTransactionConverter;
    }
    public CompteConverter getCompteConverter(){
        return this.compteConverter;
    }
    public void setCompteConverter(CompteConverter compteConverter ){
        this.compteConverter = compteConverter;
    }
    public TypeInstrumentConverter getTypeInstrumentConverter(){
        return this.typeInstrumentConverter;
    }
    public void setTypeInstrumentConverter(TypeInstrumentConverter typeInstrumentConverter ){
        this.typeInstrumentConverter = typeInstrumentConverter;
    }
    public boolean  isTypeInstrument(){
        return this.typeInstrument;
    }
    public void  setTypeInstrument(boolean typeInstrument){
        this.typeInstrument = typeInstrument;
    }
    public boolean  isTypeTransaction(){
        return this.typeTransaction;
    }
    public void  setTypeTransaction(boolean typeTransaction){
        this.typeTransaction = typeTransaction;
    }
    public boolean  isCompte(){
        return this.compte;
    }
    public void  setCompte(boolean compte){
        this.compte = compte;
    }
    public boolean  isEtatTransaction(){
        return this.etatTransaction;
    }
    public void  setEtatTransaction(boolean etatTransaction){
        this.etatTransaction = etatTransaction;
    }
}
