package ma.zs.easystock.service.impl.admin.commun;


import ma.zs.easystock.bean.core.commun.EtatAvoirVente;
import ma.zs.easystock.dao.criteria.core.commun.EtatAvoirVenteCriteria;
import ma.zs.easystock.dao.facade.core.commun.EtatAvoirVenteDao;
import ma.zs.easystock.dao.specification.core.commun.EtatAvoirVenteSpecification;
import ma.zs.easystock.service.facade.admin.commun.EtatAvoirVenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.commun.EtatAvoirVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatAvoirVenteAdminServiceImpl extends AbstractServiceImpl<EtatAvoirVente, EtatAvoirVenteCriteria, EtatAvoirVenteDao> implements EtatAvoirVenteAdminService {
    public static final String TEMPLATE = "template/etatAvoirVente.vm";
    public static final String FILE_NAME = "etatAvoirVente.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(EtatAvoirVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public List<EtatAvoirVente> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(EtatAvoirVente.class, EtatAvoirVenteSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public EtatAvoirVenteAdminServiceImpl(EtatAvoirVenteDao dao) {
        super(dao);
    }

}
