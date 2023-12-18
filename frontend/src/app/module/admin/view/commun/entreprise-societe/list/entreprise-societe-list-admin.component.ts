import {Component, OnInit} from '@angular/core';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteCriteria} from 'src/app/controller/criteria/commun/EntrepriseSocieteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-entreprise-societe-list-admin',
  templateUrl: './entreprise-societe-list-admin.component.html'
})
export class EntrepriseSocieteListAdminComponent extends AbstractListController<EntrepriseSocieteDto, EntrepriseSocieteCriteria, EntrepriseSocieteAdminService>  implements OnInit {

    fileName = 'EntrepriseSociete';



    constructor( private entrepriseSocieteService: EntrepriseSocieteAdminService  ) {
        super(entrepriseSocieteService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'nom', header: 'Nom'},
            {field: 'ice', header: 'Ice'},
            {field: 'capital', header: 'Capital'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Nom': e.nom ,
                 'Ice': e.ice ,
                 'Capital': e.capital ,
            }
        });

        this.criteriaData = [{
            'Nom': this.criteria.nom ? this.criteria.nom : environment.emptyForExport ,
            'Ice': this.criteria.ice ? this.criteria.ice : environment.emptyForExport ,
            'Capital Min': this.criteria.capitalMin ? this.criteria.capitalMin : environment.emptyForExport ,
            'Capital Max': this.criteria.capitalMax ? this.criteria.capitalMax : environment.emptyForExport ,
        }];
      }
}
