import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemCriteria} from 'src/app/controller/criteria/stock/AvoirAchatItemCriteria.model';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-avoir-achat-item-view-admin',
  templateUrl: './avoir-achat-item-view-admin.component.html'
})
export class AvoirAchatItemViewAdminComponent extends AbstractViewController<AvoirAchatItemDto, AvoirAchatItemCriteria, AvoirAchatItemAdminService> implements OnInit {


    constructor(private avoirAchatItemService: AvoirAchatItemAdminService, private depotService: DepotAdminService, private produitService: ProduitAdminService, private avoirAchatService: AvoirAchatAdminService, private taxeService: TaxeAdminService){
        super(avoirAchatItemService);
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
    get taxe(): TaxeDto {
       return this.taxeService.item;
    }
    set taxe(value: TaxeDto) {
        this.taxeService.item = value;
    }
    get taxes(): Array<TaxeDto> {
       return this.taxeService.items;
    }
    set taxes(value: Array<TaxeDto>) {
        this.taxeService.items = value;
    }
    get avoirAchat(): AvoirAchatDto {
       return this.avoirAchatService.item;
    }
    set avoirAchat(value: AvoirAchatDto) {
        this.avoirAchatService.item = value;
    }
    get avoirAchats(): Array<AvoirAchatDto> {
       return this.avoirAchatService.items;
    }
    set avoirAchats(value: Array<AvoirAchatDto>) {
        this.avoirAchatService.items = value;
    }


}
