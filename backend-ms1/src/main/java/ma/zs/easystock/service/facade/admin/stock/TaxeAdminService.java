package ma.zs.easystock.service.facade.admin.stock;

import java.util.List;
import ma.zs.easystock.bean.core.stock.Taxe;
import ma.zs.easystock.dao.criteria.core.stock.TaxeCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.stock.TaxeDto;
import org.springframework.http.HttpEntity;


public interface TaxeAdminService extends  IService<Taxe,TaxeCriteria>  {



    HttpEntity<byte[]> createPdf(TaxeDto dto) throws Exception;

}
