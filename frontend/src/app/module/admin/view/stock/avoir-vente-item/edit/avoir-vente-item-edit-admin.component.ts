import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemCriteria} from 'src/app/controller/criteria/stock/AvoirVenteItemCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';

@Component({
  selector: 'app-avoir-vente-item-edit-admin',
  templateUrl: './avoir-vente-item-edit-admin.component.html'
})
export class AvoirVenteItemEditAdminComponent extends AbstractEditController<AvoirVenteItemDto, AvoirVenteItemCriteria, AvoirVenteItemAdminService>   implements OnInit {


    private _validAvoirVenteItemBarCode = true;
    private _validAvoirVenteItemDepot = true;
    private _validAvoirVenteItemProduit = true;
    private _validAvoirVenteItemQuantite = true;
    private _validAvoirVenteItemQuantiteVendue = true;
    private _validAvoirVenteItemPrixUnitaireHt = true;
    private _validAvoirVenteItemPrixUnitaireTtc = true;
    private _validAvoirVenteItemRemise = true;
    private _validAvoirVenteItemMontantHt = true;
    private _validAvoirVenteItemMontantTtc = true;

    private _validDepotLibelle = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validProduitPrixVente = true;
    private _validProduitSeuilAlerte = true;
    private _validTaxeLibelle = true;
    private _validAvoirVenteBarCode = true;
    private _validAvoirVenteEntrepriseSociete = true;
    private _validAvoirVenteCodeAvoirVente = true;
    private _validAvoirVenteNumeroFactureAvoirVente = true;
    private _validAvoirVenteDateFactureAvoirVente = true;
    private _validAvoirVenteClient = true;
    private _validAvoirVenteMontantTtc = true;



    constructor( private avoirVenteItemService: AvoirVenteItemAdminService , private depotService: DepotAdminService, private avoirVenteService: AvoirVenteAdminService, private produitService: ProduitAdminService, private taxeService: TaxeAdminService) {
        super(avoirVenteItemService);
    }

    ngOnInit(): void {
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.avoirVente = new AvoirVenteDto();
        this.avoirVenteService.findAll().subscribe((data) => this.avoirVentes = data);
    }


