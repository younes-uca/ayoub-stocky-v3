package  ma.zs.easystock.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.commun.EtatVente;
import ma.zs.easystock.ws.dto.commun.EtatVenteDto;

@Component
public class EtatVenteConverter extends AbstractConverter<EtatVente, EtatVenteDto> {


    public  EtatVenteConverter(){//){
        super(EtatVente.class, EtatVenteDto.class);
    }

    @Override
    public EtatVente toItem(EtatVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatVente item = new EtatVente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public EtatVenteDto toDto(EtatVente item) {
        if (item == null) {
            return null;
        } else {
            EtatVenteDto dto = new EtatVenteDto();
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
