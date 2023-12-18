package  ma.zs.easystock.ws.facade.admin.reglement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.reglement.ReglementAvoirAchat;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementAvoirAchatCriteria;
import ma.zs.easystock.service.facade.admin.reglement.ReglementAvoirAchatAdminService;
import ma.zs.easystock.ws.converter.reglement.ReglementAvoirAchatConverter;
import ma.zs.easystock.ws.dto.reglement.ReglementAvoirAchatDto;
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
@RequestMapping("/api/admin/reglementAvoirAchat/")
public class ReglementAvoirAchatRestAdmin  extends AbstractController<ReglementAvoirAchat, ReglementAvoirAchatDto, ReglementAvoirAchatCriteria, ReglementAvoirAchatAdminService, ReglementAvoirAchatConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<ReglementAvoirAchat>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReglementAvoirAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one reglementAvoirAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple reglementAvoirAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all reglementAvoirAchats")
    @GetMapping("")
    public ResponseEntity<List<ReglementAvoirAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all reglementAvoirAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<ReglementAvoirAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a reglementAvoirAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReglementAvoirAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a reglementAvoirAchat by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ReglementAvoirAchatDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ReglementAvoirAchat(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  reglementAvoirAchat")
    @PostMapping("")
    public ResponseEntity<ReglementAvoirAchatDto> save(@RequestBody ReglementAvoirAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  reglementAvoirAchat")
    @PutMapping("")
    public ResponseEntity<ReglementAvoirAchatDto> update(@RequestBody ReglementAvoirAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of reglementAvoirAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<ReglementAvoirAchatDto>> delete(@RequestBody List<ReglementAvoirAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified reglementAvoirAchat")
    @DeleteMapping("")
    public ResponseEntity<ReglementAvoirAchatDto> delete(@RequestBody ReglementAvoirAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified reglementAvoirAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple reglementAvoirAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by achat id")
    @GetMapping("achat/id/{id}")
    public List<ReglementAvoirAchatDto> findByAchatId(@PathVariable Long id){
        return findDtos(service.findByAchatId(id));
    }
    @Operation(summary = "delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public int deleteByAchatId(@PathVariable Long id){
        return service.deleteByAchatId(id);
    }
    @Operation(summary = "find by modeReglement id")
    @GetMapping("modeReglement/id/{id}")
    public List<ReglementAvoirAchatDto> findByModeReglementId(@PathVariable Long id){
        return findDtos(service.findByModeReglementId(id));
    }
    @Operation(summary = "delete by modeReglement id")
    @DeleteMapping("modeReglement/id/{id}")
    public int deleteByModeReglementId(@PathVariable Long id){
        return service.deleteByModeReglementId(id);
    }
    @Operation(summary = "find by avoirAchat id")
    @GetMapping("avoirAchat/id/{id}")
    public List<ReglementAvoirAchatDto> findByAvoirAchatId(@PathVariable Long id){
        return findDtos(service.findByAvoirAchatId(id));
    }
    @Operation(summary = "delete by avoirAchat id")
    @DeleteMapping("avoirAchat/id/{id}")
    public int deleteByAvoirAchatId(@PathVariable Long id){
        return service.deleteByAvoirAchatId(id);
    }
    @Operation(summary = "Finds reglementAvoirAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReglementAvoirAchatDto>> findByCriteria(@RequestBody ReglementAvoirAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated reglementAvoirAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReglementAvoirAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports reglementAvoirAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReglementAvoirAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets reglementAvoirAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReglementAvoirAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReglementAvoirAchatRestAdmin (ReglementAvoirAchatAdminService service, ReglementAvoirAchatConverter converter) {
        super(service, converter);
    }




}
