import {Component, OnInit} from '@angular/core';
import {SortieProduitAdminService} from 'src/app/controller/service/admin/entree/SortieProduitAdmin.service';
import {SortieProduitDto} from 'src/app/controller/model/entree/SortieProduit.model';
import {SortieProduitCriteria} from 'src/app/controller/criteria/entree/SortieProduitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {SortieProduitItemDto} from 'src/app/controller/model/stock/SortieProduitItem.model';
import {SortieProduitItemAdminService} from 'src/app/controller/service/admin/stock/SortieProduitItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';


@Component({
  selector: 'app-sortie-produit-list-admin',
  templateUrl: './sortie-produit-list-admin.component.html'
})
export class SortieProduitListAdminComponent extends AbstractListController<SortieProduitDto, SortieProduitCriteria, SortieProduitAdminService>  implements OnInit {

    fileName = 'SortieProduit';

    depots: Array<DepotDto>;


    constructor( private sortieProduitService: SortieProduitAdminService  , private depotService: DepotAdminService, private sortieProduitItemService: SortieProduitItemAdminService, private produitService: ProduitAdminService) {
        super(sortieProduitService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadDepot();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateSortieProduit', header: 'Date sortie produit'},
            {field: 'depot?.libelle', header: 'Depot'},
        ];
    }


    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }

	public initDuplicate(res: SortieProduitDto) {
        if (res.sortieProduitItems != null) {
             res.sortieProduitItems.forEach(d => { d.sortieProduit = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date sortie produit': this.datePipe.transform(e.dateSortieProduit , 'dd/MM/yyyy hh:mm'),
                'Depot': e.depot?.libelle ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date sortie produit Min': this.criteria.dateSortieProduitFrom ? this.datePipe.transform(this.criteria.dateSortieProduitFrom , this.dateFormat) : environment.emptyForExport ,
            'Date sortie produit Max': this.criteria.dateSortieProduitTo ? this.datePipe.transform(this.criteria.dateSortieProduitTo , this.dateFormat) : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
