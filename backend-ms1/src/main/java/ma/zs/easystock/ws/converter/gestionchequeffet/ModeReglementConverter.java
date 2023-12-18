package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement;
import ma.zs.easystock.ws.dto.gestionchequeffet.ModeReglementDto;

@Component
public class ModeReglementConverter extends AbstractConverter<ModeReglement, ModeReglementDto> {


    public  ModeReglementConverter(){//){
        super(ModeReglement.class, ModeReglementDto.class);
    }

    @Override
    public ModeReglement toItem(ModeReglementDto dto) {
        if (dto == null) {
            return null;
        } else {
        ModeReglement item = new ModeReglement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public ModeReglementDto toDto(ModeReglement item) {
        if (item == null) {
            return null;
        } else {
            ModeReglementDto dto = new ModeReglementDto();
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
