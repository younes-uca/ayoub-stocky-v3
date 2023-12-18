import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeCriteria} from 'src/app/controller/criteria/stock/TaxeCriteria.model';



@Component({
  selector: 'app-taxe-edit-admin',
  templateUrl: './taxe-edit-admin.component.html'
})
export class TaxeEditAdminComponent extends AbstractEditController<TaxeDto, TaxeCriteria, TaxeAdminService>   implements OnInit {


    private _validTaxeLibelle = true;




    constructor( private taxeService: TaxeAdminService ) {
        super(taxeService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validTaxeLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTaxeLibelle();
    }
    public validateTaxeLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validTaxeLibelle = false;
        } else {
            this.validTaxeLibelle = true;
        }
    }






    get validTaxeLibelle(): boolean {
        return this._validTaxeLibelle;
    }
    set validTaxeLibelle(value: boolean) {
        this._validTaxeLibelle = value;
    }

}
