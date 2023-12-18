import {Component, OnInit} from '@angular/core';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatCriteria} from 'src/app/controller/criteria/stock/AchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {EtatAchatDto} from 'src/app/controller/model/commun/EtatAchat.model';
import {EtatAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAchatAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/commun/EtatAvoirAchat.model';
import {EtatAvoirAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirAchatAdmin.service';
import {AchatItemDto} from 'src/app/controller/model/stock/AchatItem.model';
import {AchatItemAdminService} from 'src/app/controller/service/admin/stock/AchatItemAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';


@Component({
  selector: 'app-achat-list-admin',
  templateUrl: './achat-list-admin.component.html'
})
export class AchatListAdminComponent extends AbstractListController<AchatDto, AchatCriteria, AchatAdminService>  implements OnInit {

    fileName = 'Achat';

    entrepriseSocietes: Array<EntrepriseSocieteDto>;
    fournisseurs: Array<FournisseurDto>;
    etatAchats: Array<EtatAchatDto>;


    constructor( private achatService: AchatAdminService  , private etatAchatService: EtatAchatAdminService, private depotService: DepotAdminService, private achatItemService: AchatItemAdminService, private produitService: ProduitAdminService, private avoirAchatService: AvoirAchatAdminService, private etatAvoirAchatService: EtatAvoirAchatAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private fournisseurService: FournisseurAdminService, private taxeService: TaxeAdminService) {
        super(achatService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadEntrepriseSociete();
        this.loadFournisseur();
        this.loadEtatAchat();
    }


    public initCol() {
        this.cols = [
            {field: 'entrepriseSociete?.nom', header: 'Entreprise societe'},
            {field: 'dateFacture', header: 'Date facture'},
            {field: 'referenceFacture', header: 'Reference facture'},
            {field: 'fournisseur?.telephone', header: 'Fournisseur'},
            {field: 'etatAchat?.libelle', header: 'Etat achat'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTva', header: 'Montant tva'},
            {field: 'montantTtc', header: 'Montant ttc'},
        ];
    }


    public async loadEntrepriseSociete(){
       this.entrepriseSocieteService.findAllOptimized().subscribe(entrepriseSocietes => this.entrepriseSocietes = entrepriseSocietes, error => console.log(error))
    }
    public async loadFournisseur(){
       this.fournisseurService.findAllOptimized().subscribe(fournisseurs => this.fournisseurs = fournisseurs, error => console.log(error))
    }
    public async loadEtatAchat(){
       this.etatAchatService.findAllOptimized().subscribe(etatAchats => this.etatAchats = etatAchats, error => console.log(error))
    }

	public initDuplicate(res: AchatDto) {
        if (res.achatItems != null) {
             res.achatItems.forEach(d => { d.achat = null; d.id = null; });
        }
        if (res.avoirAchats != null) {
             res.avoirAchats.forEach(d => { d.achat = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Entreprise societe': e.entrepriseSociete?.nom ,
                'Date facture': this.datePipe.transform(e.dateFacture , 'dd/MM/yyyy hh:mm'),
                 'Reference facture': e.referenceFacture ,
                'Fournisseur': e.fournisseur?.telephone ,
                'Etat achat': e.etatAchat?.libelle ,
                 'Montant ht': e.montantHt ,
                 'Montant tva': e.montantTva ,
                 'Montant ttc': e.montantTtc ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
        //'Entreprise societe': this.criteria.entrepriseSociete?.nom ? this.criteria.entrepriseSociete?.nom : environment.emptyForExport ,
            'Date facture Min': this.criteria.dateFactureFrom ? this.datePipe.transform(this.criteria.dateFactureFrom , this.dateFormat) : environment.emptyForExport ,
            'Date facture Max': this.criteria.dateFactureTo ? this.datePipe.transform(this.criteria.dateFactureTo , this.dateFormat) : environment.emptyForExport ,
            'Reference facture': this.criteria.referenceFacture ? this.criteria.referenceFacture : environment.emptyForExport ,
        //'Fournisseur': this.criteria.fournisseur?.telephone ? this.criteria.fournisseur?.telephone : environment.emptyForExport ,
        //'Etat achat': this.criteria.etatAchat?.libelle ? this.criteria.etatAchat?.libelle : environment.emptyForExport ,
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
