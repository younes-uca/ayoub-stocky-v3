import {Component, OnInit} from '@angular/core';
import {CategorieAdminService} from 'src/app/controller/service/admin/commun/CategorieAdmin.service';
import {CategorieDto} from 'src/app/controller/model/commun/Categorie.model';
import {CategorieCriteria} from 'src/app/controller/criteria/commun/CategorieCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-categorie-list-admin',
  templateUrl: './categorie-list-admin.component.html'
})
export class CategorieListAdminComponent extends AbstractListController<CategorieDto, CategorieCriteria, CategorieAdminService>  implements OnInit {

    fileName = 'Categorie';



    constructor( private categorieService: CategorieAdminService  ) {
        super(categorieService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
