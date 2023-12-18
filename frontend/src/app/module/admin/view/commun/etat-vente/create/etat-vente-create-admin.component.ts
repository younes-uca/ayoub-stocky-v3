import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatVenteAdminService} from 'src/app/controller/service/admin/commun/EtatVenteAdmin.service';
import {EtatVenteDto} from 'src/app/controller/model/commun/EtatVente.model';
import {EtatVenteCriteria} from 'src/app/controller/criteria/commun/EtatVenteCriteria.model';
@Component({
  selector: 'app-etat-vente-create-admin',
  templateUrl: './etat-vente-create-admin.component.html'
})
export class EtatVenteCreateAdminComponent extends AbstractCreateController<EtatVenteDto, EtatVenteCriteria, EtatVenteAdminService>  implements OnInit {



   private _validEtatVenteLibelle = true;

    constructor( private etatVenteService: EtatVenteAdminService ) {
        super(etatVenteService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validEtatVenteLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatVenteLibelle();
    }

    public validateEtatVenteLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatVenteLibelle = false;
        } else {
            this.validEtatVenteLibelle = true;
        }
    }






    get validEtatVenteLibelle(): boolean {
        return this._validEtatVenteLibelle;
    }

    set validEtatVenteLibelle(value: boolean) {
         this._validEtatVenteLibelle = value;
    }



}
