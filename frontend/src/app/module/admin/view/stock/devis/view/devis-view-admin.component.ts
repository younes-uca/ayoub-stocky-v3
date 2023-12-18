import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DevisAdminService} from 'src/app/controller/service/admin/stock/DevisAdmin.service';
import {DevisDto} from 'src/app/controller/model/stock/Devis.model';
import {DevisCriteria} from 'src/app/controller/criteria/stock/DevisCriteria.model';

import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {DevisItemDto} from 'src/app/controller/model/stock/DevisItem.model';
import {DevisItemAdminService} from 'src/app/controller/service/admin/stock/DevisItemAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-devis-view-admin',
  templateUrl: './devis-view-admin.component.html'
})
export class DevisViewAdminComponent extends AbstractViewController<DevisDto, DevisCriteria, DevisAdminService> implements OnInit {

    devisItems = new DevisItemDto();
    devisItemss: Array<DevisItemDto> = [];

    constructor(private devisService: DevisAdminService, private clientService: ClientAdminService, private produitService: ProduitAdminService, private devisItemService: DevisItemAdminService, private taxeService: TaxeAdminService){
        super(devisService);
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
