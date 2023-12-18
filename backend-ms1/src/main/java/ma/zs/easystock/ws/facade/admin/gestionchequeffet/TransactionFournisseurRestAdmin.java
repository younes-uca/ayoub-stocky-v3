package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.TransactionFournisseur;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TransactionFournisseurCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TransactionFournisseurAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.TransactionFournisseurConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransactionFournisseurDto;
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
@RequestMapping("/api/admin/transactionFournisseur/")
public class TransactionFournisseurRestAdmin  extends AbstractController<TransactionFournisseur, TransactionFournisseurDto, TransactionFournisseurCriteria, TransactionFournisseurAdminService, TransactionFournisseurConverter> {



    @Operation(summary = "upload one transactionFournisseur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple transactionFournisseurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all transactionFournisseurs")
    @GetMapping("")
    public ResponseEntity<List<TransactionFournisseurDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a transactionFournisseur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TransactionFournisseurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  transactionFournisseur")
    @PostMapping("")
    public ResponseEntity<TransactionFournisseurDto> save(@RequestBody TransactionFournisseurDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  transactionFournisseur")
    @PutMapping("")
    public ResponseEntity<TransactionFournisseurDto> update(@RequestBody TransactionFournisseurDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of transactionFournisseur")
    @PostMapping("multiple")
    public ResponseEntity<List<TransactionFournisseurDto>> delete(@RequestBody List<TransactionFournisseurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified transactionFournisseur")
    @DeleteMapping("")
    public ResponseEntity<TransactionFournisseurDto> delete(@RequestBody TransactionFournisseurDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified transactionFournisseur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple transactionFournisseurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by typeInstrument id")
    @GetMapping("typeInstrument/id/{id}")
    public List<TransactionFournisseurDto> findByTypeInstrumentId(@PathVariable Long id){
        return findDtos(service.findByTypeInstrumentId(id));
    }
    @Operation(summary = "delete by typeInstrument id")
    @DeleteMapping("typeInstrument/id/{id}")
    public int deleteByTypeInstrumentId(@PathVariable Long id){
        return service.deleteByTypeInstrumentId(id);
    }
    @Operation(summary = "find by typeTransaction id")
    @GetMapping("typeTransaction/id/{id}")
    public List<TransactionFournisseurDto> findByTypeTransactionId(@PathVariable Long id){
        return findDtos(service.findByTypeTransactionId(id));
    }
    @Operation(summary = "delete by typeTransaction id")
    @DeleteMapping("typeTransaction/id/{id}")
    public int deleteByTypeTransactionId(@PathVariable Long id){
        return service.deleteByTypeTransactionId(id);
    }
    @Operation(summary = "find by compte id")
    @GetMapping("compte/id/{id}")
    public List<TransactionFournisseurDto> findByCompteId(@PathVariable Long id){
        return findDtos(service.findByCompteId(id));
    }
    @Operation(summary = "delete by compte id")
    @DeleteMapping("compte/id/{id}")
    public int deleteByCompteId(@PathVariable Long id){
        return service.deleteByCompteId(id);
    }
    @Operation(summary = "find by etatTransaction id")
    @GetMapping("etatTransaction/id/{id}")
    public List<TransactionFournisseurDto> findByEtatTransactionId(@PathVariable Long id){
        return findDtos(service.findByEtatTransactionId(id));
    }
    @Operation(summary = "delete by etatTransaction id")
    @DeleteMapping("etatTransaction/id/{id}")
    public int deleteByEtatTransactionId(@PathVariable Long id){
        return service.deleteByEtatTransactionId(id);
    }
    @Operation(summary = "Finds transactionFournisseurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TransactionFournisseurDto>> findByCriteria(@RequestBody TransactionFournisseurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated transactionFournisseurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TransactionFournisseurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports transactionFournisseurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TransactionFournisseurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets transactionFournisseur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TransactionFournisseurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TransactionFournisseurRestAdmin (TransactionFournisseurAdminService service, TransactionFournisseurConverter converter) {
        super(service, converter);
    }




}
