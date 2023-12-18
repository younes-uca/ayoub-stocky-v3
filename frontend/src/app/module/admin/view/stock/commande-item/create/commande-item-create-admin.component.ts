import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CommandeItemAdminService} from 'src/app/controller/service/admin/stock/CommandeItemAdmin.service';
import {CommandeItemDto} from 'src/app/controller/model/stock/CommandeItem.model';
import {CommandeItemCriteria} from 'src/app/controller/criteria/stock/CommandeItemCriteria.model';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {CommandeDto} from 'src/app/controller/model/stock/Commande.model';
import {CommandeAdminService} from 'src/app/controller/service/admin/stock/CommandeAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-commande-item-create-admin',
  templateUrl: './commande-item-create-admin.component.html'
})
export class CommandeItemCreateAdminComponent extends AbstractCreateController<CommandeItemDto, CommandeItemCriteria, CommandeItemAdminService>  implements OnInit {



   private _validCommandeItemProduit = true;
   private _validCommandeItemQuantite = true;
   private _validCommandeItemPrixUnitaireHt = true;
   private _validCommandeItemPrixUnitaireTtc = true;
   private _validCommandeItemRemise = true;
   private _validCommandeItemMontantHt = true;
   private _validCommandeItemMontantTtc = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validProduitPrixVente = true;
    private _validProduitSeuilAlerte = true;
    private _validTaxeLibelle = true;
    private _validCommandeBarCode = true;
    private _validCommandeNumeroCommande = true;
    private _validCommandeDateCommande = true;
    private _validCommandeClient = true;
    private _validCommandeMontantHt = true;
    private _validCommandeMontantTva = true;
    private _validCommandeMontantTtc = true;

