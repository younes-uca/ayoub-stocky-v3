package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.gestionchequeffet.TypeInstrument;
import ma.zs.easystock.ws.dto.gestionchequeffet.TypeInstrumentDto;

@Component
public class TypeInstrumentConverter extends AbstractConverter<TypeInstrument, TypeInstrumentDto> {


    public  TypeInstrumentConverter(){//){
        super(TypeInstrument.class, TypeInstrumentDto.class);
    }

    @Override
    public TypeInstrument toItem(TypeInstrumentDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeInstrument item = new TypeInstrument();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public TypeInstrumentDto toDto(TypeInstrument item) {
        if (item == null) {
            return null;
        } else {
            TypeInstrumentDto dto = new TypeInstrumentDto();
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
