package  ma.zs.easystock.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.stock.Taxe;
import ma.zs.easystock.ws.dto.stock.TaxeDto;

@Component
public class TaxeConverter extends AbstractConverter<Taxe, TaxeDto> {


    public  TaxeConverter(){//){
        super(Taxe.class, TaxeDto.class);
    }

    @Override
    public Taxe toItem(TaxeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Taxe item = new Taxe();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());



        return item;
        }
    }

    @Override
    public TaxeDto toDto(Taxe item) {
        if (item == null) {
            return null;
        } else {
            TaxeDto dto = new TaxeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
