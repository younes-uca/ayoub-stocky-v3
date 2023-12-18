import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-achat-edit-admin',
  templateUrl: './achat-edit-admin.component.html'
})
export class AchatEditAdminComponent extends AbstractEditController<AchatDto, AchatCriteria, AchatAdminService>   implements OnInit {

    private _achatItemsElement = new AchatItemDto();
    private _avoirAchatsElement = new AvoirAchatDto();

    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;
    private _validAchatMontantHt = true;
    private _validAchatMontantTva = true;
    private _validAchatMontantTtc = true;

    private _validEntrepriseSocieteNom = true;
    private _validFournisseurIce = true;
    private _validFournisseurNom = true;
    private _validFournisseurTelephone = true;
    private _validEtatAchatLibelle = true;
    private _validAchatItemsBarCode = true;
    private _validAchatItemsFooterBarCode = true;
    private _validAchatItemsQuantite = true;
    private _validAchatItemsPrixUnitaireHt = true;
    private _validAchatItemsPrixUnitaireTtc = true;
    private _validAchatItemsRemise = true;
    private _validAchatItemsMontantHt = true;
    private _validAchatItemsMontantTtc = true;
    private _validAvoirAchatsBarCode = true;
    private _validAvoirAchatsEntrepriseSociete = true;
    private _validAvoirAchatsCodeAvoirAchat = true;
    private _validAvoirAchatsNumeroFactureAvoirFournisseur = true;
    private _validAvoirAchatsDateFactureAvoirFournisseur = true;
    private _validAvoirAchatsFournisseur = true;
    private _validAvoirAchatsMontantTtc = true;



    constructor( private achatService: AchatAdminService , private etatAchatService: EtatAchatAdminService, private depotService: DepotAdminService, private achatItemService: AchatItemAdminService, private produitService: ProduitAdminService, private avoirAchatService: AvoirAchatAdminService, private etatAvoirAchatService: EtatAvoirAchatAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private fournisseurService: FournisseurAdminService, private taxeService: TaxeAdminService) {
        super(achatService);
    }

    ngOnInit(): void {
        this.achatItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.achatItemsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.achatItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);

