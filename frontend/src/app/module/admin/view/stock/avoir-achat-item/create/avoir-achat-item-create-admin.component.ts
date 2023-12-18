import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemCriteria} from 'src/app/controller/criteria/stock/AvoirAchatItemCriteria.model';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-avoir-achat-item-create-admin',
  templateUrl: './avoir-achat-item-create-admin.component.html'
})
export class AvoirAchatItemCreateAdminComponent extends AbstractCreateController<AvoirAchatItemDto, AvoirAchatItemCriteria, AvoirAchatItemAdminService>  implements OnInit {



   private _validAvoirAchatItemBarCode = true;
   private _validAvoirAchatItemDepot = true;
   private _validAvoirAchatItemProduit = true;
   private _validAvoirAchatItemQuantite = true;
   private _validAvoirAchatItemQuantiteVendue = true;
   private _validAvoirAchatItemPrixUnitaireHt = true;
   private _validAvoirAchatItemPrixUnitaireTtc = true;
   private _validAvoirAchatItemRemise = true;
   private _validAvoirAchatItemMontantHt = true;
   private _validAvoirAchatItemMontantTtc = true;
    private _validDepotLibelle = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validProduitPrixVente = true;
    private _validProduitSeuilAlerte = true;
    private _validTaxeLibelle = true;
    private _validAvoirAchatBarCode = true;
    private _validAvoirAchatEntrepriseSociete = true;
    private _validAvoirAchatCodeAvoirAchat = true;
    private _validAvoirAchatNumeroFactureAvoirFournisseur = true;
    private _validAvoirAchatDateFactureAvoirFournisseur = true;
    private _validAvoirAchatFournisseur = true;
    private _validAvoirAchatMontantTtc = true;

    constructor( private avoirAchatItemService: AvoirAchatItemAdminService , private depotService: DepotAdminService, private produitService: ProduitAdminService, private avoirAchatService: AvoirAchatAdminService, private taxeService: TaxeAdminService) {
        super(avoirAchatItemService);
    }

    ngOnInit(): void {
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.avoirAchat = new AvoirAchatDto();
        this.avoirAchatService.findAll().subscribe((data) => this.avoirAchats = data);
    }





    public setValidation(value: boolean){
        this.validAvoirAchatItemBarCode = value;
        this.validAvoirAchatItemDepot = value;
        this.validAvoirAchatItemProduit = value;
        this.validAvoirAchatItemQuantite = value;
        this.validAvoirAchatItemQuantiteVendue = value;
        this.validAvoirAchatItemPrixUnitaireHt = value;
        this.validAvoirAchatItemPrixUnitaireTtc = value;
        this.validAvoirAchatItemRemise = value;
        this.validAvoirAchatItemMontantHt = value;
        this.validAvoirAchatItemMontantTtc = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAvoirAchatItemBarCode();
        this.validateAvoirAchatItemDepot();
        this.validateAvoirAchatItemProduit();
        this.validateAvoirAchatItemQuantite();
        this.validateAvoirAchatItemQuantiteVendue();
        this.validateAvoirAchatItemPrixUnitaireHt();
        this.validateAvoirAchatItemPrixUnitaireTtc();
        this.validateAvoirAchatItemRemise();
        this.validateAvoirAchatItemMontantHt();
        this.validateAvoirAchatItemMontantTtc();
    }

