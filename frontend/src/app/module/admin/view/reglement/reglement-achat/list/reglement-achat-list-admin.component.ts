import {Component, OnInit} from '@angular/core';
import {ReglementAchatAdminService} from 'src/app/controller/service/admin/reglement/ReglementAchatAdmin.service';
import {ReglementAchatDto} from 'src/app/controller/model/reglement/ReglementAchat.model';
import {ReglementAchatCriteria} from 'src/app/controller/criteria/reglement/ReglementAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';


@Component({
  selector: 'app-reglement-achat-list-admin',
  templateUrl: './reglement-achat-list-admin.component.html'
})
export class ReglementAchatListAdminComponent extends AbstractListController<ReglementAchatDto, ReglementAchatCriteria, ReglementAchatAdminService>  implements OnInit {

    fileName = 'ReglementAchat';

    achats: Array<AchatDto>;
    modeReglements: Array<ModeReglementDto>;


    constructor( private reglementAchatService: ReglementAchatAdminService  , private achatService: AchatAdminService, private modeReglementService: ModeReglementAdminService) {
        super(reglementAchatService);
        this.pdfName = 'ReglementAchat.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadAchat();
        this.loadModeReglement();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateReglement', header: 'Date reglement'},
            {field: 'montant', header: 'Montant'},
            {field: 'achat?.id', header: 'Achat'},
            {field: 'modeReglement?.libelle', header: 'Mode reglement'},
        ];
    }


    public async loadAchat(){
       this.achatService.findAll().subscribe(achats => this.achats = achats, error => console.log(error))
    }
    public async loadModeReglement(){
       this.modeReglementService.findAllOptimized().subscribe(modeReglements => this.modeReglements = modeReglements, error => console.log(error))
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
        }];
      }
}
