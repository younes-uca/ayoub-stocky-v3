import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/commun/FournisseurCriteria.model';



@Component({
  selector: 'app-fournisseur-edit-admin',
  templateUrl: './fournisseur-edit-admin.component.html'
})
export class FournisseurEditAdminComponent extends AbstractEditController<FournisseurDto, FournisseurCriteria, FournisseurAdminService>   implements OnInit {


    private _validFournisseurIce = true;
    private _validFournisseurNom = true;
    private _validFournisseurTelephone = true;




    constructor( private fournisseurService: FournisseurAdminService ) {
        super(fournisseurService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validFournisseurIce = value;
        this.validFournisseurNom = value;
        this.validFournisseurTelephone = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateFournisseurIce();
        this.validateFournisseurNom();
        this.validateFournisseurTelephone();
    }
    public validateFournisseurIce(){
        if (this.stringUtilService.isEmpty(this.item.ice)) {
            this.errorMessages.push('Ice non valide');
            this.validFournisseurIce = false;
        } else {
            this.validFournisseurIce = true;
        }
    }
    public validateFournisseurNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
            this.errorMessages.push('Nom non valide');
            this.validFournisseurNom = false;
        } else {
            this.validFournisseurNom = true;
        }
    }
    public validateFournisseurTelephone(){
        if (this.stringUtilService.isEmpty(this.item.telephone)) {
            this.errorMessages.push('Telephone non valide');
            this.validFournisseurTelephone = false;
        } else {
            this.validFournisseurTelephone = true;
        }
    }






    get validFournisseurIce(): boolean {
        return this._validFournisseurIce;
    }
    set validFournisseurIce(value: boolean) {
        this._validFournisseurIce = value;
    }
    get validFournisseurNom(): boolean {
        return this._validFournisseurNom;
    }
    set validFournisseurNom(value: boolean) {
        this._validFournisseurNom = value;
    }
    get validFournisseurTelephone(): boolean {
        return this._validFournisseurTelephone;
    }
    set validFournisseurTelephone(value: boolean) {
        this._validFournisseurTelephone = value;
    }

}
