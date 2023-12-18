import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {BonPourAdminService} from 'src/app/controller/service/admin/stock/BonPourAdmin.service';
import {BonPourDto} from 'src/app/controller/model/stock/BonPour.model';
import {BonPourCriteria} from 'src/app/controller/criteria/stock/BonPourCriteria.model';


import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {BonPourItemDto} from 'src/app/controller/model/stock/BonPourItem.model';
import {BonPourItemAdminService} from 'src/app/controller/service/admin/stock/BonPourItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';

@Component({
  selector: 'app-bon-pour-edit-admin',
  templateUrl: './bon-pour-edit-admin.component.html'
})
export class BonPourEditAdminComponent extends AbstractEditController<BonPourDto, BonPourCriteria, BonPourAdminService>   implements OnInit {

    private _bonPourItemsElement = new BonPourItemDto();

    private _validBonPourNumero = true;
    private _validBonPourDateBonPour = true;
    private _validBonPourClient = true;
    private _validBonPourMontantTva = true;
    private _validBonPourMontantTtc = true;

    private _validClientCin = true;
    private _validClientNom = true;
    private _validClientTelephone = true;
    private _validBonPourItemsProduit = true;
    private _validBonPourItemsQuantite = true;
    private _validBonPourItemsPrixUnitaireHt = true;
    private _validBonPourItemsPrixUnitaireTtc = true;
    private _validBonPourItemsRemise = true;
    private _validBonPourItemsMontantHt = true;
    private _validBonPourItemsMontantTtc = true;



    constructor( private bonPourService: BonPourAdminService , private clientService: ClientAdminService, private bonPourItemService: BonPourItemAdminService, private produitService: ProduitAdminService, private taxeService: TaxeAdminService) {
        super(bonPourService);
    }

