package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.TransfertItem;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TransfertItemCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TransfertItemAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.TransfertItemConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.TransfertItemDto;
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
@RequestMapping("/api/admin/transfertItem/")
public class TransfertItemRestAdmin  extends AbstractController<TransfertItem, TransfertItemDto, TransfertItemCriteria, TransfertItemAdminService, TransfertItemConverter> {



    @Operation(summary = "upload one transfertItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple transfertItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all transfertItems")
    @GetMapping("")
    public ResponseEntity<List<TransfertItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a transfertItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TransfertItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  transfertItem")
    @PostMapping("")
    public ResponseEntity<TransfertItemDto> save(@RequestBody TransfertItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  transfertItem")
    @PutMapping("")
    public ResponseEntity<TransfertItemDto> update(@RequestBody TransfertItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of transfertItem")
    @PostMapping("multiple")
    public ResponseEntity<List<TransfertItemDto>> delete(@RequestBody List<TransfertItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified transfertItem")
    @DeleteMapping("")
    public ResponseEntity<TransfertItemDto> delete(@RequestBody TransfertItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified transfertItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple transfertItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by depot id")
    @GetMapping("depot/id/{id}")
    public List<TransfertItemDto> findByDepotId(@PathVariable Long id){
        return findDtos(service.findByDepotId(id));
    }
    @Operation(summary = "delete by depot id")
    @DeleteMapping("depot/id/{id}")
    public int deleteByDepotId(@PathVariable Long id){
        return service.deleteByDepotId(id);
    }
    @Operation(summary = "find by produit id")
    @GetMapping("produit/id/{id}")
    public List<TransfertItemDto> findByProduitId(@PathVariable Long id){
        return findDtos(service.findByProduitId(id));
    }
    @Operation(summary = "delete by produit id")
    @DeleteMapping("produit/id/{id}")
    public int deleteByProduitId(@PathVariable Long id){
        return service.deleteByProduitId(id);
    }
    @Operation(summary = "find by transfert id")
    @GetMapping("transfert/id/{id}")
    public List<TransfertItemDto> findByTransfertId(@PathVariable Long id){
        return findDtos(service.findByTransfertId(id));
    }
    @Operation(summary = "delete by transfert id")
    @DeleteMapping("transfert/id/{id}")
    public int deleteByTransfertId(@PathVariable Long id){
        return service.deleteByTransfertId(id);
    }
    @Operation(summary = "Finds transfertItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TransfertItemDto>> findByCriteria(@RequestBody TransfertItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated transfertItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TransfertItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports transfertItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TransfertItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets transfertItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TransfertItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TransfertItemRestAdmin (TransfertItemAdminService service, TransfertItemConverter converter) {
        super(service, converter);
    }




}
