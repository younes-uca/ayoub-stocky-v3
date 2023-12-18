import {Component, OnInit} from '@angular/core';
import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentCriteria} from 'src/app/controller/criteria/gestionchequeffet/TypeInstrumentCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-type-instrument-list-admin',
  templateUrl: './type-instrument-list-admin.component.html'
})
export class TypeInstrumentListAdminComponent extends AbstractListController<TypeInstrumentDto, TypeInstrumentCriteria, TypeInstrumentAdminService>  implements OnInit {

    fileName = 'TypeInstrument';



    constructor( private typeInstrumentService: TypeInstrumentAdminService  ) {
        super(typeInstrumentService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
