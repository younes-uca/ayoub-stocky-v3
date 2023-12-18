import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-devis-item-create-admin',
  templateUrl: './devis-item-create-admin.component.html'
})
export class DevisItemCreateAdminComponent extends AbstractCreateController<DevisItemDto, DevisItemCriteria, DevisItemAdminService>  implements OnInit {



   private _validDevisItemProduit = true;
   private _validDevisItemQuantite = true;
   private _validDevisItemPrixUnitaireHt = true;
   private _validDevisItemPrixUnitaireTtc = true;
   private _validDevisItemRemise = true;
   private _validDevisItemMontantHt = true;
   private _validDevisItemMontantTtc = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validProduitPrixVente = true;
    private _validProduitSeuilAlerte = true;
    private _validTaxeLibelle = true;
    private _validDevisNumero = true;
    private _validDevisDateDevis = true;
    private _validDevisClient = true;
    private _validDevisMontantHt = true;
    private _validDevisMontantTva = true;
    private _validDevisMontantTtc = true;

    constructor( private devisItemService: DevisItemAdminService , private devisService: DevisAdminService, private produitService: ProduitAdminService, private taxeService: TaxeAdminService) {
        super(devisItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.devis = new DevisDto();
        this.devisService.findAll().subscribe((data) => this.deviss = data);
    }





    public setValidation(value: boolean){
        this.validDevisItemProduit = value;
        this.validDevisItemQuantite = value;
        this.validDevisItemPrixUnitaireHt = value;
        this.validDevisItemPrixUnitaireTtc = value;
        this.validDevisItemRemise = value;
        this.validDevisItemMontantHt = value;
        this.validDevisItemMontantTtc = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateDevisItemProduit();
        this.validateDevisItemQuantite();
        this.validateDevisItemPrixUnitaireHt();
        this.validateDevisItemPrixUnitaireTtc();
        this.validateDevisItemRemise();
        this.validateDevisItemMontantHt();
        this.validateDevisItemMontantTtc();
    }

    public validateDevisItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
        this.errorMessages.push('Produit non valide');
        this.validDevisItemProduit = false;
        } else {
            this.validDevisItemProduit = true;
        }
    }
    public validateDevisItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
        this.errorMessages.push('Quantite non valide');
        this.validDevisItemQuantite = false;
        } else {
            this.validDevisItemQuantite = true;
        }
    }
    public validateDevisItemPrixUnitaireHt(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireHt)) {
        this.errorMessages.push('Prix unitaire ht non valide');
        this.validDevisItemPrixUnitaireHt = false;
        } else {
            this.validDevisItemPrixUnitaireHt = true;
        }
    }
    public validateDevisItemPrixUnitaireTtc(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireTtc)) {
        this.errorMessages.push('Prix unitaire ttc non valide');
        this.validDevisItemPrixUnitaireTtc = false;
        } else {
            this.validDevisItemPrixUnitaireTtc = true;
        }
    }
    public validateDevisItemRemise(){
        if (this.stringUtilService.isEmpty(this.item.remise)) {
        this.errorMessages.push('Remise non valide');
        this.validDevisItemRemise = false;
        } else {
            this.validDevisItemRemise = true;
        }
    }
    public validateDevisItemMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
        this.errorMessages.push('Montant ht non valide');
        this.validDevisItemMontantHt = false;
        } else {
            this.validDevisItemMontantHt = true;
        }
    }
    public validateDevisItemMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
        this.errorMessages.push('Montant ttc non valide');
        this.validDevisItemMontantTtc = false;
        } else {
            this.validDevisItemMontantTtc = true;
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
    public async openCreateDevis(devis: string) {
    const isPermistted = await this.roleService.isPermitted('Devis', 'add');
    if(isPermistted) {
         this.devis = new DevisDto();
         this.createDevisDialog = true;
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
    get createDevisDialog(): boolean {
       return this.devisService.createDialog;
    }
    set createDevisDialog(value: boolean) {
        this.devisService.createDialog= value;
    }



    get validDevisItemProduit(): boolean {
        return this._validDevisItemProduit;
    }

    set validDevisItemProduit(value: boolean) {
         this._validDevisItemProduit = value;
    }
    get validDevisItemQuantite(): boolean {
        return this._validDevisItemQuantite;
    }

    set validDevisItemQuantite(value: boolean) {
         this._validDevisItemQuantite = value;
    }
    get validDevisItemPrixUnitaireHt(): boolean {
        return this._validDevisItemPrixUnitaireHt;
    }

    set validDevisItemPrixUnitaireHt(value: boolean) {
         this._validDevisItemPrixUnitaireHt = value;
    }
    get validDevisItemPrixUnitaireTtc(): boolean {
        return this._validDevisItemPrixUnitaireTtc;
    }

    set validDevisItemPrixUnitaireTtc(value: boolean) {
         this._validDevisItemPrixUnitaireTtc = value;
    }
    get validDevisItemRemise(): boolean {
        return this._validDevisItemRemise;
    }

    set validDevisItemRemise(value: boolean) {
         this._validDevisItemRemise = value;
    }
    get validDevisItemMontantHt(): boolean {
        return this._validDevisItemMontantHt;
    }

    set validDevisItemMontantHt(value: boolean) {
         this._validDevisItemMontantHt = value;
    }
    get validDevisItemMontantTtc(): boolean {
        return this._validDevisItemMontantTtc;
    }

    set validDevisItemMontantTtc(value: boolean) {
         this._validDevisItemMontantTtc = value;
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
    get validDevisNumero(): boolean {
        return this._validDevisNumero;
    }
    set validDevisNumero(value: boolean) {
        this._validDevisNumero = value;
    }
    get validDevisDateDevis(): boolean {
        return this._validDevisDateDevis;
    }
    set validDevisDateDevis(value: boolean) {
        this._validDevisDateDevis = value;
    }
    get validDevisClient(): boolean {
        return this._validDevisClient;
    }
    set validDevisClient(value: boolean) {
        this._validDevisClient = value;
    }
    get validDevisMontantHt(): boolean {
        return this._validDevisMontantHt;
    }
    set validDevisMontantHt(value: boolean) {
        this._validDevisMontantHt = value;
    }
    get validDevisMontantTva(): boolean {
        return this._validDevisMontantTva;
    }
    set validDevisMontantTva(value: boolean) {
        this._validDevisMontantTva = value;
    }
    get validDevisMontantTtc(): boolean {
        return this._validDevisMontantTtc;
    }
    set validDevisMontantTtc(value: boolean) {
        this._validDevisMontantTtc = value;
    }


}
