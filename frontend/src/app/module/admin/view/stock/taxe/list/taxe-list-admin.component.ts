import {Component, OnInit} from '@angular/core';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeCriteria} from 'src/app/controller/criteria/stock/TaxeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-taxe-list-admin',
  templateUrl: './taxe-list-admin.component.html'
})
export class TaxeListAdminComponent extends AbstractListController<TaxeDto, TaxeCriteria, TaxeAdminService>  implements OnInit {

    fileName = 'Taxe';



    constructor( private taxeService: TaxeAdminService  ) {
        super(taxeService);
        this.pdfName = 'Taxe.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'montant', header: 'Montant'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Montant': e.montant ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        }];
      }
}
