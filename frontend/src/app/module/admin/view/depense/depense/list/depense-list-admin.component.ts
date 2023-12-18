import {Component, OnInit} from '@angular/core';
import {DepenseAdminService} from 'src/app/controller/service/admin/depense/DepenseAdmin.service';
import {DepenseDto} from 'src/app/controller/model/depense/Depense.model';
import {DepenseCriteria} from 'src/app/controller/criteria/depense/DepenseCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-depense-list-admin',
  templateUrl: './depense-list-admin.component.html'
})
export class DepenseListAdminComponent extends AbstractListController<DepenseDto, DepenseCriteria, DepenseAdminService>  implements OnInit {

    fileName = 'Depense';



    constructor( private depenseService: DepenseAdminService  ) {
        super(depenseService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'dateDepense', header: 'Date depense'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'montant', header: 'Montant'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Date depense': this.datePipe.transform(e.dateDepense , 'dd/MM/yyyy hh:mm'),
                 'Libelle': e.libelle ,
                 'Montant': e.montant ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Date depense Min': this.criteria.dateDepenseFrom ? this.datePipe.transform(this.criteria.dateDepenseFrom , this.dateFormat) : environment.emptyForExport ,
            'Date depense Max': this.criteria.dateDepenseTo ? this.datePipe.transform(this.criteria.dateDepenseTo , this.dateFormat) : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
