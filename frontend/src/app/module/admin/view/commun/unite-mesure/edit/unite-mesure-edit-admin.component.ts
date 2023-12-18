import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {UniteMesureAdminService} from 'src/app/controller/service/admin/commun/UniteMesureAdmin.service';
import {UniteMesureDto} from 'src/app/controller/model/commun/UniteMesure.model';
import {UniteMesureCriteria} from 'src/app/controller/criteria/commun/UniteMesureCriteria.model';



@Component({
  selector: 'app-unite-mesure-edit-admin',
  templateUrl: './unite-mesure-edit-admin.component.html'
})
export class UniteMesureEditAdminComponent extends AbstractEditController<UniteMesureDto, UniteMesureCriteria, UniteMesureAdminService>   implements OnInit {


    private _validUniteMesureLibelle = true;




    constructor( private uniteMesureService: UniteMesureAdminService ) {
        super(uniteMesureService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validUniteMesureLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateUniteMesureLibelle();
    }
    public validateUniteMesureLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validUniteMesureLibelle = false;
        } else {
            this.validUniteMesureLibelle = true;
        }
    }






    get validUniteMesureLibelle(): boolean {
        return this._validUniteMesureLibelle;
    }
    set validUniteMesureLibelle(value: boolean) {
        this._validUniteMesureLibelle = value;
    }

}
