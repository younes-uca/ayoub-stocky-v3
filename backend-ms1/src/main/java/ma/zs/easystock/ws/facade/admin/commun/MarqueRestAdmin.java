package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.Marque;
import ma.zs.easystock.dao.criteria.core.commun.MarqueCriteria;
import ma.zs.easystock.service.facade.admin.commun.MarqueAdminService;
import ma.zs.easystock.ws.converter.commun.MarqueConverter;
import ma.zs.easystock.ws.dto.commun.MarqueDto;
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
@RequestMapping("/api/admin/marque/")
public class MarqueRestAdmin  extends AbstractController<Marque, MarqueDto, MarqueCriteria, MarqueAdminService, MarqueConverter> {



    @Operation(summary = "upload one marque")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple marques")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all marques")
    @GetMapping("")
    public ResponseEntity<List<MarqueDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all marques")
    @GetMapping("optimized")
    public ResponseEntity<List<MarqueDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a marque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MarqueDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a marque by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<MarqueDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Marque(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  marque")
    @PostMapping("")
    public ResponseEntity<MarqueDto> save(@RequestBody MarqueDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  marque")
    @PutMapping("")
    public ResponseEntity<MarqueDto> update(@RequestBody MarqueDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of marque")
    @PostMapping("multiple")
    public ResponseEntity<List<MarqueDto>> delete(@RequestBody List<MarqueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified marque")
    @DeleteMapping("")
    public ResponseEntity<MarqueDto> delete(@RequestBody MarqueDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified marque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple marques by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds marques by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MarqueDto>> findByCriteria(@RequestBody MarqueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated marques by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MarqueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports marques by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody MarqueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets marque data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MarqueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public MarqueRestAdmin (MarqueAdminService service, MarqueConverter converter) {
        super(service, converter);
    }




}
