package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.SortieProduitItem;
import ma.zs.easystock.dao.criteria.core.stock.SortieProduitItemCriteria;
import ma.zs.easystock.service.facade.admin.stock.SortieProduitItemAdminService;
import ma.zs.easystock.ws.converter.stock.SortieProduitItemConverter;
import ma.zs.easystock.ws.dto.stock.SortieProduitItemDto;
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
@RequestMapping("/api/admin/sortieProduitItem/")
public class SortieProduitItemRestAdmin  extends AbstractController<SortieProduitItem, SortieProduitItemDto, SortieProduitItemCriteria, SortieProduitItemAdminService, SortieProduitItemConverter> {



    @Operation(summary = "upload one sortieProduitItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple sortieProduitItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all sortieProduitItems")
    @GetMapping("")
    public ResponseEntity<List<SortieProduitItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a sortieProduitItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SortieProduitItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  sortieProduitItem")
    @PostMapping("")
    public ResponseEntity<SortieProduitItemDto> save(@RequestBody SortieProduitItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  sortieProduitItem")
    @PutMapping("")
    public ResponseEntity<SortieProduitItemDto> update(@RequestBody SortieProduitItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of sortieProduitItem")
    @PostMapping("multiple")
    public ResponseEntity<List<SortieProduitItemDto>> delete(@RequestBody List<SortieProduitItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified sortieProduitItem")
    @DeleteMapping("")
    public ResponseEntity<SortieProduitItemDto> delete(@RequestBody SortieProduitItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified sortieProduitItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple sortieProduitItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<SortieProduitItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by sortieProduit id")
    @GetMapping("sortieProduit/id/{id}")
    public List<SortieProduitItemDto> findBySortieProduitId(@PathVariable Long id){
        return findDtos(service.findBySortieProduitId(id));
    }
    @Operation(summary = "delete by sortieProduit id")
    @DeleteMapping("sortieProduit/id/{id}")
    public int deleteBySortieProduitId(@PathVariable Long id){
        return service.deleteBySortieProduitId(id);
    }
    @Operation(summary = "Finds sortieProduitItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SortieProduitItemDto>> findByCriteria(@RequestBody SortieProduitItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated sortieProduitItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SortieProduitItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports sortieProduitItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SortieProduitItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets sortieProduitItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SortieProduitItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SortieProduitItemRestAdmin (SortieProduitItemAdminService service, SortieProduitItemConverter converter) {
        super(service, converter);
    }




}
