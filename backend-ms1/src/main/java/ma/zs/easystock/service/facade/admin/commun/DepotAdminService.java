package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.dao.criteria.core.commun.DepotCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.commun.DepotDto;
import org.springframework.http.HttpEntity;


public interface DepotAdminService extends  IService<Depot,DepotCriteria>  {



    HttpEntity<byte[]> createPdf(DepotDto dto) throws Exception;

}
