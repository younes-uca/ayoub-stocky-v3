import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatAvoirAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirAchatAdmin.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/commun/EtatAvoirAchat.model';
import {EtatAvoirAchatCriteria} from 'src/app/controller/criteria/commun/EtatAvoirAchatCriteria.model';
@Component({
  selector: 'app-etat-avoir-achat-create-admin',
  templateUrl: './etat-avoir-achat-create-admin.component.html'
})
export class EtatAvoirAchatCreateAdminComponent extends AbstractCreateController<EtatAvoirAchatDto, EtatAvoirAchatCriteria, EtatAvoirAchatAdminService>  implements OnInit {



   private _validEtatAvoirAchatLibelle = true;

    constructor( private etatAvoirAchatService: EtatAvoirAchatAdminService ) {
        super(etatAvoirAchatService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validEtatAvoirAchatLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatAvoirAchatLibelle();
    }

    public validateEtatAvoirAchatLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatAvoirAchatLibelle = false;
        } else {
            this.validEtatAvoirAchatLibelle = true;
        }
    }






    get validEtatAvoirAchatLibelle(): boolean {
        return this._validEtatAvoirAchatLibelle;
    }

    set validEtatAvoirAchatLibelle(value: boolean) {
         this._validEtatAvoirAchatLibelle = value;
    }



}
