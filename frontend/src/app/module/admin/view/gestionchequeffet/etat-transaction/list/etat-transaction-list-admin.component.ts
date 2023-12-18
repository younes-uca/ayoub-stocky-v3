import {Component, OnInit} from '@angular/core';
import {EtatTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/EtatTransactionAdmin.service';
import {EtatTransactionDto} from 'src/app/controller/model/gestionchequeffet/EtatTransaction.model';
import {EtatTransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/EtatTransactionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-etat-transaction-list-admin',
  templateUrl: './etat-transaction-list-admin.component.html'
})
export class EtatTransactionListAdminComponent extends AbstractListController<EtatTransactionDto, EtatTransactionCriteria, EtatTransactionAdminService>  implements OnInit {

    fileName = 'EtatTransaction';



    constructor( private etatTransactionService: EtatTransactionAdminService  ) {
        super(etatTransactionService);
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
