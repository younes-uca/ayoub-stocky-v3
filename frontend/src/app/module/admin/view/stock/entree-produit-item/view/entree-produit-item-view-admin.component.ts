import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EntreeProduitItemAdminService} from 'src/app/controller/service/admin/stock/EntreeProduitItemAdmin.service';
import {EntreeProduitItemDto} from 'src/app/controller/model/stock/EntreeProduitItem.model';
import {EntreeProduitItemCriteria} from 'src/app/controller/criteria/stock/EntreeProduitItemCriteria.model';

import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EntreeProduitDto} from 'src/app/controller/model/entree/EntreeProduit.model';
import {EntreeProduitAdminService} from 'src/app/controller/service/admin/entree/EntreeProduitAdmin.service';
@Component({
  selector: 'app-entree-produit-item-view-admin',
  templateUrl: './entree-produit-item-view-admin.component.html'
})
export class EntreeProduitItemViewAdminComponent extends AbstractViewController<EntreeProduitItemDto, EntreeProduitItemCriteria, EntreeProduitItemAdminService> implements OnInit {


    constructor(private entreeProduitItemService: EntreeProduitItemAdminService, private produitService: ProduitAdminService, private entreeProduitService: EntreeProduitAdminService){
        super(entreeProduitItemService);
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
    get entreeProduit(): EntreeProduitDto {
       return this.entreeProduitService.item;
    }
    set entreeProduit(value: EntreeProduitDto) {
        this.entreeProduitService.item = value;
    }
    get entreeProduits(): Array<EntreeProduitDto> {
       return this.entreeProduitService.items;
    }
    set entreeProduits(value: Array<EntreeProduitDto>) {
        this.entreeProduitService.items = value;
    }


}
