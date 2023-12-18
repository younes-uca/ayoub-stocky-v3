package  ma.zs.easystock.ws.facade.admin.reglement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.reglement.ReglementVente;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementVenteCriteria;
import ma.zs.easystock.service.facade.admin.reglement.ReglementVenteAdminService;
import ma.zs.easystock.ws.converter.reglement.ReglementVenteConverter;
import ma.zs.easystock.ws.dto.reglement.ReglementVenteDto;
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
@RequestMapping("/api/admin/reglementVente/")
public class ReglementVenteRestAdmin  extends AbstractController<ReglementVente, ReglementVenteDto, ReglementVenteCriteria, ReglementVenteAdminService, ReglementVenteConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<ReglementVente>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReglementVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one reglementVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple reglementVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all reglementVentes")
    @GetMapping("")
    public ResponseEntity<List<ReglementVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all reglementVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<ReglementVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a reglementVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReglementVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a reglementVente by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ReglementVenteDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ReglementVente(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  reglementVente")
    @PostMapping("")
    public ResponseEntity<ReglementVenteDto> save(@RequestBody ReglementVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  reglementVente")
    @PutMapping("")
    public ResponseEntity<ReglementVenteDto> update(@RequestBody ReglementVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of reglementVente")
    @PostMapping("multiple")
    public ResponseEntity<List<ReglementVenteDto>> delete(@RequestBody List<ReglementVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified reglementVente")
    @DeleteMapping("")
    public ResponseEntity<ReglementVenteDto> delete(@RequestBody ReglementVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified reglementVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple reglementVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by vente id")
    @GetMapping("vente/id/{id}")
    public List<ReglementVenteDto> findByVenteId(@PathVariable Long id){
        return findDtos(service.findByVenteId(id));
    }
    @Operation(summary = "delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @Operation(summary = "find by modeReglement id")
    @GetMapping("modeReglement/id/{id}")
    public List<ReglementVenteDto> findByModeReglementId(@PathVariable Long id){
        return findDtos(service.findByModeReglementId(id));
    }
    @Operation(summary = "delete by modeReglement id")
    @DeleteMapping("modeReglement/id/{id}")
    public int deleteByModeReglementId(@PathVariable Long id){
        return service.deleteByModeReglementId(id);
    }
    @Operation(summary = "Finds reglementVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReglementVenteDto>> findByCriteria(@RequestBody ReglementVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated reglementVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReglementVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports reglementVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReglementVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets reglementVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReglementVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReglementVenteRestAdmin (ReglementVenteAdminService service, ReglementVenteConverter converter) {
        super(service, converter);
    }




}
