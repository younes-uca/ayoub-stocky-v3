import {Component, OnInit} from '@angular/core';
import {EntreeProduitAdminService} from 'src/app/controller/service/admin/entree/EntreeProduitAdmin.service';
import {EntreeProduitDto} from 'src/app/controller/model/entree/EntreeProduit.model';
import {EntreeProduitCriteria} from 'src/app/controller/criteria/entree/EntreeProduitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {EntreeProduitItemDto} from 'src/app/controller/model/stock/EntreeProduitItem.model';
import {EntreeProduitItemAdminService} from 'src/app/controller/service/admin/stock/EntreeProduitItemAdmin.service';


@Component({
  selector: 'app-entree-produit-list-admin',
  templateUrl: './entree-produit-list-admin.component.html'
})
export class EntreeProduitListAdminComponent extends AbstractListController<EntreeProduitDto, EntreeProduitCriteria, EntreeProduitAdminService>  implements OnInit {

    fileName = 'EntreeProduit';

    fournisseurs: Array<FournisseurDto>;
    depots: Array<DepotDto>;


    constructor( private entreeProduitService: EntreeProduitAdminService  , private depotService: DepotAdminService, private produitService: ProduitAdminService, private fournisseurService: FournisseurAdminService, private entreeProduitItemService: EntreeProduitItemAdminService) {
        super(entreeProduitService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadFournisseur();
        this.loadDepot();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateEntreeProduit', header: 'Date entree produit'},
            {field: 'fournisseur?.telephone', header: 'Fournisseur'},
            {field: 'depot?.libelle', header: 'Depot'},
        ];
    }


    public async loadFournisseur(){
       this.fournisseurService.findAllOptimized().subscribe(fournisseurs => this.fournisseurs = fournisseurs, error => console.log(error))
    }
    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }

	public initDuplicate(res: EntreeProduitDto) {
        if (res.entreeProduitItems != null) {
             res.entreeProduitItems.forEach(d => { d.entreeProduit = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date entree produit': this.datePipe.transform(e.dateEntreeProduit , 'dd/MM/yyyy hh:mm'),
                'Fournisseur': e.fournisseur?.telephone ,
                'Depot': e.depot?.libelle ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date entree produit Min': this.criteria.dateEntreeProduitFrom ? this.datePipe.transform(this.criteria.dateEntreeProduitFrom , this.dateFormat) : environment.emptyForExport ,
            'Date entree produit Max': this.criteria.dateEntreeProduitTo ? this.datePipe.transform(this.criteria.dateEntreeProduitTo , this.dateFormat) : environment.emptyForExport ,
        //'Fournisseur': this.criteria.fournisseur?.telephone ? this.criteria.fournisseur?.telephone : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
