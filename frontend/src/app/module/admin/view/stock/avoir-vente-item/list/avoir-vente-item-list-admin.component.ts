import {Component, OnInit} from '@angular/core';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemCriteria} from 'src/app/controller/criteria/stock/AvoirVenteItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';


@Component({
  selector: 'app-avoir-vente-item-list-admin',
  templateUrl: './avoir-vente-item-list-admin.component.html'
})
export class AvoirVenteItemListAdminComponent extends AbstractListController<AvoirVenteItemDto, AvoirVenteItemCriteria, AvoirVenteItemAdminService>  implements OnInit {

    fileName = 'AvoirVenteItem';

    depots: Array<DepotDto>;
    produits: Array<ProduitDto>;
    taxes: Array<TaxeDto>;
    avoirVentes: Array<AvoirVenteDto>;


    constructor( private avoirVenteItemService: AvoirVenteItemAdminService  , private depotService: DepotAdminService, private avoirVenteService: AvoirVenteAdminService, private produitService: ProduitAdminService, private taxeService: TaxeAdminService) {
        super(avoirVenteItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadDepot();
        this.loadProduit();
        this.loadTaxe();
        this.loadAvoirVente();
    }


    public initCol() {
        this.cols = [
            {field: 'barCode', header: 'Bar code'},
            {field: 'depot?.libelle', header: 'Depot'},
            {field: 'produit?.designation', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'quantiteAvoir', header: 'Quantite avoir'},
            {field: 'quantiteVendue', header: 'Quantite vendue'},
            {field: 'prixUnitaireHt', header: 'Prix unitaire ht'},
            {field: 'taxe?.libelle', header: 'Taxe'},
            {field: 'prixUnitaireTtc', header: 'Prix unitaire ttc'},
            {field: 'remise', header: 'Remise'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTtc', header: 'Montant ttc'},
            {field: 'avoirVente?.numeroFactureAvoirVente', header: 'Avoir vente'},
        ];
    }


    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }
    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadTaxe(){
       this.taxeService.findAllOptimized().subscribe(taxes => this.taxes = taxes, error => console.log(error))
    }
    public async loadAvoirVente(){
       this.avoirVenteService.findAllOptimized().subscribe(avoirVentes => this.avoirVentes = avoirVentes, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Bar code': e.barCode ,
                'Depot': e.depot?.libelle ,
                'Produit': e.produit?.designation ,
                 'Quantite': e.quantite ,
                 'Quantite avoir': e.quantiteAvoir ,
                 'Quantite vendue': e.quantiteVendue ,
                 'Prix unitaire ht': e.prixUnitaireHt ,
                'Taxe': e.taxe?.libelle ,
                 'Prix unitaire ttc': e.prixUnitaireTtc ,
                 'Remise': e.remise ,
                 'Montant ht': e.montantHt ,
                 'Montant ttc': e.montantTtc ,
                'Avoir vente': e.avoirVente?.numeroFactureAvoirVente ,
            }
        });

        this.criteriaData = [{
            'Bar code': this.criteria.barCode ? this.criteria.barCode : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.designation ? this.criteria.produit?.designation : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
            'Quantite avoir Min': this.criteria.quantiteAvoirMin ? this.criteria.quantiteAvoirMin : environment.emptyForExport ,
            'Quantite avoir Max': this.criteria.quantiteAvoirMax ? this.criteria.quantiteAvoirMax : environment.emptyForExport ,
            'Quantite vendue Min': this.criteria.quantiteVendueMin ? this.criteria.quantiteVendueMin : environment.emptyForExport ,
            'Quantite vendue Max': this.criteria.quantiteVendueMax ? this.criteria.quantiteVendueMax : environment.emptyForExport ,
            'Prix unitaire ht Min': this.criteria.prixUnitaireHtMin ? this.criteria.prixUnitaireHtMin : environment.emptyForExport ,
            'Prix unitaire ht Max': this.criteria.prixUnitaireHtMax ? this.criteria.prixUnitaireHtMax : environment.emptyForExport ,
        //'Taxe': this.criteria.taxe?.libelle ? this.criteria.taxe?.libelle : environment.emptyForExport ,
            'Prix unitaire ttc Min': this.criteria.prixUnitaireTtcMin ? this.criteria.prixUnitaireTtcMin : environment.emptyForExport ,
            'Prix unitaire ttc Max': this.criteria.prixUnitaireTtcMax ? this.criteria.prixUnitaireTtcMax : environment.emptyForExport ,
            'Remise Min': this.criteria.remiseMin ? this.criteria.remiseMin : environment.emptyForExport ,
            'Remise Max': this.criteria.remiseMax ? this.criteria.remiseMax : environment.emptyForExport ,
            'Montant ht Min': this.criteria.montantHtMin ? this.criteria.montantHtMin : environment.emptyForExport ,
            'Montant ht Max': this.criteria.montantHtMax ? this.criteria.montantHtMax : environment.emptyForExport ,
            'Montant ttc Min': this.criteria.montantTtcMin ? this.criteria.montantTtcMin : environment.emptyForExport ,
            'Montant ttc Max': this.criteria.montantTtcMax ? this.criteria.montantTtcMax : environment.emptyForExport ,
        //'Avoir vente': this.criteria.avoirVente?.numeroFactureAvoirVente ? this.criteria.avoirVente?.numeroFactureAvoirVente : environment.emptyForExport ,
        }];
      }
}
