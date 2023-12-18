package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.commun.FournisseurConverter;



import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.gestionchequeffet.ChequeEffet;
import ma.zs.easystock.ws.dto.gestionchequeffet.ChequeEffetDto;

@Component
public class ChequeEffetConverter extends AbstractConverter<ChequeEffet, ChequeEffetDto> {

    @Autowired
    private FournisseurConverter fournisseurConverter ;
    private boolean fournisseur;

    public  ChequeEffetConverter(){//Fournisseur fournisseur,){
        super(ChequeEffet.class, ChequeEffetDto.class);
        //this.fournisseur =  fournisseur ;
    }

    @Override
    public ChequeEffet toItem(ChequeEffetDto dto) {
        if (dto == null) {
            return null;
        } else {
        ChequeEffet item = new ChequeEffet();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNumero()))
                item.setNumero(dto.getNumero());
            if(StringUtil.isNotEmpty(dto.getDateEmission()))
                item.setDateEmission(DateUtil.stringEnToDate(dto.getDateEmission()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(this.fournisseur && dto.getFournisseur()!=null &&  dto.getFournisseur().getId() != null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;




        return item;
        }
    }

    @Override
    public ChequeEffetDto toDto(ChequeEffet item) {
        if (item == null) {
            return null;
        } else {
            ChequeEffetDto dto = new ChequeEffetDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNumero()))
                dto.setNumero(item.getNumero());
            if(item.getDateEmission()!=null)
                dto.setDateEmission(DateUtil.dateTimeToString(item.getDateEmission()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.fournisseur = value;
    }


    public FournisseurConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurConverter(FournisseurConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
}
