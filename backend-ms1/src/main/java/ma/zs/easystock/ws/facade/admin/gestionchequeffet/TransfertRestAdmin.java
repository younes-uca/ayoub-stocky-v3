package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.Transfert;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TransfertCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TransfertAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.TransfertConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransfertDto;
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
@RequestMapping("/api/admin/transfert/")
public class TransfertRestAdmin  extends AbstractController<Transfert, TransfertDto, TransfertCriteria, TransfertAdminService, TransfertConverter> {



    @Operation(summary = "upload one transfert")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple transferts")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all transferts")
    @GetMapping("")
    public ResponseEntity<List<TransfertDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a transfert by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TransfertDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  transfert")
    @PostMapping("")
    public ResponseEntity<TransfertDto> save(@RequestBody TransfertDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  transfert")
    @PutMapping("")
    public ResponseEntity<TransfertDto> update(@RequestBody TransfertDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of transfert")
    @PostMapping("multiple")
    public ResponseEntity<List<TransfertDto>> delete(@RequestBody List<TransfertDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified transfert")
    @DeleteMapping("")
    public ResponseEntity<TransfertDto> delete(@RequestBody TransfertDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified transfert")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple transferts by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by raison id")
    @GetMapping("raison/id/{id}")
    public List<TransfertDto> findByRaisonId(@PathVariable Long id){
        return findDtos(service.findByRaisonId(id));
    }
    @Operation(summary = "delete by raison id")
    @DeleteMapping("raison/id/{id}")
    public int deleteByRaisonId(@PathVariable Long id){
        return service.deleteByRaisonId(id);
    }
    @Operation(summary = "Finds a transfert and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<TransfertDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds transferts by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TransfertDto>> findByCriteria(@RequestBody TransfertCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated transferts by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TransfertCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports transferts by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TransfertCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets transfert data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TransfertCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TransfertRestAdmin (TransfertAdminService service, TransfertConverter converter) {
        super(service, converter);
    }




}
