package  ma.zs.easystock.ws.facade.admin.entree;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.entree.EntreeProduit;
import ma.zs.easystock.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zs.easystock.service.facade.admin.entree.EntreeProduitAdminService;
import ma.zs.easystock.ws.converter.entree.EntreeProduitConverter;
import ma.zs.easystock.ws.dto.entree.EntreeProduitDto;
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
@RequestMapping("/api/admin/entreeProduit/")
public class EntreeProduitRestAdmin  extends AbstractController<EntreeProduit, EntreeProduitDto, EntreeProduitCriteria, EntreeProduitAdminService, EntreeProduitConverter> {



    @Operation(summary = "upload one entreeProduit")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple entreeProduits")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all entreeProduits")
    @GetMapping("")
    public ResponseEntity<List<EntreeProduitDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all entreeProduits")
    @GetMapping("optimized")
    public ResponseEntity<List<EntreeProduitDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a entreeProduit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EntreeProduitDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a entreeProduit by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<EntreeProduitDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new EntreeProduit(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  entreeProduit")
    @PostMapping("")
    public ResponseEntity<EntreeProduitDto> save(@RequestBody EntreeProduitDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  entreeProduit")
    @PutMapping("")
    public ResponseEntity<EntreeProduitDto> update(@RequestBody EntreeProduitDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of entreeProduit")
    @PostMapping("multiple")
    public ResponseEntity<List<EntreeProduitDto>> delete(@RequestBody List<EntreeProduitDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified entreeProduit")
    @DeleteMapping("")
    public ResponseEntity<EntreeProduitDto> delete(@RequestBody EntreeProduitDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified entreeProduit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple entreeProduits by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by fournisseur id")
    @GetMapping("fournisseur/id/{id}")
    public List<EntreeProduitDto> findByFournisseurId(@PathVariable Long id){
        return findDtos(service.findByFournisseurId(id));
    }
    @Operation(summary = "delete by fournisseur id")
    @DeleteMapping("fournisseur/id/{id}")
    public int deleteByFournisseurId(@PathVariable Long id){
        return service.deleteByFournisseurId(id);
    }
    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public List<EntreeProduitDto> findByDepotId(@PathVariable Long id){
        return findDtos(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public int deleteByDepotId(@PathVariable Long id){
        return service.deleteByDepotId(id);
    }
    @Operation(summary = "Finds a entreeProduit and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<EntreeProduitDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds entreeProduits by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EntreeProduitDto>> findByCriteria(@RequestBody EntreeProduitCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated entreeProduits by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EntreeProduitCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports entreeProduits by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EntreeProduitCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets entreeProduit data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EntreeProduitCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EntreeProduitRestAdmin (EntreeProduitAdminService service, EntreeProduitConverter converter) {
        super(service, converter);
    }




}
