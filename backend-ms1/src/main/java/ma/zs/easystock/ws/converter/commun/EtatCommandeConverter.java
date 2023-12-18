package  ma.zs.easystock.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.commun.EtatCommande;
import ma.zs.easystock.ws.dto.commun.EtatCommandeDto;

@Component
public class EtatCommandeConverter extends AbstractConverter<EtatCommande, EtatCommandeDto> {


    public  EtatCommandeConverter(){//){
        super(EtatCommande.class, EtatCommandeDto.class);
    }

    @Override
    public EtatCommande toItem(EtatCommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatCommande item = new EtatCommande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public EtatCommandeDto toDto(EtatCommande item) {
        if (item == null) {
            return null;
        } else {
            EtatCommandeDto dto = new EtatCommandeDto();
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
