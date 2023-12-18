import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EntreeProduitItemAdminService} from 'src/app/controller/service/admin/stock/EntreeProduitItemAdmin.service';
import {EntreeProduitItemDto} from 'src/app/controller/model/stock/EntreeProduitItem.model';
import {EntreeProduitItemCriteria} from 'src/app/controller/criteria/stock/EntreeProduitItemCriteria.model';


import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {EntreeProduitDto} from 'src/app/controller/model/entree/EntreeProduit.model';
import {EntreeProduitAdminService} from 'src/app/controller/service/admin/entree/EntreeProduitAdmin.service';

@Component({
  selector: 'app-entree-produit-item-edit-admin',
  templateUrl: './entree-produit-item-edit-admin.component.html'
})
export class EntreeProduitItemEditAdminComponent extends AbstractEditController<EntreeProduitItemDto, EntreeProduitItemCriteria, EntreeProduitItemAdminService>   implements OnInit {


    private _validEntreeProduitItemProduit = true;
    private _validEntreeProduitItemQuantite = true;

    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validProduitPrixVente = true;
    private _validProduitSeuilAlerte = true;
    private _validEntreeProduitReference = true;



    constructor( private entreeProduitItemService: EntreeProduitItemAdminService , private produitService: ProduitAdminService, private entreeProduitService: EntreeProduitAdminService) {
        super(entreeProduitItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.entreeProduit = new EntreeProduitDto();
        this.entreeProduitService.findAll().subscribe((data) => this.entreeProduits = data);
    }


    public setValidation(value: boolean){
        this.validEntreeProduitItemProduit = value;
        this.validEntreeProduitItemQuantite = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEntreeProduitItemProduit();
        this.validateEntreeProduitItemQuantite();
    }
    public validateEntreeProduitItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validEntreeProduitItemProduit = false;
        } else {
            this.validEntreeProduitItemProduit = true;
        }
    }
    public validateEntreeProduitItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validEntreeProduitItemQuantite = false;
        } else {
            this.validEntreeProduitItemQuantite = true;
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
   get entreeProduit(): EntreeProduitDto {
       return this.entreeProduitService.item;
   }
  set entreeProduit(value: EntreeProduitDto) {
        this.entreeProduitService.item = value;
   }
   get entreeProduits(): Array<EntreeProduitDto> {
        return this.entreeProduitService.items;
   }
   set entreeProduits(value: Array<EntreeProduitDto>) {
        this.entreeProduitService.items = value;
   }
   get createEntreeProduitDialog(): boolean {
       return this.entreeProduitService.createDialog;
   }
  set createEntreeProduitDialog(value: boolean) {
       this.entreeProduitService.createDialog= value;
   }


    get validEntreeProduitItemProduit(): boolean {
        return this._validEntreeProduitItemProduit;
    }
    set validEntreeProduitItemProduit(value: boolean) {
        this._validEntreeProduitItemProduit = value;
    }
    get validEntreeProduitItemQuantite(): boolean {
        return this._validEntreeProduitItemQuantite;
    }
    set validEntreeProduitItemQuantite(value: boolean) {
        this._validEntreeProduitItemQuantite = value;
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
    get validEntreeProduitReference(): boolean {
        return this._validEntreeProduitReference;
    }
    set validEntreeProduitReference(value: boolean) {
        this._validEntreeProduitReference = value;
    }
}
