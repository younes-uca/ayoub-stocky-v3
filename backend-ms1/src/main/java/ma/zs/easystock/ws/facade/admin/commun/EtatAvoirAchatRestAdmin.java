package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.EtatAvoirAchat;
import ma.zs.easystock.dao.criteria.core.commun.EtatAvoirAchatCriteria;
import ma.zs.easystock.service.facade.admin.commun.EtatAvoirAchatAdminService;
import ma.zs.easystock.ws.converter.commun.EtatAvoirAchatConverter;
import ma.zs.easystock.ws.dto.commun.EtatAvoirAchatDto;
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
@RequestMapping("/api/admin/etatAvoirAchat/")
public class EtatAvoirAchatRestAdmin  extends AbstractController<EtatAvoirAchat, EtatAvoirAchatDto, EtatAvoirAchatCriteria, EtatAvoirAchatAdminService, EtatAvoirAchatConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<EtatAvoirAchat>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatAvoirAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one etatAvoirAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatAvoirAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatAvoirAchats")
    @GetMapping("")
    public ResponseEntity<List<EtatAvoirAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatAvoirAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatAvoirAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatAvoirAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatAvoirAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a etatAvoirAchat by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatAvoirAchatDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new EtatAvoirAchat(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  etatAvoirAchat")
    @PostMapping("")
    public ResponseEntity<EtatAvoirAchatDto> save(@RequestBody EtatAvoirAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatAvoirAchat")
    @PutMapping("")
    public ResponseEntity<EtatAvoirAchatDto> update(@RequestBody EtatAvoirAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatAvoirAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatAvoirAchatDto>> delete(@RequestBody List<EtatAvoirAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatAvoirAchat")
    @DeleteMapping("")
    public ResponseEntity<EtatAvoirAchatDto> delete(@RequestBody EtatAvoirAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatAvoirAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatAvoirAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds etatAvoirAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatAvoirAchatDto>> findByCriteria(@RequestBody EtatAvoirAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatAvoirAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatAvoirAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatAvoirAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatAvoirAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatAvoirAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatAvoirAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatAvoirAchatRestAdmin (EtatAvoirAchatAdminService service, EtatAvoirAchatConverter converter) {
        super(service, converter);
    }




}
