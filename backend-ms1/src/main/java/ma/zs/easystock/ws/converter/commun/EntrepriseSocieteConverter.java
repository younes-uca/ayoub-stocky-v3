package  ma.zs.easystock.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.commun.EntrepriseSociete;
import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;

@Component
public class EntrepriseSocieteConverter extends AbstractConverter<EntrepriseSociete, EntrepriseSocieteDto> {


    public  EntrepriseSocieteConverter(){//){
        super(EntrepriseSociete.class, EntrepriseSocieteDto.class);
    }

    @Override
    public EntrepriseSociete toItem(EntrepriseSocieteDto dto) {
        if (dto == null) {
            return null;
        } else {
        EntrepriseSociete item = new EntrepriseSociete();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());
            if(StringUtil.isNotEmpty(dto.getCapital()))
                item.setCapital(dto.getCapital());



        return item;
        }
    }

    @Override
    public EntrepriseSocieteDto toDto(EntrepriseSociete item) {
        if (item == null) {
            return null;
        } else {
            EntrepriseSocieteDto dto = new EntrepriseSocieteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
            if(StringUtil.isNotEmpty(item.getCapital()))
                dto.setCapital(item.getCapital());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
