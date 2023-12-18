package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.EntreeProduitItem;
import ma.zs.easystock.dao.criteria.core.stock.EntreeProduitItemCriteria;
import ma.zs.easystock.service.facade.admin.stock.EntreeProduitItemAdminService;
import ma.zs.easystock.ws.converter.stock.EntreeProduitItemConverter;
import ma.zs.easystock.ws.dto.stock.EntreeProduitItemDto;
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
@RequestMapping("/api/admin/entreeProduitItem/")
public class EntreeProduitItemRestAdmin  extends AbstractController<EntreeProduitItem, EntreeProduitItemDto, EntreeProduitItemCriteria, EntreeProduitItemAdminService, EntreeProduitItemConverter> {



    @Operation(summary = "upload one entreeProduitItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple entreeProduitItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all entreeProduitItems")
    @GetMapping("")
    public ResponseEntity<List<EntreeProduitItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a entreeProduitItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EntreeProduitItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  entreeProduitItem")
    @PostMapping("")
    public ResponseEntity<EntreeProduitItemDto> save(@RequestBody EntreeProduitItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  entreeProduitItem")
    @PutMapping("")
    public ResponseEntity<EntreeProduitItemDto> update(@RequestBody EntreeProduitItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of entreeProduitItem")
    @PostMapping("multiple")
    public ResponseEntity<List<EntreeProduitItemDto>> delete(@RequestBody List<EntreeProduitItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified entreeProduitItem")
    @DeleteMapping("")
    public ResponseEntity<EntreeProduitItemDto> delete(@RequestBody EntreeProduitItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified entreeProduitItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple entreeProduitItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<EntreeProduitItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by entreeProduit id")
    @GetMapping("entreeProduit/id/{id}")
    public List<EntreeProduitItemDto> findByEntreeProduitId(@PathVariable Long id){
        return findDtos(service.findByEntreeProduitId(id));
    }
    @Operation(summary = "delete by entreeProduit id")
    @DeleteMapping("entreeProduit/id/{id}")
    public int deleteByEntreeProduitId(@PathVariable Long id){
        return service.deleteByEntreeProduitId(id);
    }
    @Operation(summary = "Finds entreeProduitItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EntreeProduitItemDto>> findByCriteria(@RequestBody EntreeProduitItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated entreeProduitItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EntreeProduitItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports entreeProduitItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EntreeProduitItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets entreeProduitItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EntreeProduitItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EntreeProduitItemRestAdmin (EntreeProduitItemAdminService service, EntreeProduitItemConverter converter) {
        super(service, converter);
    }




}
