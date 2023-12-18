import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotCriteria} from 'src/app/controller/criteria/commun/DepotCriteria.model';
@Component({
  selector: 'app-depot-create-admin',
  templateUrl: './depot-create-admin.component.html'
})
export class DepotCreateAdminComponent extends AbstractCreateController<DepotDto, DepotCriteria, DepotAdminService>  implements OnInit {



   private _validDepotLibelle = true;

    constructor( private depotService: DepotAdminService ) {
        super(depotService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validDepotLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateDepotLibelle();
    }

    public validateDepotLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validDepotLibelle = false;
        } else {
            this.validDepotLibelle = true;
        }
    }






    get validDepotLibelle(): boolean {
        return this._validDepotLibelle;
    }

    set validDepotLibelle(value: boolean) {
         this._validDepotLibelle = value;
    }



}