    public validateAvoirAchatItemBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
        this.errorMessages.push('Bar code non valide');
        this.validAvoirAchatItemBarCode = false;
        } else {
            this.validAvoirAchatItemBarCode = true;
        }
    }
    public validateAvoirAchatItemDepot(){
        if (this.stringUtilService.isEmpty(this.item.depot)) {
        this.errorMessages.push('Depot non valide');
        this.validAvoirAchatItemDepot = false;
        } else {
            this.validAvoirAchatItemDepot = true;
        }
    }
    public validateAvoirAchatItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
        this.errorMessages.push('Produit non valide');
        this.validAvoirAchatItemProduit = false;
        } else {
            this.validAvoirAchatItemProduit = true;
        }
    }
    public validateAvoirAchatItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
        this.errorMessages.push('Quantite non valide');
        this.validAvoirAchatItemQuantite = false;
        } else {
            this.validAvoirAchatItemQuantite = true;
        }
    }
    public validateAvoirAchatItemQuantiteVendue(){
        if (this.stringUtilService.isEmpty(this.item.quantiteVendue)) {
        this.errorMessages.push('Quantite vendue non valide');
        this.validAvoirAchatItemQuantiteVendue = false;
        } else {
            this.validAvoirAchatItemQuantiteVendue = true;
        }
    }
    public validateAvoirAchatItemPrixUnitaireHt(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireHt)) {
        this.errorMessages.push('Prix unitaire ht non valide');
        this.validAvoirAchatItemPrixUnitaireHt = false;
        } else {
            this.validAvoirAchatItemPrixUnitaireHt = true;
        }
    }
    public validateAvoirAchatItemPrixUnitaireTtc(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireTtc)) {
        this.errorMessages.push('Prix unitaire ttc non valide');
        this.validAvoirAchatItemPrixUnitaireTtc = false;
        } else {
            this.validAvoirAchatItemPrixUnitaireTtc = true;
        }
    }
    public validateAvoirAchatItemRemise(){
        if (this.stringUtilService.isEmpty(this.item.remise)) {
        this.errorMessages.push('Remise non valide');
        this.validAvoirAchatItemRemise = false;
        } else {
            this.validAvoirAchatItemRemise = true;
        }
    }
    public validateAvoirAchatItemMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
        this.errorMessages.push('Montant ht non valide');
        this.validAvoirAchatItemMontantHt = false;
        } else {
            this.validAvoirAchatItemMontantHt = true;
        }
    }
    public validateAvoirAchatItemMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
        this.errorMessages.push('Montant ttc non valide');
        this.validAvoirAchatItemMontantTtc = false;
        } else {
            this.validAvoirAchatItemMontantTtc = true;
        }
    }


    public async openCreateProduit(produit: string) {
    const isPermistted = await this.roleService.isPermitted('Produit', 'add');
    if(isPermistted) {
         this.produit = new ProduitDto();
         this.createProduitDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateTaxe(taxe: string) {
    const isPermistted = await this.roleService.isPermitted('Taxe', 'add');
    if(isPermistted) {
         this.taxe = new TaxeDto();
         this.createTaxeDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateAvoirAchat(avoirAchat: string) {
    const isPermistted = await this.roleService.isPermitted('AvoirAchat', 'add');
    if(isPermistted) {
         this.avoirAchat = new AvoirAchatDto();
         this.createAvoirAchatDialog = true;
    }else{
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
    get avoirAchat(): AvoirAchatDto {
        return this.avoirAchatService.item;
    }
    set avoirAchat(value: AvoirAchatDto) {
        this.avoirAchatService.item = value;
    }
    get avoirAchats(): Array<AvoirAchatDto> {
        return this.avoirAchatService.items;
    }
    set avoirAchats(value: Array<AvoirAchatDto>) {
        this.avoirAchatService.items = value;
    }
    get createAvoirAchatDialog(): boolean {
       return this.avoirAchatService.createDialog;
    }
    set createAvoirAchatDialog(value: boolean) {
        this.avoirAchatService.createDialog= value;
    }



    get validAvoirAchatItemBarCode(): boolean {
        return this._validAvoirAchatItemBarCode;
    }

    set validAvoirAchatItemBarCode(value: boolean) {
         this._validAvoirAchatItemBarCode = value;
    }
    get validAvoirAchatItemDepot(): boolean {
        return this._validAvoirAchatItemDepot;
    }

    set validAvoirAchatItemDepot(value: boolean) {
         this._validAvoirAchatItemDepot = value;
    }
    get validAvoirAchatItemProduit(): boolean {
        return this._validAvoirAchatItemProduit;
    }

    set validAvoirAchatItemProduit(value: boolean) {
         this._validAvoirAchatItemProduit = value;
    }
    get validAvoirAchatItemQuantite(): boolean {
        return this._validAvoirAchatItemQuantite;
    }

    set validAvoirAchatItemQuantite(value: boolean) {
         this._validAvoirAchatItemQuantite = value;
    }
    get validAvoirAchatItemQuantiteVendue(): boolean {
        return this._validAvoirAchatItemQuantiteVendue;
    }

    set validAvoirAchatItemQuantiteVendue(value: boolean) {
         this._validAvoirAchatItemQuantiteVendue = value;
    }
    get validAvoirAchatItemPrixUnitaireHt(): boolean {
        return this._validAvoirAchatItemPrixUnitaireHt;
    }

    set validAvoirAchatItemPrixUnitaireHt(value: boolean) {
         this._validAvoirAchatItemPrixUnitaireHt = value;
    }
    get validAvoirAchatItemPrixUnitaireTtc(): boolean {
        return this._validAvoirAchatItemPrixUnitaireTtc;
    }

    set validAvoirAchatItemPrixUnitaireTtc(value: boolean) {
         this._validAvoirAchatItemPrixUnitaireTtc = value;
    }
    get validAvoirAchatItemRemise(): boolean {
        return this._validAvoirAchatItemRemise;
    }

    set validAvoirAchatItemRemise(value: boolean) {
         this._validAvoirAchatItemRemise = value;
    }
    get validAvoirAchatItemMontantHt(): boolean {
        return this._validAvoirAchatItemMontantHt;
    }

    set validAvoirAchatItemMontantHt(value: boolean) {
         this._validAvoirAchatItemMontantHt = value;
    }
    get validAvoirAchatItemMontantTtc(): boolean {
        return this._validAvoirAchatItemMontantTtc;
    }

    set validAvoirAchatItemMontantTtc(value: boolean) {
         this._validAvoirAchatItemMontantTtc = value;
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
    get validAvoirAchatBarCode(): boolean {
        return this._validAvoirAchatBarCode;
    }
    set validAvoirAchatBarCode(value: boolean) {
        this._validAvoirAchatBarCode = value;
    }
    get validAvoirAchatEntrepriseSociete(): boolean {
        return this._validAvoirAchatEntrepriseSociete;
    }
    set validAvoirAchatEntrepriseSociete(value: boolean) {
        this._validAvoirAchatEntrepriseSociete = value;
    }
    get validAvoirAchatCodeAvoirAchat(): boolean {
        return this._validAvoirAchatCodeAvoirAchat;
    }
    set validAvoirAchatCodeAvoirAchat(value: boolean) {
        this._validAvoirAchatCodeAvoirAchat = value;
    }
    get validAvoirAchatNumeroFactureAvoirFournisseur(): boolean {
        return this._validAvoirAchatNumeroFactureAvoirFournisseur;
    }
    set validAvoirAchatNumeroFactureAvoirFournisseur(value: boolean) {
        this._validAvoirAchatNumeroFactureAvoirFournisseur = value;
    }
    get validAvoirAchatDateFactureAvoirFournisseur(): boolean {
        return this._validAvoirAchatDateFactureAvoirFournisseur;
    }
    set validAvoirAchatDateFactureAvoirFournisseur(value: boolean) {
        this._validAvoirAchatDateFactureAvoirFournisseur = value;
    }
    get validAvoirAchatFournisseur(): boolean {
        return this._validAvoirAchatFournisseur;
    }
    set validAvoirAchatFournisseur(value: boolean) {
        this._validAvoirAchatFournisseur = value;
    }
    get validAvoirAchatMontantTtc(): boolean {
        return this._validAvoirAchatMontantTtc;
    }
    set validAvoirAchatMontantTtc(value: boolean) {
        this._validAvoirAchatMontantTtc = value;
    }


}
