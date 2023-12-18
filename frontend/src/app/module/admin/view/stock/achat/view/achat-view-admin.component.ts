import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatCriteria} from 'src/app/controller/criteria/stock/AchatCriteria.model';

import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {EtatAchatDto} from 'src/app/controller/model/commun/EtatAchat.model';
import {EtatAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAchatAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/commun/EtatAvoirAchat.model';
import {EtatAvoirAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirAchatAdmin.service';
import {AchatItemDto} from 'src/app/controller/model/stock/AchatItem.model';
import {AchatItemAdminService} from 'src/app/controller/service/admin/stock/AchatItemAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-achat-view-admin',
  templateUrl: './achat-view-admin.component.html'
})
export class AchatViewAdminComponent extends AbstractViewController<AchatDto, AchatCriteria, AchatAdminService> implements OnInit {

    achatItems = new AchatItemDto();
    achatItemss: Array<AchatItemDto> = [];
    avoirAchats = new AvoirAchatDto();
    avoirAchatss: Array<AvoirAchatDto> = [];

    constructor(private achatService: AchatAdminService, private etatAchatService: EtatAchatAdminService, private depotService: DepotAdminService, private achatItemService: AchatItemAdminService, private produitService: ProduitAdminService, private avoirAchatService: AvoirAchatAdminService, private etatAvoirAchatService: EtatAvoirAchatAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private fournisseurService: FournisseurAdminService, private taxeService: TaxeAdminService){
        super(achatService);
    }

    ngOnInit(): void {
    }


    get etatAvoirAchat(): EtatAvoirAchatDto {
       return this.etatAvoirAchatService.item;
    }
    set etatAvoirAchat(value: EtatAvoirAchatDto) {
        this.etatAvoirAchatService.item = value;
    }
    get etatAvoirAchats(): Array<EtatAvoirAchatDto> {
       return this.etatAvoirAchatService.items;
    }
    set etatAvoirAchats(value: Array<EtatAvoirAchatDto>) {
        this.etatAvoirAchatService.items = value;
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
    get etatAchat(): EtatAchatDto {
       return this.etatAchatService.item;
    }
    set etatAchat(value: EtatAchatDto) {
        this.etatAchatService.item = value;
    }
    get etatAchats(): Array<EtatAchatDto> {
       return this.etatAchatService.items;
    }
    set etatAchats(value: Array<EtatAchatDto>) {
        this.etatAchatService.items = value;
    }
    get entrepriseSociete(): EntrepriseSocieteDto {
       return this.entrepriseSocieteService.item;
    }
    set entrepriseSociete(value: EntrepriseSocieteDto) {
        this.entrepriseSocieteService.item = value;
    }
    get entrepriseSocietes(): Array<EntrepriseSocieteDto> {
       return this.entrepriseSocieteService.items;
    }
    set entrepriseSocietes(value: Array<EntrepriseSocieteDto>) {
        this.entrepriseSocieteService.items = value;
    }
    get fournisseur(): FournisseurDto {
       return this.fournisseurService.item;
    }
    set fournisseur(value: FournisseurDto) {
        this.fournisseurService.item = value;
    }
    get fournisseurs(): Array<FournisseurDto> {
       return this.fournisseurService.items;
    }
    set fournisseurs(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
    }


}
