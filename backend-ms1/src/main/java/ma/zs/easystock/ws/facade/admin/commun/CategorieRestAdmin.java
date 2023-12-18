package  ma.zs.easystock.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.commun.Categorie;
import ma.zs.easystock.dao.criteria.core.commun.CategorieCriteria;
import ma.zs.easystock.service.facade.admin.commun.CategorieAdminService;
import ma.zs.easystock.ws.converter.commun.CategorieConverter;
import ma.zs.easystock.ws.dto.commun.CategorieDto;
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
@RequestMapping("/api/admin/categorie/")
public class CategorieRestAdmin  extends AbstractController<Categorie, CategorieDto, CategorieCriteria, CategorieAdminService, CategorieConverter> {



    @Operation(summary = "upload one categorie")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categories")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categories")
    @GetMapping("")
    public ResponseEntity<List<CategorieDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categories")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categorie by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a categorie by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<CategorieDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new Categorie(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  categorie")
    @PostMapping("")
    public ResponseEntity<CategorieDto> save(@RequestBody CategorieDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categorie")
    @PutMapping("")
    public ResponseEntity<CategorieDto> update(@RequestBody CategorieDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categorie")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieDto>> delete(@RequestBody List<CategorieDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categorie")
    @DeleteMapping("")
    public ResponseEntity<CategorieDto> delete(@RequestBody CategorieDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categorie")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categories by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds categories by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieDto>> findByCriteria(@RequestBody CategorieCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categories by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categories by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategorieCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categorie data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategorieRestAdmin (CategorieAdminService service, CategorieConverter converter) {
        super(service, converter);
    }




}
