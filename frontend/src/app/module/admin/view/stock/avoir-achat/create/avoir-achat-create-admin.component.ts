import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatCriteria} from 'src/app/controller/criteria/stock/AvoirAchatCriteria.model';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/commun/EtatAvoirAchat.model';
import {EtatAvoirAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirAchatAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-avoir-achat-create-admin',
  templateUrl: './avoir-achat-create-admin.component.html'
})
export class AvoirAchatCreateAdminComponent extends AbstractCreateController<AvoirAchatDto, AvoirAchatCriteria, AvoirAchatAdminService>  implements OnInit {

    private _avoirAchatItemsElement = new AvoirAchatItemDto();


   private _validAvoirAchatBarCode = true;
   private _validAvoirAchatEntrepriseSociete = true;
   private _validAvoirAchatCodeAvoirAchat = true;
   private _validAvoirAchatNumeroFactureAvoirFournisseur = true;
   private _validAvoirAchatDateFactureAvoirFournisseur = true;
   private _validAvoirAchatFournisseur = true;
   private _validAvoirAchatMontantTtc = true;
    private _validEntrepriseSocieteNom = true;
    private _validFournisseurIce = true;
    private _validFournisseurNom = true;
    private _validFournisseurTelephone = true;
    private _validEtatAvoirAchatLibelle = true;
    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;
    private _validAchatMontantHt = true;
    private _validAchatMontantTva = true;
    private _validAchatMontantTtc = true;
    private _validAvoirAchatItemsBarCode = true;
    private _validAvoirAchatItemsDepot = true;
    private _validAvoirAchatItemsProduit = true;
    private _validAvoirAchatItemsQuantite = true;
    private _validAvoirAchatItemsQuantiteVendue = true;
    private _validAvoirAchatItemsPrixUnitaireHt = true;
    private _validAvoirAchatItemsPrixUnitaireTtc = true;
    private _validAvoirAchatItemsRemise = true;
    private _validAvoirAchatItemsMontantHt = true;
    private _validAvoirAchatItemsMontantTtc = true;

    constructor( private avoirAchatService: AvoirAchatAdminService , private depotService: DepotAdminService, private etatAvoirAchatService: EtatAvoirAchatAdminService, private avoirAchatItemService: AvoirAchatItemAdminService, private produitService: ProduitAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private fournisseurService: FournisseurAdminService, private achatService: AchatAdminService, private taxeService: TaxeAdminService) {
        super(avoirAchatService);
    }

    ngOnInit(): void {
        this.avoirAchatItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.avoirAchatItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.avoirAchatItemsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
        this.etatAvoirAchat = new EtatAvoirAchatDto();
        this.etatAvoirAchatService.findAll().subscribe((data) => this.etatAvoirAchats = data);
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
    }



    validateAvoirAchatItems(){
        this.errorMessages = new Array();
        this.validateAvoirAchatItemsBarCode();
        this.validateAvoirAchatItemsDepot();
        this.validateAvoirAchatItemsProduit();
        this.validateAvoirAchatItemsQuantite();
        this.validateAvoirAchatItemsQuantiteVendue();
        this.validateAvoirAchatItemsPrixUnitaireHt();
        this.validateAvoirAchatItemsPrixUnitaireTtc();
        this.validateAvoirAchatItemsRemise();
        this.validateAvoirAchatItemsMontantHt();
        this.validateAvoirAchatItemsMontantTtc();
    }


    public setValidation(value: boolean){
        this.validAvoirAchatBarCode = value;
        this.validAvoirAchatEntrepriseSociete = value;
        this.validAvoirAchatCodeAvoirAchat = value;
        this.validAvoirAchatNumeroFactureAvoirFournisseur = value;
        this.validAvoirAchatDateFactureAvoirFournisseur = value;
        this.validAvoirAchatFournisseur = value;
        this.validAvoirAchatMontantTtc = value;
        this.validAvoirAchatItemsBarCode = value;
        this.validAvoirAchatItemsDepot = value;
        this.validAvoirAchatItemsProduit = value;
        this.validAvoirAchatItemsQuantite = value;
        this.validAvoirAchatItemsQuantiteVendue = value;
        this.validAvoirAchatItemsPrixUnitaireHt = value;
        this.validAvoirAchatItemsPrixUnitaireTtc = value;
        this.validAvoirAchatItemsRemise = value;
        this.validAvoirAchatItemsMontantHt = value;
        this.validAvoirAchatItemsMontantTtc = value;
    }

