package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.Devis;
import ma.zs.easystock.dao.criteria.core.stock.DevisCriteria;
import ma.zs.easystock.service.facade.admin.stock.DevisAdminService;
import ma.zs.easystock.ws.converter.stock.DevisConverter;
import ma.zs.easystock.ws.dto.stock.DevisDto;
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
@RequestMapping("/api/admin/devis/")
public class DevisRestAdmin  extends AbstractController<Devis, DevisDto, DevisCriteria, DevisAdminService, DevisConverter> {



    @Operation(summary = "upload one devis")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple deviss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all deviss")
    @GetMapping("")
    public ResponseEntity<List<DevisDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all deviss")
    @GetMapping("optimized")
    public ResponseEntity<List<DevisDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a devis by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DevisDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a devis by numero")
    @GetMapping("numero/{numero}")
    public ResponseEntity<DevisDto> findByNumero(@PathVariable String numero, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Devis(numero), includes, excludes);
    }

    @Operation(summary = "Saves the specified  devis")
    @PostMapping("")
    public ResponseEntity<DevisDto> save(@RequestBody DevisDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  devis")
    @PutMapping("")
    public ResponseEntity<DevisDto> update(@RequestBody DevisDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of devis")
    @PostMapping("multiple")
    public ResponseEntity<List<DevisDto>> delete(@RequestBody List<DevisDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified devis")
    @DeleteMapping("")
    public ResponseEntity<DevisDto> delete(@RequestBody DevisDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified devis")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple deviss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by client id")
    @GetMapping("client/id/{id}")
    public List<DevisDto> findByClientId(@PathVariable Long id){
        return findDtos(service.findByClientId(id));
    }
    @Operation(summary = "delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @Operation(summary = "Finds a devis and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<DevisDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds deviss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DevisDto>> findByCriteria(@RequestBody DevisCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated deviss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DevisCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports deviss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DevisCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets devis data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DevisCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public DevisRestAdmin (DevisAdminService service, DevisConverter converter) {
        super(service, converter);
    }




}
