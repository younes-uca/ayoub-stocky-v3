package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.EtatVente;
import ma.zs.easystock.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.easystock.service.facade.admin.commun.EtatVenteAdminService;
import ma.zs.easystock.ws.converter.commun.EtatVenteConverter;
import ma.zs.easystock.ws.dto.commun.EtatVenteDto;
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
@RequestMapping("/api/admin/etatVente/")
public class EtatVenteRestAdmin  extends AbstractController<EtatVente, EtatVenteDto, EtatVenteCriteria, EtatVenteAdminService, EtatVenteConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<EtatVente>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one etatVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatVentes")
    @GetMapping("")
    public ResponseEntity<List<EtatVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a etatVente by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatVenteDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new EtatVente(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  etatVente")
    @PostMapping("")
    public ResponseEntity<EtatVenteDto> save(@RequestBody EtatVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatVente")
    @PutMapping("")
    public ResponseEntity<EtatVenteDto> update(@RequestBody EtatVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatVente")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatVenteDto>> delete(@RequestBody List<EtatVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatVente")
    @DeleteMapping("")
    public ResponseEntity<EtatVenteDto> delete(@RequestBody EtatVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds etatVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatVenteDto>> findByCriteria(@RequestBody EtatVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatVenteRestAdmin (EtatVenteAdminService service, EtatVenteConverter converter) {
        super(service, converter);
    }




}
