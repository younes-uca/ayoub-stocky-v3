import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SortieProduitItemAdminService} from 'src/app/controller/service/admin/stock/SortieProduitItemAdmin.service';
import {SortieProduitItemDto} from 'src/app/controller/model/stock/SortieProduitItem.model';
import {SortieProduitItemCriteria} from 'src/app/controller/criteria/stock/SortieProduitItemCriteria.model';

import {SortieProduitDto} from 'src/app/controller/model/entree/SortieProduit.model';
import {SortieProduitAdminService} from 'src/app/controller/service/admin/entree/SortieProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
@Component({
  selector: 'app-sortie-produit-item-view-admin',
  templateUrl: './sortie-produit-item-view-admin.component.html'
})
export class SortieProduitItemViewAdminComponent extends AbstractViewController<SortieProduitItemDto, SortieProduitItemCriteria, SortieProduitItemAdminService> implements OnInit {


    constructor(private sortieProduitItemService: SortieProduitItemAdminService, private sortieProduitService: SortieProduitAdminService, private produitService: ProduitAdminService){
        super(sortieProduitItemService);
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
    get sortieProduit(): SortieProduitDto {
       return this.sortieProduitService.item;
    }
    set sortieProduit(value: SortieProduitDto) {
        this.sortieProduitService.item = value;
    }
    get sortieProduits(): Array<SortieProduitDto> {
       return this.sortieProduitService.items;
    }
    set sortieProduits(value: Array<SortieProduitDto>) {
        this.sortieProduitService.items = value;
    }


}
