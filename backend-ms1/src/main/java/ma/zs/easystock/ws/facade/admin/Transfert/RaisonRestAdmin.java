package  ma.zs.easystock.ws.facade.admin.Transfert;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.Transfert.Raison;
import ma.zs.easystock.dao.criteria.core.Transfert.RaisonCriteria;
import ma.zs.easystock.service.facade.admin.Transfert.RaisonAdminService;
import ma.zs.easystock.ws.converter.Transfert.RaisonConverter;
import ma.zs.easystock.ws.dto.Transfert.RaisonDto;
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
@RequestMapping("/api/admin/raison/")
public class RaisonRestAdmin  extends AbstractController<Raison, RaisonDto, RaisonCriteria, RaisonAdminService, RaisonConverter> {



    @Operation(summary = "upload one raison")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple raisons")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all raisons")
    @GetMapping("")
    public ResponseEntity<List<RaisonDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all raisons")
    @GetMapping("optimized")
    public ResponseEntity<List<RaisonDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a raison by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RaisonDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a raison by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<RaisonDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Raison(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  raison")
    @PostMapping("")
    public ResponseEntity<RaisonDto> save(@RequestBody RaisonDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  raison")
    @PutMapping("")
    public ResponseEntity<RaisonDto> update(@RequestBody RaisonDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of raison")
    @PostMapping("multiple")
    public ResponseEntity<List<RaisonDto>> delete(@RequestBody List<RaisonDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified raison")
    @DeleteMapping("")
    public ResponseEntity<RaisonDto> delete(@RequestBody RaisonDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified raison")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple raisons by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds raisons by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RaisonDto>> findByCriteria(@RequestBody RaisonCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated raisons by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RaisonCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports raisons by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody RaisonCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets raison data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RaisonCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public RaisonRestAdmin (RaisonAdminService service, RaisonConverter converter) {
        super(service, converter);
    }




}
