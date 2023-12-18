import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategorieAdminService} from 'src/app/controller/service/admin/commun/CategorieAdmin.service';
import {CategorieDto} from 'src/app/controller/model/commun/Categorie.model';
import {CategorieCriteria} from 'src/app/controller/criteria/commun/CategorieCriteria.model';

@Component({
  selector: 'app-categorie-view-admin',
  templateUrl: './categorie-view-admin.component.html'
})
export class CategorieViewAdminComponent extends AbstractViewController<CategorieDto, CategorieCriteria, CategorieAdminService> implements OnInit {


    constructor(private categorieService: CategorieAdminService){
        super(categorieService);
    }

    ngOnInit(): void {
    }




}
