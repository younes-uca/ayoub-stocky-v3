package  ma.zs.easystock.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.easystock.zynerator.util.StringUtil;
import ma.zs.easystock.zynerator.converter.AbstractConverter;
import ma.zs.easystock.zynerator.util.DateUtil;
import ma.zs.easystock.bean.core.gestionchequeffet.EtatTransaction;
import ma.zs.easystock.ws.dto.gestionchequeffet.EtatTransactionDto;

@Component
public class EtatTransactionConverter extends AbstractConverter<EtatTransaction, EtatTransactionDto> {


    public  EtatTransactionConverter(){//){
        super(EtatTransaction.class, EtatTransactionDto.class);
    }

    @Override
    public EtatTransaction toItem(EtatTransactionDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatTransaction item = new EtatTransaction();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public EtatTransactionDto toDto(EtatTransaction item) {
        if (item == null) {
            return null;
        } else {
            EtatTransactionDto dto = new EtatTransactionDto();
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
