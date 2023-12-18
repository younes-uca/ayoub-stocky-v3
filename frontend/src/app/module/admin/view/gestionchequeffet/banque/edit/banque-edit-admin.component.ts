import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {BanqueAdminService} from 'src/app/controller/service/admin/gestionchequeffet/BanqueAdmin.service';
import {BanqueDto} from 'src/app/controller/model/gestionchequeffet/Banque.model';
import {BanqueCriteria} from 'src/app/controller/criteria/gestionchequeffet/BanqueCriteria.model';



@Component({
  selector: 'app-banque-edit-admin',
  templateUrl: './banque-edit-admin.component.html'
})
export class BanqueEditAdminComponent extends AbstractEditController<BanqueDto, BanqueCriteria, BanqueAdminService>   implements OnInit {


    private _validBanqueLibelle = true;




    constructor( private banqueService: BanqueAdminService ) {
        super(banqueService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validBanqueLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateBanqueLibelle();
    }
    public validateBanqueLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validBanqueLibelle = false;
        } else {
            this.validBanqueLibelle = true;
        }
    }






    get validBanqueLibelle(): boolean {
        return this._validBanqueLibelle;
    }
    set validBanqueLibelle(value: boolean) {
        this._validBanqueLibelle = value;
    }

}
