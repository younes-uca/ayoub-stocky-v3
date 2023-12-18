import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/EtatTransactionAdmin.service';
import {EtatTransactionDto} from 'src/app/controller/model/gestionchequeffet/EtatTransaction.model';
import {EtatTransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/EtatTransactionCriteria.model';

@Component({
  selector: 'app-etat-transaction-view-admin',
  templateUrl: './etat-transaction-view-admin.component.html'
})
export class EtatTransactionViewAdminComponent extends AbstractViewController<EtatTransactionDto, EtatTransactionCriteria, EtatTransactionAdminService> implements OnInit {


    constructor(private etatTransactionService: EtatTransactionAdminService){
        super(etatTransactionService);
    }

    ngOnInit(): void {
    }




}
