package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.Compte;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.CompteAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.CompteConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.CompteDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.easystock.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/compte/")
public class CompteRestAdmin  extends AbstractController<Compte, CompteDto, CompteCriteria, CompteAdminService, CompteConverter> {



    @Operation(summary = "upload one compte")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple comptes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all comptes")
    @GetMapping("")
    public ResponseEntity<List<CompteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all comptes")
    @GetMapping("optimized")
    public ResponseEntity<List<CompteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a compte by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CompteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a compte by numeroCompte")
    @GetMapping("numeroCompte/{numeroCompte}")
    public ResponseEntity<CompteDto> findByNumeroCompte(@PathVariable String numeroCompte, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Compte(numeroCompte), includes, excludes);
    }

    @Operation(summary = "Saves the specified  compte")
    @PostMapping("")
    public ResponseEntity<CompteDto> save(@RequestBody CompteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  compte")
    @PutMapping("")
    public ResponseEntity<CompteDto> update(@RequestBody CompteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of compte")
    @PostMapping("multiple")
    public ResponseEntity<List<CompteDto>> delete(@RequestBody List<CompteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified compte")
    @DeleteMapping("")
    public ResponseEntity<CompteDto> delete(@RequestBody CompteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified compte")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple comptes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by banque id")
    @GetMapping("banque/id/{id}")
    public List<CompteDto> findByBanqueId(@PathVariable Long id){
        return findDtos(service.findByBanqueId(id));
    }
    @Operation(summary = "delete by banque id")
    @DeleteMapping("banque/id/{id}")
    public int deleteByBanqueId(@PathVariable Long id){
        return service.deleteByBanqueId(id);
    }
    @Operation(summary = "find by proprietaire id")
    @GetMapping("proprietaire/id/{id}")
    public List<CompteDto> findByProprietaireId(@PathVariable Long id){
        return findDtos(service.findByProprietaireId(id));
    }
    @Operation(summary = "delete by proprietaire id")
    @DeleteMapping("proprietaire/id/{id}")
    public int deleteByProprietaireId(@PathVariable Long id){
        return service.deleteByProprietaireId(id);
    }
    @Operation(summary = "Finds comptes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CompteDto>> findByCriteria(@RequestBody CompteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated comptes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CompteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports comptes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CompteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets compte data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CompteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CompteRestAdmin (CompteAdminService service, CompteConverter converter) {
        super(service, converter);
    }




}
