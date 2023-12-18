import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-devis-create-admin',
  templateUrl: './devis-create-admin.component.html'
})
export class DevisCreateAdminComponent extends AbstractCreateController<DevisDto, DevisCriteria, DevisAdminService>  implements OnInit {

    private _devisItemsElement = new DevisItemDto();


   private _validDevisNumero = true;
   private _validDevisDateDevis = true;
   private _validDevisClient = true;
   private _validDevisMontantHt = true;
   private _validDevisMontantTva = true;
   private _validDevisMontantTtc = true;
    private _validClientCin = true;
    private _validClientNom = true;
    private _validClientTelephone = true;
    private _validDevisItemsProduit = true;
    private _validDevisItemsQuantite = true;
    private _validDevisItemsPrixUnitaireHt = true;
    private _validDevisItemsPrixUnitaireTtc = true;
    private _validDevisItemsRemise = true;
    private _validDevisItemsMontantHt = true;
    private _validDevisItemsMontantTtc = true;

    constructor( private devisService: DevisAdminService , private clientService: ClientAdminService, private produitService: ProduitAdminService, private devisItemService: DevisItemAdminService, private taxeService: TaxeAdminService) {
        super(devisService);
    }

    ngOnInit(): void {
        this.devisItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.devisItemsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
    }



    validateDevisItems(){
        this.errorMessages = new Array();
        this.validateDevisItemsProduit();
        this.validateDevisItemsQuantite();
        this.validateDevisItemsPrixUnitaireHt();
        this.validateDevisItemsPrixUnitaireTtc();
        this.validateDevisItemsRemise();
        this.validateDevisItemsMontantHt();
        this.validateDevisItemsMontantTtc();
    }


    public setValidation(value: boolean){
        this.validDevisNumero = value;
        this.validDevisDateDevis = value;
        this.validDevisClient = value;
        this.validDevisMontantHt = value;
        this.validDevisMontantTva = value;
        this.validDevisMontantTtc = value;
        this.validDevisItemsProduit = value;
        this.validDevisItemsQuantite = value;
        this.validDevisItemsPrixUnitaireHt = value;
        this.validDevisItemsPrixUnitaireTtc = value;
        this.validDevisItemsRemise = value;
        this.validDevisItemsMontantHt = value;
        this.validDevisItemsMontantTtc = value;
    }

