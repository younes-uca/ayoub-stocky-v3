package  ma.zs.easystock.ws.converter.reglement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.easystock.ws.converter.gestionchequeffet.ModeReglementConverter;
import ma.zs.easystock.ws.converter.stock.VenteConverter;

import ma.zs.easystock.bean.core.stock.Vente;


import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.reglement.ReglementVente;
import ma.zs.easystock.ws.dto.reglement.ReglementVenteDto;

@Component
public class ReglementVenteConverter extends AbstractConverter<ReglementVente, ReglementVenteDto> {

    @Autowired
    private ModeReglementConverter modeReglementConverter ;
    @Autowired
    private VenteConverter venteConverter ;
    private boolean vente;
    private boolean modeReglement;

    public  ReglementVenteConverter(){//ModeReglement modeReglementVente vente,){
        super(ReglementVente.class, ReglementVenteDto.class);
        //this.modeReglement =  modeReglement ;
        //this.vente =  vente ;
    }

    @Override
    public ReglementVente toItem(ReglementVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReglementVente item = new ReglementVente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateReglement()))
                item.setDateReglement(DateUtil.stringEnToDate(dto.getDateReglement()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getVente() != null && dto.getVente().getId() != null){
                item.setVente(new Vente());
                item.getVente().setId(dto.getVente().getId());
                item.getVente().setNumeroFacture(dto.getVente().getNumeroFacture());
            }

            if(this.modeReglement && dto.getModeReglement()!=null &&  dto.getModeReglement().getId() != null)
                item.setModeReglement(modeReglementConverter.toItem(dto.getModeReglement())) ;




        return item;
        }
    }

    @Override
    public ReglementVenteDto toDto(ReglementVente item) {
        if (item == null) {
            return null;
        } else {
            ReglementVenteDto dto = new ReglementVenteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateReglement()!=null)
                dto.setDateReglement(DateUtil.dateTimeToString(item.getDateReglement()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.vente && item.getVente()!=null) {
            dto.setVente(venteConverter.toDto(item.getVente())) ;
        }
        if(this.modeReglement && item.getModeReglement()!=null) {
            dto.setModeReglement(modeReglementConverter.toDto(item.getModeReglement())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.vente = value;
        this.modeReglement = value;
    }


    public ModeReglementConverter getModeReglementConverter(){
        return this.modeReglementConverter;
    }
    public void setModeReglementConverter(ModeReglementConverter modeReglementConverter ){
        this.modeReglementConverter = modeReglementConverter;
    }
    public VenteConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteConverter(VenteConverter venteConverter ){
        this.venteConverter = venteConverter;
    }
    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
    public boolean  isModeReglement(){
        return this.modeReglement;
    }
    public void  setModeReglement(boolean modeReglement){
        this.modeReglement = modeReglement;
    }
}