    public setValidation(value: boolean){
        this.validAvoirVenteItemBarCode = value;
        this.validAvoirVenteItemDepot = value;
        this.validAvoirVenteItemProduit = value;
        this.validAvoirVenteItemQuantite = value;
        this.validAvoirVenteItemQuantiteVendue = value;
        this.validAvoirVenteItemPrixUnitaireHt = value;
        this.validAvoirVenteItemPrixUnitaireTtc = value;
        this.validAvoirVenteItemRemise = value;
        this.validAvoirVenteItemMontantHt = value;
        this.validAvoirVenteItemMontantTtc = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAvoirVenteItemBarCode();
        this.validateAvoirVenteItemDepot();
        this.validateAvoirVenteItemProduit();
        this.validateAvoirVenteItemQuantite();
        this.validateAvoirVenteItemQuantiteVendue();
        this.validateAvoirVenteItemPrixUnitaireHt();
        this.validateAvoirVenteItemPrixUnitaireTtc();
        this.validateAvoirVenteItemRemise();
        this.validateAvoirVenteItemMontantHt();
        this.validateAvoirVenteItemMontantTtc();
    }
    public validateAvoirVenteItemBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
            this.errorMessages.push('Bar code non valide');
            this.validAvoirVenteItemBarCode = false;
        } else {
            this.validAvoirVenteItemBarCode = true;
        }
    }
    public validateAvoirVenteItemDepot(){
        if (this.stringUtilService.isEmpty(this.item.depot)) {
            this.errorMessages.push('Depot non valide');
            this.validAvoirVenteItemDepot = false;
        } else {
            this.validAvoirVenteItemDepot = true;
        }
    }
    public validateAvoirVenteItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validAvoirVenteItemProduit = false;
        } else {
            this.validAvoirVenteItemProduit = true;
        }
    }
    public validateAvoirVenteItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validAvoirVenteItemQuantite = false;
        } else {
            this.validAvoirVenteItemQuantite = true;
        }
    }
    public validateAvoirVenteItemQuantiteVendue(){
        if (this.stringUtilService.isEmpty(this.item.quantiteVendue)) {
            this.errorMessages.push('Quantite vendue non valide');
            this.validAvoirVenteItemQuantiteVendue = false;
        } else {
            this.validAvoirVenteItemQuantiteVendue = true;
        }
    }
    public validateAvoirVenteItemPrixUnitaireHt(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireHt)) {
            this.errorMessages.push('Prix unitaire ht non valide');
            this.validAvoirVenteItemPrixUnitaireHt = false;
        } else {
            this.validAvoirVenteItemPrixUnitaireHt = true;
        }
    }
    public validateAvoirVenteItemPrixUnitaireTtc(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireTtc)) {
            this.errorMessages.push('Prix unitaire ttc non valide');
            this.validAvoirVenteItemPrixUnitaireTtc = false;
        } else {
            this.validAvoirVenteItemPrixUnitaireTtc = true;
        }
    }
    public validateAvoirVenteItemRemise(){
        if (this.stringUtilService.isEmpty(this.item.remise)) {
            this.errorMessages.push('Remise non valide');
            this.validAvoirVenteItemRemise = false;
        } else {
            this.validAvoirVenteItemRemise = true;
        }
    }
    public validateAvoirVenteItemMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
            this.errorMessages.push('Montant ht non valide');
            this.validAvoirVenteItemMontantHt = false;
        } else {
            this.validAvoirVenteItemMontantHt = true;
        }
    }
    public validateAvoirVenteItemMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
            this.errorMessages.push('Montant ttc non valide');
            this.validAvoirVenteItemMontantTtc = false;
        } else {
            this.validAvoirVenteItemMontantTtc = true;
        }
    }



   public async openCreateProduit(produit: string) {
        const isPermistted = await this.roleService.isPermitted('Produit', 'edit');
        if (isPermistted) {
             this.produit = new ProduitDto();
             this.createProduitDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateTaxe(taxe: string) {
        const isPermistted = await this.roleService.isPermitted('Taxe', 'edit');
        if (isPermistted) {
             this.taxe = new TaxeDto();
             this.createTaxeDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateAvoirVente(avoirVente: string) {
        const isPermistted = await this.roleService.isPermitted('AvoirVente', 'edit');
        if (isPermistted) {
             this.avoirVente = new AvoirVenteDto();
             this.createAvoirVenteDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
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
   get createTaxeDialog(): boolean {
       return this.taxeService.createDialog;
   }
  set createTaxeDialog(value: boolean) {
       this.taxeService.createDialog= value;
   }
   get avoirVente(): AvoirVenteDto {
       return this.avoirVenteService.item;
   }
  set avoirVente(value: AvoirVenteDto) {
        this.avoirVenteService.item = value;
   }
   get avoirVentes(): Array<AvoirVenteDto> {
        return this.avoirVenteService.items;
   }
   set avoirVentes(value: Array<AvoirVenteDto>) {
        this.avoirVenteService.items = value;
   }
   get createAvoirVenteDialog(): boolean {
       return this.avoirVenteService.createDialog;
   }
  set createAvoirVenteDialog(value: boolean) {
       this.avoirVenteService.createDialog= value;
   }


    get validAvoirVenteItemBarCode(): boolean {
        return this._validAvoirVenteItemBarCode;
    }
    set validAvoirVenteItemBarCode(value: boolean) {
        this._validAvoirVenteItemBarCode = value;
    }
    get validAvoirVenteItemDepot(): boolean {
        return this._validAvoirVenteItemDepot;
    }
    set validAvoirVenteItemDepot(value: boolean) {
        this._validAvoirVenteItemDepot = value;
    }
    get validAvoirVenteItemProduit(): boolean {
        return this._validAvoirVenteItemProduit;
    }
    set validAvoirVenteItemProduit(value: boolean) {
        this._validAvoirVenteItemProduit = value;
    }
    get validAvoirVenteItemQuantite(): boolean {
        return this._validAvoirVenteItemQuantite;
    }
    set validAvoirVenteItemQuantite(value: boolean) {
        this._validAvoirVenteItemQuantite = value;
    }
    get validAvoirVenteItemQuantiteVendue(): boolean {
        return this._validAvoirVenteItemQuantiteVendue;
    }
    set validAvoirVenteItemQuantiteVendue(value: boolean) {
        this._validAvoirVenteItemQuantiteVendue = value;
    }
    get validAvoirVenteItemPrixUnitaireHt(): boolean {
        return this._validAvoirVenteItemPrixUnitaireHt;
    }
    set validAvoirVenteItemPrixUnitaireHt(value: boolean) {
        this._validAvoirVenteItemPrixUnitaireHt = value;
    }
    get validAvoirVenteItemPrixUnitaireTtc(): boolean {
        return this._validAvoirVenteItemPrixUnitaireTtc;
    }
    set validAvoirVenteItemPrixUnitaireTtc(value: boolean) {
        this._validAvoirVenteItemPrixUnitaireTtc = value;
    }
    get validAvoirVenteItemRemise(): boolean {
        return this._validAvoirVenteItemRemise;
    }
    set validAvoirVenteItemRemise(value: boolean) {
        this._validAvoirVenteItemRemise = value;
    }
    get validAvoirVenteItemMontantHt(): boolean {
        return this._validAvoirVenteItemMontantHt;
    }
    set validAvoirVenteItemMontantHt(value: boolean) {
        this._validAvoirVenteItemMontantHt = value;
    }
    get validAvoirVenteItemMontantTtc(): boolean {
        return this._validAvoirVenteItemMontantTtc;
    }
    set validAvoirVenteItemMontantTtc(value: boolean) {
        this._validAvoirVenteItemMontantTtc = value;
    }

    get validDepotLibelle(): boolean {
        return this._validDepotLibelle;
    }
    set validDepotLibelle(value: boolean) {
        this._validDepotLibelle = value;
    }
    get validProduitReference(): boolean {
        return this._validProduitReference;
    }
    set validProduitReference(value: boolean) {
        this._validProduitReference = value;
    }
    get validProduitBarCode(): boolean {
        return this._validProduitBarCode;
    }
    set validProduitBarCode(value: boolean) {
        this._validProduitBarCode = value;
    }
    get validProduitDesignation(): boolean {
        return this._validProduitDesignation;
    }
    set validProduitDesignation(value: boolean) {
        this._validProduitDesignation = value;
    }
    get validProduitQuantite(): boolean {
        return this._validProduitQuantite;
    }
    set validProduitQuantite(value: boolean) {
        this._validProduitQuantite = value;
    }
    get validProduitPrixVente(): boolean {
        return this._validProduitPrixVente;
    }
    set validProduitPrixVente(value: boolean) {
        this._validProduitPrixVente = value;
    }
    get validProduitSeuilAlerte(): boolean {
        return this._validProduitSeuilAlerte;
    }
    set validProduitSeuilAlerte(value: boolean) {
        this._validProduitSeuilAlerte = value;
    }
    get validTaxeLibelle(): boolean {
        return this._validTaxeLibelle;
    }
    set validTaxeLibelle(value: boolean) {
        this._validTaxeLibelle = value;
    }
    get validAvoirVenteBarCode(): boolean {
        return this._validAvoirVenteBarCode;
    }
    set validAvoirVenteBarCode(value: boolean) {
        this._validAvoirVenteBarCode = value;
    }
    get validAvoirVenteEntrepriseSociete(): boolean {
        return this._validAvoirVenteEntrepriseSociete;
    }
    set validAvoirVenteEntrepriseSociete(value: boolean) {
        this._validAvoirVenteEntrepriseSociete = value;
    }
    get validAvoirVenteCodeAvoirVente(): boolean {
        return this._validAvoirVenteCodeAvoirVente;
    }
    set validAvoirVenteCodeAvoirVente(value: boolean) {
        this._validAvoirVenteCodeAvoirVente = value;
    }
    get validAvoirVenteNumeroFactureAvoirVente(): boolean {
        return this._validAvoirVenteNumeroFactureAvoirVente;
    }
    set validAvoirVenteNumeroFactureAvoirVente(value: boolean) {
        this._validAvoirVenteNumeroFactureAvoirVente = value;
    }
    get validAvoirVenteDateFactureAvoirVente(): boolean {
        return this._validAvoirVenteDateFactureAvoirVente;
    }
    set validAvoirVenteDateFactureAvoirVente(value: boolean) {
        this._validAvoirVenteDateFactureAvoirVente = value;
    }
    get validAvoirVenteClient(): boolean {
        return this._validAvoirVenteClient;
    }
    set validAvoirVenteClient(value: boolean) {
        this._validAvoirVenteClient = value;
    }
    get validAvoirVenteMontantTtc(): boolean {
        return this._validAvoirVenteMontantTtc;
    }
    set validAvoirVenteMontantTtc(value: boolean) {
        this._validAvoirVenteMontantTtc = value;
    }
}
