package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.Depot;
import ma.zs.easystock.dao.criteria.core.commun.DepotCriteria;
import ma.zs.easystock.service.facade.admin.commun.DepotAdminService;
import ma.zs.easystock.ws.converter.commun.DepotConverter;
import ma.zs.easystock.ws.dto.commun.DepotDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.zs.easystock.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/depot/")
public class DepotRestAdmin  extends AbstractController<Depot, DepotDto, DepotCriteria, DepotAdminService, DepotConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<Depot>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody DepotDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one depot")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple depots")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all depots")
    @GetMapping("")
    public ResponseEntity<List<DepotDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all depots")
    @GetMapping("optimized")
    public ResponseEntity<List<DepotDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a depot by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DepotDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a depot by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<DepotDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Depot(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  depot")
    @PostMapping("")
    public ResponseEntity<DepotDto> save(@RequestBody DepotDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  depot")
    @PutMapping("")
    public ResponseEntity<DepotDto> update(@RequestBody DepotDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of depot")
    @PostMapping("multiple")
    public ResponseEntity<List<DepotDto>> delete(@RequestBody List<DepotDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified depot")
    @DeleteMapping("")
    public ResponseEntity<DepotDto> delete(@RequestBody DepotDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified depot")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple depots by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds depots by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DepotDto>> findByCriteria(@RequestBody DepotCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated depots by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DepotCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports depots by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DepotCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets depot data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DepotCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public DepotRestAdmin (DepotAdminService service, DepotConverter converter) {
        super(service, converter);
    }




}
