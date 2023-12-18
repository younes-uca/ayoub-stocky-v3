package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.Proprietaire;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ProprietaireAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.ProprietaireConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.ProprietaireDto;
import ma.zs.easystock.zynerator.controller.AbstractController;
import ma.zs.easystock.zynerator.dto.AuditEntityDto;
import ma.zs.easystock.zynerator.util.PaginatedList;


import ma.zs.easystock.zynerator.security.bean.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.easystock.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.easystock.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/proprietaire/")
public class ProprietaireRestAdmin  extends AbstractController<Proprietaire, ProprietaireDto, ProprietaireCriteria, ProprietaireAdminService, ProprietaireConverter> {



    @Operation(summary = "upload one proprietaire")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple proprietaires")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all proprietaires")
    @GetMapping("")
    public ResponseEntity<List<ProprietaireDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all proprietaires")
    @GetMapping("optimized")
    public ResponseEntity<List<ProprietaireDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a proprietaire by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProprietaireDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a proprietaire by telephone")
    @GetMapping("telephone/{telephone}")
    public ResponseEntity<ProprietaireDto> findByTelephone(@PathVariable String telephone, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Proprietaire(telephone), includes, excludes);
    }

    @Operation(summary = "Saves the specified  proprietaire")
    @PostMapping("")
    public ResponseEntity<ProprietaireDto> save(@RequestBody ProprietaireDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  proprietaire")
    @PutMapping("")
    public ResponseEntity<ProprietaireDto> update(@RequestBody ProprietaireDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of proprietaire")
    @PostMapping("multiple")
    public ResponseEntity<List<ProprietaireDto>> delete(@RequestBody List<ProprietaireDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified proprietaire")
    @DeleteMapping("")
    public ResponseEntity<ProprietaireDto> delete(@RequestBody ProprietaireDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified proprietaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple proprietaires by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds proprietaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProprietaireDto>> findByCriteria(@RequestBody ProprietaireCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated proprietaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProprietaireCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports proprietaires by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProprietaireCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets proprietaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProprietaireCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    @Operation(summary = "Change password to the specified  utilisateur")
    @PutMapping("changePassword")
    public boolean changePassword(@RequestBody User dto) throws Exception {
        return service.changePassword(dto.getUsername(),dto.getPassword());
    }
    public ProprietaireRestAdmin (ProprietaireAdminService service, ProprietaireConverter converter) {
        super(service, converter);
    }




}
