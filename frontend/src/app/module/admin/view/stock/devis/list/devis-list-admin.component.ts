import {Component, OnInit} from '@angular/core';
import {DevisAdminService} from 'src/app/controller/service/admin/stock/DevisAdmin.service';
import {DevisDto} from 'src/app/controller/model/stock/Devis.model';
import {DevisCriteria} from 'src/app/controller/criteria/stock/DevisCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {DevisItemDto} from 'src/app/controller/model/stock/DevisItem.model';
import {DevisItemAdminService} from 'src/app/controller/service/admin/stock/DevisItemAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';


@Component({
  selector: 'app-devis-list-admin',
  templateUrl: './devis-list-admin.component.html'
})
export class DevisListAdminComponent extends AbstractListController<DevisDto, DevisCriteria, DevisAdminService>  implements OnInit {

    fileName = 'Devis';

    clients: Array<ClientDto>;


    constructor( private devisService: DevisAdminService  , private clientService: ClientAdminService, private produitService: ProduitAdminService, private devisItemService: DevisItemAdminService, private taxeService: TaxeAdminService) {
        super(devisService);
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
            {field: 'dateDevis', header: 'Date devis'},
            {field: 'client?.telephone', header: 'Client'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTva', header: 'Montant tva'},
            {field: 'montantTtc', header: 'Montant ttc'},
        ];
    }


    public async loadClient(){
       this.clientService.findAllOptimized().subscribe(clients => this.clients = clients, error => console.log(error))
    }

	public initDuplicate(res: DevisDto) {
        if (res.devisItems != null) {
             res.devisItems.forEach(d => { d.devis = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Numero': e.numero ,
                'Date devis': this.datePipe.transform(e.dateDevis , 'dd/MM/yyyy hh:mm'),
                'Client': e.client?.telephone ,
                 'Montant ht': e.montantHt ,
                 'Montant tva': e.montantTva ,
                 'Montant ttc': e.montantTtc ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Numero': this.criteria.numero ? this.criteria.numero : environment.emptyForExport ,
            'Date devis Min': this.criteria.dateDevisFrom ? this.datePipe.transform(this.criteria.dateDevisFrom , this.dateFormat) : environment.emptyForExport ,
            'Date devis Max': this.criteria.dateDevisTo ? this.datePipe.transform(this.criteria.dateDevisTo , this.dateFormat) : environment.emptyForExport ,
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
