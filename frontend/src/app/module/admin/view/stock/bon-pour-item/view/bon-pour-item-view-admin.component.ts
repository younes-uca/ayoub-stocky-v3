import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BonPourItemAdminService} from 'src/app/controller/service/admin/stock/BonPourItemAdmin.service';
import {BonPourItemDto} from 'src/app/controller/model/stock/BonPourItem.model';
import {BonPourItemCriteria} from 'src/app/controller/criteria/stock/BonPourItemCriteria.model';

import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {BonPourDto} from 'src/app/controller/model/stock/BonPour.model';
import {BonPourAdminService} from 'src/app/controller/service/admin/stock/BonPourAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-bon-pour-item-view-admin',
  templateUrl: './bon-pour-item-view-admin.component.html'
})
export class BonPourItemViewAdminComponent extends AbstractViewController<BonPourItemDto, BonPourItemCriteria, BonPourItemAdminService> implements OnInit {


    constructor(private bonPourItemService: BonPourItemAdminService, private produitService: ProduitAdminService, private bonPourService: BonPourAdminService, private taxeService: TaxeAdminService){
        super(bonPourItemService);
    }

    ngOnInit(): void {
    }


    get bonPour(): BonPourDto {
       return this.bonPourService.item;
    }
    set bonPour(value: BonPourDto) {
        this.bonPourService.item = value;
    }
    get bonPours(): Array<BonPourDto> {
       return this.bonPourService.items;
    }
    set bonPours(value: Array<BonPourDto>) {
        this.bonPourService.items = value;
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


}
