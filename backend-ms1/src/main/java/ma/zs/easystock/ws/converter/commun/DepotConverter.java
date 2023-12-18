package  ma.zs.easystock.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.ws.dto.commun.DepotDto;

@Component
public class DepotConverter extends AbstractConverter<Depot, DepotDto> {


    public  DepotConverter(){//){
        super(Depot.class, DepotDto.class);
    }

    @Override
    public Depot toItem(DepotDto dto) {
        if (dto == null) {
            return null;
        } else {
        Depot item = new Depot();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());



        return item;
        }
    }

    @Override
    public DepotDto toDto(Depot item) {
        if (item == null) {
            return null;
        } else {
            DepotDto dto = new DepotDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
