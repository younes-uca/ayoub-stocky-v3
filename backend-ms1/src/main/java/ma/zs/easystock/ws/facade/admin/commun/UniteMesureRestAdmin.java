package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.UniteMesure;
import ma.zs.easystock.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zs.easystock.service.facade.admin.commun.UniteMesureAdminService;
import ma.zs.easystock.ws.converter.commun.UniteMesureConverter;
import ma.zs.easystock.ws.dto.commun.UniteMesureDto;
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
@RequestMapping("/api/admin/uniteMesure/")
public class UniteMesureRestAdmin  extends AbstractController<UniteMesure, UniteMesureDto, UniteMesureCriteria, UniteMesureAdminService, UniteMesureConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<UniteMesure>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody UniteMesureDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one uniteMesure")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple uniteMesures")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all uniteMesures")
    @GetMapping("")
    public ResponseEntity<List<UniteMesureDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all uniteMesures")
    @GetMapping("optimized")
    public ResponseEntity<List<UniteMesureDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a uniteMesure by id")
    @GetMapping("id/{id}")
    public ResponseEntity<UniteMesureDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a uniteMesure by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<UniteMesureDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new UniteMesure(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  uniteMesure")
    @PostMapping("")
    public ResponseEntity<UniteMesureDto> save(@RequestBody UniteMesureDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  uniteMesure")
    @PutMapping("")
    public ResponseEntity<UniteMesureDto> update(@RequestBody UniteMesureDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of uniteMesure")
    @PostMapping("multiple")
    public ResponseEntity<List<UniteMesureDto>> delete(@RequestBody List<UniteMesureDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified uniteMesure")
    @DeleteMapping("")
    public ResponseEntity<UniteMesureDto> delete(@RequestBody UniteMesureDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified uniteMesure")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple uniteMesures by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds uniteMesures by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<UniteMesureDto>> findByCriteria(@RequestBody UniteMesureCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated uniteMesures by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody UniteMesureCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports uniteMesures by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody UniteMesureCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets uniteMesure data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody UniteMesureCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public UniteMesureRestAdmin (UniteMesureAdminService service, UniteMesureConverter converter) {
        super(service, converter);
    }




}
