import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {RaisonAdminService} from 'src/app/controller/service/admin/Transfert/RaisonAdmin.service';
import {RaisonDto} from 'src/app/controller/model/Transfert/Raison.model';
import {RaisonCriteria} from 'src/app/controller/criteria/Transfert/RaisonCriteria.model';
@Component({
  selector: 'app-raison-create-admin',
  templateUrl: './raison-create-admin.component.html'
})
export class RaisonCreateAdminComponent extends AbstractCreateController<RaisonDto, RaisonCriteria, RaisonAdminService>  implements OnInit {



   private _validRaisonLibelle = true;

    constructor( private raisonService: RaisonAdminService ) {
        super(raisonService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validRaisonLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateRaisonLibelle();
    }

    public validateRaisonLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validRaisonLibelle = false;
        } else {
            this.validRaisonLibelle = true;
        }
    }






    get validRaisonLibelle(): boolean {
        return this._validRaisonLibelle;
    }

    set validRaisonLibelle(value: boolean) {
         this._validRaisonLibelle = value;
    }



}
