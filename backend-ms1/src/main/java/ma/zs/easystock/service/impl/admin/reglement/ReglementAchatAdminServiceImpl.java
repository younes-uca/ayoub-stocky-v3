package ma.zs.easystock.service.impl.admin.reglement;


import ma.zs.easystock.bean.core.reglement.ReglementAchat;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementAchatCriteria;
import ma.zs.easystock.dao.facade.core.reglement.ReglementAchatDao;
import ma.zs.easystock.dao.specification.core.reglement.ReglementAchatSpecification;
import ma.zs.easystock.service.facade.admin.reglement.ReglementAchatAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.reglement.ReglementAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.AchatAdminService ;
import ma.zs.easystock.bean.core.stock.Achat ;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ModeReglementAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement ;

import java.util.List;
@Service
public class ReglementAchatAdminServiceImpl extends AbstractServiceImpl<ReglementAchat, ReglementAchatCriteria, ReglementAchatDao> implements ReglementAchatAdminService {
    public static final String TEMPLATE = "template/reglementAchat.vm";
    public static final String FILE_NAME = "reglementAchat.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));


    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));



    ATTRIBUTES.add(new Attribute("description"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(ReglementAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public ReglementAchat findByReferenceEntity(ReglementAchat t){
        return  dao.findByReference(t.getReference());
    }

    public List<ReglementAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }
    public List<ReglementAchat> findByModeReglementId(Long id){
        return dao.findByModeReglementId(id);
    }
    public int deleteByModeReglementId(Long id){
        return dao.deleteByModeReglementId(id);
    }
    public long countByModeReglementId(Long id){
        return dao.countByModeReglementId(id);
    }

    public List<ReglementAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(ReglementAchat.class, ReglementAchatSpecification.class);
    }


    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private ModeReglementAdminService modeReglementService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReglementAchatAdminServiceImpl(ReglementAchatDao dao) {
        super(dao);
    }

}
