import {Component, OnInit} from '@angular/core';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteCriteria} from 'src/app/controller/criteria/stock/AvoirVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirVenteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';


@Component({
  selector: 'app-avoir-vente-list-admin',
  templateUrl: './avoir-vente-list-admin.component.html'
})
export class AvoirVenteListAdminComponent extends AbstractListController<AvoirVenteDto, AvoirVenteCriteria, AvoirVenteAdminService>  implements OnInit {

    fileName = 'AvoirVente';

    entrepriseSocietes: Array<EntrepriseSocieteDto>;
    clients: Array<ClientDto>;
    etatAvoirVentes: Array<EtatAvoirVenteDto>;
    ventes: Array<VenteDto>;


    constructor( private avoirVenteService: AvoirVenteAdminService  , private clientService: ClientAdminService, private avoirVenteItemService: AvoirVenteItemAdminService, private depotService: DepotAdminService, private etatAvoirVenteService: EtatAvoirVenteAdminService, private produitService: ProduitAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private venteService: VenteAdminService, private taxeService: TaxeAdminService) {
        super(avoirVenteService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadEntrepriseSociete();
        this.loadClient();
        this.loadEtatAvoirVente();
        this.loadVente();
    }


    public initCol() {
        this.cols = [
            {field: 'barCode', header: 'Bar code'},
            {field: 'entrepriseSociete?.nom', header: 'Entreprise societe'},
            {field: 'codeAvoirVente', header: 'Code avoir vente'},
            {field: 'numeroFactureAvoirVente', header: 'Numero facture avoir vente'},
            {field: 'dateFactureAvoirVente', header: 'Date facture avoir vente'},
            {field: 'client?.telephone', header: 'Client'},
            {field: 'etatAvoirVente?.libelle', header: 'Etat avoir vente'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTva', header: 'Montant tva'},
            {field: 'montantTtc', header: 'Montant ttc'},
            {field: 'vente?.numeroFacture', header: 'Vente'},
        ];
    }


    public async loadEntrepriseSociete(){
       this.entrepriseSocieteService.findAllOptimized().subscribe(entrepriseSocietes => this.entrepriseSocietes = entrepriseSocietes, error => console.log(error))
    }
    public async loadClient(){
       this.clientService.findAllOptimized().subscribe(clients => this.clients = clients, error => console.log(error))
    }
    public async loadEtatAvoirVente(){
       this.etatAvoirVenteService.findAllOptimized().subscribe(etatAvoirVentes => this.etatAvoirVentes = etatAvoirVentes, error => console.log(error))
    }
    public async loadVente(){
       this.venteService.findAllOptimized().subscribe(ventes => this.ventes = ventes, error => console.log(error))
    }

	public initDuplicate(res: AvoirVenteDto) {
        if (res.avoirVenteItems != null) {
             res.avoirVenteItems.forEach(d => { d.avoirVente = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Bar code': e.barCode ,
                'Entreprise societe': e.entrepriseSociete?.nom ,
                 'Code avoir vente': e.codeAvoirVente ,
                 'Numero facture avoir vente': e.numeroFactureAvoirVente ,
                'Date facture avoir vente': this.datePipe.transform(e.dateFactureAvoirVente , 'dd/MM/yyyy hh:mm'),
                'Client': e.client?.telephone ,
                'Etat avoir vente': e.etatAvoirVente?.libelle ,
                 'Montant ht': e.montantHt ,
                 'Montant tva': e.montantTva ,
                 'Montant ttc': e.montantTtc ,
                 'Description': e.description ,
                'Vente': e.vente?.numeroFacture ,
            }
        });

        this.criteriaData = [{
            'Bar code': this.criteria.barCode ? this.criteria.barCode : environment.emptyForExport ,
        //'Entreprise societe': this.criteria.entrepriseSociete?.nom ? this.criteria.entrepriseSociete?.nom : environment.emptyForExport ,
            'Code avoir vente': this.criteria.codeAvoirVente ? this.criteria.codeAvoirVente : environment.emptyForExport ,
            'Numero facture avoir vente': this.criteria.numeroFactureAvoirVente ? this.criteria.numeroFactureAvoirVente : environment.emptyForExport ,
            'Date facture avoir vente Min': this.criteria.dateFactureAvoirVenteFrom ? this.datePipe.transform(this.criteria.dateFactureAvoirVenteFrom , this.dateFormat) : environment.emptyForExport ,
            'Date facture avoir vente Max': this.criteria.dateFactureAvoirVenteTo ? this.datePipe.transform(this.criteria.dateFactureAvoirVenteTo , this.dateFormat) : environment.emptyForExport ,
        //'Client': this.criteria.client?.telephone ? this.criteria.client?.telephone : environment.emptyForExport ,
        //'Etat avoir vente': this.criteria.etatAvoirVente?.libelle ? this.criteria.etatAvoirVente?.libelle : environment.emptyForExport ,
            'Montant ht Min': this.criteria.montantHtMin ? this.criteria.montantHtMin : environment.emptyForExport ,
            'Montant ht Max': this.criteria.montantHtMax ? this.criteria.montantHtMax : environment.emptyForExport ,
            'Montant tva Min': this.criteria.montantTvaMin ? this.criteria.montantTvaMin : environment.emptyForExport ,
            'Montant tva Max': this.criteria.montantTvaMax ? this.criteria.montantTvaMax : environment.emptyForExport ,
            'Montant ttc Min': this.criteria.montantTtcMin ? this.criteria.montantTtcMin : environment.emptyForExport ,
            'Montant ttc Max': this.criteria.montantTtcMax ? this.criteria.montantTtcMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Vente': this.criteria.vente?.numeroFacture ? this.criteria.vente?.numeroFacture : environment.emptyForExport ,
        }];
      }
}
