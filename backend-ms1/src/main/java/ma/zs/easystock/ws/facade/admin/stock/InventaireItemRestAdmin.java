package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.InventaireItem;
import ma.zs.easystock.dao.criteria.core.stock.InventaireItemCriteria;
import ma.zs.easystock.service.facade.admin.stock.InventaireItemAdminService;
import ma.zs.easystock.ws.converter.stock.InventaireItemConverter;
import ma.zs.easystock.ws.dto.stock.InventaireItemDto;
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
@RequestMapping("/api/admin/inventaireItem/")
public class InventaireItemRestAdmin  extends AbstractController<InventaireItem, InventaireItemDto, InventaireItemCriteria, InventaireItemAdminService, InventaireItemConverter> {



    @Operation(summary = "upload one inventaireItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple inventaireItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all inventaireItems")
    @GetMapping("")
    public ResponseEntity<List<InventaireItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a inventaireItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InventaireItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  inventaireItem")
    @PostMapping("")
    public ResponseEntity<InventaireItemDto> save(@RequestBody InventaireItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  inventaireItem")
    @PutMapping("")
    public ResponseEntity<InventaireItemDto> update(@RequestBody InventaireItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of inventaireItem")
    @PostMapping("multiple")
    public ResponseEntity<List<InventaireItemDto>> delete(@RequestBody List<InventaireItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified inventaireItem")
    @DeleteMapping("")
    public ResponseEntity<InventaireItemDto> delete(@RequestBody InventaireItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified inventaireItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple inventaireItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<InventaireItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by inventaire id")
    @GetMapping("inventaire/id/{id}")
    public List<InventaireItemDto> findByInventaireId(@PathVariable Long id){
        return findDtos(service.findByInventaireId(id));
    }
    @Operation(summary = "delete by inventaire id")
    @DeleteMapping("inventaire/id/{id}")
    public int deleteByInventaireId(@PathVariable Long id){
        return service.deleteByInventaireId(id);
    }
    @Operation(summary = "Finds inventaireItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InventaireItemDto>> findByCriteria(@RequestBody InventaireItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated inventaireItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InventaireItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports inventaireItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InventaireItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets inventaireItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InventaireItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public InventaireItemRestAdmin (InventaireItemAdminService service, InventaireItemConverter converter) {
        super(service, converter);
    }




}
