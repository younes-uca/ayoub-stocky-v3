package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.EntrepriseSociete;
import ma.zs.easystock.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zs.easystock.service.facade.admin.commun.EntrepriseSocieteAdminService;
import ma.zs.easystock.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.easystock.ws.dto.commun.EntrepriseSocieteDto;
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
@RequestMapping("/api/admin/entrepriseSociete/")
public class EntrepriseSocieteRestAdmin  extends AbstractController<EntrepriseSociete, EntrepriseSocieteDto, EntrepriseSocieteCriteria, EntrepriseSocieteAdminService, EntrepriseSocieteConverter> {



    @Operation(summary = "upload one entrepriseSociete")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple entrepriseSocietes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all entrepriseSocietes")
    @GetMapping("")
    public ResponseEntity<List<EntrepriseSocieteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all entrepriseSocietes")
    @GetMapping("optimized")
    public ResponseEntity<List<EntrepriseSocieteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a entrepriseSociete by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EntrepriseSocieteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a entrepriseSociete by nom")
    @GetMapping("nom/{nom}")
    public ResponseEntity<EntrepriseSocieteDto> findByNom(@PathVariable String nom, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new EntrepriseSociete(nom), includes, excludes);
    }

    @Operation(summary = "Saves the specified  entrepriseSociete")
    @PostMapping("")
    public ResponseEntity<EntrepriseSocieteDto> save(@RequestBody EntrepriseSocieteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  entrepriseSociete")
    @PutMapping("")
    public ResponseEntity<EntrepriseSocieteDto> update(@RequestBody EntrepriseSocieteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of entrepriseSociete")
    @PostMapping("multiple")
    public ResponseEntity<List<EntrepriseSocieteDto>> delete(@RequestBody List<EntrepriseSocieteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified entrepriseSociete")
    @DeleteMapping("")
    public ResponseEntity<EntrepriseSocieteDto> delete(@RequestBody EntrepriseSocieteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified entrepriseSociete")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple entrepriseSocietes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds entrepriseSocietes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EntrepriseSocieteDto>> findByCriteria(@RequestBody EntrepriseSocieteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated entrepriseSocietes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EntrepriseSocieteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports entrepriseSocietes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EntrepriseSocieteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets entrepriseSociete data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EntrepriseSocieteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EntrepriseSocieteRestAdmin (EntrepriseSocieteAdminService service, EntrepriseSocieteConverter converter) {
        super(service, converter);
    }




}
