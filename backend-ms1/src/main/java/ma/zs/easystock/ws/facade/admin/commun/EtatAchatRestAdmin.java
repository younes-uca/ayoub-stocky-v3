package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.EtatAchat;
import ma.zs.easystock.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zs.easystock.service.facade.admin.commun.EtatAchatAdminService;
import ma.zs.easystock.ws.converter.commun.EtatAchatConverter;
import ma.zs.easystock.ws.dto.commun.EtatAchatDto;
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
@RequestMapping("/api/admin/etatAchat/")
public class EtatAchatRestAdmin  extends AbstractController<EtatAchat, EtatAchatDto, EtatAchatCriteria, EtatAchatAdminService, EtatAchatConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<EtatAchat>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one etatAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatAchats")
    @GetMapping("")
    public ResponseEntity<List<EtatAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a etatAchat by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatAchatDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new EtatAchat(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  etatAchat")
    @PostMapping("")
    public ResponseEntity<EtatAchatDto> save(@RequestBody EtatAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatAchat")
    @PutMapping("")
    public ResponseEntity<EtatAchatDto> update(@RequestBody EtatAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatAchatDto>> delete(@RequestBody List<EtatAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatAchat")
    @DeleteMapping("")
    public ResponseEntity<EtatAchatDto> delete(@RequestBody EtatAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds etatAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatAchatDto>> findByCriteria(@RequestBody EtatAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatAchatRestAdmin (EtatAchatAdminService service, EtatAchatConverter converter) {
        super(service, converter);
    }




}
