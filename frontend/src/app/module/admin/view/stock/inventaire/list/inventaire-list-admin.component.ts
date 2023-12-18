import {Component, OnInit} from '@angular/core';
import {InventaireAdminService} from 'src/app/controller/service/admin/stock/InventaireAdmin.service';
import {InventaireDto} from 'src/app/controller/model/stock/Inventaire.model';
import {InventaireCriteria} from 'src/app/controller/criteria/stock/InventaireCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {InventaireItemDto} from 'src/app/controller/model/stock/InventaireItem.model';
import {InventaireItemAdminService} from 'src/app/controller/service/admin/stock/InventaireItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';


@Component({
  selector: 'app-inventaire-list-admin',
  templateUrl: './inventaire-list-admin.component.html'
})
export class InventaireListAdminComponent extends AbstractListController<InventaireDto, InventaireCriteria, InventaireAdminService>  implements OnInit {

    fileName = 'Inventaire';

    entrepriseSocietes: Array<EntrepriseSocieteDto>;
    depots: Array<DepotDto>;


    constructor( private inventaireService: InventaireAdminService  , private depotService: DepotAdminService, private inventaireItemService: InventaireItemAdminService, private produitService: ProduitAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService) {
        super(inventaireService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadEntrepriseSociete();
        this.loadDepot();
    }


    public initCol() {
        this.cols = [
            {field: 'entrepriseSociete?.nom', header: 'Entreprise societe'},
            {field: 'depot?.libelle', header: 'Depot'},
            {field: 'reference', header: 'Reference'},
            {field: 'dateInventaire', header: 'Date inventaire'},
        ];
    }


    public async loadEntrepriseSociete(){
       this.entrepriseSocieteService.findAllOptimized().subscribe(entrepriseSocietes => this.entrepriseSocietes = entrepriseSocietes, error => console.log(error))
    }
    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }

	public initDuplicate(res: InventaireDto) {
        if (res.inventaireItems != null) {
             res.inventaireItems.forEach(d => { d.inventaire = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Entreprise societe': e.entrepriseSociete?.nom ,
                'Depot': e.depot?.libelle ,
                 'Reference': e.reference ,
                'Date inventaire': this.datePipe.transform(e.dateInventaire , 'dd/MM/yyyy hh:mm'),
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
        //'Entreprise societe': this.criteria.entrepriseSociete?.nom ? this.criteria.entrepriseSociete?.nom : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date inventaire Min': this.criteria.dateInventaireFrom ? this.datePipe.transform(this.criteria.dateInventaireFrom , this.dateFormat) : environment.emptyForExport ,
            'Date inventaire Max': this.criteria.dateInventaireTo ? this.datePipe.transform(this.criteria.dateInventaireTo , this.dateFormat) : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
