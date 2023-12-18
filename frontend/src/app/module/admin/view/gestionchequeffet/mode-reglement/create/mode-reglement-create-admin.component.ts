import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementCriteria} from 'src/app/controller/criteria/gestionchequeffet/ModeReglementCriteria.model';
@Component({
  selector: 'app-mode-reglement-create-admin',
  templateUrl: './mode-reglement-create-admin.component.html'
})
export class ModeReglementCreateAdminComponent extends AbstractCreateController<ModeReglementDto, ModeReglementCriteria, ModeReglementAdminService>  implements OnInit {



   private _validModeReglementLibelle = true;

    constructor( private modeReglementService: ModeReglementAdminService ) {
        super(modeReglementService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validModeReglementLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateModeReglementLibelle();
    }

    public validateModeReglementLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validModeReglementLibelle = false;
        } else {
            this.validModeReglementLibelle = true;
        }
    }






    get validModeReglementLibelle(): boolean {
        return this._validModeReglementLibelle;
    }

    set validModeReglementLibelle(value: boolean) {
         this._validModeReglementLibelle = value;
    }



}
