package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.EtatAvoirVente;
import ma.zs.easystock.dao.criteria.core.commun.EtatAvoirVenteCriteria;
import ma.zs.easystock.service.facade.admin.commun.EtatAvoirVenteAdminService;
import ma.zs.easystock.ws.converter.commun.EtatAvoirVenteConverter;
import ma.zs.easystock.ws.dto.commun.EtatAvoirVenteDto;
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
@RequestMapping("/api/admin/etatAvoirVente/")
public class EtatAvoirVenteRestAdmin  extends AbstractController<EtatAvoirVente, EtatAvoirVenteDto, EtatAvoirVenteCriteria, EtatAvoirVenteAdminService, EtatAvoirVenteConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<EtatAvoirVente>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody EtatAvoirVenteDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one etatAvoirVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatAvoirVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatAvoirVentes")
    @GetMapping("")
    public ResponseEntity<List<EtatAvoirVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatAvoirVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatAvoirVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatAvoirVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatAvoirVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a etatAvoirVente by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatAvoirVenteDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new EtatAvoirVente(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  etatAvoirVente")
    @PostMapping("")
    public ResponseEntity<EtatAvoirVenteDto> save(@RequestBody EtatAvoirVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatAvoirVente")
    @PutMapping("")
    public ResponseEntity<EtatAvoirVenteDto> update(@RequestBody EtatAvoirVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatAvoirVente")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatAvoirVenteDto>> delete(@RequestBody List<EtatAvoirVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatAvoirVente")
    @DeleteMapping("")
    public ResponseEntity<EtatAvoirVenteDto> delete(@RequestBody EtatAvoirVenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatAvoirVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatAvoirVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds etatAvoirVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatAvoirVenteDto>> findByCriteria(@RequestBody EtatAvoirVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatAvoirVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatAvoirVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatAvoirVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatAvoirVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatAvoirVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatAvoirVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatAvoirVenteRestAdmin (EtatAvoirVenteAdminService service, EtatAvoirVenteConverter converter) {
        super(service, converter);
    }




}
