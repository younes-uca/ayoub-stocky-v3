package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.AvoirAchat;
import ma.zs.easystock.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zs.easystock.service.facade.admin.stock.AvoirAchatAdminService;
import ma.zs.easystock.ws.converter.stock.AvoirAchatConverter;
import ma.zs.easystock.ws.dto.stock.AvoirAchatDto;
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
@RequestMapping("/api/admin/avoirAchat/")
public class AvoirAchatRestAdmin  extends AbstractController<AvoirAchat, AvoirAchatDto, AvoirAchatCriteria, AvoirAchatAdminService, AvoirAchatConverter> {



    @Operation(summary = "upload one avoirAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple avoirAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all avoirAchats")
    @GetMapping("")
    public ResponseEntity<List<AvoirAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all avoirAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<AvoirAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a avoirAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a avoirAchat by numeroFactureAvoirFournisseur")
    @GetMapping("numeroFactureAvoirFournisseur/{numeroFactureAvoirFournisseur}")
    public ResponseEntity<AvoirAchatDto> findByNumeroFactureAvoirFournisseur(@PathVariable String numeroFactureAvoirFournisseur, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new AvoirAchat(numeroFactureAvoirFournisseur), includes, excludes);
    }

    @Operation(summary = "Saves the specified  avoirAchat")
    @PostMapping("")
    public ResponseEntity<AvoirAchatDto> save(@RequestBody AvoirAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  avoirAchat")
    @PutMapping("")
    public ResponseEntity<AvoirAchatDto> update(@RequestBody AvoirAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of avoirAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<AvoirAchatDto>> delete(@RequestBody List<AvoirAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified avoirAchat")
    @DeleteMapping("")
    public ResponseEntity<AvoirAchatDto> delete(@RequestBody AvoirAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified avoirAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple avoirAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public List<AvoirAchatDto> findByEntrepriseSocieteId(@PathVariable Long id){
        return findDtos(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public int deleteByEntrepriseSocieteId(@PathVariable Long id){
        return service.deleteByEntrepriseSocieteId(id);
    }
    @Operation(summary = "find by fournisseur id")
    @GetMapping("fournisseur/id/{id}")
    public List<AvoirAchatDto> findByFournisseurId(@PathVariable Long id){
        return findDtos(service.findByFournisseurId(id));
    }
    @Operation(summary = "delete by fournisseur id")
    @DeleteMapping("fournisseur/id/{id}")
    public int deleteByFournisseurId(@PathVariable Long id){
        return service.deleteByFournisseurId(id);
    }
    @Operation(summary = "find by etatAvoirAchat id")
    @GetMapping("etatAvoirAchat/id/{id}")
    public List<AvoirAchatDto> findByEtatAvoirAchatId(@PathVariable Long id){
        return findDtos(service.findByEtatAvoirAchatId(id));
    }
    @Operation(summary = "delete by etatAvoirAchat id")
    @DeleteMapping("etatAvoirAchat/id/{id}")
    public int deleteByEtatAvoirAchatId(@PathVariable Long id){
        return service.deleteByEtatAvoirAchatId(id);
    }
    @Operation(summary = "find by achat id")
    @GetMapping("achat/id/{id}")
    public List<AvoirAchatDto> findByAchatId(@PathVariable Long id){
        return findDtos(service.findByAchatId(id));
    }
    @Operation(summary = "delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public int deleteByAchatId(@PathVariable Long id){
        return service.deleteByAchatId(id);
    }
    @Operation(summary = "Finds a avoirAchat and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<AvoirAchatDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds avoirAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AvoirAchatDto>> findByCriteria(@RequestBody AvoirAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated avoirAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AvoirAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports avoirAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AvoirAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets avoirAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AvoirAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public AvoirAchatRestAdmin (AvoirAchatAdminService service, AvoirAchatConverter converter) {
        super(service, converter);
    }




}
