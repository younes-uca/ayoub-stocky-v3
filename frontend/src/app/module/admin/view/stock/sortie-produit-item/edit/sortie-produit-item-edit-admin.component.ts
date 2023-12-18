import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {SortieProduitItemAdminService} from 'src/app/controller/service/admin/stock/SortieProduitItemAdmin.service';
import {SortieProduitItemDto} from 'src/app/controller/model/stock/SortieProduitItem.model';
import {SortieProduitItemCriteria} from 'src/app/controller/criteria/stock/SortieProduitItemCriteria.model';


import {SortieProduitDto} from 'src/app/controller/model/entree/SortieProduit.model';
import {SortieProduitAdminService} from 'src/app/controller/service/admin/entree/SortieProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';

@Component({
  selector: 'app-sortie-produit-item-edit-admin',
  templateUrl: './sortie-produit-item-edit-admin.component.html'
})
export class SortieProduitItemEditAdminComponent extends AbstractEditController<SortieProduitItemDto, SortieProduitItemCriteria, SortieProduitItemAdminService>   implements OnInit {


    private _validSortieProduitItemProduit = true;
    private _validSortieProduitItemQuantite = true;

    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validProduitPrixVente = true;
    private _validProduitSeuilAlerte = true;
    private _validSortieProduitReference = true;



    constructor( private sortieProduitItemService: SortieProduitItemAdminService , private sortieProduitService: SortieProduitAdminService, private produitService: ProduitAdminService) {
        super(sortieProduitItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.sortieProduit = new SortieProduitDto();
        this.sortieProduitService.findAll().subscribe((data) => this.sortieProduits = data);
    }


    public setValidation(value: boolean){
        this.validSortieProduitItemProduit = value;
        this.validSortieProduitItemQuantite = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSortieProduitItemProduit();
        this.validateSortieProduitItemQuantite();
    }
    public validateSortieProduitItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validSortieProduitItemProduit = false;
        } else {
            this.validSortieProduitItemProduit = true;
        }
    }
    public validateSortieProduitItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validSortieProduitItemQuantite = false;
        } else {
            this.validSortieProduitItemQuantite = true;
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
   get sortieProduit(): SortieProduitDto {
       return this.sortieProduitService.item;
   }
  set sortieProduit(value: SortieProduitDto) {
        this.sortieProduitService.item = value;
   }
   get sortieProduits(): Array<SortieProduitDto> {
        return this.sortieProduitService.items;
   }
   set sortieProduits(value: Array<SortieProduitDto>) {
        this.sortieProduitService.items = value;
   }
   get createSortieProduitDialog(): boolean {
       return this.sortieProduitService.createDialog;
   }
  set createSortieProduitDialog(value: boolean) {
       this.sortieProduitService.createDialog= value;
   }


    get validSortieProduitItemProduit(): boolean {
        return this._validSortieProduitItemProduit;
    }
    set validSortieProduitItemProduit(value: boolean) {
        this._validSortieProduitItemProduit = value;
    }
    get validSortieProduitItemQuantite(): boolean {
        return this._validSortieProduitItemQuantite;
    }
    set validSortieProduitItemQuantite(value: boolean) {
        this._validSortieProduitItemQuantite = value;
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
    get validSortieProduitReference(): boolean {
        return this._validSortieProduitReference;
    }
    set validSortieProduitReference(value: boolean) {
        this._validSortieProduitReference = value;
    }
}
