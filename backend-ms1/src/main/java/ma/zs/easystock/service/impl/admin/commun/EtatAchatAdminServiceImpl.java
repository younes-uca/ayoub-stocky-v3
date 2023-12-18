package ma.zs.easystock.service.impl.admin.commun;


import ma.zs.easystock.bean.core.commun.EtatAchat;
import ma.zs.easystock.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.easystock.dao.facade.core.commun.EtatAchatDao;
import ma.zs.easystock.dao.specification.core.commun.EtatAchatSpecification;
import ma.zs.easystock.service.facade.admin.commun.EtatAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.EtatAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatAchatAdminServiceImpl extends AbstractServiceImpl<EtatAchat, EtatAchatCriteria, EtatAchatDao> implements EtatAchatAdminService {
    public static final String TEMPLATE = "template/etatAchat.vm";
    public static final String FILE_NAME = "etatAchat.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(EtatAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public List<EtatAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(EtatAchat.class, EtatAchatSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public EtatAchatAdminServiceImpl(EtatAchatDao dao) {
        super(dao);
    }

}
