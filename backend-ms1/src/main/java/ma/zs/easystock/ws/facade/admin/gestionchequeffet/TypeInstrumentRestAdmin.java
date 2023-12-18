package  ma.zs.easystock.ws.facade.admin.gestionchequeffet;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.easystock.bean.core.gestionchequeffet.TypeInstrument;
import ma.zs.easystock.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;
import ma.zs.easystock.service.facade.admin.gestionchequeffet.TypeInstrumentAdminService;
import ma.zs.easystock.ws.converter.gestionchequeffet.TypeInstrumentConverter;
import ma.zs.easystock.ws.dto.gestionchequeffet.TypeInstrumentDto;
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
@RequestMapping("/api/admin/typeInstrument/")
public class TypeInstrumentRestAdmin  extends AbstractController<TypeInstrument, TypeInstrumentDto, TypeInstrumentCriteria, TypeInstrumentAdminService, TypeInstrumentConverter> {



    @Operation(summary = "upload one typeInstrument")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeInstruments")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeInstruments")
    @GetMapping("")
    public ResponseEntity<List<TypeInstrumentDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeInstruments")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeInstrumentDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeInstrument by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeInstrumentDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a typeInstrument by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypeInstrumentDto> findByLibelle(@PathVariable String libelle, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new TypeInstrument(libelle), includes, excludes);
    }

    @Operation(summary = "Saves the specified  typeInstrument")
    @PostMapping("")
    public ResponseEntity<TypeInstrumentDto> save(@RequestBody TypeInstrumentDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeInstrument")
    @PutMapping("")
    public ResponseEntity<TypeInstrumentDto> update(@RequestBody TypeInstrumentDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeInstrument")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeInstrumentDto>> delete(@RequestBody List<TypeInstrumentDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeInstrument")
    @DeleteMapping("")
    public ResponseEntity<TypeInstrumentDto> delete(@RequestBody TypeInstrumentDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeInstrument")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeInstruments by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds typeInstruments by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeInstrumentDto>> findByCriteria(@RequestBody TypeInstrumentCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeInstruments by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeInstrumentCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeInstruments by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeInstrumentCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeInstrument data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeInstrumentCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeInstrumentRestAdmin (TypeInstrumentAdminService service, TypeInstrumentConverter converter) {
        super(service, converter);
    }




}