    constructor( private commandeItemService: CommandeItemAdminService , private produitService: ProduitAdminService, private commandeService: CommandeAdminService, private taxeService: TaxeAdminService) {
        super(commandeItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.commande = new CommandeDto();
        this.commandeService.findAll().subscribe((data) => this.commandes = data);
    }





    public setValidation(value: boolean){
        this.validCommandeItemProduit = value;
        this.validCommandeItemQuantite = value;
        this.validCommandeItemPrixUnitaireHt = value;
        this.validCommandeItemPrixUnitaireTtc = value;
        this.validCommandeItemRemise = value;
        this.validCommandeItemMontantHt = value;
        this.validCommandeItemMontantTtc = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCommandeItemProduit();
        this.validateCommandeItemQuantite();
        this.validateCommandeItemPrixUnitaireHt();
        this.validateCommandeItemPrixUnitaireTtc();
        this.validateCommandeItemRemise();
        this.validateCommandeItemMontantHt();
        this.validateCommandeItemMontantTtc();
    }

    public validateCommandeItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
        this.errorMessages.push('Produit non valide');
        this.validCommandeItemProduit = false;
        } else {
            this.validCommandeItemProduit = true;
        }
    }
    public validateCommandeItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
        this.errorMessages.push('Quantite non valide');
        this.validCommandeItemQuantite = false;
        } else {
            this.validCommandeItemQuantite = true;
        }
    }
    public validateCommandeItemPrixUnitaireHt(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireHt)) {
        this.errorMessages.push('Prix unitaire ht non valide');
        this.validCommandeItemPrixUnitaireHt = false;
        } else {
            this.validCommandeItemPrixUnitaireHt = true;
        }
    }
    public validateCommandeItemPrixUnitaireTtc(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireTtc)) {
        this.errorMessages.push('Prix unitaire ttc non valide');
        this.validCommandeItemPrixUnitaireTtc = false;
        } else {
            this.validCommandeItemPrixUnitaireTtc = true;
        }
    }
    public validateCommandeItemRemise(){
        if (this.stringUtilService.isEmpty(this.item.remise)) {
        this.errorMessages.push('Remise non valide');
        this.validCommandeItemRemise = false;
        } else {
            this.validCommandeItemRemise = true;
        }
    }
    public validateCommandeItemMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
        this.errorMessages.push('Montant ht non valide');
        this.validCommandeItemMontantHt = false;
        } else {
            this.validCommandeItemMontantHt = true;
        }
    }
    public validateCommandeItemMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
        this.errorMessages.push('Montant ttc non valide');
        this.validCommandeItemMontantTtc = false;
        } else {
            this.validCommandeItemMontantTtc = true;
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
    public async openCreateCommande(commande: string) {
    const isPermistted = await this.roleService.isPermitted('Commande', 'add');
    if(isPermistted) {
         this.commande = new CommandeDto();
         this.createCommandeDialog = true;
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
    get commande(): CommandeDto {
        return this.commandeService.item;
    }
    set commande(value: CommandeDto) {
        this.commandeService.item = value;
    }
    get commandes(): Array<CommandeDto> {
        return this.commandeService.items;
    }
    set commandes(value: Array<CommandeDto>) {
        this.commandeService.items = value;
    }
    get createCommandeDialog(): boolean {
       return this.commandeService.createDialog;
    }
    set createCommandeDialog(value: boolean) {
        this.commandeService.createDialog= value;
    }



    get validCommandeItemProduit(): boolean {
        return this._validCommandeItemProduit;
    }

    set validCommandeItemProduit(value: boolean) {
         this._validCommandeItemProduit = value;
    }
    get validCommandeItemQuantite(): boolean {
        return this._validCommandeItemQuantite;
    }

    set validCommandeItemQuantite(value: boolean) {
         this._validCommandeItemQuantite = value;
    }
    get validCommandeItemPrixUnitaireHt(): boolean {
        return this._validCommandeItemPrixUnitaireHt;
    }

    set validCommandeItemPrixUnitaireHt(value: boolean) {
         this._validCommandeItemPrixUnitaireHt = value;
    }
    get validCommandeItemPrixUnitaireTtc(): boolean {
        return this._validCommandeItemPrixUnitaireTtc;
    }

    set validCommandeItemPrixUnitaireTtc(value: boolean) {
         this._validCommandeItemPrixUnitaireTtc = value;
    }
    get validCommandeItemRemise(): boolean {
        return this._validCommandeItemRemise;
    }

    set validCommandeItemRemise(value: boolean) {
         this._validCommandeItemRemise = value;
    }
    get validCommandeItemMontantHt(): boolean {
        return this._validCommandeItemMontantHt;
    }

    set validCommandeItemMontantHt(value: boolean) {
         this._validCommandeItemMontantHt = value;
    }
    get validCommandeItemMontantTtc(): boolean {
        return this._validCommandeItemMontantTtc;
    }

    set validCommandeItemMontantTtc(value: boolean) {
         this._validCommandeItemMontantTtc = value;
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
    get validCommandeBarCode(): boolean {
        return this._validCommandeBarCode;
    }
    set validCommandeBarCode(value: boolean) {
        this._validCommandeBarCode = value;
    }
    get validCommandeNumeroCommande(): boolean {
        return this._validCommandeNumeroCommande;
    }
    set validCommandeNumeroCommande(value: boolean) {
        this._validCommandeNumeroCommande = value;
    }
    get validCommandeDateCommande(): boolean {
        return this._validCommandeDateCommande;
    }
    set validCommandeDateCommande(value: boolean) {
        this._validCommandeDateCommande = value;
    }
    get validCommandeClient(): boolean {
        return this._validCommandeClient;
    }
    set validCommandeClient(value: boolean) {
        this._validCommandeClient = value;
    }
    get validCommandeMontantHt(): boolean {
        return this._validCommandeMontantHt;
    }
    set validCommandeMontantHt(value: boolean) {
        this._validCommandeMontantHt = value;
    }
    get validCommandeMontantTva(): boolean {
        return this._validCommandeMontantTva;
    }
    set validCommandeMontantTva(value: boolean) {
        this._validCommandeMontantTva = value;
    }
    get validCommandeMontantTtc(): boolean {
        return this._validCommandeMontantTtc;
    }
    set validCommandeMontantTtc(value: boolean) {
        this._validCommandeMontantTtc = value;
    }


}
