package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.UniteMesure;
import ma.zs.easystock.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.commun.UniteMesureDto;
import org.springframework.http.HttpEntity;


public interface UniteMesureAdminService extends  IService<UniteMesure,UniteMesureCriteria>  {



    HttpEntity<byte[]> createPdf(UniteMesureDto dto) throws Exception;

}
