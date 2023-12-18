import {Component, OnInit} from '@angular/core';
import {TransfertItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertItemAdmin.service';
import {TransfertItemDto} from 'src/app/controller/model/gestionchequeffet/TransfertItem.model';
import {TransfertItemCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransfertItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {TransfertDto} from 'src/app/controller/model/gestionchequeffet/Transfert.model';
import {TransfertAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertAdmin.service';


@Component({
  selector: 'app-transfert-item-list-admin',
  templateUrl: './transfert-item-list-admin.component.html'
})
export class TransfertItemListAdminComponent extends AbstractListController<TransfertItemDto, TransfertItemCriteria, TransfertItemAdminService>  implements OnInit {

    fileName = 'TransfertItem';

    depots: Array<DepotDto>;
    produits: Array<ProduitDto>;
    transferts: Array<TransfertDto>;


    constructor( private transfertItemService: TransfertItemAdminService  , private depotService: DepotAdminService, private produitService: ProduitAdminService, private transfertService: TransfertAdminService) {
        super(transfertItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadDepot();
        this.loadProduit();
        this.loadTransfert();
    }


    public initCol() {
        this.cols = [
            {field: 'depot?.libelle', header: 'Depot'},
            {field: 'produit?.designation', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'transfert?.id', header: 'Transfert'},
        ];
    }


    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }
    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadTransfert(){
       this.transfertService.findAll().subscribe(transferts => this.transferts = transferts, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Depot': e.depot?.libelle ,
                'Produit': e.produit?.designation ,
                 'Quantite': e.quantite ,
                'Transfert': e.transfert?.id ,
            }
        });

        this.criteriaData = [{
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.designation ? this.criteria.produit?.designation : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
        //'Transfert': this.criteria.transfert?.id ? this.criteria.transfert?.id : environment.emptyForExport ,
        }];
      }
}
