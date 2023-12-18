package  ma.zs.easystock.ws.facade.admin.reglement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.reglement.ReglementAvoirVente;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementAvoirVenteCriteria;
import ma.zs.easystock.service.facade.admin.reglement.ReglementAvoirVenteAdminService;
import ma.zs.easystock.ws.converter.reglement.ReglementAvoirVenteConverter;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirVenteDto;
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
@RequestMapping("/api/admin/reglementAvoirVente/")
public class ReglementAvoirVenteRestAdmin  extends AbstractController<ReglementAvoirVente, ReglementAvoirVenteDto, ReglementAvoirVenteCriteria, ReglementAvoirVenteAdminService, ReglementAvoirVenteConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<ReglementAvoirVente>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReglementAvoirVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one reglementAvoirVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple reglementAvoirVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all reglementAvoirVentes")
    @GetMapping("")
    public ResponseEntity<List<ReglementAvoirVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all reglementAvoirVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<ReglementAvoirVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a reglementAvoirVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReglementAvoirVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a reglementAvoirVente by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ReglementAvoirVenteDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ReglementAvoirVente(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  reglementAvoirVente")
    @PostMapping("")
    public ResponseEntity<ReglementAvoirVenteDto> save(@RequestBody ReglementAvoirVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  reglementAvoirVente")
    @PutMapping("")
    public ResponseEntity<ReglementAvoirVenteDto> update(@RequestBody ReglementAvoirVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of reglementAvoirVente")
    @PostMapping("multiple")
    public ResponseEntity<List<ReglementAvoirVenteDto>> delete(@RequestBody List<ReglementAvoirVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified reglementAvoirVente")
    @DeleteMapping("")
    public ResponseEntity<ReglementAvoirVenteDto> delete(@RequestBody ReglementAvoirVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified reglementAvoirVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple reglementAvoirVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by vente id")
    @GetMapping("vente/id/{id}")
    public List<ReglementAvoirVenteDto> findByVenteId(@PathVariable Long id){
        return findDtos(service.findByVenteId(id));
    }
    @Operation(summary = "delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @Operation(summary = "find by modeReglement id")
    @GetMapping("modeReglement/id/{id}")
    public List<ReglementAvoirVenteDto> findByModeReglementId(@PathVariable Long id){
        return findDtos(service.findByModeReglementId(id));
    }
    @Operation(summary = "delete by modeReglement id")
    @DeleteMapping("modeReglement/id/{id}")
    public int deleteByModeReglementId(@PathVariable Long id){
        return service.deleteByModeReglementId(id);
    }
    @Operation(summary = "find by avoirVente id")
    @GetMapping("avoirVente/id/{id}")
    public List<ReglementAvoirVenteDto> findByAvoirVenteId(@PathVariable Long id){
        return findDtos(service.findByAvoirVenteId(id));
    }
    @Operation(summary = "delete by avoirVente id")
    @DeleteMapping("avoirVente/id/{id}")
    public int deleteByAvoirVenteId(@PathVariable Long id){
        return service.deleteByAvoirVenteId(id);
    }
    @Operation(summary = "Finds reglementAvoirVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReglementAvoirVenteDto>> findByCriteria(@RequestBody ReglementAvoirVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated reglementAvoirVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReglementAvoirVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports reglementAvoirVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReglementAvoirVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets reglementAvoirVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReglementAvoirVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReglementAvoirVenteRestAdmin (ReglementAvoirVenteAdminService service, ReglementAvoirVenteConverter converter) {
        super(service, converter);
    }




}
