import {Component, OnInit} from '@angular/core';
import {BonPourAdminService} from 'src/app/controller/service/admin/stock/BonPourAdmin.service';
import {BonPourDto} from 'src/app/controller/model/stock/BonPour.model';
import {BonPourCriteria} from 'src/app/controller/criteria/stock/BonPourCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {BonPourItemDto} from 'src/app/controller/model/stock/BonPourItem.model';
import {BonPourItemAdminService} from 'src/app/controller/service/admin/stock/BonPourItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';


@Component({
  selector: 'app-bon-pour-list-admin',
  templateUrl: './bon-pour-list-admin.component.html'
})
export class BonPourListAdminComponent extends AbstractListController<BonPourDto, BonPourCriteria, BonPourAdminService>  implements OnInit {

    fileName = 'BonPour';

    clients: Array<ClientDto>;


    constructor( private bonPourService: BonPourAdminService  , private clientService: ClientAdminService, private bonPourItemService: BonPourItemAdminService, private produitService: ProduitAdminService, private taxeService: TaxeAdminService) {
        super(bonPourService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadClient();
    }


    public initCol() {
        this.cols = [
            {field: 'numero', header: 'Numero'},
            {field: 'dateBonPour', header: 'Date bon pour'},
            {field: 'client?.telephone', header: 'Client'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTva', header: 'Montant tva'},
            {field: 'montantTtc', header: 'Montant ttc'},
        ];
    }


    public async loadClient(){
       this.clientService.findAllOptimized().subscribe(clients => this.clients = clients, error => console.log(error))
    }

	public initDuplicate(res: BonPourDto) {
        if (res.bonPourItems != null) {
             res.bonPourItems.forEach(d => { d.bonPour = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Numero': e.numero ,
                'Date bon pour': this.datePipe.transform(e.dateBonPour , 'dd/MM/yyyy hh:mm'),
                'Client': e.client?.telephone ,
                 'Montant ht': e.montantHt ,
                 'Montant tva': e.montantTva ,
                 'Montant ttc': e.montantTtc ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Numero': this.criteria.numero ? this.criteria.numero : environment.emptyForExport ,
            'Date bon pour Min': this.criteria.dateBonPourFrom ? this.datePipe.transform(this.criteria.dateBonPourFrom , this.dateFormat) : environment.emptyForExport ,
            'Date bon pour Max': this.criteria.dateBonPourTo ? this.datePipe.transform(this.criteria.dateBonPourTo , this.dateFormat) : environment.emptyForExport ,
        //'Client': this.criteria.client?.telephone ? this.criteria.client?.telephone : environment.emptyForExport ,
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
