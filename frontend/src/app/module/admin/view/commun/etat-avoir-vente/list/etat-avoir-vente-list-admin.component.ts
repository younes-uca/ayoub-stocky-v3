import {Component, OnInit} from '@angular/core';
import {EtatAvoirVenteAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirVenteAdmin.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteCriteria} from 'src/app/controller/criteria/commun/EtatAvoirVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-etat-avoir-vente-list-admin',
  templateUrl: './etat-avoir-vente-list-admin.component.html'
})
export class EtatAvoirVenteListAdminComponent extends AbstractListController<EtatAvoirVenteDto, EtatAvoirVenteCriteria, EtatAvoirVenteAdminService>  implements OnInit {

    fileName = 'EtatAvoirVente';



    constructor( private etatAvoirVenteService: EtatAvoirVenteAdminService  ) {
        super(etatAvoirVenteService);
        this.pdfName = 'EtatAvoirVente.pdf';
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
