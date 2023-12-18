package ma.zs.easystock.service.facade.admin.commun;

import java.util.List;
import ma.zs.easystock.bean.core.commun.Client;
import ma.zs.easystock.dao.criteria.core.commun.ClientCriteria;
import ma.zs.easystock.zynerator.service.IService;

import ma.zs.easystock.ws.dto.commun.ClientDto;
import org.springframework.http.HttpEntity;


public interface ClientAdminService extends  IService<Client,ClientCriteria>  {
    Client findByUsername(String username);
    boolean changePassword(String username, String newPassword);



    HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception;

}
