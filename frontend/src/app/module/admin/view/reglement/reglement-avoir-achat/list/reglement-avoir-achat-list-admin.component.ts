import {Component, OnInit} from '@angular/core';
import {ReglementAvoirAchatAdminService} from 'src/app/controller/service/admin/reglement/ReglementAvoirAchatAdmin.service';
import {ReglementAvoirAchatDto} from 'src/app/controller/model/reglement/ReglementAvoirAchat.model';
import {ReglementAvoirAchatCriteria} from 'src/app/controller/criteria/reglement/ReglementAvoirAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';


@Component({
  selector: 'app-reglement-avoir-achat-list-admin',
  templateUrl: './reglement-avoir-achat-list-admin.component.html'
})
export class ReglementAvoirAchatListAdminComponent extends AbstractListController<ReglementAvoirAchatDto, ReglementAvoirAchatCriteria, ReglementAvoirAchatAdminService>  implements OnInit {

    fileName = 'ReglementAvoirAchat';

    achats: Array<AchatDto>;
    modeReglements: Array<ModeReglementDto>;
    avoirAchats: Array<AvoirAchatDto>;


    constructor( private reglementAvoirAchatService: ReglementAvoirAchatAdminService  , private avoirAchatService: AvoirAchatAdminService, private achatService: AchatAdminService, private modeReglementService: ModeReglementAdminService) {
        super(reglementAvoirAchatService);
        this.pdfName = 'ReglementAvoirAchat.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadAchat();
        this.loadModeReglement();
        this.loadAvoirAchat();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateReglement', header: 'Date reglement'},
            {field: 'montant', header: 'Montant'},
            {field: 'achat?.id', header: 'Achat'},
            {field: 'modeReglement?.libelle', header: 'Mode reglement'},
            {field: 'avoirAchat?.numeroFactureAvoirFournisseur', header: 'Avoir achat'},
        ];
    }


    public async loadAchat(){
       this.achatService.findAll().subscribe(achats => this.achats = achats, error => console.log(error))
    }
    public async loadModeReglement(){
       this.modeReglementService.findAllOptimized().subscribe(modeReglements => this.modeReglements = modeReglements, error => console.log(error))
    }
    public async loadAvoirAchat(){
       this.avoirAchatService.findAllOptimized().subscribe(avoirAchats => this.avoirAchats = avoirAchats, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date reglement': this.datePipe.transform(e.dateReglement , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Achat': e.achat?.id ,
                'Mode reglement': e.modeReglement?.libelle ,
                 'Description': e.description ,
                'Avoir achat': e.avoirAchat?.numeroFactureAvoirFournisseur ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date reglement Min': this.criteria.dateReglementFrom ? this.datePipe.transform(this.criteria.dateReglementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date reglement Max': this.criteria.dateReglementTo ? this.datePipe.transform(this.criteria.dateReglementTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Achat': this.criteria.achat?.id ? this.criteria.achat?.id : environment.emptyForExport ,
        //'Mode reglement': this.criteria.modeReglement?.libelle ? this.criteria.modeReglement?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Avoir achat': this.criteria.avoirAchat?.numeroFactureAvoirFournisseur ? this.criteria.avoirAchat?.numeroFactureAvoirFournisseur : environment.emptyForExport ,
        }];
      }
}
