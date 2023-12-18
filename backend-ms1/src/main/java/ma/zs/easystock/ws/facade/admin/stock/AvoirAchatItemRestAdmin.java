package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.AvoirAchatItem;
import ma.zs.easystock.dao.criteria.core.stock.AvoirAchatItemCriteria;
import ma.zs.easystock.service.facade.admin.stock.AvoirAchatItemAdminService;
import ma.zs.easystock.ws.converter.stock.AvoirAchatItemConverter;
import ma.zs.easystock.ws.dto.stock.AvoirAchatItemDto;
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
@RequestMapping("/api/admin/avoirAchatItem/")
public class AvoirAchatItemRestAdmin  extends AbstractController<AvoirAchatItem, AvoirAchatItemDto, AvoirAchatItemCriteria, AvoirAchatItemAdminService, AvoirAchatItemConverter> {



    @Operation(summary = "upload one avoirAchatItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple avoirAchatItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all avoirAchatItems")
    @GetMapping("")
    public ResponseEntity<List<AvoirAchatItemDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all avoirAchatItems")
    @GetMapping("optimized")
    public ResponseEntity<List<AvoirAchatItemDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a avoirAchatItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirAchatItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a avoirAchatItem by barCode")
    @GetMapping("barCode/{barCode}")
    public ResponseEntity<AvoirAchatItemDto> findByBarCode(@PathVariable String barCode, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new AvoirAchatItem(barCode), includes, excludes);
    }

    @Operation(summary = "Saves the specified  avoirAchatItem")
    @PostMapping("")
    public ResponseEntity<AvoirAchatItemDto> save(@RequestBody AvoirAchatItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  avoirAchatItem")
    @PutMapping("")
    public ResponseEntity<AvoirAchatItemDto> update(@RequestBody AvoirAchatItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of avoirAchatItem")
    @PostMapping("multiple")
    public ResponseEntity<List<AvoirAchatItemDto>> delete(@RequestBody List<AvoirAchatItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified avoirAchatItem")
    @DeleteMapping("")
    public ResponseEntity<AvoirAchatItemDto> delete(@RequestBody AvoirAchatItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified avoirAchatItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple avoirAchatItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public List<AvoirAchatItemDto> findByDepotId(@PathVariable Long id){
        return findDtos(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public int deleteByDepotId(@PathVariable Long id){
        return service.deleteByDepotId(id);
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<AvoirAchatItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public List<AvoirAchatItemDto> findByTaxeId(@PathVariable Long id){
        return findDtos(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public int deleteByTaxeId(@PathVariable Long id){
        return service.deleteByTaxeId(id);
    }
    @Operation(summary = "find by avoirAchat id")
    @GetMapping("avoirAchat/id/{id}")
    public List<AvoirAchatItemDto> findByAvoirAchatId(@PathVariable Long id){
        return findDtos(service.findByAvoirAchatId(id));
    }
    @Operation(summary = "delete by avoirAchat id")
    @DeleteMapping("avoirAchat/id/{id}")
    public int deleteByAvoirAchatId(@PathVariable Long id){
        return service.deleteByAvoirAchatId(id);
    }
    @Operation(summary = "Finds avoirAchatItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AvoirAchatItemDto>> findByCriteria(@RequestBody AvoirAchatItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated avoirAchatItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AvoirAchatItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports avoirAchatItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AvoirAchatItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets avoirAchatItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AvoirAchatItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public AvoirAchatItemRestAdmin (AvoirAchatItemAdminService service, AvoirAchatItemConverter converter) {
        super(service, converter);
    }




}
