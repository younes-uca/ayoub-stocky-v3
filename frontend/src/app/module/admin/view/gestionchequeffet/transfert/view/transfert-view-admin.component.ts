import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TransfertAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertAdmin.service';
import {TransfertDto} from 'src/app/controller/model/gestionchequeffet/Transfert.model';
import {TransfertCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransfertCriteria.model';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {TransfertItemDto} from 'src/app/controller/model/gestionchequeffet/TransfertItem.model';
import {TransfertItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {RaisonDto} from 'src/app/controller/model/Transfert/Raison.model';
import {RaisonAdminService} from 'src/app/controller/service/admin/Transfert/RaisonAdmin.service';
@Component({
  selector: 'app-transfert-view-admin',
  templateUrl: './transfert-view-admin.component.html'
})
export class TransfertViewAdminComponent extends AbstractViewController<TransfertDto, TransfertCriteria, TransfertAdminService> implements OnInit {

    transfertItems = new TransfertItemDto();
    transfertItemss: Array<TransfertItemDto> = [];

    constructor(private transfertService: TransfertAdminService, private depotService: DepotAdminService, private transfertItemService: TransfertItemAdminService, private produitService: ProduitAdminService, private raisonService: RaisonAdminService){
        super(transfertService);
    }

    ngOnInit(): void {
    }


    get produit(): ProduitDto {
       return this.produitService.item;
    }
    set produit(value: ProduitDto) {
        this.produitService.item = value;
    }
    get produits(): Array<ProduitDto> {
       return this.produitService.items;
    }
    set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
    }
    get depot(): DepotDto {
       return this.depotService.item;
    }
    set depot(value: DepotDto) {
        this.depotService.item = value;
    }
    get depots(): Array<DepotDto> {
       return this.depotService.items;
    }
    set depots(value: Array<DepotDto>) {
        this.depotService.items = value;
    }
    get raison(): RaisonDto {
       return this.raisonService.item;
    }
    set raison(value: RaisonDto) {
        this.raisonService.item = value;
    }
    get raisons(): Array<RaisonDto> {
       return this.raisonService.items;
    }
    set raisons(value: Array<RaisonDto>) {
        this.raisonService.items = value;
    }


}
