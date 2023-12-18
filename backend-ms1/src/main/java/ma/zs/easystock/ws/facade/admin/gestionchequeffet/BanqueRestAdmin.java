package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.Banque;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.BanqueCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.BanqueAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.BanqueConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.BanqueDto;
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
@RequestMapping("/api/admin/banque/")
public class BanqueRestAdmin  extends AbstractController<Banque, BanqueDto, BanqueCriteria, BanqueAdminService, BanqueConverter> {



    @Operation(summary = "upload one banque")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple banques")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all banques")
    @GetMapping("")
    public ResponseEntity<List<BanqueDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all banques")
    @GetMapping("optimized")
    public ResponseEntity<List<BanqueDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a banque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BanqueDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a banque by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<BanqueDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Banque(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  banque")
    @PostMapping("")
    public ResponseEntity<BanqueDto> save(@RequestBody BanqueDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  banque")
    @PutMapping("")
    public ResponseEntity<BanqueDto> update(@RequestBody BanqueDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of banque")
    @PostMapping("multiple")
    public ResponseEntity<List<BanqueDto>> delete(@RequestBody List<BanqueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified banque")
    @DeleteMapping("")
    public ResponseEntity<BanqueDto> delete(@RequestBody BanqueDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified banque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple banques by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds banques by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BanqueDto>> findByCriteria(@RequestBody BanqueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated banques by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BanqueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports banques by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BanqueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets banque data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BanqueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public BanqueRestAdmin (BanqueAdminService service, BanqueConverter converter) {
        super(service, converter);
    }




}
