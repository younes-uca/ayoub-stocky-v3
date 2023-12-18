import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteCriteria} from 'src/app/controller/criteria/commun/EntrepriseSocieteCriteria.model';
@Component({
  selector: 'app-entreprise-societe-create-admin',
  templateUrl: './entreprise-societe-create-admin.component.html'
})
export class EntrepriseSocieteCreateAdminComponent extends AbstractCreateController<EntrepriseSocieteDto, EntrepriseSocieteCriteria, EntrepriseSocieteAdminService>  implements OnInit {



   private _validEntrepriseSocieteNom = true;

    constructor( private entrepriseSocieteService: EntrepriseSocieteAdminService ) {
        super(entrepriseSocieteService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validEntrepriseSocieteNom = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEntrepriseSocieteNom();
    }

    public validateEntrepriseSocieteNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
        this.errorMessages.push('Nom non valide');
        this.validEntrepriseSocieteNom = false;
        } else {
            this.validEntrepriseSocieteNom = true;
        }
    }






    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }

    set validEntrepriseSocieteNom(value: boolean) {
         this._validEntrepriseSocieteNom = value;
    }



}
