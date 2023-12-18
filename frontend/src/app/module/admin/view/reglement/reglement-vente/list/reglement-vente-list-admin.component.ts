import {Component, OnInit} from '@angular/core';
import {ReglementVenteAdminService} from 'src/app/controller/service/admin/reglement/ReglementVenteAdmin.service';
import {ReglementVenteDto} from 'src/app/controller/model/reglement/ReglementVente.model';
import {ReglementVenteCriteria} from 'src/app/controller/criteria/reglement/ReglementVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';


@Component({
  selector: 'app-reglement-vente-list-admin',
  templateUrl: './reglement-vente-list-admin.component.html'
})
export class ReglementVenteListAdminComponent extends AbstractListController<ReglementVenteDto, ReglementVenteCriteria, ReglementVenteAdminService>  implements OnInit {

    fileName = 'ReglementVente';

    ventes: Array<VenteDto>;
    modeReglements: Array<ModeReglementDto>;


    constructor( private reglementVenteService: ReglementVenteAdminService  , private modeReglementService: ModeReglementAdminService, private venteService: VenteAdminService) {
        super(reglementVenteService);
        this.pdfName = 'ReglementVente.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadVente();
        this.loadModeReglement();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'dateReglement', header: 'Date reglement'},
            {field: 'montant', header: 'Montant'},
            {field: 'vente?.numeroFacture', header: 'Vente'},
            {field: 'modeReglement?.libelle', header: 'Mode reglement'},
        ];
    }


    public async loadVente(){
       this.venteService.findAllOptimized().subscribe(ventes => this.ventes = ventes, error => console.log(error))
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
                'Vente': e.vente?.numeroFacture ,
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
        //'Vente': this.criteria.vente?.numeroFacture ? this.criteria.vente?.numeroFacture : environment.emptyForExport ,
        //'Mode reglement': this.criteria.modeReglement?.libelle ? this.criteria.modeReglement?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
