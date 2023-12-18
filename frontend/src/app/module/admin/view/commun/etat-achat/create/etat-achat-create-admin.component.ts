import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAchatAdmin.service';
import {EtatAchatDto} from 'src/app/controller/model/commun/EtatAchat.model';
import {EtatAchatCriteria} from 'src/app/controller/criteria/commun/EtatAchatCriteria.model';
@Component({
  selector: 'app-etat-achat-create-admin',
  templateUrl: './etat-achat-create-admin.component.html'
})
export class EtatAchatCreateAdminComponent extends AbstractCreateController<EtatAchatDto, EtatAchatCriteria, EtatAchatAdminService>  implements OnInit {



   private _validEtatAchatLibelle = true;

    constructor( private etatAchatService: EtatAchatAdminService ) {
        super(etatAchatService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validEtatAchatLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatAchatLibelle();
    }

    public validateEtatAchatLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatAchatLibelle = false;
        } else {
            this.validEtatAchatLibelle = true;
        }
    }






    get validEtatAchatLibelle(): boolean {
        return this._validEtatAchatLibelle;
    }

    set validEtatAchatLibelle(value: boolean) {
         this._validEtatAchatLibelle = value;
    }



}