    public addDevisItems() {
        if( this.item.devisItems == null )
            this.item.devisItems = new Array<DevisItemDto>();
       this.validateDevisItems();
       if (this.errorMessages.length === 0) {
              this.item.devisItems.push({... this.devisItemsElement});
              this.devisItemsElement = new DevisItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletedevisItems(p: DevisItemDto) {
        this.item.devisItems.forEach((element, index) => {
            if (element === p) { this.item.devisItems.splice(index, 1); }
        });
    }

    public editdevisItems(p: DevisItemDto) {
        this.devisItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateDevisNumero();
        this.validateDevisDateDevis();
        this.validateDevisClient();
        this.validateDevisMontantHt();
        this.validateDevisMontantTva();
        this.validateDevisMontantTtc();
    }

    public validateDevisNumero(){
        if (this.stringUtilService.isEmpty(this.item.numero)) {
        this.errorMessages.push('Numero non valide');
        this.validDevisNumero = false;
        } else {
            this.validDevisNumero = true;
        }
    }
    public validateDevisDateDevis(){
        if (this.stringUtilService.isEmpty(this.item.dateDevis)) {
        this.errorMessages.push('Date devis non valide');
        this.validDevisDateDevis = false;
        } else {
            this.validDevisDateDevis = true;
        }
    }
    public validateDevisClient(){
        if (this.stringUtilService.isEmpty(this.item.client)) {
        this.errorMessages.push('Client non valide');
        this.validDevisClient = false;
        } else {
            this.validDevisClient = true;
        }
    }
    public validateDevisMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
        this.errorMessages.push('Montant ht non valide');
        this.validDevisMontantHt = false;
        } else {
            this.validDevisMontantHt = true;
        }
    }
    public validateDevisMontantTva(){
        if (this.stringUtilService.isEmpty(this.item.montantTva)) {
        this.errorMessages.push('Montant tva non valide');
        this.validDevisMontantTva = false;
        } else {
            this.validDevisMontantTva = true;
        }
    }
    public validateDevisMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
        this.errorMessages.push('Montant ttc non valide');
        this.validDevisMontantTtc = false;
        } else {
            this.validDevisMontantTtc = true;
        }
    }

    public validateDevisItemsProduit(){
        if (this.devisItemsElement.produit == null) {
            this.errorMessages.push('Produit de la devisItem est  invalide');
            this.validDevisItemsProduit = false;
        } else {
            this.validDevisItemsProduit = true;
        }
    }
    public validateDevisItemsQuantite(){
        if (this.devisItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la devisItem est  invalide');
            this.validDevisItemsQuantite = false;
        } else {
            this.validDevisItemsQuantite = true;
        }
    }
    public validateDevisItemsPrixUnitaireHt(){
        if (this.devisItemsElement.prixUnitaireHt == null) {
            this.errorMessages.push('PrixUnitaireHt de la devisItem est  invalide');
            this.validDevisItemsPrixUnitaireHt = false;
        } else {
            this.validDevisItemsPrixUnitaireHt = true;
        }
    }
    public validateDevisItemsPrixUnitaireTtc(){
        if (this.devisItemsElement.prixUnitaireTtc == null) {
            this.errorMessages.push('PrixUnitaireTtc de la devisItem est  invalide');
            this.validDevisItemsPrixUnitaireTtc = false;
        } else {
            this.validDevisItemsPrixUnitaireTtc = true;
        }
    }
    public validateDevisItemsRemise(){
        if (this.devisItemsElement.remise == null) {
            this.errorMessages.push('Remise de la devisItem est  invalide');
            this.validDevisItemsRemise = false;
        } else {
            this.validDevisItemsRemise = true;
        }
    }
    public validateDevisItemsMontantHt(){
        if (this.devisItemsElement.montantHt == null) {
            this.errorMessages.push('MontantHt de la devisItem est  invalide');
            this.validDevisItemsMontantHt = false;
        } else {
            this.validDevisItemsMontantHt = true;
        }
    }
    public validateDevisItemsMontantTtc(){
        if (this.devisItemsElement.montantTtc == null) {
            this.errorMessages.push('MontantTtc de la devisItem est  invalide');
            this.validDevisItemsMontantTtc = false;
        } else {
            this.validDevisItemsMontantTtc = true;
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
    get validDevisItemsProduit(): boolean {
        return this._validDevisItemsProduit;
    }
    set validDevisItemsProduit(value: boolean) {
        this._validDevisItemsProduit = value;
    }
    get validDevisItemsQuantite(): boolean {
        return this._validDevisItemsQuantite;
    }
    set validDevisItemsQuantite(value: boolean) {
        this._validDevisItemsQuantite = value;
    }
    get validDevisItemsPrixUnitaireHt(): boolean {
        return this._validDevisItemsPrixUnitaireHt;
    }
    set validDevisItemsPrixUnitaireHt(value: boolean) {
        this._validDevisItemsPrixUnitaireHt = value;
    }
    get validDevisItemsPrixUnitaireTtc(): boolean {
        return this._validDevisItemsPrixUnitaireTtc;
    }
    set validDevisItemsPrixUnitaireTtc(value: boolean) {
        this._validDevisItemsPrixUnitaireTtc = value;
    }
    get validDevisItemsRemise(): boolean {
        return this._validDevisItemsRemise;
    }
    set validDevisItemsRemise(value: boolean) {
        this._validDevisItemsRemise = value;
    }
    get validDevisItemsMontantHt(): boolean {
        return this._validDevisItemsMontantHt;
    }
    set validDevisItemsMontantHt(value: boolean) {
        this._validDevisItemsMontantHt = value;
    }
    get validDevisItemsMontantTtc(): boolean {
        return this._validDevisItemsMontantTtc;
    }
    set validDevisItemsMontantTtc(value: boolean) {
        this._validDevisItemsMontantTtc = value;
    }

    get devisItemsElement(): DevisItemDto {
        if( this._devisItemsElement == null )
            this._devisItemsElement = new DevisItemDto();
        return this._devisItemsElement;
    }

    set devisItemsElement(value: DevisItemDto) {
        this._devisItemsElement = value;
    }

}
