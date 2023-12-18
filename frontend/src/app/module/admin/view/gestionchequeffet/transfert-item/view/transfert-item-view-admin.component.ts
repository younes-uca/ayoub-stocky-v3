import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TransfertItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertItemAdmin.service';
import {TransfertItemDto} from 'src/app/controller/model/gestionchequeffet/TransfertItem.model';
import {TransfertItemCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransfertItemCriteria.model';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {TransfertDto} from 'src/app/controller/model/gestionchequeffet/Transfert.model';
import {TransfertAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertAdmin.service';
@Component({
  selector: 'app-transfert-item-view-admin',
  templateUrl: './transfert-item-view-admin.component.html'
})
export class TransfertItemViewAdminComponent extends AbstractViewController<TransfertItemDto, TransfertItemCriteria, TransfertItemAdminService> implements OnInit {


    constructor(private transfertItemService: TransfertItemAdminService, private depotService: DepotAdminService, private produitService: ProduitAdminService, private transfertService: TransfertAdminService){
        super(transfertItemService);
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
    get transfert(): TransfertDto {
       return this.transfertService.item;
    }
    set transfert(value: TransfertDto) {
        this.transfertService.item = value;
    }
    get transferts(): Array<TransfertDto> {
       return this.transfertService.items;
    }
    set transferts(value: Array<TransfertDto>) {
        this.transfertService.items = value;
    }


}
