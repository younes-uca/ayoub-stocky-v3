import {Component, OnInit} from '@angular/core';
import {EtatCommandeAdminService} from 'src/app/controller/service/admin/commun/EtatCommandeAdmin.service';
import {EtatCommandeDto} from 'src/app/controller/model/commun/EtatCommande.model';
import {EtatCommandeCriteria} from 'src/app/controller/criteria/commun/EtatCommandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-etat-commande-list-admin',
  templateUrl: './etat-commande-list-admin.component.html'
})
export class EtatCommandeListAdminComponent extends AbstractListController<EtatCommandeDto, EtatCommandeCriteria, EtatCommandeAdminService>  implements OnInit {

    fileName = 'EtatCommande';



    constructor( private etatCommandeService: EtatCommandeAdminService  ) {
        super(etatCommandeService);
        this.pdfName = 'EtatCommande.pdf';
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
