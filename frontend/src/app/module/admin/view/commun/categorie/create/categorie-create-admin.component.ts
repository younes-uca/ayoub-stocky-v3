import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CategorieAdminService} from 'src/app/controller/service/admin/commun/CategorieAdmin.service';
import {CategorieDto} from 'src/app/controller/model/commun/Categorie.model';
import {CategorieCriteria} from 'src/app/controller/criteria/commun/CategorieCriteria.model';
@Component({
  selector: 'app-categorie-create-admin',
  templateUrl: './categorie-create-admin.component.html'
})
export class CategorieCreateAdminComponent extends AbstractCreateController<CategorieDto, CategorieCriteria, CategorieAdminService>  implements OnInit {



   private _validCategorieLibelle = true;

    constructor( private categorieService: CategorieAdminService ) {
        super(categorieService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validCategorieLibelle = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategorieLibelle();
    }

    public validateCategorieLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validCategorieLibelle = false;
        } else {
            this.validCategorieLibelle = true;
        }
    }






    get validCategorieLibelle(): boolean {
        return this._validCategorieLibelle;
    }

    set validCategorieLibelle(value: boolean) {
         this._validCategorieLibelle = value;
    }



}
