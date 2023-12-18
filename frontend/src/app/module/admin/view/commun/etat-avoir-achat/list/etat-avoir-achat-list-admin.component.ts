import {Component, OnInit} from '@angular/core';
import {EtatAvoirAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirAchatAdmin.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/commun/EtatAvoirAchat.model';
import {EtatAvoirAchatCriteria} from 'src/app/controller/criteria/commun/EtatAvoirAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-etat-avoir-achat-list-admin',
  templateUrl: './etat-avoir-achat-list-admin.component.html'
})
export class EtatAvoirAchatListAdminComponent extends AbstractListController<EtatAvoirAchatDto, EtatAvoirAchatCriteria, EtatAvoirAchatAdminService>  implements OnInit {

    fileName = 'EtatAvoirAchat';



    constructor( private etatAvoirAchatService: EtatAvoirAchatAdminService  ) {
        super(etatAvoirAchatService);
        this.pdfName = 'EtatAvoirAchat.pdf';
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
