import {Component, OnInit} from '@angular/core';
import {UniteMesureAdminService} from 'src/app/controller/service/admin/commun/UniteMesureAdmin.service';
import {UniteMesureDto} from 'src/app/controller/model/commun/UniteMesure.model';
import {UniteMesureCriteria} from 'src/app/controller/criteria/commun/UniteMesureCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-unite-mesure-list-admin',
  templateUrl: './unite-mesure-list-admin.component.html'
})
export class UniteMesureListAdminComponent extends AbstractListController<UniteMesureDto, UniteMesureCriteria, UniteMesureAdminService>  implements OnInit {

    fileName = 'UniteMesure';



    constructor( private uniteMesureService: UniteMesureAdminService  ) {
        super(uniteMesureService);
        this.pdfName = 'UniteMesure.pdf';
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
