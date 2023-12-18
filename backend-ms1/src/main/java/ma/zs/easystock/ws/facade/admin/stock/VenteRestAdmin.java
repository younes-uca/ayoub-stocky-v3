package  ma.zs.easystock.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.stock.Vente;
import ma.zs.easystock.dao.criteria.core.stock.VenteCriteria;
import ma.zs.easystock.service.facade.admin.stock.VenteAdminService;
import ma.zs.easystock.ws.converter.stock.VenteConverter;
import ma.zs.easystock.ws.dto.stock.VenteDto;
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
@RequestMapping("/api/admin/vente/")
public class VenteRestAdmin  extends AbstractController<Vente, VenteDto, VenteCriteria, VenteAdminService, VenteConverter> {



    @Operation(summary = "upload one vente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple ventes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all ventes")
    @GetMapping("")
    public ResponseEntity<List<VenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all ventes")
    @GetMapping("optimized")
    public ResponseEntity<List<VenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a vente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a vente by numeroFacture")
    @GetMapping("numeroFacture/{numeroFacture}")
    public ResponseEntity<VenteDto> findByNumeroFacture(@PathVariable String numeroFacture, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Vente(numeroFacture), includes, excludes);
    }

    @Operation(summary = "Saves the specified  vente")
    @PostMapping("")
    public ResponseEntity<VenteDto> save(@RequestBody VenteDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  vente")
    @PutMapping("")
    public ResponseEntity<VenteDto> update(@RequestBody VenteDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of vente")
    @PostMapping("multiple")
    public ResponseEntity<List<VenteDto>> delete(@RequestBody List<VenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified vente")
    @DeleteMapping("")
    public ResponseEntity<VenteDto> delete(@RequestBody VenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified vente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple ventes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public List<VenteDto> findByEntrepriseSocieteId(@PathVariable Long id){
        return findDtos(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public int deleteByEntrepriseSocieteId(@PathVariable Long id){
        return service.deleteByEntrepriseSocieteId(id);
    }
    @Operation(summary = "find by client id")
    @GetMapping("client/id/{id}")
    public List<VenteDto> findByClientId(@PathVariable Long id){
        return findDtos(service.findByClientId(id));
    }
    @Operation(summary = "delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @Operation(summary = "find by etatVente id")
    @GetMapping("etatVente/id/{id}")
    public List<VenteDto> findByEtatVenteId(@PathVariable Long id){
        return findDtos(service.findByEtatVenteId(id));
    }
    @Operation(summary = "delete by etatVente id")
    @DeleteMapping("etatVente/id/{id}")
    public int deleteByEtatVenteId(@PathVariable Long id){
        return service.deleteByEtatVenteId(id);
    }
    @Operation(summary = "Finds a vente and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<VenteDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds ventes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<VenteDto>> findByCriteria(@RequestBody VenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated ventes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody VenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports ventes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody VenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets vente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody VenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public VenteRestAdmin (VenteAdminService service, VenteConverter converter) {
        super(service, converter);
    }




}
