package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.VenteItem;
import ma.zs.easystock.dao.criteria.core.stock.VenteItemCriteria;
import ma.zs.easystock.service.facade.admin.stock.VenteItemAdminService;
import ma.zs.easystock.ws.converter.stock.VenteItemConverter;
import ma.zs.easystock.ws.dto.stock.VenteItemDto;
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
@RequestMapping("/api/admin/venteItem/")
public class VenteItemRestAdmin  extends AbstractController<VenteItem, VenteItemDto, VenteItemCriteria, VenteItemAdminService, VenteItemConverter> {



    @Operation(summary = "upload one venteItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple venteItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all venteItems")
    @GetMapping("")
    public ResponseEntity<List<VenteItemDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all venteItems")
    @GetMapping("optimized")
    public ResponseEntity<List<VenteItemDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a venteItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VenteItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a venteItem by barCode")
    @GetMapping("barCode/{barCode}")
    public ResponseEntity<VenteItemDto> findByBarCode(@PathVariable String barCode, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new VenteItem(barCode), includes, excludes);
    }

    @Operation(summary = "Saves the specified  venteItem")
    @PostMapping("")
    public ResponseEntity<VenteItemDto> save(@RequestBody VenteItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  venteItem")
    @PutMapping("")
    public ResponseEntity<VenteItemDto> update(@RequestBody VenteItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of venteItem")
    @PostMapping("multiple")
    public ResponseEntity<List<VenteItemDto>> delete(@RequestBody List<VenteItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified venteItem")
    @DeleteMapping("")
    public ResponseEntity<VenteItemDto> delete(@RequestBody VenteItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified venteItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple venteItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public List<VenteItemDto> findByDepotId(@PathVariable Long id){
        return findDtos(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public int deleteByDepotId(@PathVariable Long id){
        return service.deleteByDepotId(id);
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<VenteItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public List<VenteItemDto> findByTaxeId(@PathVariable Long id){
        return findDtos(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public int deleteByTaxeId(@PathVariable Long id){
        return service.deleteByTaxeId(id);
    }
    @Operation(summary = "find by vente id")
    @GetMapping("vente/id/{id}")
    public List<VenteItemDto> findByVenteId(@PathVariable Long id){
        return findDtos(service.findByVenteId(id));
    }
    @Operation(summary = "delete by vente id")
    @DeleteMapping("vente/id/{id}")
    public int deleteByVenteId(@PathVariable Long id){
        return service.deleteByVenteId(id);
    }
    @Operation(summary = "Finds venteItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<VenteItemDto>> findByCriteria(@RequestBody VenteItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated venteItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody VenteItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports venteItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody VenteItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets venteItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody VenteItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public VenteItemRestAdmin (VenteItemAdminService service, VenteItemConverter converter) {
        super(service, converter);
    }




}
