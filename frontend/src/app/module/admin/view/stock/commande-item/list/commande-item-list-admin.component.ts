import {Component, OnInit} from '@angular/core';
import {CommandeItemAdminService} from 'src/app/controller/service/admin/stock/CommandeItemAdmin.service';
import {CommandeItemDto} from 'src/app/controller/model/stock/CommandeItem.model';
import {CommandeItemCriteria} from 'src/app/controller/criteria/stock/CommandeItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {CommandeDto} from 'src/app/controller/model/stock/Commande.model';
import {CommandeAdminService} from 'src/app/controller/service/admin/stock/CommandeAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';


@Component({
  selector: 'app-commande-item-list-admin',
  templateUrl: './commande-item-list-admin.component.html'
})
export class CommandeItemListAdminComponent extends AbstractListController<CommandeItemDto, CommandeItemCriteria, CommandeItemAdminService>  implements OnInit {

    fileName = 'CommandeItem';

    produits: Array<ProduitDto>;
    taxes: Array<TaxeDto>;
    commandes: Array<CommandeDto>;


    constructor( private commandeItemService: CommandeItemAdminService  , private produitService: ProduitAdminService, private commandeService: CommandeAdminService, private taxeService: TaxeAdminService) {
        super(commandeItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadTaxe();
        this.loadCommande();
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.designation', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'prixUnitaireHt', header: 'Prix unitaire ht'},
            {field: 'taxe?.libelle', header: 'Taxe'},
            {field: 'prixUnitaireTtc', header: 'Prix unitaire ttc'},
            {field: 'remise', header: 'Remise'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTtc', header: 'Montant ttc'},
            {field: 'commande?.numeroCommande', header: 'Commande'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadTaxe(){
       this.taxeService.findAllOptimized().subscribe(taxes => this.taxes = taxes, error => console.log(error))
    }
    public async loadCommande(){
       this.commandeService.findAllOptimized().subscribe(commandes => this.commandes = commandes, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.designation ,
                 'Quantite': e.quantite ,
                 'Prix unitaire ht': e.prixUnitaireHt ,
                'Taxe': e.taxe?.libelle ,
                 'Prix unitaire ttc': e.prixUnitaireTtc ,
                 'Remise': e.remise ,
                 'Montant ht': e.montantHt ,
                 'Montant ttc': e.montantTtc ,
                'Commande': e.commande?.numeroCommande ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.designation ? this.criteria.produit?.designation : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
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
        //'Commande': this.criteria.commande?.numeroCommande ? this.criteria.commande?.numeroCommande : environment.emptyForExport ,
        }];
      }
}
