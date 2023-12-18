import {Component, OnInit} from '@angular/core';
import {EtatVenteAdminService} from 'src/app/controller/service/admin/commun/EtatVenteAdmin.service';
import {EtatVenteDto} from 'src/app/controller/model/commun/EtatVente.model';
import {EtatVenteCriteria} from 'src/app/controller/criteria/commun/EtatVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-etat-vente-list-admin',
  templateUrl: './etat-vente-list-admin.component.html'
})
export class EtatVenteListAdminComponent extends AbstractListController<EtatVenteDto, EtatVenteCriteria, EtatVenteAdminService>  implements OnInit {

    fileName = 'EtatVente';



    constructor( private etatVenteService: EtatVenteAdminService  ) {
        super(etatVenteService);
        this.pdfName = 'EtatVente.pdf';
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
