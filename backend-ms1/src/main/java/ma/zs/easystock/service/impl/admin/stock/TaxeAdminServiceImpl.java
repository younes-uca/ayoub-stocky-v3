package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.Taxe;
import ma.zs.easystock.dao.criteria.core.stock.TaxeCriteria;
import ma.zs.easystock.dao.facade.core.stock.TaxeDao;
import ma.zs.easystock.dao.specification.core.stock.TaxeSpecification;
import ma.zs.easystock.service.facade.admin.stock.TaxeAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.stock.TaxeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TaxeAdminServiceImpl extends AbstractServiceImpl<Taxe, TaxeCriteria, TaxeDao> implements TaxeAdminService {
    public static final String TEMPLATE = "template/taxe.vm";
    public static final String FILE_NAME = "taxe.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));

    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(TaxeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public List<Taxe> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Taxe.class, TaxeSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public TaxeAdminServiceImpl(TaxeDao dao) {
        super(dao);
    }

}
