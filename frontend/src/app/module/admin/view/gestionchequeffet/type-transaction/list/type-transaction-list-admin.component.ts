import {Component, OnInit} from '@angular/core';
import {TypeTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeTransactionAdmin.service';
import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/TypeTransactionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-type-transaction-list-admin',
  templateUrl: './type-transaction-list-admin.component.html'
})
export class TypeTransactionListAdminComponent extends AbstractListController<TypeTransactionDto, TypeTransactionCriteria, TypeTransactionAdminService>  implements OnInit {

    fileName = 'TypeTransaction';



    constructor( private typeTransactionService: TypeTransactionAdminService  ) {
        super(typeTransactionService);
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
