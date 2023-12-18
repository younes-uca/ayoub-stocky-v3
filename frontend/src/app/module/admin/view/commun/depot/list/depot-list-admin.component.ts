import {Component, OnInit} from '@angular/core';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotCriteria} from 'src/app/controller/criteria/commun/DepotCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-depot-list-admin',
  templateUrl: './depot-list-admin.component.html'
})
export class DepotListAdminComponent extends AbstractListController<DepotDto, DepotCriteria, DepotAdminService>  implements OnInit {

    fileName = 'Depot';



    constructor( private depotService: DepotAdminService  ) {
        super(depotService);
        this.pdfName = 'Depot.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'adresse', header: 'Adresse'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Adresse': e.adresse ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Adresse': this.criteria.adresse ? this.criteria.adresse : environment.emptyForExport ,
        }];
      }
}
