package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.Tache;
import ma.zs.easystock.dao.criteria.core.stock.TacheCriteria;
import ma.zs.easystock.service.facade.admin.stock.TacheAdminService;
import ma.zs.easystock.ws.converter.stock.TacheConverter;
import ma.zs.easystock.ws.dto.stock.TacheDto;
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
@RequestMapping("/api/admin/tache/")
public class TacheRestAdmin  extends AbstractController<Tache, TacheDto, TacheCriteria, TacheAdminService, TacheConverter> {



    @Operation(summary = "upload one tache")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple taches")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all taches")
    @GetMapping("")
    public ResponseEntity<List<TacheDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a tache by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TacheDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  tache")
    @PostMapping("")
    public ResponseEntity<TacheDto> save(@RequestBody TacheDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  tache")
    @PutMapping("")
    public ResponseEntity<TacheDto> update(@RequestBody TacheDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of tache")
    @PostMapping("multiple")
    public ResponseEntity<List<TacheDto>> delete(@RequestBody List<TacheDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified tache")
    @DeleteMapping("")
    public ResponseEntity<TacheDto> delete(@RequestBody TacheDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified tache")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple taches by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by collaborateur id")
    @GetMapping("collaborateur/id/{id}")
    public List<TacheDto> findByCollaborateurId(@PathVariable Long id){
        return findDtos(service.findByCollaborateurId(id));
    }
    @Operation(summary = "delete by collaborateur id")
    @DeleteMapping("collaborateur/id/{id}")
    public int deleteByCollaborateurId(@PathVariable Long id){
        return service.deleteByCollaborateurId(id);
    }
    @Operation(summary = "Finds taches by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TacheDto>> findByCriteria(@RequestBody TacheCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated taches by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TacheCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports taches by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TacheCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets tache data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TacheCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TacheRestAdmin (TacheAdminService service, TacheConverter converter) {
        super(service, converter);
    }




}
