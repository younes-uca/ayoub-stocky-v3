import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {DepenseAdminService} from 'src/app/controller/service/admin/depense/DepenseAdmin.service';
import {DepenseDto} from 'src/app/controller/model/depense/Depense.model';
import {DepenseCriteria} from 'src/app/controller/criteria/depense/DepenseCriteria.model';



@Component({
  selector: 'app-depense-edit-admin',
  templateUrl: './depense-edit-admin.component.html'
})
export class DepenseEditAdminComponent extends AbstractEditController<DepenseDto, DepenseCriteria, DepenseAdminService>   implements OnInit {


    private _validDepenseDateDepense = true;
    private _validDepenseLibelle = true;
    private _validDepenseMontant = true;




    constructor( private depenseService: DepenseAdminService ) {
        super(depenseService);
    }

    ngOnInit(): void {
    }
    public prepareEdit() {
        this.item.dateDepense = this.depenseService.format(this.item.dateDepense);
    }



    public setValidation(value: boolean){
        this.validDepenseDateDepense = value;
        this.validDepenseLibelle = value;
        this.validDepenseMontant = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateDepenseDateDepense();
        this.validateDepenseLibelle();
        this.validateDepenseMontant();
    }
    public validateDepenseDateDepense(){
        if (this.stringUtilService.isEmpty(this.item.dateDepense)) {
            this.errorMessages.push('Date depense non valide');
            this.validDepenseDateDepense = false;
        } else {
            this.validDepenseDateDepense = true;
        }
    }
    public validateDepenseLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validDepenseLibelle = false;
        } else {
            this.validDepenseLibelle = true;
        }
    }
    public validateDepenseMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validDepenseMontant = false;
        } else {
            this.validDepenseMontant = true;
        }
    }






    get validDepenseDateDepense(): boolean {
        return this._validDepenseDateDepense;
    }
    set validDepenseDateDepense(value: boolean) {
        this._validDepenseDateDepense = value;
    }
    get validDepenseLibelle(): boolean {
        return this._validDepenseLibelle;
    }
    set validDepenseLibelle(value: boolean) {
        this._validDepenseLibelle = value;
    }
    get validDepenseMontant(): boolean {
        return this._validDepenseMontant;
    }
    set validDepenseMontant(value: boolean) {
        this._validDepenseMontant = value;
    }

}
