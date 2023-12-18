import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {VenteItemAdminService} from 'src/app/controller/service/admin/stock/VenteItemAdmin.service';
import {VenteItemDto} from 'src/app/controller/model/stock/VenteItem.model';
import {VenteItemCriteria} from 'src/app/controller/criteria/stock/VenteItemCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';

@Component({
  selector: 'app-vente-item-edit-admin',
  templateUrl: './vente-item-edit-admin.component.html'
})
export class VenteItemEditAdminComponent extends AbstractEditController<VenteItemDto, VenteItemCriteria, VenteItemAdminService>   implements OnInit {


    private _validVenteItemBarCode = true;
    private _validVenteItemQuantite = true;
    private _validVenteItemQuantiteVendue = true;
    private _validVenteItemPrixUnitaireHt = true;
    private _validVenteItemPrixUnitaireTtc = true;
    private _validVenteItemRemise = true;
    private _validVenteItemMontantHt = true;
    private _validVenteItemMontantTtc = true;

    private _validDepotLibelle = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validProduitPrixVente = true;
    private _validProduitSeuilAlerte = true;
    private _validTaxeLibelle = true;
    private _validVenteBarCode = true;
    private _validVenteEntrepriseSociete = true;
    private _validVenteCodeVente = true;
    private _validVenteDateFacture = true;
    private _validVenteNumeroFacture = true;
    private _validVenteClient = true;
    private _validVenteMontantHt = true;
    private _validVenteMontantTva = true;
    private _validVenteMontantTtc = true;



    constructor( private venteItemService: VenteItemAdminService , private depotService: DepotAdminService, private produitService: ProduitAdminService, private venteService: VenteAdminService, private taxeService: TaxeAdminService) {
        super(venteItemService);
    }

    ngOnInit(): void {
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
    }


    public setValidation(value: boolean){
        this.validVenteItemBarCode = value;
        this.validVenteItemQuantite = value;
        this.validVenteItemQuantiteVendue = value;
        this.validVenteItemPrixUnitaireHt = value;
        this.validVenteItemPrixUnitaireTtc = value;
        this.validVenteItemRemise = value;
        this.validVenteItemMontantHt = value;
        this.validVenteItemMontantTtc = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateVenteItemBarCode();
        this.validateVenteItemQuantite();
        this.validateVenteItemQuantiteVendue();
        this.validateVenteItemPrixUnitaireHt();
        this.validateVenteItemPrixUnitaireTtc();
        this.validateVenteItemRemise();
        this.validateVenteItemMontantHt();
        this.validateVenteItemMontantTtc();
    }
    public validateVenteItemBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
            this.errorMessages.push('Bar code non valide');
            this.validVenteItemBarCode = false;
        } else {
            this.validVenteItemBarCode = true;
        }
    }
    public validateVenteItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validVenteItemQuantite = false;
        } else {
            this.validVenteItemQuantite = true;
        }
    }
    public validateVenteItemQuantiteVendue(){
        if (this.stringUtilService.isEmpty(this.item.quantiteVendue)) {
            this.errorMessages.push('Quantite vendue non valide');
            this.validVenteItemQuantiteVendue = false;
        } else {
            this.validVenteItemQuantiteVendue = true;
        }
    }
    public validateVenteItemPrixUnitaireHt(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireHt)) {
            this.errorMessages.push('Prix unitaire ht non valide');
            this.validVenteItemPrixUnitaireHt = false;
        } else {
            this.validVenteItemPrixUnitaireHt = true;
        }
    }
    public validateVenteItemPrixUnitaireTtc(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireTtc)) {
            this.errorMessages.push('Prix unitaire ttc non valide');
            this.validVenteItemPrixUnitaireTtc = false;
        } else {
            this.validVenteItemPrixUnitaireTtc = true;
        }
    }
    public validateVenteItemRemise(){
        if (this.stringUtilService.isEmpty(this.item.remise)) {
            this.errorMessages.push('Remise non valide');
            this.validVenteItemRemise = false;
        } else {
            this.validVenteItemRemise = true;
        }
    }
    public validateVenteItemMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
            this.errorMessages.push('Montant ht non valide');
            this.validVenteItemMontantHt = false;
        } else {
            this.validVenteItemMontantHt = true;
        }
    }
    public validateVenteItemMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
            this.errorMessages.push('Montant ttc non valide');
            this.validVenteItemMontantTtc = false;
        } else {
            this.validVenteItemMontantTtc = true;
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
   public async openCreateVente(vente: string) {
        const isPermistted = await this.roleService.isPermitted('Vente', 'edit');
        if (isPermistted) {
             this.vente = new VenteDto();
             this.createVenteDialog = true;
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


    get validVenteItemBarCode(): boolean {
        return this._validVenteItemBarCode;
    }
    set validVenteItemBarCode(value: boolean) {
        this._validVenteItemBarCode = value;
    }
    get validVenteItemQuantite(): boolean {
        return this._validVenteItemQuantite;
    }
    set validVenteItemQuantite(value: boolean) {
        this._validVenteItemQuantite = value;
    }
    get validVenteItemQuantiteVendue(): boolean {
        return this._validVenteItemQuantiteVendue;
    }
    set validVenteItemQuantiteVendue(value: boolean) {
        this._validVenteItemQuantiteVendue = value;
    }
    get validVenteItemPrixUnitaireHt(): boolean {
        return this._validVenteItemPrixUnitaireHt;
    }
    set validVenteItemPrixUnitaireHt(value: boolean) {
        this._validVenteItemPrixUnitaireHt = value;
    }
    get validVenteItemPrixUnitaireTtc(): boolean {
        return this._validVenteItemPrixUnitaireTtc;
    }
    set validVenteItemPrixUnitaireTtc(value: boolean) {
        this._validVenteItemPrixUnitaireTtc = value;
    }
    get validVenteItemRemise(): boolean {
        return this._validVenteItemRemise;
    }
    set validVenteItemRemise(value: boolean) {
        this._validVenteItemRemise = value;
    }
    get validVenteItemMontantHt(): boolean {
        return this._validVenteItemMontantHt;
    }
    set validVenteItemMontantHt(value: boolean) {
        this._validVenteItemMontantHt = value;
    }
    get validVenteItemMontantTtc(): boolean {
        return this._validVenteItemMontantTtc;
    }
    set validVenteItemMontantTtc(value: boolean) {
        this._validVenteItemMontantTtc = value;
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
}
