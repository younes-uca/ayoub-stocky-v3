import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EtatVenteAdminService} from 'src/app/controller/service/admin/commun/EtatVenteAdmin.service';
import {EtatVenteDto} from 'src/app/controller/model/commun/EtatVente.model';
import {EtatVenteCriteria} from 'src/app/controller/criteria/commun/EtatVenteCriteria.model';



@Component({
  selector: 'app-etat-vente-edit-admin',
  templateUrl: './etat-vente-edit-admin.component.html'
})
export class EtatVenteEditAdminComponent extends AbstractEditController<EtatVenteDto, EtatVenteCriteria, EtatVenteAdminService>   implements OnInit {


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
