package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.BonPour;
import ma.zs.easystock.dao.criteria.core.stock.BonPourCriteria;
import ma.zs.easystock.service.facade.admin.stock.BonPourAdminService;
import ma.zs.easystock.ws.converter.stock.BonPourConverter;
import ma.zs.easystock.ws.dto.stock.BonPourDto;
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
@RequestMapping("/api/admin/bonPour/")
public class BonPourRestAdmin  extends AbstractController<BonPour, BonPourDto, BonPourCriteria, BonPourAdminService, BonPourConverter> {



    @Operation(summary = "upload one bonPour")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple bonPours")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all bonPours")
    @GetMapping("")
    public ResponseEntity<List<BonPourDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all bonPours")
    @GetMapping("optimized")
    public ResponseEntity<List<BonPourDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a bonPour by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BonPourDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a bonPour by numero")
    @GetMapping("numero/{numero}")
    public ResponseEntity<BonPourDto> findByNumero(@PathVariable String numero, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new BonPour(numero), includes, excludes);
    }

    @Operation(summary = "Saves the specified  bonPour")
    @PostMapping("")
    public ResponseEntity<BonPourDto> save(@RequestBody BonPourDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  bonPour")
    @PutMapping("")
    public ResponseEntity<BonPourDto> update(@RequestBody BonPourDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of bonPour")
    @PostMapping("multiple")
    public ResponseEntity<List<BonPourDto>> delete(@RequestBody List<BonPourDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified bonPour")
    @DeleteMapping("")
    public ResponseEntity<BonPourDto> delete(@RequestBody BonPourDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified bonPour")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple bonPours by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by client id")
    @GetMapping("client/id/{id}")
    public List<BonPourDto> findByClientId(@PathVariable Long id){
        return findDtos(service.findByClientId(id));
    }
    @Operation(summary = "delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @Operation(summary = "Finds a bonPour and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<BonPourDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds bonPours by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BonPourDto>> findByCriteria(@RequestBody BonPourCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated bonPours by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BonPourCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports bonPours by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BonPourCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets bonPour data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BonPourCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public BonPourRestAdmin (BonPourAdminService service, BonPourConverter converter) {
        super(service, converter);
    }




}
