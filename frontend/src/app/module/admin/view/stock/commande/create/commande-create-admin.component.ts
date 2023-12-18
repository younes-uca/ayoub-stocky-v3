import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-commande-create-admin',
  templateUrl: './commande-create-admin.component.html'
})
export class CommandeCreateAdminComponent extends AbstractCreateController<CommandeDto, CommandeCriteria, CommandeAdminService>  implements OnInit {

    private _commandeItemsElement = new CommandeItemDto();


   private _validCommandeBarCode = true;
   private _validCommandeNumeroCommande = true;
   private _validCommandeDateCommande = true;
   private _validCommandeClient = true;
   private _validCommandeMontantHt = true;
   private _validCommandeMontantTva = true;
   private _validCommandeMontantTtc = true;
    private _validClientCin = true;
    private _validClientNom = true;
    private _validClientTelephone = true;
    private _validEtatCommandeLibelle = true;
    private _validCommandeItemsProduit = true;
    private _validCommandeItemsQuantite = true;
    private _validCommandeItemsPrixUnitaireHt = true;
    private _validCommandeItemsPrixUnitaireTtc = true;
    private _validCommandeItemsRemise = true;
    private _validCommandeItemsMontantHt = true;
    private _validCommandeItemsMontantTtc = true;

    constructor( private commandeService: CommandeAdminService , private clientService: ClientAdminService, private commandeItemService: CommandeItemAdminService, private produitService: ProduitAdminService, private etatCommandeService: EtatCommandeAdminService, private taxeService: TaxeAdminService) {
        super(commandeService);
    }

    ngOnInit(): void {
        this.commandeItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.commandeItemsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.etatCommande = new EtatCommandeDto();
        this.etatCommandeService.findAll().subscribe((data) => this.etatCommandes = data);
    }



    validateCommandeItems(){
        this.errorMessages = new Array();
        this.validateCommandeItemsProduit();
        this.validateCommandeItemsQuantite();
        this.validateCommandeItemsPrixUnitaireHt();
        this.validateCommandeItemsPrixUnitaireTtc();
        this.validateCommandeItemsRemise();
        this.validateCommandeItemsMontantHt();
        this.validateCommandeItemsMontantTtc();
    }


    public setValidation(value: boolean){
        this.validCommandeBarCode = value;
        this.validCommandeNumeroCommande = value;
        this.validCommandeDateCommande = value;
        this.validCommandeClient = value;
        this.validCommandeMontantHt = value;
        this.validCommandeMontantTva = value;
        this.validCommandeMontantTtc = value;
        this.validCommandeItemsProduit = value;
        this.validCommandeItemsQuantite = value;
        this.validCommandeItemsPrixUnitaireHt = value;
        this.validCommandeItemsPrixUnitaireTtc = value;
        this.validCommandeItemsRemise = value;
        this.validCommandeItemsMontantHt = value;
        this.validCommandeItemsMontantTtc = value;
    }

