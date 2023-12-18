import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CommandeAdminService} from 'src/app/controller/service/admin/stock/CommandeAdmin.service';
import {CommandeDto} from 'src/app/controller/model/stock/Commande.model';
import {CommandeCriteria} from 'src/app/controller/criteria/stock/CommandeCriteria.model';

import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {CommandeItemDto} from 'src/app/controller/model/stock/CommandeItem.model';
import {CommandeItemAdminService} from 'src/app/controller/service/admin/stock/CommandeItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EtatCommandeDto} from 'src/app/controller/model/commun/EtatCommande.model';
import {EtatCommandeAdminService} from 'src/app/controller/service/admin/commun/EtatCommandeAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-commande-view-admin',
  templateUrl: './commande-view-admin.component.html'
})
export class CommandeViewAdminComponent extends AbstractViewController<CommandeDto, CommandeCriteria, CommandeAdminService> implements OnInit {

    commandeItems = new CommandeItemDto();
    commandeItemss: Array<CommandeItemDto> = [];

    constructor(private commandeService: CommandeAdminService, private clientService: ClientAdminService, private commandeItemService: CommandeItemAdminService, private produitService: ProduitAdminService, private etatCommandeService: EtatCommandeAdminService, private taxeService: TaxeAdminService){
        super(commandeService);
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
    get etatCommande(): EtatCommandeDto {
       return this.etatCommandeService.item;
    }
    set etatCommande(value: EtatCommandeDto) {
        this.etatCommandeService.item = value;
    }
    get etatCommandes(): Array<EtatCommandeDto> {
       return this.etatCommandeService.items;
    }
    set etatCommandes(value: Array<EtatCommandeDto>) {
        this.etatCommandeService.items = value;
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
