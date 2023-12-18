package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.Taxe;
import ma.zs.easystock.dao.criteria.core.stock.TaxeCriteria;
import ma.zs.easystock.service.facade.admin.stock.TaxeAdminService;
import ma.zs.easystock.ws.converter.stock.TaxeConverter;
import ma.zs.easystock.ws.dto.stock.TaxeDto;
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
@RequestMapping("/api/admin/taxe/")
public class TaxeRestAdmin  extends AbstractController<Taxe, TaxeDto, TaxeCriteria, TaxeAdminService, TaxeConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<Taxe>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody TaxeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one taxe")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple taxes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all taxes")
    @GetMapping("")
    public ResponseEntity<List<TaxeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all taxes")
    @GetMapping("optimized")
    public ResponseEntity<List<TaxeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a taxe by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TaxeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a taxe by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TaxeDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Taxe(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  taxe")
    @PostMapping("")
    public ResponseEntity<TaxeDto> save(@RequestBody TaxeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  taxe")
    @PutMapping("")
    public ResponseEntity<TaxeDto> update(@RequestBody TaxeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of taxe")
    @PostMapping("multiple")
    public ResponseEntity<List<TaxeDto>> delete(@RequestBody List<TaxeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified taxe")
    @DeleteMapping("")
    public ResponseEntity<TaxeDto> delete(@RequestBody TaxeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified taxe")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple taxes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds taxes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TaxeDto>> findByCriteria(@RequestBody TaxeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated taxes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TaxeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports taxes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TaxeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets taxe data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TaxeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TaxeRestAdmin (TaxeAdminService service, TaxeConverter converter) {
        super(service, converter);
    }




}
