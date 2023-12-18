import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {MarqueAdminService} from 'src/app/controller/service/admin/commun/MarqueAdmin.service';
import {MarqueDto} from 'src/app/controller/model/commun/Marque.model';
import {MarqueCriteria} from 'src/app/controller/criteria/commun/MarqueCriteria.model';



@Component({
  selector: 'app-marque-edit-admin',
  templateUrl: './marque-edit-admin.component.html'
})
export class MarqueEditAdminComponent extends AbstractEditController<MarqueDto, MarqueCriteria, MarqueAdminService>   implements OnInit {


    private _validMarqueLibelle = true;




    constructor( private marqueService: MarqueAdminService ) {
        super(marqueService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validMarqueLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateMarqueLibelle();
    }
    public validateMarqueLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validMarqueLibelle = false;
        } else {
            this.validMarqueLibelle = true;
        }
    }






    get validMarqueLibelle(): boolean {
        return this._validMarqueLibelle;
    }
    set validMarqueLibelle(value: boolean) {
        this._validMarqueLibelle = value;
    }

}
