package ma.zs.easystock.service.impl.admin.reglement;


import ma.zs.easystock.bean.core.reglement.ReglementAvoirVente;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementAvoirVenteCriteria;
import ma.zs.easystock.dao.facade.core.reglement.ReglementAvoirVenteDao;
import ma.zs.easystock.dao.specification.core.reglement.ReglementAvoirVenteSpecification;
import ma.zs.easystock.service.facade.admin.reglement.ReglementAvoirVenteAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.stock.AvoirVenteAdminService ;
import ma.zs.easystock.bean.core.stock.AvoirVente ;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ModeReglementAdminService ;
import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement ;
import ma.zs.easystock.service.facade.admin.stock.VenteAdminService ;
import ma.zs.easystock.bean.core.stock.Vente ;

import java.util.List;
@Service
public class ReglementAvoirVenteAdminServiceImpl extends AbstractServiceImpl<ReglementAvoirVente, ReglementAvoirVenteCriteria, ReglementAvoirVenteDao> implements ReglementAvoirVenteAdminService {
    public static final String TEMPLATE = "template/reglementAvoirVente.vm";
    public static final String FILE_NAME = "reglementAvoirVente.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));


    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));



    ATTRIBUTES.add(new Attribute("description"));

    }

    @Override
    public HttpEntity<byte[]> createPdf(ReglementAvoirVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public ReglementAvoirVente findByReferenceEntity(ReglementAvoirVente t){
        return  dao.findByReference(t.getReference());
    }

    public List<ReglementAvoirVente> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteNumeroFacture(String numeroFacture){
        return dao.countByVenteNumeroFacture(numeroFacture);
    }
    public List<ReglementAvoirVente> findByModeReglementId(Long id){
        return dao.findByModeReglementId(id);
    }
    public int deleteByModeReglementId(Long id){
        return dao.deleteByModeReglementId(id);
    }
    public long countByModeReglementId(Long id){
        return dao.countByModeReglementId(id);
    }
    public List<ReglementAvoirVente> findByAvoirVenteId(Long id){
        return dao.findByAvoirVenteId(id);
    }
    public int deleteByAvoirVenteId(Long id){
        return dao.deleteByAvoirVenteId(id);
    }
    public long countByAvoirVenteNumeroFactureAvoirVente(String numeroFactureAvoirVente){
        return dao.countByAvoirVenteNumeroFactureAvoirVente(numeroFactureAvoirVente);
    }

    public List<ReglementAvoirVente> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(ReglementAvoirVente.class, ReglementAvoirVenteSpecification.class);
    }


    @Autowired
    private AvoirVenteAdminService avoirVenteService ;
    @Autowired
    private ModeReglementAdminService modeReglementService ;
    @Autowired
    private VenteAdminService venteService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReglementAvoirVenteAdminServiceImpl(ReglementAvoirVenteDao dao) {
        super(dao);
    }

}