    public addAvoirAchatItems() {
        if( this.item.avoirAchatItems == null )
            this.item.avoirAchatItems = new Array<AvoirAchatItemDto>();
       this.validateAvoirAchatItems();
       if (this.errorMessages.length === 0) {
              this.item.avoirAchatItems.push({... this.avoirAchatItemsElement});
              this.avoirAchatItemsElement = new AvoirAchatItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteavoirAchatItems(p: AvoirAchatItemDto) {
        this.item.avoirAchatItems.forEach((element, index) => {
            if (element === p) { this.item.avoirAchatItems.splice(index, 1); }
        });
    }

    public editavoirAchatItems(p: AvoirAchatItemDto) {
        this.avoirAchatItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAvoirAchatBarCode();
        this.validateAvoirAchatEntrepriseSociete();
        this.validateAvoirAchatCodeAvoirAchat();
        this.validateAvoirAchatNumeroFactureAvoirFournisseur();
        this.validateAvoirAchatDateFactureAvoirFournisseur();
        this.validateAvoirAchatFournisseur();
        this.validateAvoirAchatMontantTtc();
    }

    public validateAvoirAchatBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
        this.errorMessages.push('Bar code non valide');
        this.validAvoirAchatBarCode = false;
        } else {
            this.validAvoirAchatBarCode = true;
        }
    }
    public validateAvoirAchatEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
        this.errorMessages.push('Entreprise societe non valide');
        this.validAvoirAchatEntrepriseSociete = false;
        } else {
            this.validAvoirAchatEntrepriseSociete = true;
        }
    }
    public validateAvoirAchatCodeAvoirAchat(){
        if (this.stringUtilService.isEmpty(this.item.codeAvoirAchat)) {
        this.errorMessages.push('Code avoir achat non valide');
        this.validAvoirAchatCodeAvoirAchat = false;
        } else {
            this.validAvoirAchatCodeAvoirAchat = true;
        }
    }
    public validateAvoirAchatNumeroFactureAvoirFournisseur(){
        if (this.stringUtilService.isEmpty(this.item.numeroFactureAvoirFournisseur)) {
        this.errorMessages.push('Numero facture avoir fournisseur non valide');
        this.validAvoirAchatNumeroFactureAvoirFournisseur = false;
        } else {
            this.validAvoirAchatNumeroFactureAvoirFournisseur = true;
        }
    }
    public validateAvoirAchatDateFactureAvoirFournisseur(){
        if (this.stringUtilService.isEmpty(this.item.dateFactureAvoirFournisseur)) {
        this.errorMessages.push('Date facture avoir fournisseur non valide');
        this.validAvoirAchatDateFactureAvoirFournisseur = false;
        } else {
            this.validAvoirAchatDateFactureAvoirFournisseur = true;
        }
    }
    public validateAvoirAchatFournisseur(){
        if (this.stringUtilService.isEmpty(this.item.fournisseur)) {
        this.errorMessages.push('Fournisseur non valide');
        this.validAvoirAchatFournisseur = false;
        } else {
            this.validAvoirAchatFournisseur = true;
        }
    }
    public validateAvoirAchatMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
        this.errorMessages.push('Montant ttc non valide');
        this.validAvoirAchatMontantTtc = false;
        } else {
            this.validAvoirAchatMontantTtc = true;
        }
    }

    public validateAvoirAchatItemsBarCode(){
        if (this.avoirAchatItemsElement.barCode == null) {
            this.errorMessages.push('BarCode de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsBarCode = false;
        } else {
            this.validAvoirAchatItemsBarCode = true;
        }
    }
    public validateAvoirAchatItemsDepot(){
        if (this.avoirAchatItemsElement.depot == null) {
            this.errorMessages.push('Depot de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsDepot = false;
        } else {
            this.validAvoirAchatItemsDepot = true;
        }
    }
    public validateAvoirAchatItemsProduit(){
        if (this.avoirAchatItemsElement.produit == null) {
            this.errorMessages.push('Produit de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsProduit = false;
        } else {
            this.validAvoirAchatItemsProduit = true;
        }
    }
    public validateAvoirAchatItemsQuantite(){
        if (this.avoirAchatItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsQuantite = false;
        } else {
            this.validAvoirAchatItemsQuantite = true;
        }
    }
    public validateAvoirAchatItemsQuantiteVendue(){
        if (this.avoirAchatItemsElement.quantiteVendue == null) {
            this.errorMessages.push('QuantiteVendue de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsQuantiteVendue = false;
        } else {
            this.validAvoirAchatItemsQuantiteVendue = true;
        }
    }
    public validateAvoirAchatItemsPrixUnitaireHt(){
        if (this.avoirAchatItemsElement.prixUnitaireHt == null) {
            this.errorMessages.push('PrixUnitaireHt de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsPrixUnitaireHt = false;
        } else {
            this.validAvoirAchatItemsPrixUnitaireHt = true;
        }
    }
    public validateAvoirAchatItemsPrixUnitaireTtc(){
        if (this.avoirAchatItemsElement.prixUnitaireTtc == null) {
            this.errorMessages.push('PrixUnitaireTtc de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsPrixUnitaireTtc = false;
        } else {
            this.validAvoirAchatItemsPrixUnitaireTtc = true;
        }
    }
    public validateAvoirAchatItemsRemise(){
        if (this.avoirAchatItemsElement.remise == null) {
            this.errorMessages.push('Remise de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsRemise = false;
        } else {
            this.validAvoirAchatItemsRemise = true;
        }
    }
    public validateAvoirAchatItemsMontantHt(){
        if (this.avoirAchatItemsElement.montantHt == null) {
            this.errorMessages.push('MontantHt de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsMontantHt = false;
        } else {
            this.validAvoirAchatItemsMontantHt = true;
        }
    }
    public validateAvoirAchatItemsMontantTtc(){
        if (this.avoirAchatItemsElement.montantTtc == null) {
            this.errorMessages.push('MontantTtc de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsMontantTtc = false;
        } else {
            this.validAvoirAchatItemsMontantTtc = true;
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
    public async openCreateAchat(achat: string) {
    const isPermistted = await this.roleService.isPermitted('Achat', 'add');
    if(isPermistted) {
         this.achat = new AchatDto();
         this.createAchatDialog = true;
    }else{
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
    get achat(): AchatDto {
        return this.achatService.item;
    }
    set achat(value: AchatDto) {
        this.achatService.item = value;
    }
    get achats(): Array<AchatDto> {
        return this.achatService.items;
    }
    set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
    }
    get createAchatDialog(): boolean {
       return this.achatService.createDialog;
    }
    set createAchatDialog(value: boolean) {
        this.achatService.createDialog= value;
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
    get validEtatAvoirAchatLibelle(): boolean {
        return this._validEtatAvoirAchatLibelle;
    }
    set validEtatAvoirAchatLibelle(value: boolean) {
        this._validEtatAvoirAchatLibelle = value;
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
    get validAvoirAchatItemsBarCode(): boolean {
        return this._validAvoirAchatItemsBarCode;
    }
    set validAvoirAchatItemsBarCode(value: boolean) {
        this._validAvoirAchatItemsBarCode = value;
    }
    get validAvoirAchatItemsDepot(): boolean {
        return this._validAvoirAchatItemsDepot;
    }
    set validAvoirAchatItemsDepot(value: boolean) {
        this._validAvoirAchatItemsDepot = value;
    }
    get validAvoirAchatItemsProduit(): boolean {
        return this._validAvoirAchatItemsProduit;
    }
    set validAvoirAchatItemsProduit(value: boolean) {
        this._validAvoirAchatItemsProduit = value;
    }
    get validAvoirAchatItemsQuantite(): boolean {
        return this._validAvoirAchatItemsQuantite;
    }
    set validAvoirAchatItemsQuantite(value: boolean) {
        this._validAvoirAchatItemsQuantite = value;
    }
    get validAvoirAchatItemsQuantiteVendue(): boolean {
        return this._validAvoirAchatItemsQuantiteVendue;
    }
    set validAvoirAchatItemsQuantiteVendue(value: boolean) {
        this._validAvoirAchatItemsQuantiteVendue = value;
    }
    get validAvoirAchatItemsPrixUnitaireHt(): boolean {
        return this._validAvoirAchatItemsPrixUnitaireHt;
    }
    set validAvoirAchatItemsPrixUnitaireHt(value: boolean) {
        this._validAvoirAchatItemsPrixUnitaireHt = value;
    }
    get validAvoirAchatItemsPrixUnitaireTtc(): boolean {
        return this._validAvoirAchatItemsPrixUnitaireTtc;
    }
    set validAvoirAchatItemsPrixUnitaireTtc(value: boolean) {
        this._validAvoirAchatItemsPrixUnitaireTtc = value;
    }
    get validAvoirAchatItemsRemise(): boolean {
        return this._validAvoirAchatItemsRemise;
    }
    set validAvoirAchatItemsRemise(value: boolean) {
        this._validAvoirAchatItemsRemise = value;
    }
    get validAvoirAchatItemsMontantHt(): boolean {
        return this._validAvoirAchatItemsMontantHt;
    }
    set validAvoirAchatItemsMontantHt(value: boolean) {
        this._validAvoirAchatItemsMontantHt = value;
    }
    get validAvoirAchatItemsMontantTtc(): boolean {
        return this._validAvoirAchatItemsMontantTtc;
    }
    set validAvoirAchatItemsMontantTtc(value: boolean) {
        this._validAvoirAchatItemsMontantTtc = value;
    }

    get avoirAchatItemsElement(): AvoirAchatItemDto {
        if( this._avoirAchatItemsElement == null )
            this._avoirAchatItemsElement = new AvoirAchatItemDto();
        return this._avoirAchatItemsElement;
    }

    set avoirAchatItemsElement(value: AvoirAchatItemDto) {
        this._avoirAchatItemsElement = value;
    }

}
