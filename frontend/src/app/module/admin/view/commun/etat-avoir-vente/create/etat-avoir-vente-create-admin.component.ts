import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatAvoirVenteAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirVenteAdmin.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteCriteria} from 'src/app/controller/criteria/commun/EtatAvoirVenteCriteria.model';
@Component({
  selector: 'app-etat-avoir-vente-create-admin',
  templateUrl: './etat-avoir-vente-create-admin.component.html'
})
export class EtatAvoirVenteCreateAdminComponent extends AbstractCreateController<EtatAvoirVenteDto, EtatAvoirVenteCriteria, EtatAvoirVenteAdminService>  implements OnInit {



   private _validEtatAvoirVenteLibelle = true;

    constructor( private etatAvoirVenteService: EtatAvoirVenteAdminService ) {
        super(etatAvoirVenteService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validEtatAvoirVenteLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatAvoirVenteLibelle();
    }

    public validateEtatAvoirVenteLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatAvoirVenteLibelle = false;
        } else {
            this.validEtatAvoirVenteLibelle = true;
        }
    }






    get validEtatAvoirVenteLibelle(): boolean {
        return this._validEtatAvoirVenteLibelle;
    }

    set validEtatAvoirVenteLibelle(value: boolean) {
         this._validEtatAvoirVenteLibelle = value;
    }



}
