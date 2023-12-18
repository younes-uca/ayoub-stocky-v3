package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.ModeReglement;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.ModeReglementCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.ModeReglementAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.ModeReglementConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.ModeReglementDto;
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
@RequestMapping("/api/admin/modeReglement/")
public class ModeReglementRestAdmin  extends AbstractController<ModeReglement, ModeReglementDto, ModeReglementCriteria, ModeReglementAdminService, ModeReglementConverter> {



    @Operation(summary = "upload one modeReglement")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple modeReglements")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all modeReglements")
    @GetMapping("")
    public ResponseEntity<List<ModeReglementDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all modeReglements")
    @GetMapping("optimized")
    public ResponseEntity<List<ModeReglementDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a modeReglement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ModeReglementDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a modeReglement by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<ModeReglementDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new ModeReglement(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  modeReglement")
    @PostMapping("")
    public ResponseEntity<ModeReglementDto> save(@RequestBody ModeReglementDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  modeReglement")
    @PutMapping("")
    public ResponseEntity<ModeReglementDto> update(@RequestBody ModeReglementDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of modeReglement")
    @PostMapping("multiple")
    public ResponseEntity<List<ModeReglementDto>> delete(@RequestBody List<ModeReglementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified modeReglement")
    @DeleteMapping("")
    public ResponseEntity<ModeReglementDto> delete(@RequestBody ModeReglementDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified modeReglement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple modeReglements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds modeReglements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ModeReglementDto>> findByCriteria(@RequestBody ModeReglementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated modeReglements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ModeReglementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports modeReglements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ModeReglementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets modeReglement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ModeReglementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ModeReglementRestAdmin (ModeReglementAdminService service, ModeReglementConverter converter) {
        super(service, converter);
    }




}
