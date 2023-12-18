import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteCriteria} from 'src/app/controller/criteria/stock/AvoirVenteCriteria.model';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirVenteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
@Component({
  selector: 'app-avoir-vente-create-admin',
  templateUrl: './avoir-vente-create-admin.component.html'
})
export class AvoirVenteCreateAdminComponent extends AbstractCreateController<AvoirVenteDto, AvoirVenteCriteria, AvoirVenteAdminService>  implements OnInit {

    private _avoirVenteItemsElement = new AvoirVenteItemDto();


   private _validAvoirVenteBarCode = true;
   private _validAvoirVenteEntrepriseSociete = true;
   private _validAvoirVenteCodeAvoirVente = true;
   private _validAvoirVenteNumeroFactureAvoirVente = true;
   private _validAvoirVenteDateFactureAvoirVente = true;
   private _validAvoirVenteClient = true;
   private _validAvoirVenteMontantTtc = true;
    private _validEntrepriseSocieteNom = true;
    private _validClientCin = true;
    private _validClientNom = true;
    private _validClientTelephone = true;
    private _validEtatAvoirVenteLibelle = true;
    private _validVenteBarCode = true;
    private _validVenteEntrepriseSociete = true;
    private _validVenteCodeVente = true;
    private _validVenteDateFacture = true;
    private _validVenteNumeroFacture = true;
    private _validVenteClient = true;
    private _validVenteMontantHt = true;
    private _validVenteMontantTva = true;
    private _validVenteMontantTtc = true;
    private _validAvoirVenteItemsBarCode = true;
    private _validAvoirVenteItemsDepot = true;
    private _validAvoirVenteItemsProduit = true;
    private _validAvoirVenteItemsQuantite = true;
    private _validAvoirVenteItemsQuantiteVendue = true;
    private _validAvoirVenteItemsPrixUnitaireHt = true;
    private _validAvoirVenteItemsPrixUnitaireTtc = true;
    private _validAvoirVenteItemsRemise = true;
    private _validAvoirVenteItemsMontantHt = true;
    private _validAvoirVenteItemsMontantTtc = true;

    constructor( private avoirVenteService: AvoirVenteAdminService , private clientService: ClientAdminService, private avoirVenteItemService: AvoirVenteItemAdminService, private depotService: DepotAdminService, private etatAvoirVenteService: EtatAvoirVenteAdminService, private produitService: ProduitAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private venteService: VenteAdminService, private taxeService: TaxeAdminService) {
        super(avoirVenteService);
    }

    ngOnInit(): void {
        this.avoirVenteItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.avoirVenteItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.avoirVenteItemsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.etatAvoirVente = new EtatAvoirVenteDto();
        this.etatAvoirVenteService.findAll().subscribe((data) => this.etatAvoirVentes = data);
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
    }



    validateAvoirVenteItems(){
        this.errorMessages = new Array();
        this.validateAvoirVenteItemsBarCode();
        this.validateAvoirVenteItemsDepot();
        this.validateAvoirVenteItemsProduit();
        this.validateAvoirVenteItemsQuantite();
        this.validateAvoirVenteItemsQuantiteVendue();
        this.validateAvoirVenteItemsPrixUnitaireHt();
        this.validateAvoirVenteItemsPrixUnitaireTtc();
        this.validateAvoirVenteItemsRemise();
        this.validateAvoirVenteItemsMontantHt();
        this.validateAvoirVenteItemsMontantTtc();
    }


    public setValidation(value: boolean){
        this.validAvoirVenteBarCode = value;
        this.validAvoirVenteEntrepriseSociete = value;
        this.validAvoirVenteCodeAvoirVente = value;
        this.validAvoirVenteNumeroFactureAvoirVente = value;
        this.validAvoirVenteDateFactureAvoirVente = value;
        this.validAvoirVenteClient = value;
        this.validAvoirVenteMontantTtc = value;
        this.validAvoirVenteItemsBarCode = value;
        this.validAvoirVenteItemsDepot = value;
        this.validAvoirVenteItemsProduit = value;
        this.validAvoirVenteItemsQuantite = value;
        this.validAvoirVenteItemsQuantiteVendue = value;
        this.validAvoirVenteItemsPrixUnitaireHt = value;
        this.validAvoirVenteItemsPrixUnitaireTtc = value;
        this.validAvoirVenteItemsRemise = value;
        this.validAvoirVenteItemsMontantHt = value;
        this.validAvoirVenteItemsMontantTtc = value;
    }

