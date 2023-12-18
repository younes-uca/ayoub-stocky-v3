import {Component, OnInit} from '@angular/core';
import {EtatAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAchatAdmin.service';
import {EtatAchatDto} from 'src/app/controller/model/commun/EtatAchat.model';
import {EtatAchatCriteria} from 'src/app/controller/criteria/commun/EtatAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-etat-achat-list-admin',
  templateUrl: './etat-achat-list-admin.component.html'
})
export class EtatAchatListAdminComponent extends AbstractListController<EtatAchatDto, EtatAchatCriteria, EtatAchatAdminService>  implements OnInit {

    fileName = 'EtatAchat';



    constructor( private etatAchatService: EtatAchatAdminService  ) {
        super(etatAchatService);
        this.pdfName = 'EtatAchat.pdf';
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
