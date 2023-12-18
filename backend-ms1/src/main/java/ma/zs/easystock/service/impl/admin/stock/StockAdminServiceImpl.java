package ma.zs.easystock.service.impl.admin.stock;


import ma.zs.easystock.bean.core.stock.Stock;
import ma.zs.easystock.dao.criteria.core.stock.StockCriteria;
import ma.zs.easystock.dao.facade.core.stock.StockDao;
import ma.zs.easystock.dao.specification.core.stock.StockSpecification;
import ma.zs.easystock.service.facade.admin.stock.StockAdminService;
import ma.zs.easystock.zynerator.service.AbstractServiceImpl;
import ma.zs.easystock.zynerator.service.Attribute;
import ma.zs.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.easystock.zynerator.util.VelocityPdf;
import ma.zs.easystock.ws.dto.stock.StockDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.easystock.service.facade.admin.commun.DepotAdminService ;
import ma.zs.easystock.bean.core.commun.Depot ;
import ma.zs.easystock.service.facade.admin.stock.ProduitAdminService ;
import ma.zs.easystock.bean.core.stock.Produit ;

import java.util.List;
@Service
public class StockAdminServiceImpl extends AbstractServiceImpl<Stock, StockCriteria, StockDao> implements StockAdminService {
    public static final String TEMPLATE = "template/stock.vm";
    public static final String FILE_NAME = "stock.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{




    ATTRIBUTES.add(new Attribute("quantite","BigDecimal"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(StockDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }





    public List<Stock> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitReference(String reference){
        return dao.countByProduitReference(reference);
    }
    public List<Stock> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotId(Long id){
        return dao.countByDepotId(id);
    }



    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Stock.class, StockSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public StockAdminServiceImpl(StockDao dao) {
        super(dao);
    }

}