    ngOnInit(): void {
        this.bonPourItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.bonPourItemsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);

        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
    }
    public prepareEdit() {
        this.item.dateBonPour = this.bonPourService.format(this.item.dateBonPour);
    }



    public validateBonPourItems(){
        this.errorMessages = new Array();
        this.validateBonPourItemsProduit();
        this.validateBonPourItemsQuantite();
        this.validateBonPourItemsPrixUnitaireHt();
        this.validateBonPourItemsPrixUnitaireTtc();
        this.validateBonPourItemsRemise();
        this.validateBonPourItemsMontantHt();
        this.validateBonPourItemsMontantTtc();
    }
    public setValidation(value: boolean){
        this.validBonPourNumero = value;
        this.validBonPourDateBonPour = value;
        this.validBonPourClient = value;
        this.validBonPourMontantTva = value;
        this.validBonPourMontantTtc = value;
        this.validBonPourItemsProduit = value;
        this.validBonPourItemsQuantite = value;
        this.validBonPourItemsPrixUnitaireHt = value;
        this.validBonPourItemsPrixUnitaireTtc = value;
        this.validBonPourItemsRemise = value;
        this.validBonPourItemsMontantHt = value;
        this.validBonPourItemsMontantTtc = value;
        }
   public addBonPourItems() {
        if( this.item.bonPourItems == null )
            this.item.bonPourItems = new Array<BonPourItemDto>();
       this.validateBonPourItems();
       if (this.errorMessages.length === 0) {
            if(this.bonPourItemsElement.id == null){
                this.item.bonPourItems.push(this.bonPourItemsElement);
            }else{
                const index = this.item.bonPourItems.findIndex(e => e.id == this.bonPourItemsElement.id);
                this.item.bonPourItems[index] = this.bonPourItemsElement;
            }
          this.bonPourItemsElement = new BonPourItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteBonPourItems(p: BonPourItemDto) {
        this.item.bonPourItems.forEach((element, index) => {
            if (element === p) { this.item.bonPourItems.splice(index, 1); }
        });
    }

    public editBonPourItems(p: BonPourItemDto) {
        this.bonPourItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateBonPourNumero();
        this.validateBonPourDateBonPour();
        this.validateBonPourClient();
        this.validateBonPourMontantTva();
        this.validateBonPourMontantTtc();
    }
    public validateBonPourNumero(){
        if (this.stringUtilService.isEmpty(this.item.numero)) {
            this.errorMessages.push('Numero non valide');
            this.validBonPourNumero = false;
        } else {
            this.validBonPourNumero = true;
        }
    }
    public validateBonPourDateBonPour(){
        if (this.stringUtilService.isEmpty(this.item.dateBonPour)) {
            this.errorMessages.push('Date bon pour non valide');
            this.validBonPourDateBonPour = false;
        } else {
            this.validBonPourDateBonPour = true;
        }
    }
    public validateBonPourClient(){
        if (this.stringUtilService.isEmpty(this.item.client)) {
            this.errorMessages.push('Client non valide');
            this.validBonPourClient = false;
        } else {
            this.validBonPourClient = true;
        }
    }
    public validateBonPourMontantTva(){
        if (this.stringUtilService.isEmpty(this.item.montantTva)) {
            this.errorMessages.push('Montant tva non valide');
            this.validBonPourMontantTva = false;
        } else {
            this.validBonPourMontantTva = true;
        }
    }
    public validateBonPourMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
            this.errorMessages.push('Montant ttc non valide');
            this.validBonPourMontantTtc = false;
        } else {
            this.validBonPourMontantTtc = true;
        }
    }


    private validateBonPourItemsProduit(){
        if (this.bonPourItemsElement.produit == null) {
        this.errorMessages.push('Produit de la bonPourItem est  invalide');
            this.validBonPourItemsProduit = false;
        } else {
            this.validBonPourItemsProduit = true;
        }
    }
    private validateBonPourItemsQuantite(){
        if (this.bonPourItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la bonPourItem est  invalide');
            this.validBonPourItemsQuantite = false;
        } else {
            this.validBonPourItemsQuantite = true;
        }
    }
    private validateBonPourItemsPrixUnitaireHt(){
        if (this.bonPourItemsElement.prixUnitaireHt == null) {
        this.errorMessages.push('PrixUnitaireHt de la bonPourItem est  invalide');
            this.validBonPourItemsPrixUnitaireHt = false;
        } else {
            this.validBonPourItemsPrixUnitaireHt = true;
        }
    }
    private validateBonPourItemsPrixUnitaireTtc(){
        if (this.bonPourItemsElement.prixUnitaireTtc == null) {
        this.errorMessages.push('PrixUnitaireTtc de la bonPourItem est  invalide');
            this.validBonPourItemsPrixUnitaireTtc = false;
        } else {
            this.validBonPourItemsPrixUnitaireTtc = true;
        }
    }
    private validateBonPourItemsRemise(){
        if (this.bonPourItemsElement.remise == null) {
        this.errorMessages.push('Remise de la bonPourItem est  invalide');
            this.validBonPourItemsRemise = false;
        } else {
            this.validBonPourItemsRemise = true;
        }
    }
    private validateBonPourItemsMontantHt(){
        if (this.bonPourItemsElement.montantHt == null) {
        this.errorMessages.push('MontantHt de la bonPourItem est  invalide');
            this.validBonPourItemsMontantHt = false;
        } else {
            this.validBonPourItemsMontantHt = true;
        }
    }
    private validateBonPourItemsMontantTtc(){
        if (this.bonPourItemsElement.montantTtc == null) {
        this.errorMessages.push('MontantTtc de la bonPourItem est  invalide');
            this.validBonPourItemsMontantTtc = false;
        } else {
            this.validBonPourItemsMontantTtc = true;
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

    get bonPourItemsElement(): BonPourItemDto {
        if( this._bonPourItemsElement == null )
            this._bonPourItemsElement = new BonPourItemDto();
         return this._bonPourItemsElement;
    }

    set bonPourItemsElement(value: BonPourItemDto) {
        this._bonPourItemsElement = value;
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
    get validBonPourItemsProduit(): boolean {
        return this._validBonPourItemsProduit;
    }
    set validBonPourItemsProduit(value: boolean) {
        this._validBonPourItemsProduit = value;
    }
    get validBonPourItemsQuantite(): boolean {
        return this._validBonPourItemsQuantite;
    }
    set validBonPourItemsQuantite(value: boolean) {
        this._validBonPourItemsQuantite = value;
    }
    get validBonPourItemsPrixUnitaireHt(): boolean {
        return this._validBonPourItemsPrixUnitaireHt;
    }
    set validBonPourItemsPrixUnitaireHt(value: boolean) {
        this._validBonPourItemsPrixUnitaireHt = value;
    }
    get validBonPourItemsPrixUnitaireTtc(): boolean {
        return this._validBonPourItemsPrixUnitaireTtc;
    }
    set validBonPourItemsPrixUnitaireTtc(value: boolean) {
        this._validBonPourItemsPrixUnitaireTtc = value;
    }
    get validBonPourItemsRemise(): boolean {
        return this._validBonPourItemsRemise;
    }
    set validBonPourItemsRemise(value: boolean) {
        this._validBonPourItemsRemise = value;
    }
    get validBonPourItemsMontantHt(): boolean {
        return this._validBonPourItemsMontantHt;
    }
    set validBonPourItemsMontantHt(value: boolean) {
        this._validBonPourItemsMontantHt = value;
    }
    get validBonPourItemsMontantTtc(): boolean {
        return this._validBonPourItemsMontantTtc;
    }
    set validBonPourItemsMontantTtc(value: boolean) {
        this._validBonPourItemsMontantTtc = value;
    }
}
