package  ma.zs.easystock.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.commun.EtatAvoirAchat;
import ma.zs.easystock.ws.dto.commun.EtatAvoirAchatDto;

@Component
public class EtatAvoirAchatConverter extends AbstractConverter<EtatAvoirAchat, EtatAvoirAchatDto> {


    public  EtatAvoirAchatConverter(){//){
        super(EtatAvoirAchat.class, EtatAvoirAchatDto.class);
    }

    @Override
    public EtatAvoirAchat toItem(EtatAvoirAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatAvoirAchat item = new EtatAvoirAchat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public EtatAvoirAchatDto toDto(EtatAvoirAchat item) {
        if (item == null) {
            return null;
        } else {
            EtatAvoirAchatDto dto = new EtatAvoirAchatDto();
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
