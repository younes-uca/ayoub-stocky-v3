package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.ProprietaireBanque;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ProprietaireBanqueCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ProprietaireBanqueAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.ProprietaireBanqueConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.ProprietaireBanqueDto;
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
@RequestMapping("/api/admin/proprietaireBanque/")
public class ProprietaireBanqueRestAdmin  extends AbstractController<ProprietaireBanque, ProprietaireBanqueDto, ProprietaireBanqueCriteria, ProprietaireBanqueAdminService, ProprietaireBanqueConverter> {



    @Operation(summary = "upload one proprietaireBanque")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple proprietaireBanques")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all proprietaireBanques")
    @GetMapping("")
    public ResponseEntity<List<ProprietaireBanqueDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a proprietaireBanque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProprietaireBanqueDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  proprietaireBanque")
    @PostMapping("")
    public ResponseEntity<ProprietaireBanqueDto> save(@RequestBody ProprietaireBanqueDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  proprietaireBanque")
    @PutMapping("")
    public ResponseEntity<ProprietaireBanqueDto> update(@RequestBody ProprietaireBanqueDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of proprietaireBanque")
    @PostMapping("multiple")
    public ResponseEntity<List<ProprietaireBanqueDto>> delete(@RequestBody List<ProprietaireBanqueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified proprietaireBanque")
    @DeleteMapping("")
    public ResponseEntity<ProprietaireBanqueDto> delete(@RequestBody ProprietaireBanqueDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified proprietaireBanque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple proprietaireBanques by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by proprietaire id")
    @GetMapping("proprietaire/id/{id}")
    public List<ProprietaireBanqueDto> findByProprietaireId(@PathVariable Long id){
        return findDtos(service.findByProprietaireId(id));
    }
    @Operation(summary = "delete by proprietaire id")
    @DeleteMapping("proprietaire/id/{id}")
    public int deleteByProprietaireId(@PathVariable Long id){
        return service.deleteByProprietaireId(id);
    }
    @Operation(summary = "find by banque id")
    @GetMapping("banque/id/{id}")
    public List<ProprietaireBanqueDto> findByBanqueId(@PathVariable Long id){
        return findDtos(service.findByBanqueId(id));
    }
    @Operation(summary = "delete by banque id")
    @DeleteMapping("banque/id/{id}")
    public int deleteByBanqueId(@PathVariable Long id){
        return service.deleteByBanqueId(id);
    }
    @Operation(summary = "find by compte id")
    @GetMapping("compte/id/{id}")
    public List<ProprietaireBanqueDto> findByCompteId(@PathVariable Long id){
        return findDtos(service.findByCompteId(id));
    }
    @Operation(summary = "delete by compte id")
    @DeleteMapping("compte/id/{id}")
    public int deleteByCompteId(@PathVariable Long id){
        return service.deleteByCompteId(id);
    }
    @Operation(summary = "Finds proprietaireBanques by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProprietaireBanqueDto>> findByCriteria(@RequestBody ProprietaireBanqueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated proprietaireBanques by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProprietaireBanqueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports proprietaireBanques by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProprietaireBanqueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets proprietaireBanque data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProprietaireBanqueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ProprietaireBanqueRestAdmin (ProprietaireBanqueAdminService service, ProprietaireBanqueConverter converter) {
        super(service, converter);
    }




}
