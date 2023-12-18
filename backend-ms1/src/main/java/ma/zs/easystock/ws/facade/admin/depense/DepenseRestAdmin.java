package  ma.zs.easystock.ws.facade.admin.depense;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.depense.Depense;
import ma.zs.easystock.dao.criteria.core.depense.DepenseCriteria;
import ma.zs.easystock.service.facade.admin.depense.DepenseAdminService;
import ma.zs.easystock.ws.converter.depense.DepenseConverter;
import ma.zs.easystock.ws.dto.depense.DepenseDto;
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
@RequestMapping("/api/admin/depense/")
public class DepenseRestAdmin  extends AbstractController<Depense, DepenseDto, DepenseCriteria, DepenseAdminService, DepenseConverter> {



    @Operation(summary = "upload one depense")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple depenses")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all depenses")
    @GetMapping("")
    public ResponseEntity<List<DepenseDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a depense by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DepenseDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  depense")
    @PostMapping("")
    public ResponseEntity<DepenseDto> save(@RequestBody DepenseDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  depense")
    @PutMapping("")
    public ResponseEntity<DepenseDto> update(@RequestBody DepenseDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of depense")
    @PostMapping("multiple")
    public ResponseEntity<List<DepenseDto>> delete(@RequestBody List<DepenseDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified depense")
    @DeleteMapping("")
    public ResponseEntity<DepenseDto> delete(@RequestBody DepenseDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified depense")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple depenses by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds depenses by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DepenseDto>> findByCriteria(@RequestBody DepenseCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated depenses by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DepenseCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports depenses by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DepenseCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets depense data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DepenseCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public DepenseRestAdmin (DepenseAdminService service, DepenseConverter converter) {
        super(service, converter);
    }




}
