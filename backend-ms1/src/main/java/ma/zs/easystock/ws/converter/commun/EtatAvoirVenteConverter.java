package  ma.zs.easystock.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.commun.EtatAvoirVente;
import ma.zs.easystock.ws.dto.commun.EtatAvoirVenteDto;

@Component
public class EtatAvoirVenteConverter extends AbstractConverter<EtatAvoirVente, EtatAvoirVenteDto> {


    public  EtatAvoirVenteConverter(){//){
        super(EtatAvoirVente.class, EtatAvoirVenteDto.class);
    }

    @Override
    public EtatAvoirVente toItem(EtatAvoirVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatAvoirVente item = new EtatAvoirVente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public EtatAvoirVenteDto toDto(EtatAvoirVente item) {
        if (item == null) {
            return null;
        } else {
            EtatAvoirVenteDto dto = new EtatAvoirVenteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
