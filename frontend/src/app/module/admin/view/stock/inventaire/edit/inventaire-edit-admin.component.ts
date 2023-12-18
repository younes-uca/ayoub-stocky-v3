import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {InventaireAdminService} from 'src/app/controller/service/admin/stock/InventaireAdmin.service';
import {InventaireDto} from 'src/app/controller/model/stock/Inventaire.model';
import {InventaireCriteria} from 'src/app/controller/criteria/stock/InventaireCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {InventaireItemDto} from 'src/app/controller/model/stock/InventaireItem.model';
import {InventaireItemAdminService} from 'src/app/controller/service/admin/stock/InventaireItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';

@Component({
  selector: 'app-inventaire-edit-admin',
  templateUrl: './inventaire-edit-admin.component.html'
})
export class InventaireEditAdminComponent extends AbstractEditController<InventaireDto, InventaireCriteria, InventaireAdminService>   implements OnInit {

    private _inventaireItemsElement = new InventaireItemDto();

    private _validInventaireReference = true;
    private _validInventaireDateInventaire = true;

    private _validEntrepriseSocieteNom = true;
    private _validDepotLibelle = true;
    private _validInventaireItemsQuantiteEstime = true;
    private _validInventaireItemsQuantiteReelle = true;



    constructor( private inventaireService: InventaireAdminService , private depotService: DepotAdminService, private inventaireItemService: InventaireItemAdminService, private produitService: ProduitAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService) {
        super(inventaireService);
    }

    ngOnInit(): void {
        this.inventaireItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);

        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
    }
    public prepareEdit() {
        this.item.dateInventaire = this.inventaireService.format(this.item.dateInventaire);
    }



    public validateInventaireItems(){
        this.errorMessages = new Array();
        this.validateInventaireItemsQuantiteEstime();
        this.validateInventaireItemsQuantiteReelle();
    }
    public setValidation(value: boolean){
        this.validInventaireReference = value;
        this.validInventaireDateInventaire = value;
        this.validInventaireItemsQuantiteEstime = value;
        this.validInventaireItemsQuantiteReelle = value;
        }
   public addInventaireItems() {
        if( this.item.inventaireItems == null )
            this.item.inventaireItems = new Array<InventaireItemDto>();
       this.validateInventaireItems();
       if (this.errorMessages.length === 0) {
            if(this.inventaireItemsElement.id == null){
                this.item.inventaireItems.push(this.inventaireItemsElement);
            }else{
                const index = this.item.inventaireItems.findIndex(e => e.id == this.inventaireItemsElement.id);
                this.item.inventaireItems[index] = this.inventaireItemsElement;
            }
          this.inventaireItemsElement = new InventaireItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteInventaireItems(p: InventaireItemDto) {
        this.item.inventaireItems.forEach((element, index) => {
            if (element === p) { this.item.inventaireItems.splice(index, 1); }
        });
    }

    public editInventaireItems(p: InventaireItemDto) {
        this.inventaireItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateInventaireReference();
        this.validateInventaireDateInventaire();
    }
    public validateInventaireReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validInventaireReference = false;
        } else {
            this.validInventaireReference = true;
        }
    }
    public validateInventaireDateInventaire(){
        if (this.stringUtilService.isEmpty(this.item.dateInventaire)) {
            this.errorMessages.push('Date inventaire non valide');
            this.validInventaireDateInventaire = false;
        } else {
            this.validInventaireDateInventaire = true;
        }
    }


    private validateInventaireItemsQuantiteEstime(){
        if (this.inventaireItemsElement.quantiteEstime == null) {
        this.errorMessages.push('QuantiteEstime de la inventaireItem est  invalide');
            this.validInventaireItemsQuantiteEstime = false;
        } else {
            this.validInventaireItemsQuantiteEstime = true;
        }
    }
    private validateInventaireItemsQuantiteReelle(){
        if (this.inventaireItemsElement.quantiteReelle == null) {
        this.errorMessages.push('QuantiteReelle de la inventaireItem est  invalide');
            this.validInventaireItemsQuantiteReelle = false;
        } else {
            this.validInventaireItemsQuantiteReelle = true;
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

    get inventaireItemsElement(): InventaireItemDto {
        if( this._inventaireItemsElement == null )
            this._inventaireItemsElement = new InventaireItemDto();
         return this._inventaireItemsElement;
    }

    set inventaireItemsElement(value: InventaireItemDto) {
        this._inventaireItemsElement = value;
    }

    get validInventaireReference(): boolean {
        return this._validInventaireReference;
    }
    set validInventaireReference(value: boolean) {
        this._validInventaireReference = value;
    }
    get validInventaireDateInventaire(): boolean {
        return this._validInventaireDateInventaire;
    }
    set validInventaireDateInventaire(value: boolean) {
        this._validInventaireDateInventaire = value;
    }

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
    }
    get validDepotLibelle(): boolean {
        return this._validDepotLibelle;
    }
    set validDepotLibelle(value: boolean) {
        this._validDepotLibelle = value;
    }
    get validInventaireItemsQuantiteEstime(): boolean {
        return this._validInventaireItemsQuantiteEstime;
    }
    set validInventaireItemsQuantiteEstime(value: boolean) {
        this._validInventaireItemsQuantiteEstime = value;
    }
    get validInventaireItemsQuantiteReelle(): boolean {
        return this._validInventaireItemsQuantiteReelle;
    }
    set validInventaireItemsQuantiteReelle(value: boolean) {
        this._validInventaireItemsQuantiteReelle = value;
    }
}
