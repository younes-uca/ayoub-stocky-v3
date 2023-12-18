package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.DevisItem;
import ma.zs.easystock.dao.criteria.core.stock.DevisItemCriteria;
import ma.zs.easystock.service.facade.admin.stock.DevisItemAdminService;
import ma.zs.easystock.ws.converter.stock.DevisItemConverter;
import ma.zs.easystock.ws.dto.stock.DevisItemDto;
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
@RequestMapping("/api/admin/devisItem/")
public class DevisItemRestAdmin  extends AbstractController<DevisItem, DevisItemDto, DevisItemCriteria, DevisItemAdminService, DevisItemConverter> {



    @Operation(summary = "upload one devisItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple devisItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all devisItems")
    @GetMapping("")
    public ResponseEntity<List<DevisItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a devisItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DevisItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  devisItem")
    @PostMapping("")
    public ResponseEntity<DevisItemDto> save(@RequestBody DevisItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  devisItem")
    @PutMapping("")
    public ResponseEntity<DevisItemDto> update(@RequestBody DevisItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of devisItem")
    @PostMapping("multiple")
    public ResponseEntity<List<DevisItemDto>> delete(@RequestBody List<DevisItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified devisItem")
    @DeleteMapping("")
    public ResponseEntity<DevisItemDto> delete(@RequestBody DevisItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified devisItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple devisItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<DevisItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public List<DevisItemDto> findByTaxeId(@PathVariable Long id){
        return findDtos(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public int deleteByTaxeId(@PathVariable Long id){
        return service.deleteByTaxeId(id);
    }
    @Operation(summary = "find by devis id")
    @GetMapping("devis/id/{id}")
    public List<DevisItemDto> findByDevisId(@PathVariable Long id){
        return findDtos(service.findByDevisId(id));
    }
    @Operation(summary = "delete by devis id")
    @DeleteMapping("devis/id/{id}")
    public int deleteByDevisId(@PathVariable Long id){
        return service.deleteByDevisId(id);
    }
    @Operation(summary = "Finds devisItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DevisItemDto>> findByCriteria(@RequestBody DevisItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated devisItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DevisItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports devisItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DevisItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets devisItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DevisItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public DevisItemRestAdmin (DevisItemAdminService service, DevisItemConverter converter) {
        super(service, converter);
    }




}
