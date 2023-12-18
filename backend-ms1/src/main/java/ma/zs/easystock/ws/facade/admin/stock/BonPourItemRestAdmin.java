package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.BonPourItem;
import ma.zs.easystock.dao.criteria.core.stock.BonPourItemCriteria;
import ma.zs.easystock.service.facade.admin.stock.BonPourItemAdminService;
import ma.zs.easystock.ws.converter.stock.BonPourItemConverter;
import ma.zs.easystock.ws.dto.stock.BonPourItemDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.easystock.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/bonPourItem/")
public class BonPourItemRestAdmin  extends AbstractController<BonPourItem, BonPourItemDto, BonPourItemCriteria, BonPourItemAdminService, BonPourItemConverter> {



    @Operation(summary = "upload one bonPourItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple bonPourItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all bonPourItems")
    @GetMapping("")
    public ResponseEntity<List<BonPourItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a bonPourItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BonPourItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  bonPourItem")
    @PostMapping("")
    public ResponseEntity<BonPourItemDto> save(@RequestBody BonPourItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  bonPourItem")
    @PutMapping("")
    public ResponseEntity<BonPourItemDto> update(@RequestBody BonPourItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of bonPourItem")
    @PostMapping("multiple")
    public ResponseEntity<List<BonPourItemDto>> delete(@RequestBody List<BonPourItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified bonPourItem")
    @DeleteMapping("")
    public ResponseEntity<BonPourItemDto> delete(@RequestBody BonPourItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified bonPourItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple bonPourItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<BonPourItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public List<BonPourItemDto> findByTaxeId(@PathVariable Long id){
        return findDtos(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public int deleteByTaxeId(@PathVariable Long id){
        return service.deleteByTaxeId(id);
    }
    @Operation(summary = "find by bonPour id")
    @GetMapping("bonPour/id/{id}")
    public List<BonPourItemDto> findByBonPourId(@PathVariable Long id){
        return findDtos(service.findByBonPourId(id));
    }
    @Operation(summary = "delete by bonPour id")
    @DeleteMapping("bonPour/id/{id}")
    public int deleteByBonPourId(@PathVariable Long id){
        return service.deleteByBonPourId(id);
    }
    @Operation(summary = "Finds bonPourItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BonPourItemDto>> findByCriteria(@RequestBody BonPourItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated bonPourItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BonPourItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports bonPourItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BonPourItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets bonPourItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BonPourItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public BonPourItemRestAdmin (BonPourItemAdminService service, BonPourItemConverter converter) {
        super(service, converter);
    }




}
