package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.AvoirVenteItem;
import ma.zs.easystock.dao.criteria.core.stock.AvoirVenteItemCriteria;
import ma.zs.easystock.service.facade.admin.stock.AvoirVenteItemAdminService;
import ma.zs.easystock.ws.converter.stock.AvoirVenteItemConverter;
import ma.zs.easystock.ws.dto.stock.AvoirVenteItemDto;
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
@RequestMapping("/api/admin/avoirVenteItem/")
public class AvoirVenteItemRestAdmin  extends AbstractController<AvoirVenteItem, AvoirVenteItemDto, AvoirVenteItemCriteria, AvoirVenteItemAdminService, AvoirVenteItemConverter> {



    @Operation(summary = "upload one avoirVenteItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple avoirVenteItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all avoirVenteItems")
    @GetMapping("")
    public ResponseEntity<List<AvoirVenteItemDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all avoirVenteItems")
    @GetMapping("optimized")
    public ResponseEntity<List<AvoirVenteItemDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a avoirVenteItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvoirVenteItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a avoirVenteItem by barCode")
    @GetMapping("barCode/{barCode}")
    public ResponseEntity<AvoirVenteItemDto> findByBarCode(@PathVariable String barCode, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new AvoirVenteItem(barCode), includes, excludes);
    }

    @Operation(summary = "Saves the specified  avoirVenteItem")
    @PostMapping("")
    public ResponseEntity<AvoirVenteItemDto> save(@RequestBody AvoirVenteItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  avoirVenteItem")
    @PutMapping("")
    public ResponseEntity<AvoirVenteItemDto> update(@RequestBody AvoirVenteItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of avoirVenteItem")
    @PostMapping("multiple")
    public ResponseEntity<List<AvoirVenteItemDto>> delete(@RequestBody List<AvoirVenteItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified avoirVenteItem")
    @DeleteMapping("")
    public ResponseEntity<AvoirVenteItemDto> delete(@RequestBody AvoirVenteItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified avoirVenteItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple avoirVenteItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public List<AvoirVenteItemDto> findByDepotId(@PathVariable Long id){
        return findDtos(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public int deleteByDepotId(@PathVariable Long id){
        return service.deleteByDepotId(id);
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<AvoirVenteItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public List<AvoirVenteItemDto> findByTaxeId(@PathVariable Long id){
        return findDtos(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public int deleteByTaxeId(@PathVariable Long id){
        return service.deleteByTaxeId(id);
    }
    @Operation(summary = "find by avoirVente id")
    @GetMapping("avoirVente/id/{id}")
    public List<AvoirVenteItemDto> findByAvoirVenteId(@PathVariable Long id){
        return findDtos(service.findByAvoirVenteId(id));
    }
    @Operation(summary = "delete by avoirVente id")
    @DeleteMapping("avoirVente/id/{id}")
    public int deleteByAvoirVenteId(@PathVariable Long id){
        return service.deleteByAvoirVenteId(id);
    }
    @Operation(summary = "Finds avoirVenteItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AvoirVenteItemDto>> findByCriteria(@RequestBody AvoirVenteItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated avoirVenteItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AvoirVenteItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports avoirVenteItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AvoirVenteItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets avoirVenteItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AvoirVenteItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public AvoirVenteItemRestAdmin (AvoirVenteItemAdminService service, AvoirVenteItemConverter converter) {
        super(service, converter);
    }




}