    public addCommandeItems() {
        if( this.item.commandeItems == null )
            this.item.commandeItems = new Array<CommandeItemDto>();
       this.validateCommandeItems();
       if (this.errorMessages.length === 0) {
              this.item.commandeItems.push({... this.commandeItemsElement});
              this.commandeItemsElement = new CommandeItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletecommandeItems(p: CommandeItemDto) {
        this.item.commandeItems.forEach((element, index) => {
            if (element === p) { this.item.commandeItems.splice(index, 1); }
        });
    }

    public editcommandeItems(p: CommandeItemDto) {
        this.commandeItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCommandeBarCode();
        this.validateCommandeNumeroCommande();
        this.validateCommandeDateCommande();
        this.validateCommandeClient();
        this.validateCommandeMontantHt();
        this.validateCommandeMontantTva();
        this.validateCommandeMontantTtc();
    }

    public validateCommandeBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
        this.errorMessages.push('Bar code non valide');
        this.validCommandeBarCode = false;
        } else {
            this.validCommandeBarCode = true;
        }
    }
    public validateCommandeNumeroCommande(){
        if (this.stringUtilService.isEmpty(this.item.numeroCommande)) {
        this.errorMessages.push('Numero commande non valide');
        this.validCommandeNumeroCommande = false;
        } else {
            this.validCommandeNumeroCommande = true;
        }
    }
    public validateCommandeDateCommande(){
        if (this.stringUtilService.isEmpty(this.item.dateCommande)) {
        this.errorMessages.push('Date commande non valide');
        this.validCommandeDateCommande = false;
        } else {
            this.validCommandeDateCommande = true;
        }
    }
    public validateCommandeClient(){
        if (this.stringUtilService.isEmpty(this.item.client)) {
        this.errorMessages.push('Client non valide');
        this.validCommandeClient = false;
        } else {
            this.validCommandeClient = true;
        }
    }
    public validateCommandeMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
        this.errorMessages.push('Montant ht non valide');
        this.validCommandeMontantHt = false;
        } else {
            this.validCommandeMontantHt = true;
        }
    }
    public validateCommandeMontantTva(){
        if (this.stringUtilService.isEmpty(this.item.montantTva)) {
        this.errorMessages.push('Montant tva non valide');
        this.validCommandeMontantTva = false;
        } else {
            this.validCommandeMontantTva = true;
        }
    }
    public validateCommandeMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
        this.errorMessages.push('Montant ttc non valide');
        this.validCommandeMontantTtc = false;
        } else {
            this.validCommandeMontantTtc = true;
        }
    }

    public validateCommandeItemsProduit(){
        if (this.commandeItemsElement.produit == null) {
            this.errorMessages.push('Produit de la commandeItem est  invalide');
            this.validCommandeItemsProduit = false;
        } else {
            this.validCommandeItemsProduit = true;
        }
    }
    public validateCommandeItemsQuantite(){
        if (this.commandeItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la commandeItem est  invalide');
            this.validCommandeItemsQuantite = false;
        } else {
            this.validCommandeItemsQuantite = true;
        }
    }
    public validateCommandeItemsPrixUnitaireHt(){
        if (this.commandeItemsElement.prixUnitaireHt == null) {
            this.errorMessages.push('PrixUnitaireHt de la commandeItem est  invalide');
            this.validCommandeItemsPrixUnitaireHt = false;
        } else {
            this.validCommandeItemsPrixUnitaireHt = true;
        }
    }
    public validateCommandeItemsPrixUnitaireTtc(){
        if (this.commandeItemsElement.prixUnitaireTtc == null) {
            this.errorMessages.push('PrixUnitaireTtc de la commandeItem est  invalide');
            this.validCommandeItemsPrixUnitaireTtc = false;
        } else {
            this.validCommandeItemsPrixUnitaireTtc = true;
        }
    }
    public validateCommandeItemsRemise(){
        if (this.commandeItemsElement.remise == null) {
            this.errorMessages.push('Remise de la commandeItem est  invalide');
            this.validCommandeItemsRemise = false;
        } else {
            this.validCommandeItemsRemise = true;
        }
    }
    public validateCommandeItemsMontantHt(){
        if (this.commandeItemsElement.montantHt == null) {
            this.errorMessages.push('MontantHt de la commandeItem est  invalide');
            this.validCommandeItemsMontantHt = false;
        } else {
            this.validCommandeItemsMontantHt = true;
        }
    }
    public validateCommandeItemsMontantTtc(){
        if (this.commandeItemsElement.montantTtc == null) {
            this.errorMessages.push('MontantTtc de la commandeItem est  invalide');
            this.validCommandeItemsMontantTtc = false;
        } else {
            this.validCommandeItemsMontantTtc = true;
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
    get createClientDialog(): boolean {
       return this.clientService.createDialog;
    }
    set createClientDialog(value: boolean) {
        this.clientService.createDialog= value;
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
    get createEtatCommandeDialog(): boolean {
       return this.etatCommandeService.createDialog;
    }
    set createEtatCommandeDialog(value: boolean) {
        this.etatCommandeService.createDialog= value;
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

    get validClientCin(): boolean {
        return this._validClientCin;
    }
    set validClientCin(value: boolean) {
        this._validClientCin = value;
    }
    get validClientNom(): boolean {
        return this._validClientNom;
    }
    set validClientNom(value: boolean) {
        this._validClientNom = value;
    }
    get validClientTelephone(): boolean {
        return this._validClientTelephone;
    }
    set validClientTelephone(value: boolean) {
        this._validClientTelephone = value;
    }
    get validEtatCommandeLibelle(): boolean {
        return this._validEtatCommandeLibelle;
    }
    set validEtatCommandeLibelle(value: boolean) {
        this._validEtatCommandeLibelle = value;
    }
    get validCommandeItemsProduit(): boolean {
        return this._validCommandeItemsProduit;
    }
    set validCommandeItemsProduit(value: boolean) {
        this._validCommandeItemsProduit = value;
    }
    get validCommandeItemsQuantite(): boolean {
        return this._validCommandeItemsQuantite;
    }
    set validCommandeItemsQuantite(value: boolean) {
        this._validCommandeItemsQuantite = value;
    }
    get validCommandeItemsPrixUnitaireHt(): boolean {
        return this._validCommandeItemsPrixUnitaireHt;
    }
    set validCommandeItemsPrixUnitaireHt(value: boolean) {
        this._validCommandeItemsPrixUnitaireHt = value;
    }
    get validCommandeItemsPrixUnitaireTtc(): boolean {
        return this._validCommandeItemsPrixUnitaireTtc;
    }
    set validCommandeItemsPrixUnitaireTtc(value: boolean) {
        this._validCommandeItemsPrixUnitaireTtc = value;
    }
    get validCommandeItemsRemise(): boolean {
        return this._validCommandeItemsRemise;
    }
    set validCommandeItemsRemise(value: boolean) {
        this._validCommandeItemsRemise = value;
    }
    get validCommandeItemsMontantHt(): boolean {
        return this._validCommandeItemsMontantHt;
    }
    set validCommandeItemsMontantHt(value: boolean) {
        this._validCommandeItemsMontantHt = value;
    }
    get validCommandeItemsMontantTtc(): boolean {
        return this._validCommandeItemsMontantTtc;
    }
    set validCommandeItemsMontantTtc(value: boolean) {
        this._validCommandeItemsMontantTtc = value;
    }

    get commandeItemsElement(): CommandeItemDto {
        if( this._commandeItemsElement == null )
            this._commandeItemsElement = new CommandeItemDto();
        return this._commandeItemsElement;
    }

    set commandeItemsElement(value: CommandeItemDto) {
        this._commandeItemsElement = value;
    }

}
