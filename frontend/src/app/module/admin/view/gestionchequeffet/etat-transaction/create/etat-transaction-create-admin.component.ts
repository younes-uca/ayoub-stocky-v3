import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/EtatTransactionAdmin.service';
import {EtatTransactionDto} from 'src/app/controller/model/gestionchequeffet/EtatTransaction.model';
import {EtatTransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/EtatTransactionCriteria.model';
@Component({
  selector: 'app-etat-transaction-create-admin',
  templateUrl: './etat-transaction-create-admin.component.html'
})
export class EtatTransactionCreateAdminComponent extends AbstractCreateController<EtatTransactionDto, EtatTransactionCriteria, EtatTransactionAdminService>  implements OnInit {



   private _validEtatTransactionLibelle = true;

    constructor( private etatTransactionService: EtatTransactionAdminService ) {
        super(etatTransactionService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validEtatTransactionLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatTransactionLibelle();
    }

    public validateEtatTransactionLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatTransactionLibelle = false;
        } else {
            this.validEtatTransactionLibelle = true;
        }
    }






    get validEtatTransactionLibelle(): boolean {
        return this._validEtatTransactionLibelle;
    }

    set validEtatTransactionLibelle(value: boolean) {
         this._validEtatTransactionLibelle = value;
    }



}
