import {Component, OnInit} from '@angular/core';
import {TransfertAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertAdmin.service';
import {TransfertDto} from 'src/app/controller/model/gestionchequeffet/Transfert.model';
import {TransfertCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransfertCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {TransfertItemDto} from 'src/app/controller/model/gestionchequeffet/TransfertItem.model';
import {TransfertItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {RaisonDto} from 'src/app/controller/model/Transfert/Raison.model';
import {RaisonAdminService} from 'src/app/controller/service/admin/Transfert/RaisonAdmin.service';


@Component({
  selector: 'app-transfert-list-admin',
  templateUrl: './transfert-list-admin.component.html'
})
export class TransfertListAdminComponent extends AbstractListController<TransfertDto, TransfertCriteria, TransfertAdminService>  implements OnInit {

    fileName = 'Transfert';

    raisons: Array<RaisonDto>;


    constructor( private transfertService: TransfertAdminService  , private depotService: DepotAdminService, private transfertItemService: TransfertItemAdminService, private produitService: ProduitAdminService, private raisonService: RaisonAdminService) {
        super(transfertService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadRaison();
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'raison?.libelle', header: 'Raison'},
            {field: 'dateTransfert', header: 'Date transfert'},
        ];
    }


    public async loadRaison(){
       this.raisonService.findAllOptimized().subscribe(raisons => this.raisons = raisons, error => console.log(error))
    }

	public initDuplicate(res: TransfertDto) {
        if (res.transfertItems != null) {
             res.transfertItems.forEach(d => { d.transfert = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Raison': e.raison?.libelle ,
                'Date transfert': this.datePipe.transform(e.dateTransfert , 'dd/MM/yyyy hh:mm'),
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
        //'Raison': this.criteria.raison?.libelle ? this.criteria.raison?.libelle : environment.emptyForExport ,
            'Date transfert Min': this.criteria.dateTransfertFrom ? this.datePipe.transform(this.criteria.dateTransfertFrom , this.dateFormat) : environment.emptyForExport ,
            'Date transfert Max': this.criteria.dateTransfertTo ? this.datePipe.transform(this.criteria.dateTransfertTo , this.dateFormat) : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
