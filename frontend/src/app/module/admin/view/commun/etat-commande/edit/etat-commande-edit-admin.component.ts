import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EtatCommandeAdminService} from 'src/app/controller/service/admin/commun/EtatCommandeAdmin.service';
import {EtatCommandeDto} from 'src/app/controller/model/commun/EtatCommande.model';
import {EtatCommandeCriteria} from 'src/app/controller/criteria/commun/EtatCommandeCriteria.model';



@Component({
  selector: 'app-etat-commande-edit-admin',
  templateUrl: './etat-commande-edit-admin.component.html'
})
export class EtatCommandeEditAdminComponent extends AbstractEditController<EtatCommandeDto, EtatCommandeCriteria, EtatCommandeAdminService>   implements OnInit {


    private _validEtatCommandeLibelle = true;




    constructor( private etatCommandeService: EtatCommandeAdminService ) {
        super(etatCommandeService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validEtatCommandeLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatCommandeLibelle();
    }
    public validateEtatCommandeLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validEtatCommandeLibelle = false;
        } else {
            this.validEtatCommandeLibelle = true;
        }
    }






    get validEtatCommandeLibelle(): boolean {
        return this._validEtatCommandeLibelle;
    }
    set validEtatCommandeLibelle(value: boolean) {
        this._validEtatCommandeLibelle = value;
    }

}
