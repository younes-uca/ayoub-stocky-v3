package  ma.zs.easystock.ws.converter.depense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.depense.Depense;
import ma.zs.easystock.ws.dto.depense.DepenseDto;

@Component
public class DepenseConverter extends AbstractConverter<Depense, DepenseDto> {


    public  DepenseConverter(){//){
        super(Depense.class, DepenseDto.class);
    }

    @Override
    public Depense toItem(DepenseDto dto) {
        if (dto == null) {
            return null;
        } else {
        Depense item = new Depense();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateDepense()))
                item.setDateDepense(DateUtil.stringEnToDate(dto.getDateDepense()));
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());



        return item;
        }
    }

    @Override
    public DepenseDto toDto(Depense item) {
        if (item == null) {
            return null;
        } else {
            DepenseDto dto = new DepenseDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateDepense()!=null)
                dto.setDateDepense(DateUtil.dateTimeToString(item.getDateDepense()));
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
