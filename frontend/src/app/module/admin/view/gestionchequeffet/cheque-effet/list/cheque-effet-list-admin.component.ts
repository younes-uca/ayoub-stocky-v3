import {Component, OnInit} from '@angular/core';
import {ChequeEffetAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ChequeEffetAdmin.service';
import {ChequeEffetDto} from 'src/app/controller/model/gestionchequeffet/ChequeEffet.model';
import {ChequeEffetCriteria} from 'src/app/controller/criteria/gestionchequeffet/ChequeEffetCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';


@Component({
  selector: 'app-cheque-effet-list-admin',
  templateUrl: './cheque-effet-list-admin.component.html'
})
export class ChequeEffetListAdminComponent extends AbstractListController<ChequeEffetDto, ChequeEffetCriteria, ChequeEffetAdminService>  implements OnInit {

    fileName = 'ChequeEffet';

    fournisseurs: Array<FournisseurDto>;


    constructor( private chequeEffetService: ChequeEffetAdminService  , private fournisseurService: FournisseurAdminService) {
        super(chequeEffetService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadFournisseur();
    }


    public initCol() {
        this.cols = [
            {field: 'numero', header: 'Numero'},
            {field: 'dateEmission', header: 'Date emission'},
            {field: 'montant', header: 'Montant'},
            {field: 'fournisseur?.telephone', header: 'Fournisseur'},
        ];
    }


    public async loadFournisseur(){
       this.fournisseurService.findAllOptimized().subscribe(fournisseurs => this.fournisseurs = fournisseurs, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Numero': e.numero ,
                'Date emission': this.datePipe.transform(e.dateEmission , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Fournisseur': e.fournisseur?.telephone ,
            }
        });

        this.criteriaData = [{
            'Numero': this.criteria.numero ? this.criteria.numero : environment.emptyForExport ,
            'Date emission Min': this.criteria.dateEmissionFrom ? this.datePipe.transform(this.criteria.dateEmissionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date emission Max': this.criteria.dateEmissionTo ? this.datePipe.transform(this.criteria.dateEmissionTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Fournisseur': this.criteria.fournisseur?.telephone ? this.criteria.fournisseur?.telephone : environment.emptyForExport ,
        }];
      }
}
