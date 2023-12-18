package ma.zs.easystock.service.impl.admin.commun;


import ma.zs.easystock.bean.core.commun.EtatAvoirAchat;
import ma.zs.easystock.dao.criteria.core.commun.EtatAvoirAchatCriteria;
import ma.zs.easystock.dao.facade.core.commun.EtatAvoirAchatDao;
import ma.zs.easystock.dao.specification.core.commun.EtatAvoirAchatSpecification;
import ma.zs.easystock.service.facade.admin.commun.EtatAvoirAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.EtatAvoirAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatAvoirAchatAdminServiceImpl extends AbstractServiceImpl<EtatAvoirAchat, EtatAvoirAchatCriteria, EtatAvoirAchatDao> implements EtatAvoirAchatAdminService {
    public static final String TEMPLATE = "template/etatAvoirAchat.vm";
    public static final String FILE_NAME = "etatAvoirAchat.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(EtatAvoirAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public List<EtatAvoirAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(EtatAvoirAchat.class, EtatAvoirAchatSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public EtatAvoirAchatAdminServiceImpl(EtatAvoirAchatDao dao) {
        super(dao);
    }

}
