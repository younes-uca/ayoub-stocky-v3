package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.gestionchequeffet.TypeTransaction;
import ma.zs.easystock.ws.dto.gestionchequeffet.TypeTransactionDto;

@Component
public class TypeTransactionConverter extends AbstractConverter<TypeTransaction, TypeTransactionDto> {


    public  TypeTransactionConverter(){//){
        super(TypeTransaction.class, TypeTransactionDto.class);
    }

    @Override
    public TypeTransaction toItem(TypeTransactionDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeTransaction item = new TypeTransaction();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public TypeTransactionDto toDto(TypeTransaction item) {
        if (item == null) {
            return null;
        } else {
            TypeTransactionDto dto = new TypeTransactionDto();
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
