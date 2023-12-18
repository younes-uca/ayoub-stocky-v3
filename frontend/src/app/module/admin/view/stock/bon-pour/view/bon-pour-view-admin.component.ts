import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BonPourAdminService} from 'src/app/controller/service/admin/stock/BonPourAdmin.service';
import {BonPourDto} from 'src/app/controller/model/stock/BonPour.model';
import {BonPourCriteria} from 'src/app/controller/criteria/stock/BonPourCriteria.model';

import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {BonPourItemDto} from 'src/app/controller/model/stock/BonPourItem.model';
import {BonPourItemAdminService} from 'src/app/controller/service/admin/stock/BonPourItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-bon-pour-view-admin',
  templateUrl: './bon-pour-view-admin.component.html'
})
export class BonPourViewAdminComponent extends AbstractViewController<BonPourDto, BonPourCriteria, BonPourAdminService> implements OnInit {

    bonPourItems = new BonPourItemDto();
    bonPourItemss: Array<BonPourItemDto> = [];

    constructor(private bonPourService: BonPourAdminService, private clientService: ClientAdminService, private bonPourItemService: BonPourItemAdminService, private produitService: ProduitAdminService, private taxeService: TaxeAdminService){
        super(bonPourService);
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
    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients(): Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
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
