package ma.zs.easystock.service.impl.admin.reglement;


import ma.zs.easystock.bean.core.reglement.ReglementVente;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementVenteCriteria;
import ma.zs.easystock.dao.facade.core.reglement.ReglementVenteDao;
import ma.zs.easystock.dao.specification.core.reglement.ReglementVenteSpecification;
import ma.zs.easystock.service.facade.admin.reglement.ReglementVenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.reglement.ReglementVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.gestionchequeffet.ModeReglementAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement ;
import ma.zs.easystock.service.facade.admin.stock.VenteAdminService ;
import ma.zs.easystock.bean.core.stock.Vente ;

import java.util.List;
@Service
public class ReglementVenteAdminServiceImpl extends AbstractServiceImpl<ReglementVente, ReglementVenteCriteria, ReglementVenteDao> implements ReglementVenteAdminService {
    public static final String TEMPLATE = "template/reglementVente.vm";
    public static final String FILE_NAME = "reglementVente.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));


    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));



    ATTRIBUTES.add(new Attribute("description"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(ReglementVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public ReglementVente findByReferenceEntity(ReglementVente t){
        return  dao.findByReference(t.getReference());
    }

    public List<ReglementVente> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteNumeroFacture(String numeroFacture){
        return dao.countByVenteNumeroFacture(numeroFacture);
    }
    public List<ReglementVente> findByModeReglementId(Long id){
        return dao.findByModeReglementId(id);
    }
    public int deleteByModeReglementId(Long id){
        return dao.deleteByModeReglementId(id);
    }
    public long countByModeReglementId(Long id){
        return dao.countByModeReglementId(id);
    }

    public List<ReglementVente> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(ReglementVente.class, ReglementVenteSpecification.class);
    }


    @Autowired
    private ModeReglementAdminService modeReglementService ;
    @Autowired
    private VenteAdminService venteService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReglementVenteAdminServiceImpl(ReglementVenteDao dao) {
        super(dao);
    }

}
