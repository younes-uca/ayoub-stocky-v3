package  ma.zs.easystock.ws.facade.admin.reglement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.reglement.ReglementAchat;
import ma.zs.easystock.dao.criteria.core.reglement.ReglementAchatCriteria;
import ma.zs.easystock.service.facade.admin.reglement.ReglementAchatAdminService;
import ma.zs.easystock.ws.converter.reglement.ReglementAchatConverter;
import ma.zs.easystock.ws.dto.reglement.ReglementAchatDto;
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
@RequestMapping("/api/admin/reglementAchat/")
public class ReglementAchatRestAdmin  extends AbstractController<ReglementAchat, ReglementAchatDto, ReglementAchatCriteria, ReglementAchatAdminService, ReglementAchatConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<ReglementAchat>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody ReglementAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one reglementAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple reglementAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all reglementAchats")
    @GetMapping("")
    public ResponseEntity<List<ReglementAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all reglementAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<ReglementAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a reglementAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReglementAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a reglementAchat by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ReglementAchatDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ReglementAchat(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  reglementAchat")
    @PostMapping("")
    public ResponseEntity<ReglementAchatDto> save(@RequestBody ReglementAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  reglementAchat")
    @PutMapping("")
    public ResponseEntity<ReglementAchatDto> update(@RequestBody ReglementAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of reglementAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<ReglementAchatDto>> delete(@RequestBody List<ReglementAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified reglementAchat")
    @DeleteMapping("")
    public ResponseEntity<ReglementAchatDto> delete(@RequestBody ReglementAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified reglementAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple reglementAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by achat id")
    @GetMapping("achat/id/{id}")
    public List<ReglementAchatDto> findByAchatId(@PathVariable Long id){
        return findDtos(service.findByAchatId(id));
    }
    @Operation(summary = "delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public int deleteByAchatId(@PathVariable Long id){
        return service.deleteByAchatId(id);
    }
    @Operation(summary = "find by modeReglement id")
    @GetMapping("modeReglement/id/{id}")
    public List<ReglementAchatDto> findByModeReglementId(@PathVariable Long id){
        return findDtos(service.findByModeReglementId(id));
    }
    @Operation(summary = "delete by modeReglement id")
    @DeleteMapping("modeReglement/id/{id}")
    public int deleteByModeReglementId(@PathVariable Long id){
        return service.deleteByModeReglementId(id);
    }
    @Operation(summary = "Finds reglementAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReglementAchatDto>> findByCriteria(@RequestBody ReglementAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated reglementAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReglementAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports reglementAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReglementAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets reglementAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReglementAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReglementAchatRestAdmin (ReglementAchatAdminService service, ReglementAchatConverter converter) {
        super(service, converter);
    }




}
