package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.EtatTransaction;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.EtatTransactionCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.EtatTransactionAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.EtatTransactionConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.EtatTransactionDto;
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
@RequestMapping("/api/admin/etatTransaction/")
public class EtatTransactionRestAdmin  extends AbstractController<EtatTransaction, EtatTransactionDto, EtatTransactionCriteria, EtatTransactionAdminService, EtatTransactionConverter> {



    @Operation(summary = "upload one etatTransaction")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatTransactions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatTransactions")
    @GetMapping("")
    public ResponseEntity<List<EtatTransactionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatTransactions")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatTransactionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatTransaction by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatTransactionDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a etatTransaction by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatTransactionDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new EtatTransaction(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  etatTransaction")
    @PostMapping("")
    public ResponseEntity<EtatTransactionDto> save(@RequestBody EtatTransactionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatTransaction")
    @PutMapping("")
    public ResponseEntity<EtatTransactionDto> update(@RequestBody EtatTransactionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatTransaction")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatTransactionDto>> delete(@RequestBody List<EtatTransactionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatTransaction")
    @DeleteMapping("")
    public ResponseEntity<EtatTransactionDto> delete(@RequestBody EtatTransactionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatTransaction")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatTransactions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds etatTransactions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatTransactionDto>> findByCriteria(@RequestBody EtatTransactionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatTransactions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatTransactionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatTransactions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatTransactionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatTransaction data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatTransactionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatTransactionRestAdmin (EtatTransactionAdminService service, EtatTransactionConverter converter) {
        super(service, converter);
    }




}