    public addAvoirVenteItems() {
        if( this.item.avoirVenteItems == null )
            this.item.avoirVenteItems = new Array<AvoirVenteItemDto>();
       this.validateAvoirVenteItems();
       if (this.errorMessages.length === 0) {
              this.item.avoirVenteItems.push({... this.avoirVenteItemsElement});
              this.avoirVenteItemsElement = new AvoirVenteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteavoirVenteItems(p: AvoirVenteItemDto) {
        this.item.avoirVenteItems.forEach((element, index) => {
            if (element === p) { this.item.avoirVenteItems.splice(index, 1); }
        });
    }

    public editavoirVenteItems(p: AvoirVenteItemDto) {
        this.avoirVenteItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAvoirVenteBarCode();
        this.validateAvoirVenteEntrepriseSociete();
        this.validateAvoirVenteCodeAvoirVente();
        this.validateAvoirVenteNumeroFactureAvoirVente();
        this.validateAvoirVenteDateFactureAvoirVente();
        this.validateAvoirVenteClient();
        this.validateAvoirVenteMontantTtc();
    }

    public validateAvoirVenteBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
        this.errorMessages.push('Bar code non valide');
        this.validAvoirVenteBarCode = false;
        } else {
            this.validAvoirVenteBarCode = true;
        }
    }
    public validateAvoirVenteEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
        this.errorMessages.push('Entreprise societe non valide');
        this.validAvoirVenteEntrepriseSociete = false;
        } else {
            this.validAvoirVenteEntrepriseSociete = true;
        }
    }
    public validateAvoirVenteCodeAvoirVente(){
        if (this.stringUtilService.isEmpty(this.item.codeAvoirVente)) {
        this.errorMessages.push('Code avoir vente non valide');
        this.validAvoirVenteCodeAvoirVente = false;
        } else {
            this.validAvoirVenteCodeAvoirVente = true;
        }
    }
    public validateAvoirVenteNumeroFactureAvoirVente(){
        if (this.stringUtilService.isEmpty(this.item.numeroFactureAvoirVente)) {
        this.errorMessages.push('Numero facture avoir vente non valide');
        this.validAvoirVenteNumeroFactureAvoirVente = false;
        } else {
            this.validAvoirVenteNumeroFactureAvoirVente = true;
        }
    }
    public validateAvoirVenteDateFactureAvoirVente(){
        if (this.stringUtilService.isEmpty(this.item.dateFactureAvoirVente)) {
        this.errorMessages.push('Date facture avoir vente non valide');
        this.validAvoirVenteDateFactureAvoirVente = false;
        } else {
            this.validAvoirVenteDateFactureAvoirVente = true;
        }
    }
    public validateAvoirVenteClient(){
        if (this.stringUtilService.isEmpty(this.item.client)) {
        this.errorMessages.push('Client non valide');
        this.validAvoirVenteClient = false;
        } else {
            this.validAvoirVenteClient = true;
        }
    }
    public validateAvoirVenteMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
        this.errorMessages.push('Montant ttc non valide');
        this.validAvoirVenteMontantTtc = false;
        } else {
            this.validAvoirVenteMontantTtc = true;
        }
    }

    public validateAvoirVenteItemsBarCode(){
        if (this.avoirVenteItemsElement.barCode == null) {
            this.errorMessages.push('BarCode de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsBarCode = false;
        } else {
            this.validAvoirVenteItemsBarCode = true;
        }
    }
    public validateAvoirVenteItemsDepot(){
        if (this.avoirVenteItemsElement.depot == null) {
            this.errorMessages.push('Depot de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsDepot = false;
        } else {
            this.validAvoirVenteItemsDepot = true;
        }
    }
    public validateAvoirVenteItemsProduit(){
        if (this.avoirVenteItemsElement.produit == null) {
            this.errorMessages.push('Produit de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsProduit = false;
        } else {
            this.validAvoirVenteItemsProduit = true;
        }
    }
    public validateAvoirVenteItemsQuantite(){
        if (this.avoirVenteItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsQuantite = false;
        } else {
            this.validAvoirVenteItemsQuantite = true;
        }
    }
    public validateAvoirVenteItemsQuantiteVendue(){
        if (this.avoirVenteItemsElement.quantiteVendue == null) {
            this.errorMessages.push('QuantiteVendue de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsQuantiteVendue = false;
        } else {
            this.validAvoirVenteItemsQuantiteVendue = true;
        }
    }
    public validateAvoirVenteItemsPrixUnitaireHt(){
        if (this.avoirVenteItemsElement.prixUnitaireHt == null) {
            this.errorMessages.push('PrixUnitaireHt de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsPrixUnitaireHt = false;
        } else {
            this.validAvoirVenteItemsPrixUnitaireHt = true;
        }
    }
    public validateAvoirVenteItemsPrixUnitaireTtc(){
        if (this.avoirVenteItemsElement.prixUnitaireTtc == null) {
            this.errorMessages.push('PrixUnitaireTtc de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsPrixUnitaireTtc = false;
        } else {
            this.validAvoirVenteItemsPrixUnitaireTtc = true;
        }
    }
    public validateAvoirVenteItemsRemise(){
        if (this.avoirVenteItemsElement.remise == null) {
            this.errorMessages.push('Remise de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsRemise = false;
        } else {
            this.validAvoirVenteItemsRemise = true;
        }
    }
    public validateAvoirVenteItemsMontantHt(){
        if (this.avoirVenteItemsElement.montantHt == null) {
            this.errorMessages.push('MontantHt de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsMontantHt = false;
        } else {
            this.validAvoirVenteItemsMontantHt = true;
        }
    }
    public validateAvoirVenteItemsMontantTtc(){
        if (this.avoirVenteItemsElement.montantTtc == null) {
            this.errorMessages.push('MontantTtc de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsMontantTtc = false;
        } else {
            this.validAvoirVenteItemsMontantTtc = true;
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
    public async openCreateVente(vente: string) {
    const isPermistted = await this.roleService.isPermitted('Vente', 'add');
    if(isPermistted) {
         this.vente = new VenteDto();
         this.createVenteDialog = true;
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
    get vente(): VenteDto {
        return this.venteService.item;
    }
    set vente(value: VenteDto) {
        this.venteService.item = value;
    }
    get ventes(): Array<VenteDto> {
        return this.venteService.items;
    }
    set ventes(value: Array<VenteDto>) {
        this.venteService.items = value;
    }
    get createVenteDialog(): boolean {
       return this.venteService.createDialog;
    }
    set createVenteDialog(value: boolean) {
        this.venteService.createDialog= value;
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
    get etatAvoirVente(): EtatAvoirVenteDto {
        return this.etatAvoirVenteService.item;
    }
    set etatAvoirVente(value: EtatAvoirVenteDto) {
        this.etatAvoirVenteService.item = value;
    }
    get etatAvoirVentes(): Array<EtatAvoirVenteDto> {
        return this.etatAvoirVenteService.items;
    }
    set etatAvoirVentes(value: Array<EtatAvoirVenteDto>) {
        this.etatAvoirVenteService.items = value;
    }
    get createEtatAvoirVenteDialog(): boolean {
       return this.etatAvoirVenteService.createDialog;
    }
    set createEtatAvoirVenteDialog(value: boolean) {
        this.etatAvoirVenteService.createDialog= value;
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

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
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
    get validEtatAvoirVenteLibelle(): boolean {
        return this._validEtatAvoirVenteLibelle;
    }
    set validEtatAvoirVenteLibelle(value: boolean) {
        this._validEtatAvoirVenteLibelle = value;
    }
    get validVenteBarCode(): boolean {
        return this._validVenteBarCode;
    }
    set validVenteBarCode(value: boolean) {
        this._validVenteBarCode = value;
    }
    get validVenteEntrepriseSociete(): boolean {
        return this._validVenteEntrepriseSociete;
    }
    set validVenteEntrepriseSociete(value: boolean) {
        this._validVenteEntrepriseSociete = value;
    }
    get validVenteCodeVente(): boolean {
        return this._validVenteCodeVente;
    }
    set validVenteCodeVente(value: boolean) {
        this._validVenteCodeVente = value;
    }
    get validVenteDateFacture(): boolean {
        return this._validVenteDateFacture;
    }
    set validVenteDateFacture(value: boolean) {
        this._validVenteDateFacture = value;
    }
    get validVenteNumeroFacture(): boolean {
        return this._validVenteNumeroFacture;
    }
    set validVenteNumeroFacture(value: boolean) {
        this._validVenteNumeroFacture = value;
    }
    get validVenteClient(): boolean {
        return this._validVenteClient;
    }
    set validVenteClient(value: boolean) {
        this._validVenteClient = value;
    }
    get validVenteMontantHt(): boolean {
        return this._validVenteMontantHt;
    }
    set validVenteMontantHt(value: boolean) {
        this._validVenteMontantHt = value;
    }
    get validVenteMontantTva(): boolean {
        return this._validVenteMontantTva;
    }
    set validVenteMontantTva(value: boolean) {
        this._validVenteMontantTva = value;
    }
    get validVenteMontantTtc(): boolean {
        return this._validVenteMontantTtc;
    }
    set validVenteMontantTtc(value: boolean) {
        this._validVenteMontantTtc = value;
    }
    get validAvoirVenteItemsBarCode(): boolean {
        return this._validAvoirVenteItemsBarCode;
    }
    set validAvoirVenteItemsBarCode(value: boolean) {
        this._validAvoirVenteItemsBarCode = value;
    }
    get validAvoirVenteItemsDepot(): boolean {
        return this._validAvoirVenteItemsDepot;
    }
    set validAvoirVenteItemsDepot(value: boolean) {
        this._validAvoirVenteItemsDepot = value;
    }
    get validAvoirVenteItemsProduit(): boolean {
        return this._validAvoirVenteItemsProduit;
    }
    set validAvoirVenteItemsProduit(value: boolean) {
        this._validAvoirVenteItemsProduit = value;
    }
    get validAvoirVenteItemsQuantite(): boolean {
        return this._validAvoirVenteItemsQuantite;
    }
    set validAvoirVenteItemsQuantite(value: boolean) {
        this._validAvoirVenteItemsQuantite = value;
    }
    get validAvoirVenteItemsQuantiteVendue(): boolean {
        return this._validAvoirVenteItemsQuantiteVendue;
    }
    set validAvoirVenteItemsQuantiteVendue(value: boolean) {
        this._validAvoirVenteItemsQuantiteVendue = value;
    }
    get validAvoirVenteItemsPrixUnitaireHt(): boolean {
        return this._validAvoirVenteItemsPrixUnitaireHt;
    }
    set validAvoirVenteItemsPrixUnitaireHt(value: boolean) {
        this._validAvoirVenteItemsPrixUnitaireHt = value;
    }
    get validAvoirVenteItemsPrixUnitaireTtc(): boolean {
        return this._validAvoirVenteItemsPrixUnitaireTtc;
    }
    set validAvoirVenteItemsPrixUnitaireTtc(value: boolean) {
        this._validAvoirVenteItemsPrixUnitaireTtc = value;
    }
    get validAvoirVenteItemsRemise(): boolean {
        return this._validAvoirVenteItemsRemise;
    }
    set validAvoirVenteItemsRemise(value: boolean) {
        this._validAvoirVenteItemsRemise = value;
    }
    get validAvoirVenteItemsMontantHt(): boolean {
        return this._validAvoirVenteItemsMontantHt;
    }
    set validAvoirVenteItemsMontantHt(value: boolean) {
        this._validAvoirVenteItemsMontantHt = value;
    }
    get validAvoirVenteItemsMontantTtc(): boolean {
        return this._validAvoirVenteItemsMontantTtc;
    }
    set validAvoirVenteItemsMontantTtc(value: boolean) {
        this._validAvoirVenteItemsMontantTtc = value;
    }

    get avoirVenteItemsElement(): AvoirVenteItemDto {
        if( this._avoirVenteItemsElement == null )
            this._avoirVenteItemsElement = new AvoirVenteItemDto();
        return this._avoirVenteItemsElement;
    }

    set avoirVenteItemsElement(value: AvoirVenteItemDto) {
        this._avoirVenteItemsElement = value;
    }

}
