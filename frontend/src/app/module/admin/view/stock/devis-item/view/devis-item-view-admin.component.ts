import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DevisItemAdminService} from 'src/app/controller/service/admin/stock/DevisItemAdmin.service';
import {DevisItemDto} from 'src/app/controller/model/stock/DevisItem.model';
import {DevisItemCriteria} from 'src/app/controller/criteria/stock/DevisItemCriteria.model';

import {DevisDto} from 'src/app/controller/model/stock/Devis.model';
import {DevisAdminService} from 'src/app/controller/service/admin/stock/DevisAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-devis-item-view-admin',
  templateUrl: './devis-item-view-admin.component.html'
})
export class DevisItemViewAdminComponent extends AbstractViewController<DevisItemDto, DevisItemCriteria, DevisItemAdminService> implements OnInit {


    constructor(private devisItemService: DevisItemAdminService, private devisService: DevisAdminService, private produitService: ProduitAdminService, private taxeService: TaxeAdminService){
        super(devisItemService);
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
    get devis(): DevisDto {
       return this.devisService.item;
    }
    set devis(value: DevisDto) {
        this.devisService.item = value;
    }
    get deviss(): Array<DevisDto> {
       return this.devisService.items;
    }
    set deviss(value: Array<DevisDto>) {
        this.devisService.items = value;
    }


}
