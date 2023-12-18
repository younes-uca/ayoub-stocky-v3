import {Component, OnInit} from '@angular/core';
import {CommandeAdminService} from 'src/app/controller/service/admin/stock/CommandeAdmin.service';
import {CommandeDto} from 'src/app/controller/model/stock/Commande.model';
import {CommandeCriteria} from 'src/app/controller/criteria/stock/CommandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {CommandeItemDto} from 'src/app/controller/model/stock/CommandeItem.model';
import {CommandeItemAdminService} from 'src/app/controller/service/admin/stock/CommandeItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EtatCommandeDto} from 'src/app/controller/model/commun/EtatCommande.model';
import {EtatCommandeAdminService} from 'src/app/controller/service/admin/commun/EtatCommandeAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';


@Component({
  selector: 'app-commande-list-admin',
  templateUrl: './commande-list-admin.component.html'
})
export class CommandeListAdminComponent extends AbstractListController<CommandeDto, CommandeCriteria, CommandeAdminService>  implements OnInit {

    fileName = 'Commande';

    clients: Array<ClientDto>;
    etatCommandes: Array<EtatCommandeDto>;


    constructor( private commandeService: CommandeAdminService  , private clientService: ClientAdminService, private commandeItemService: CommandeItemAdminService, private produitService: ProduitAdminService, private etatCommandeService: EtatCommandeAdminService, private taxeService: TaxeAdminService) {
        super(commandeService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadClient();
        this.loadEtatCommande();
    }


    public initCol() {
        this.cols = [
            {field: 'barCode', header: 'Bar code'},
            {field: 'numeroCommande', header: 'Numero commande'},
            {field: 'dateCommande', header: 'Date commande'},
            {field: 'client?.telephone', header: 'Client'},
            {field: 'etatCommande?.libelle', header: 'Etat commande'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTva', header: 'Montant tva'},
            {field: 'montantTtc', header: 'Montant ttc'},
        ];
    }


    public async loadClient(){
       this.clientService.findAllOptimized().subscribe(clients => this.clients = clients, error => console.log(error))
    }
    public async loadEtatCommande(){
       this.etatCommandeService.findAllOptimized().subscribe(etatCommandes => this.etatCommandes = etatCommandes, error => console.log(error))
    }

	public initDuplicate(res: CommandeDto) {
        if (res.commandeItems != null) {
             res.commandeItems.forEach(d => { d.commande = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Bar code': e.barCode ,
                 'Numero commande': e.numeroCommande ,
                'Date commande': this.datePipe.transform(e.dateCommande , 'dd/MM/yyyy hh:mm'),
                'Client': e.client?.telephone ,
                'Etat commande': e.etatCommande?.libelle ,
                 'Montant ht': e.montantHt ,
                 'Montant tva': e.montantTva ,
                 'Montant ttc': e.montantTtc ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Bar code': this.criteria.barCode ? this.criteria.barCode : environment.emptyForExport ,
            'Numero commande': this.criteria.numeroCommande ? this.criteria.numeroCommande : environment.emptyForExport ,
            'Date commande Min': this.criteria.dateCommandeFrom ? this.datePipe.transform(this.criteria.dateCommandeFrom , this.dateFormat) : environment.emptyForExport ,
            'Date commande Max': this.criteria.dateCommandeTo ? this.datePipe.transform(this.criteria.dateCommandeTo , this.dateFormat) : environment.emptyForExport ,
        //'Client': this.criteria.client?.telephone ? this.criteria.client?.telephone : environment.emptyForExport ,
        //'Etat commande': this.criteria.etatCommande?.libelle ? this.criteria.etatCommande?.libelle : environment.emptyForExport ,
            'Montant ht Min': this.criteria.montantHtMin ? this.criteria.montantHtMin : environment.emptyForExport ,
            'Montant ht Max': this.criteria.montantHtMax ? this.criteria.montantHtMax : environment.emptyForExport ,
            'Montant tva Min': this.criteria.montantTvaMin ? this.criteria.montantTvaMin : environment.emptyForExport ,
            'Montant tva Max': this.criteria.montantTvaMax ? this.criteria.montantTvaMax : environment.emptyForExport ,
            'Montant ttc Min': this.criteria.montantTtcMin ? this.criteria.montantTtcMin : environment.emptyForExport ,
            'Montant ttc Max': this.criteria.montantTtcMax ? this.criteria.montantTtcMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
