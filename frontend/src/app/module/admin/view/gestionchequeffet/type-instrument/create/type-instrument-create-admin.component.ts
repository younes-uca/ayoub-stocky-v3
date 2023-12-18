import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentCriteria} from 'src/app/controller/criteria/gestionchequeffet/TypeInstrumentCriteria.model';
@Component({
  selector: 'app-type-instrument-create-admin',
  templateUrl: './type-instrument-create-admin.component.html'
})
export class TypeInstrumentCreateAdminComponent extends AbstractCreateController<TypeInstrumentDto, TypeInstrumentCriteria, TypeInstrumentAdminService>  implements OnInit {



   private _validTypeInstrumentLibelle = true;

    constructor( private typeInstrumentService: TypeInstrumentAdminService ) {
        super(typeInstrumentService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validTypeInstrumentLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypeInstrumentLibelle();
    }

    public validateTypeInstrumentLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validTypeInstrumentLibelle = false;
        } else {
            this.validTypeInstrumentLibelle = true;
        }
    }






    get validTypeInstrumentLibelle(): boolean {
        return this._validTypeInstrumentLibelle;
    }

    set validTypeInstrumentLibelle(value: boolean) {
         this._validTypeInstrumentLibelle = value;
    }



}
