package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.CommandeItem;
import ma.zs.easystock.dao.criteria.core.stock.CommandeItemCriteria;
import ma.zs.easystock.service.facade.admin.stock.CommandeItemAdminService;
import ma.zs.easystock.ws.converter.stock.CommandeItemConverter;
import ma.zs.easystock.ws.dto.stock.CommandeItemDto;
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
@RequestMapping("/api/admin/commandeItem/")
public class CommandeItemRestAdmin  extends AbstractController<CommandeItem, CommandeItemDto, CommandeItemCriteria, CommandeItemAdminService, CommandeItemConverter> {



    @Operation(summary = "upload one commandeItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple commandeItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all commandeItems")
    @GetMapping("")
    public ResponseEntity<List<CommandeItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a commandeItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CommandeItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  commandeItem")
    @PostMapping("")
    public ResponseEntity<CommandeItemDto> save(@RequestBody CommandeItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  commandeItem")
    @PutMapping("")
    public ResponseEntity<CommandeItemDto> update(@RequestBody CommandeItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of commandeItem")
    @PostMapping("multiple")
    public ResponseEntity<List<CommandeItemDto>> delete(@RequestBody List<CommandeItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified commandeItem")
    @DeleteMapping("")
    public ResponseEntity<CommandeItemDto> delete(@RequestBody CommandeItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified commandeItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple commandeItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<CommandeItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by taxe id")
    @GetMapping("taxe/id/{id}")
    public List<CommandeItemDto> findByTaxeId(@PathVariable Long id){
        return findDtos(service.findByTaxeId(id));
    }
    @Operation(summary = "delete by taxe id")
    @DeleteMapping("taxe/id/{id}")
    public int deleteByTaxeId(@PathVariable Long id){
        return service.deleteByTaxeId(id);
    }
    @Operation(summary = "find by commande id")
    @GetMapping("commande/id/{id}")
    public List<CommandeItemDto> findByCommandeId(@PathVariable Long id){
        return findDtos(service.findByCommandeId(id));
    }
    @Operation(summary = "delete by commande id")
    @DeleteMapping("commande/id/{id}")
    public int deleteByCommandeId(@PathVariable Long id){
        return service.deleteByCommandeId(id);
    }
    @Operation(summary = "Finds commandeItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CommandeItemDto>> findByCriteria(@RequestBody CommandeItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated commandeItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CommandeItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports commandeItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CommandeItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets commandeItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CommandeItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CommandeItemRestAdmin (CommandeItemAdminService service, CommandeItemConverter converter) {
        super(service, converter);
    }




}
