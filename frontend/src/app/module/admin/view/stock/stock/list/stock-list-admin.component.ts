import {Component, OnInit} from '@angular/core';
import {StockAdminService} from 'src/app/controller/service/admin/stock/StockAdmin.service';
import {StockDto} from 'src/app/controller/model/stock/Stock.model';
import {StockCriteria} from 'src/app/controller/criteria/stock/StockCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';


@Component({
  selector: 'app-stock-list-admin',
  templateUrl: './stock-list-admin.component.html'
})
export class StockListAdminComponent extends AbstractListController<StockDto, StockCriteria, StockAdminService>  implements OnInit {

    fileName = 'Stock';

    produits: Array<ProduitDto>;
    depots: Array<DepotDto>;


    constructor( private stockService: StockAdminService  , private depotService: DepotAdminService, private produitService: ProduitAdminService) {
        super(stockService);
        this.pdfName = 'Stock.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadDepot();
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.designation', header: 'Produit'},
            {field: 'depot?.libelle', header: 'Depot'},
            {field: 'quantite', header: 'Quantite'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.designation ,
                'Depot': e.depot?.libelle ,
                 'Quantite': e.quantite ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.designation ? this.criteria.produit?.designation : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
        }];
      }
}
