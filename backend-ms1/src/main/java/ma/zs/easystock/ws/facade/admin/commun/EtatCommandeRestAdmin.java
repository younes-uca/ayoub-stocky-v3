package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.EtatCommande;
import ma.zs.easystock.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zs.easystock.service.facade.admin.commun.EtatCommandeAdminService;
import ma.zs.easystock.ws.converter.commun.EtatCommandeConverter;
import ma.zs.easystock.ws.dto.commun.EtatCommandeDto;
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
@RequestMapping("/api/admin/etatCommande/")
public class EtatCommandeRestAdmin  extends AbstractController<EtatCommande, EtatCommandeDto, EtatCommandeCriteria, EtatCommandeAdminService, EtatCommandeConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<EtatCommande>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatCommandeDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one etatCommande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatCommandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatCommandes")
    @GetMapping("")
    public ResponseEntity<List<EtatCommandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatCommandes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatCommandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatCommande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatCommandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a etatCommande by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatCommandeDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new EtatCommande(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  etatCommande")
    @PostMapping("")
    public ResponseEntity<EtatCommandeDto> save(@RequestBody EtatCommandeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatCommande")
    @PutMapping("")
    public ResponseEntity<EtatCommandeDto> update(@RequestBody EtatCommandeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatCommande")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatCommandeDto>> delete(@RequestBody List<EtatCommandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatCommande")
    @DeleteMapping("")
    public ResponseEntity<EtatCommandeDto> delete(@RequestBody EtatCommandeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatCommande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatCommandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds etatCommandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatCommandeDto>> findByCriteria(@RequestBody EtatCommandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatCommandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatCommandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatCommandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatCommandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatCommande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatCommandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatCommandeRestAdmin (EtatCommandeAdminService service, EtatCommandeConverter converter) {
        super(service, converter);
    }




}
