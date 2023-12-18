import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {BonPourItemAdminService} from 'src/app/controller/service/admin/stock/BonPourItemAdmin.service';
import {BonPourItemDto} from 'src/app/controller/model/stock/BonPourItem.model';
import {BonPourItemCriteria} from 'src/app/controller/criteria/stock/BonPourItemCriteria.model';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {BonPourDto} from 'src/app/controller/model/stock/BonPour.model';
import {BonPourAdminService} from 'src/app/controller/service/admin/stock/BonPourAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-bon-pour-item-create-admin',
  templateUrl: './bon-pour-item-create-admin.component.html'
})
export class BonPourItemCreateAdminComponent extends AbstractCreateController<BonPourItemDto, BonPourItemCriteria, BonPourItemAdminService>  implements OnInit {



   private _validBonPourItemProduit = true;
   private _validBonPourItemQuantite = true;
   private _validBonPourItemPrixUnitaireHt = true;
   private _validBonPourItemPrixUnitaireTtc = true;
   private _validBonPourItemRemise = true;
   private _validBonPourItemMontantHt = true;
   private _validBonPourItemMontantTtc = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validProduitPrixVente = true;
    private _validProduitSeuilAlerte = true;
    private _validTaxeLibelle = true;
    private _validBonPourNumero = true;
    private _validBonPourDateBonPour = true;
    private _validBonPourClient = true;
    private _validBonPourMontantTva = true;
    private _validBonPourMontantTtc = true;

    constructor( private bonPourItemService: BonPourItemAdminService , private produitService: ProduitAdminService, private bonPourService: BonPourAdminService, private taxeService: TaxeAdminService) {
        super(bonPourItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.bonPour = new BonPourDto();
        this.bonPourService.findAll().subscribe((data) => this.bonPours = data);
    }





    public setValidation(value: boolean){
        this.validBonPourItemProduit = value;
        this.validBonPourItemQuantite = value;
        this.validBonPourItemPrixUnitaireHt = value;
        this.validBonPourItemPrixUnitaireTtc = value;
        this.validBonPourItemRemise = value;
        this.validBonPourItemMontantHt = value;
        this.validBonPourItemMontantTtc = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateBonPourItemProduit();
        this.validateBonPourItemQuantite();
        this.validateBonPourItemPrixUnitaireHt();
        this.validateBonPourItemPrixUnitaireTtc();
        this.validateBonPourItemRemise();
        this.validateBonPourItemMontantHt();
        this.validateBonPourItemMontantTtc();
    }

    public validateBonPourItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
        this.errorMessages.push('Produit non valide');
        this.validBonPourItemProduit = false;
        } else {
            this.validBonPourItemProduit = true;
        }
    }
    public validateBonPourItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
        this.errorMessages.push('Quantite non valide');
        this.validBonPourItemQuantite = false;
        } else {
            this.validBonPourItemQuantite = true;
        }
    }
    public validateBonPourItemPrixUnitaireHt(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireHt)) {
        this.errorMessages.push('Prix unitaire ht non valide');
        this.validBonPourItemPrixUnitaireHt = false;
        } else {
            this.validBonPourItemPrixUnitaireHt = true;
        }
    }
    public validateBonPourItemPrixUnitaireTtc(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireTtc)) {
        this.errorMessages.push('Prix unitaire ttc non valide');
        this.validBonPourItemPrixUnitaireTtc = false;
        } else {
            this.validBonPourItemPrixUnitaireTtc = true;
        }
    }
    public validateBonPourItemRemise(){
        if (this.stringUtilService.isEmpty(this.item.remise)) {
        this.errorMessages.push('Remise non valide');
        this.validBonPourItemRemise = false;
        } else {
            this.validBonPourItemRemise = true;
        }
    }
    public validateBonPourItemMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
        this.errorMessages.push('Montant ht non valide');
        this.validBonPourItemMontantHt = false;
        } else {
            this.validBonPourItemMontantHt = true;
        }
    }
    public validateBonPourItemMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
        this.errorMessages.push('Montant ttc non valide');
        this.validBonPourItemMontantTtc = false;
        } else {
            this.validBonPourItemMontantTtc = true;
        }
    }


    public async openCreateBonPour(bonPour: string) {
    const isPermistted = await this.roleService.isPermitted('BonPour', 'add');
    if(isPermistted) {
         this.bonPour = new BonPourDto();
         this.createBonPourDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
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

    get bonPour(): BonPourDto {
        return this.bonPourService.item;
    }
    set bonPour(value: BonPourDto) {
        this.bonPourService.item = value;
    }
    get bonPours(): Array<BonPourDto> {
        return this.bonPourService.items;
    }
    set bonPours(value: Array<BonPourDto>) {
        this.bonPourService.items = value;
    }
    get createBonPourDialog(): boolean {
       return this.bonPourService.createDialog;
    }
    set createBonPourDialog(value: boolean) {
        this.bonPourService.createDialog= value;
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



    get validBonPourItemProduit(): boolean {
        return this._validBonPourItemProduit;
    }

    set validBonPourItemProduit(value: boolean) {
         this._validBonPourItemProduit = value;
    }
    get validBonPourItemQuantite(): boolean {
        return this._validBonPourItemQuantite;
    }

    set validBonPourItemQuantite(value: boolean) {
         this._validBonPourItemQuantite = value;
    }
    get validBonPourItemPrixUnitaireHt(): boolean {
        return this._validBonPourItemPrixUnitaireHt;
    }

    set validBonPourItemPrixUnitaireHt(value: boolean) {
         this._validBonPourItemPrixUnitaireHt = value;
    }
    get validBonPourItemPrixUnitaireTtc(): boolean {
        return this._validBonPourItemPrixUnitaireTtc;
    }

    set validBonPourItemPrixUnitaireTtc(value: boolean) {
         this._validBonPourItemPrixUnitaireTtc = value;
    }
    get validBonPourItemRemise(): boolean {
        return this._validBonPourItemRemise;
    }

    set validBonPourItemRemise(value: boolean) {
         this._validBonPourItemRemise = value;
    }
    get validBonPourItemMontantHt(): boolean {
        return this._validBonPourItemMontantHt;
    }

    set validBonPourItemMontantHt(value: boolean) {
         this._validBonPourItemMontantHt = value;
    }
    get validBonPourItemMontantTtc(): boolean {
        return this._validBonPourItemMontantTtc;
    }

    set validBonPourItemMontantTtc(value: boolean) {
         this._validBonPourItemMontantTtc = value;
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
    get validBonPourNumero(): boolean {
        return this._validBonPourNumero;
    }
    set validBonPourNumero(value: boolean) {
        this._validBonPourNumero = value;
    }
    get validBonPourDateBonPour(): boolean {
        return this._validBonPourDateBonPour;
    }
    set validBonPourDateBonPour(value: boolean) {
        this._validBonPourDateBonPour = value;
    }
    get validBonPourClient(): boolean {
        return this._validBonPourClient;
    }
    set validBonPourClient(value: boolean) {
        this._validBonPourClient = value;
    }
    get validBonPourMontantTva(): boolean {
        return this._validBonPourMontantTva;
    }
    set validBonPourMontantTva(value: boolean) {
        this._validBonPourMontantTva = value;
    }
    get validBonPourMontantTtc(): boolean {
        return this._validBonPourMontantTtc;
    }
    set validBonPourMontantTtc(value: boolean) {
        this._validBonPourMontantTtc = value;
    }


}
