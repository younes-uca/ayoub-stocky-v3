import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TypeTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeTransactionAdmin.service';
import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/TypeTransactionCriteria.model';

@Component({
  selector: 'app-type-transaction-view-admin',
  templateUrl: './type-transaction-view-admin.component.html'
})
export class TypeTransactionViewAdminComponent extends AbstractViewController<TypeTransactionDto, TypeTransactionCriteria, TypeTransactionAdminService> implements OnInit {


    constructor(private typeTransactionService: TypeTransactionAdminService){
        super(typeTransactionService);
    }

    ngOnInit(): void {
    }




}
