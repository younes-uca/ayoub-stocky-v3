package  ma.zs.easystock.ws.converter.Transfert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.Transfert.Raison;
import ma.zs.easystock.ws.dto.Transfert.RaisonDto;

@Component
public class RaisonConverter extends AbstractConverter<Raison, RaisonDto> {


    public  RaisonConverter(){//){
        super(Raison.class, RaisonDto.class);
    }

    @Override
    public Raison toItem(RaisonDto dto) {
        if (dto == null) {
            return null;
        } else {
        Raison item = new Raison();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public RaisonDto toDto(Raison item) {
        if (item == null) {
            return null;
        } else {
            RaisonDto dto = new RaisonDto();
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
