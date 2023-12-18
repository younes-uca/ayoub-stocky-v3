import {Component, OnInit} from '@angular/core';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/stock/VenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {ReglementVenteDto} from 'src/app/controller/model/reglement/ReglementVente.model';
import {ReglementVenteAdminService} from 'src/app/controller/service/admin/reglement/ReglementVenteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
import {VenteItemDto} from 'src/app/controller/model/stock/VenteItem.model';
import {VenteItemAdminService} from 'src/app/controller/service/admin/stock/VenteItemAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {EtatVenteDto} from 'src/app/controller/model/commun/EtatVente.model';
import {EtatVenteAdminService} from 'src/app/controller/service/admin/commun/EtatVenteAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirVenteAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';


@Component({
  selector: 'app-vente-list-admin',
  templateUrl: './vente-list-admin.component.html'
})
export class VenteListAdminComponent extends AbstractListController<VenteDto, VenteCriteria, VenteAdminService>  implements OnInit {

    fileName = 'Vente';

    entrepriseSocietes: Array<EntrepriseSocieteDto>;
    clients: Array<ClientDto>;
    etatVentes: Array<EtatVenteDto>;


    constructor( private venteService: VenteAdminService  , private etatVenteService: EtatVenteAdminService, private clientService: ClientAdminService, private depotService: DepotAdminService, private venteItemService: VenteItemAdminService, private avoirVenteService: AvoirVenteAdminService, private reglementVenteService: ReglementVenteAdminService, private produitService: ProduitAdminService, private etatAvoirVenteService: EtatAvoirVenteAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private modeReglementService: ModeReglementAdminService, private taxeService: TaxeAdminService) {
        super(venteService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadEntrepriseSociete();
        this.loadClient();
        this.loadEtatVente();
    }


    public initCol() {
        this.cols = [
            {field: 'barCode', header: 'Bar code'},
            {field: 'entrepriseSociete?.nom', header: 'Entreprise societe'},
            {field: 'codeVente', header: 'Code vente'},
            {field: 'dateFacture', header: 'Date facture'},
            {field: 'numeroFacture', header: 'Numero facture'},
            {field: 'client?.telephone', header: 'Client'},
            {field: 'etatVente?.libelle', header: 'Etat vente'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTva', header: 'Montant tva'},
            {field: 'montantTtc', header: 'Montant ttc'},
        ];
    }


    public async loadEntrepriseSociete(){
       this.entrepriseSocieteService.findAllOptimized().subscribe(entrepriseSocietes => this.entrepriseSocietes = entrepriseSocietes, error => console.log(error))
    }
    public async loadClient(){
       this.clientService.findAllOptimized().subscribe(clients => this.clients = clients, error => console.log(error))
    }
    public async loadEtatVente(){
       this.etatVenteService.findAllOptimized().subscribe(etatVentes => this.etatVentes = etatVentes, error => console.log(error))
    }

	public initDuplicate(res: VenteDto) {
        if (res.venteItems != null) {
             res.venteItems.forEach(d => { d.vente = null; d.id = null; });
        }
        if (res.avoirVentes != null) {
             res.avoirVentes.forEach(d => { d.vente = null; d.id = null; });
        }
        if (res.reglementVentes != null) {
             res.reglementVentes.forEach(d => { d.vente = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Bar code': e.barCode ,
                'Entreprise societe': e.entrepriseSociete?.nom ,
                 'Code vente': e.codeVente ,
                'Date facture': this.datePipe.transform(e.dateFacture , 'dd/MM/yyyy hh:mm'),
                 'Numero facture': e.numeroFacture ,
                'Client': e.client?.telephone ,
                'Etat vente': e.etatVente?.libelle ,
                 'Montant ht': e.montantHt ,
                 'Montant tva': e.montantTva ,
                 'Montant ttc': e.montantTtc ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Bar code': this.criteria.barCode ? this.criteria.barCode : environment.emptyForExport ,
        //'Entreprise societe': this.criteria.entrepriseSociete?.nom ? this.criteria.entrepriseSociete?.nom : environment.emptyForExport ,
            'Code vente': this.criteria.codeVente ? this.criteria.codeVente : environment.emptyForExport ,
            'Date facture Min': this.criteria.dateFactureFrom ? this.datePipe.transform(this.criteria.dateFactureFrom , this.dateFormat) : environment.emptyForExport ,
            'Date facture Max': this.criteria.dateFactureTo ? this.datePipe.transform(this.criteria.dateFactureTo , this.dateFormat) : environment.emptyForExport ,
            'Numero facture': this.criteria.numeroFacture ? this.criteria.numeroFacture : environment.emptyForExport ,
        //'Client': this.criteria.client?.telephone ? this.criteria.client?.telephone : environment.emptyForExport ,
        //'Etat vente': this.criteria.etatVente?.libelle ? this.criteria.etatVente?.libelle : environment.emptyForExport ,
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
