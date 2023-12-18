import {Component, OnInit} from '@angular/core';
import {SortieProduitItemAdminService} from 'src/app/controller/service/admin/stock/SortieProduitItemAdmin.service';
import {SortieProduitItemDto} from 'src/app/controller/model/stock/SortieProduitItem.model';
import {SortieProduitItemCriteria} from 'src/app/controller/criteria/stock/SortieProduitItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {SortieProduitDto} from 'src/app/controller/model/entree/SortieProduit.model';
import {SortieProduitAdminService} from 'src/app/controller/service/admin/entree/SortieProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';


@Component({
  selector: 'app-sortie-produit-item-list-admin',
  templateUrl: './sortie-produit-item-list-admin.component.html'
})
export class SortieProduitItemListAdminComponent extends AbstractListController<SortieProduitItemDto, SortieProduitItemCriteria, SortieProduitItemAdminService>  implements OnInit {

    fileName = 'SortieProduitItem';

    produits: Array<ProduitDto>;
    sortieProduits: Array<SortieProduitDto>;


    constructor( private sortieProduitItemService: SortieProduitItemAdminService  , private sortieProduitService: SortieProduitAdminService, private produitService: ProduitAdminService) {
        super(sortieProduitItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadSortieProduit();
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.designation', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'sortieProduit?.reference', header: 'Sortie produit'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadSortieProduit(){
       this.sortieProduitService.findAllOptimized().subscribe(sortieProduits => this.sortieProduits = sortieProduits, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.designation ,
                 'Quantite': e.quantite ,
                 'Description': e.description ,
                'Sortie produit': e.sortieProduit?.reference ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.designation ? this.criteria.produit?.designation : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Sortie produit': this.criteria.sortieProduit?.reference ? this.criteria.sortieProduit?.reference : environment.emptyForExport ,
        }];
      }
}
