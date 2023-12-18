import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EntreeProduitAdminService} from 'src/app/controller/service/admin/entree/EntreeProduitAdmin.service';
import {EntreeProduitDto} from 'src/app/controller/model/entree/EntreeProduit.model';
import {EntreeProduitCriteria} from 'src/app/controller/criteria/entree/EntreeProduitCriteria.model';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {EntreeProduitItemDto} from 'src/app/controller/model/stock/EntreeProduitItem.model';
import {EntreeProduitItemAdminService} from 'src/app/controller/service/admin/stock/EntreeProduitItemAdmin.service';
@Component({
  selector: 'app-entree-produit-create-admin',
  templateUrl: './entree-produit-create-admin.component.html'
})
export class EntreeProduitCreateAdminComponent extends AbstractCreateController<EntreeProduitDto, EntreeProduitCriteria, EntreeProduitAdminService>  implements OnInit {

    private _entreeProduitItemsElement = new EntreeProduitItemDto();


   private _validEntreeProduitReference = true;
    private _validFournisseurIce = true;
    private _validFournisseurNom = true;
    private _validFournisseurTelephone = true;
    private _validDepotLibelle = true;
    private _validEntreeProduitItemsProduit = true;
    private _validEntreeProduitItemsQuantite = true;

    constructor( private entreeProduitService: EntreeProduitAdminService , private depotService: DepotAdminService, private produitService: ProduitAdminService, private fournisseurService: FournisseurAdminService, private entreeProduitItemService: EntreeProduitItemAdminService) {
        super(entreeProduitService);
    }

    ngOnInit(): void {
        this.entreeProduitItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
    }



    validateEntreeProduitItems(){
        this.errorMessages = new Array();
        this.validateEntreeProduitItemsProduit();
        this.validateEntreeProduitItemsQuantite();
    }


    public setValidation(value: boolean){
        this.validEntreeProduitReference = value;
        this.validEntreeProduitItemsProduit = value;
        this.validEntreeProduitItemsQuantite = value;
    }

    public addEntreeProduitItems() {
        if( this.item.entreeProduitItems == null )
            this.item.entreeProduitItems = new Array<EntreeProduitItemDto>();
       this.validateEntreeProduitItems();
       if (this.errorMessages.length === 0) {
              this.item.entreeProduitItems.push({... this.entreeProduitItemsElement});
              this.entreeProduitItemsElement = new EntreeProduitItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteentreeProduitItems(p: EntreeProduitItemDto) {
        this.item.entreeProduitItems.forEach((element, index) => {
            if (element === p) { this.item.entreeProduitItems.splice(index, 1); }
        });
    }

    public editentreeProduitItems(p: EntreeProduitItemDto) {
        this.entreeProduitItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEntreeProduitReference();
    }

    public validateEntreeProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validEntreeProduitReference = false;
        } else {
            this.validEntreeProduitReference = true;
        }
    }

    public validateEntreeProduitItemsProduit(){
        if (this.entreeProduitItemsElement.produit == null) {
            this.errorMessages.push('Produit de la entreeProduitItem est  invalide');
            this.validEntreeProduitItemsProduit = false;
        } else {
            this.validEntreeProduitItemsProduit = true;
        }
    }
    public validateEntreeProduitItemsQuantite(){
        if (this.entreeProduitItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la entreeProduitItem est  invalide');
            this.validEntreeProduitItemsQuantite = false;
        } else {
            this.validEntreeProduitItemsQuantite = true;
        }
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
    get createProduitDialog(): boolean {
       return this.produitService.createDialog;
    }
    set createProduitDialog(value: boolean) {
        this.produitService.createDialog= value;
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
    get createDepotDialog(): boolean {
       return this.depotService.createDialog;
    }
    set createDepotDialog(value: boolean) {
        this.depotService.createDialog= value;
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
    get createFournisseurDialog(): boolean {
       return this.fournisseurService.createDialog;
    }
    set createFournisseurDialog(value: boolean) {
        this.fournisseurService.createDialog= value;
    }



    get validEntreeProduitReference(): boolean {
        return this._validEntreeProduitReference;
    }

    set validEntreeProduitReference(value: boolean) {
         this._validEntreeProduitReference = value;
    }

    get validFournisseurIce(): boolean {
        return this._validFournisseurIce;
    }
    set validFournisseurIce(value: boolean) {
        this._validFournisseurIce = value;
    }
    get validFournisseurNom(): boolean {
        return this._validFournisseurNom;
    }
    set validFournisseurNom(value: boolean) {
        this._validFournisseurNom = value;
    }
    get validFournisseurTelephone(): boolean {
        return this._validFournisseurTelephone;
    }
    set validFournisseurTelephone(value: boolean) {
        this._validFournisseurTelephone = value;
    }
    get validDepotLibelle(): boolean {
        return this._validDepotLibelle;
    }
    set validDepotLibelle(value: boolean) {
        this._validDepotLibelle = value;
    }
    get validEntreeProduitItemsProduit(): boolean {
        return this._validEntreeProduitItemsProduit;
    }
    set validEntreeProduitItemsProduit(value: boolean) {
        this._validEntreeProduitItemsProduit = value;
    }
    get validEntreeProduitItemsQuantite(): boolean {
        return this._validEntreeProduitItemsQuantite;
    }
    set validEntreeProduitItemsQuantite(value: boolean) {
        this._validEntreeProduitItemsQuantite = value;
    }

    get entreeProduitItemsElement(): EntreeProduitItemDto {
        if( this._entreeProduitItemsElement == null )
            this._entreeProduitItemsElement = new EntreeProduitItemDto();
        return this._entreeProduitItemsElement;
    }

    set entreeProduitItemsElement(value: EntreeProduitItemDto) {
        this._entreeProduitItemsElement = value;
    }

}