        this.avoirAchatsElement.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.avoirAchatsElement.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
        this.avoirAchatsElement.etatAvoirAchat = new EtatAvoirAchatDto();
        this.etatAvoirAchatService.findAll().subscribe((data) => this.etatAvoirAchats = data);

        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
        this.etatAchat = new EtatAchatDto();
        this.etatAchatService.findAll().subscribe((data) => this.etatAchats = data);
    }
    public prepareEdit() {
        this.item.dateFacture = this.achatService.format(this.item.dateFacture);
    }



    public validateAchatItems(){
        this.errorMessages = new Array();
        this.validateAchatItemsBarCode();
        this.validateAchatItemsFooterBarCode();
        this.validateAchatItemsQuantite();
        this.validateAchatItemsPrixUnitaireHt();
        this.validateAchatItemsPrixUnitaireTtc();
        this.validateAchatItemsRemise();
        this.validateAchatItemsMontantHt();
        this.validateAchatItemsMontantTtc();
    }
    public validateAvoirAchats(){
        this.errorMessages = new Array();
        this.validateAvoirAchatsBarCode();
        this.validateAvoirAchatsEntrepriseSociete();
        this.validateAvoirAchatsCodeAvoirAchat();
        this.validateAvoirAchatsNumeroFactureAvoirFournisseur();
        this.validateAvoirAchatsDateFactureAvoirFournisseur();
        this.validateAvoirAchatsFournisseur();
        this.validateAvoirAchatsMontantTtc();
    }
    public setValidation(value: boolean){
        this.validAchatDateFacture = value;
        this.validAchatFournisseur = value;
        this.validAchatMontantHt = value;
        this.validAchatMontantTva = value;
        this.validAchatMontantTtc = value;
        this.validAchatItemsBarCode = value;
        this.validAchatItemsFooterBarCode = value;
        this.validAchatItemsQuantite = value;
        this.validAchatItemsPrixUnitaireHt = value;
        this.validAchatItemsPrixUnitaireTtc = value;
        this.validAchatItemsRemise = value;
        this.validAchatItemsMontantHt = value;
        this.validAchatItemsMontantTtc = value;
        this.validAvoirAchatsBarCode = value;
        this.validAvoirAchatsEntrepriseSociete = value;
        this.validAvoirAchatsCodeAvoirAchat = value;
        this.validAvoirAchatsNumeroFactureAvoirFournisseur = value;
        this.validAvoirAchatsDateFactureAvoirFournisseur = value;
        this.validAvoirAchatsFournisseur = value;
        this.validAvoirAchatsMontantTtc = value;
        }
   public addAchatItems() {
        if( this.item.achatItems == null )
            this.item.achatItems = new Array<AchatItemDto>();
       this.validateAchatItems();
       if (this.errorMessages.length === 0) {
            if(this.achatItemsElement.id == null){
                this.item.achatItems.push(this.achatItemsElement);
            }else{
                const index = this.item.achatItems.findIndex(e => e.id == this.achatItemsElement.id);
                this.item.achatItems[index] = this.achatItemsElement;
            }
          this.achatItemsElement = new AchatItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAchatItems(p: AchatItemDto) {
        this.item.achatItems.forEach((element, index) => {
            if (element === p) { this.item.achatItems.splice(index, 1); }
        });
    }

    public editAchatItems(p: AchatItemDto) {
        this.achatItemsElement = {... p};
        this.activeTab = 0;
    }
   public addAvoirAchats() {
        if( this.item.avoirAchats == null )
            this.item.avoirAchats = new Array<AvoirAchatDto>();
       this.validateAvoirAchats();
       if (this.errorMessages.length === 0) {
            if(this.avoirAchatsElement.id == null){
                this.item.avoirAchats.push(this.avoirAchatsElement);
            }else{
                const index = this.item.avoirAchats.findIndex(e => e.id == this.avoirAchatsElement.id);
                this.item.avoirAchats[index] = this.avoirAchatsElement;
            }
          this.avoirAchatsElement = new AvoirAchatDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirAchats(p: AvoirAchatDto) {
        this.item.avoirAchats.forEach((element, index) => {
            if (element === p) { this.item.avoirAchats.splice(index, 1); }
        });
    }

    public editAvoirAchats(p: AvoirAchatDto) {
        this.avoirAchatsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAchatDateFacture();
        this.validateAchatFournisseur();
        this.validateAchatMontantHt();
        this.validateAchatMontantTva();
        this.validateAchatMontantTtc();
    }
    public validateAchatDateFacture(){
        if (this.stringUtilService.isEmpty(this.item.dateFacture)) {
            this.errorMessages.push('Date facture non valide');
            this.validAchatDateFacture = false;
        } else {
            this.validAchatDateFacture = true;
        }
    }
    public validateAchatFournisseur(){
        if (this.stringUtilService.isEmpty(this.item.fournisseur)) {
            this.errorMessages.push('Fournisseur non valide');
            this.validAchatFournisseur = false;
        } else {
            this.validAchatFournisseur = true;
        }
    }
    public validateAchatMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
            this.errorMessages.push('Montant ht non valide');
            this.validAchatMontantHt = false;
        } else {
            this.validAchatMontantHt = true;
        }
    }
    public validateAchatMontantTva(){
        if (this.stringUtilService.isEmpty(this.item.montantTva)) {
            this.errorMessages.push('Montant tva non valide');
            this.validAchatMontantTva = false;
        } else {
            this.validAchatMontantTva = true;
        }
    }
    public validateAchatMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
            this.errorMessages.push('Montant ttc non valide');
            this.validAchatMontantTtc = false;
        } else {
            this.validAchatMontantTtc = true;
        }
    }


    private validateAchatItemsBarCode(){
        if (this.achatItemsElement.barCode == null) {
        this.errorMessages.push('BarCode de la achatItem est  invalide');
            this.validAchatItemsBarCode = false;
        } else {
            this.validAchatItemsBarCode = true;
        }
    }
    private validateAchatItemsFooterBarCode(){
        if (this.achatItemsElement.footerBarCode == null) {
        this.errorMessages.push('FooterBarCode de la achatItem est  invalide');
            this.validAchatItemsFooterBarCode = false;
        } else {
            this.validAchatItemsFooterBarCode = true;
        }
    }
    private validateAchatItemsQuantite(){
        if (this.achatItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la achatItem est  invalide');
            this.validAchatItemsQuantite = false;
        } else {
            this.validAchatItemsQuantite = true;
        }
    }
    private validateAchatItemsPrixUnitaireHt(){
        if (this.achatItemsElement.prixUnitaireHt == null) {
        this.errorMessages.push('PrixUnitaireHt de la achatItem est  invalide');
            this.validAchatItemsPrixUnitaireHt = false;
        } else {
            this.validAchatItemsPrixUnitaireHt = true;
        }
    }
    private validateAchatItemsPrixUnitaireTtc(){
        if (this.achatItemsElement.prixUnitaireTtc == null) {
        this.errorMessages.push('PrixUnitaireTtc de la achatItem est  invalide');
            this.validAchatItemsPrixUnitaireTtc = false;
        } else {
            this.validAchatItemsPrixUnitaireTtc = true;
        }
    }
    private validateAchatItemsRemise(){
        if (this.achatItemsElement.remise == null) {
        this.errorMessages.push('Remise de la achatItem est  invalide');
            this.validAchatItemsRemise = false;
        } else {
            this.validAchatItemsRemise = true;
        }
    }
    private validateAchatItemsMontantHt(){
        if (this.achatItemsElement.montantHt == null) {
        this.errorMessages.push('MontantHt de la achatItem est  invalide');
            this.validAchatItemsMontantHt = false;
        } else {
            this.validAchatItemsMontantHt = true;
        }
    }
    private validateAchatItemsMontantTtc(){
        if (this.achatItemsElement.montantTtc == null) {
        this.errorMessages.push('MontantTtc de la achatItem est  invalide');
            this.validAchatItemsMontantTtc = false;
        } else {
            this.validAchatItemsMontantTtc = true;
        }
    }
    private validateAvoirAchatsBarCode(){
        if (this.avoirAchatsElement.barCode == null) {
        this.errorMessages.push('BarCode de la avoirAchat est  invalide');
            this.validAvoirAchatsBarCode = false;
        } else {
            this.validAvoirAchatsBarCode = true;
        }
    }
    private validateAvoirAchatsEntrepriseSociete(){
        if (this.avoirAchatsElement.entrepriseSociete == null) {
        this.errorMessages.push('EntrepriseSociete de la avoirAchat est  invalide');
            this.validAvoirAchatsEntrepriseSociete = false;
        } else {
            this.validAvoirAchatsEntrepriseSociete = true;
        }
    }
    private validateAvoirAchatsCodeAvoirAchat(){
        if (this.avoirAchatsElement.codeAvoirAchat == null) {
        this.errorMessages.push('CodeAvoirAchat de la avoirAchat est  invalide');
            this.validAvoirAchatsCodeAvoirAchat = false;
        } else {
            this.validAvoirAchatsCodeAvoirAchat = true;
        }
    }
    private validateAvoirAchatsNumeroFactureAvoirFournisseur(){
        if (this.avoirAchatsElement.numeroFactureAvoirFournisseur == null) {
        this.errorMessages.push('NumeroFactureAvoirFournisseur de la avoirAchat est  invalide');
            this.validAvoirAchatsNumeroFactureAvoirFournisseur = false;
        } else {
            this.validAvoirAchatsNumeroFactureAvoirFournisseur = true;
        }
    }
    private validateAvoirAchatsDateFactureAvoirFournisseur(){
        if (this.avoirAchatsElement.dateFactureAvoirFournisseur == null) {
        this.errorMessages.push('DateFactureAvoirFournisseur de la avoirAchat est  invalide');
            this.validAvoirAchatsDateFactureAvoirFournisseur = false;
        } else {
            this.validAvoirAchatsDateFactureAvoirFournisseur = true;
        }
    }
    private validateAvoirAchatsFournisseur(){
        if (this.avoirAchatsElement.fournisseur == null) {
        this.errorMessages.push('Fournisseur de la avoirAchat est  invalide');
            this.validAvoirAchatsFournisseur = false;
        } else {
            this.validAvoirAchatsFournisseur = true;
        }
    }
    private validateAvoirAchatsMontantTtc(){
        if (this.avoirAchatsElement.montantTtc == null) {
        this.errorMessages.push('MontantTtc de la avoirAchat est  invalide');
            this.validAvoirAchatsMontantTtc = false;
        } else {
            this.validAvoirAchatsMontantTtc = true;
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
   get createEtatAvoirAchatDialog(): boolean {
       return this.etatAvoirAchatService.createDialog;
   }
  set createEtatAvoirAchatDialog(value: boolean) {
       this.etatAvoirAchatService.createDialog= value;
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
   get createEtatAchatDialog(): boolean {
       return this.etatAchatService.createDialog;
   }
  set createEtatAchatDialog(value: boolean) {
       this.etatAchatService.createDialog= value;
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
   get createEntrepriseSocieteDialog(): boolean {
       return this.entrepriseSocieteService.createDialog;
   }
  set createEntrepriseSocieteDialog(value: boolean) {
       this.entrepriseSocieteService.createDialog= value;
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

    get achatItemsElement(): AchatItemDto {
        if( this._achatItemsElement == null )
            this._achatItemsElement = new AchatItemDto();
         return this._achatItemsElement;
    }

    set achatItemsElement(value: AchatItemDto) {
        this._achatItemsElement = value;
    }
    get avoirAchatsElement(): AvoirAchatDto {
        if( this._avoirAchatsElement == null )
            this._avoirAchatsElement = new AvoirAchatDto();
         return this._avoirAchatsElement;
    }

    set avoirAchatsElement(value: AvoirAchatDto) {
        this._avoirAchatsElement = value;
    }

    get validAchatDateFacture(): boolean {
        return this._validAchatDateFacture;
    }
    set validAchatDateFacture(value: boolean) {
        this._validAchatDateFacture = value;
    }
    get validAchatFournisseur(): boolean {
        return this._validAchatFournisseur;
    }
    set validAchatFournisseur(value: boolean) {
        this._validAchatFournisseur = value;
    }
    get validAchatMontantHt(): boolean {
        return this._validAchatMontantHt;
    }
    set validAchatMontantHt(value: boolean) {
        this._validAchatMontantHt = value;
    }
    get validAchatMontantTva(): boolean {
        return this._validAchatMontantTva;
    }
    set validAchatMontantTva(value: boolean) {
        this._validAchatMontantTva = value;
    }
    get validAchatMontantTtc(): boolean {
        return this._validAchatMontantTtc;
    }
    set validAchatMontantTtc(value: boolean) {
        this._validAchatMontantTtc = value;
    }

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
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
    get validEtatAchatLibelle(): boolean {
        return this._validEtatAchatLibelle;
    }
    set validEtatAchatLibelle(value: boolean) {
        this._validEtatAchatLibelle = value;
    }
    get validAchatItemsBarCode(): boolean {
        return this._validAchatItemsBarCode;
    }
    set validAchatItemsBarCode(value: boolean) {
        this._validAchatItemsBarCode = value;
    }
    get validAchatItemsFooterBarCode(): boolean {
        return this._validAchatItemsFooterBarCode;
    }
    set validAchatItemsFooterBarCode(value: boolean) {
        this._validAchatItemsFooterBarCode = value;
    }
    get validAchatItemsQuantite(): boolean {
        return this._validAchatItemsQuantite;
    }
    set validAchatItemsQuantite(value: boolean) {
        this._validAchatItemsQuantite = value;
    }
    get validAchatItemsPrixUnitaireHt(): boolean {
        return this._validAchatItemsPrixUnitaireHt;
    }
    set validAchatItemsPrixUnitaireHt(value: boolean) {
        this._validAchatItemsPrixUnitaireHt = value;
    }
    get validAchatItemsPrixUnitaireTtc(): boolean {
        return this._validAchatItemsPrixUnitaireTtc;
    }
    set validAchatItemsPrixUnitaireTtc(value: boolean) {
        this._validAchatItemsPrixUnitaireTtc = value;
    }
    get validAchatItemsRemise(): boolean {
        return this._validAchatItemsRemise;
    }
    set validAchatItemsRemise(value: boolean) {
        this._validAchatItemsRemise = value;
    }
    get validAchatItemsMontantHt(): boolean {
        return this._validAchatItemsMontantHt;
    }
    set validAchatItemsMontantHt(value: boolean) {
        this._validAchatItemsMontantHt = value;
    }
    get validAchatItemsMontantTtc(): boolean {
        return this._validAchatItemsMontantTtc;
    }
    set validAchatItemsMontantTtc(value: boolean) {
        this._validAchatItemsMontantTtc = value;
    }
    get validAvoirAchatsBarCode(): boolean {
        return this._validAvoirAchatsBarCode;
    }
    set validAvoirAchatsBarCode(value: boolean) {
        this._validAvoirAchatsBarCode = value;
    }
    get validAvoirAchatsEntrepriseSociete(): boolean {
        return this._validAvoirAchatsEntrepriseSociete;
    }
    set validAvoirAchatsEntrepriseSociete(value: boolean) {
        this._validAvoirAchatsEntrepriseSociete = value;
    }
    get validAvoirAchatsCodeAvoirAchat(): boolean {
        return this._validAvoirAchatsCodeAvoirAchat;
    }
    set validAvoirAchatsCodeAvoirAchat(value: boolean) {
        this._validAvoirAchatsCodeAvoirAchat = value;
    }
    get validAvoirAchatsNumeroFactureAvoirFournisseur(): boolean {
        return this._validAvoirAchatsNumeroFactureAvoirFournisseur;
    }
    set validAvoirAchatsNumeroFactureAvoirFournisseur(value: boolean) {
        this._validAvoirAchatsNumeroFactureAvoirFournisseur = value;
    }
    get validAvoirAchatsDateFactureAvoirFournisseur(): boolean {
        return this._validAvoirAchatsDateFactureAvoirFournisseur;
    }
    set validAvoirAchatsDateFactureAvoirFournisseur(value: boolean) {
        this._validAvoirAchatsDateFactureAvoirFournisseur = value;
    }
    get validAvoirAchatsFournisseur(): boolean {
        return this._validAvoirAchatsFournisseur;
    }
    set validAvoirAchatsFournisseur(value: boolean) {
        this._validAvoirAchatsFournisseur = value;
    }
    get validAvoirAchatsMontantTtc(): boolean {
        return this._validAvoirAchatsMontantTtc;
    }
    set validAvoirAchatsMontantTtc(value: boolean) {
        this._validAvoirAchatsMontantTtc = value;
    }
}
