import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TransfertItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertItemAdmin.service';
import {TransfertItemDto} from 'src/app/controller/model/gestionchequeffet/TransfertItem.model';
import {TransfertItemCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransfertItemCriteria.model';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {TransfertDto} from 'src/app/controller/model/gestionchequeffet/Transfert.model';
import {TransfertAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertAdmin.service';
@Component({
  selector: 'app-transfert-item-create-admin',
  templateUrl: './transfert-item-create-admin.component.html'
})
export class TransfertItemCreateAdminComponent extends AbstractCreateController<TransfertItemDto, TransfertItemCriteria, TransfertItemAdminService>  implements OnInit {



   private _validTransfertItemQuantite = true;
    private _validDepotLibelle = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validProduitPrixVente = true;
    private _validProduitSeuilAlerte = true;
    private _validTransfertDateTransfert = true;

    constructor( private transfertItemService: TransfertItemAdminService , private depotService: DepotAdminService, private produitService: ProduitAdminService, private transfertService: TransfertAdminService) {
        super(transfertItemService);
    }

    ngOnInit(): void {
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.transfert = new TransfertDto();
        this.transfertService.findAll().subscribe((data) => this.transferts = data);
    }





    public setValidation(value: boolean){
        this.validTransfertItemQuantite = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTransfertItemQuantite();
    }

    public validateTransfertItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
        this.errorMessages.push('Quantite non valide');
        this.validTransfertItemQuantite = false;
        } else {
            this.validTransfertItemQuantite = true;
        }
    }


    public async openCreateTransfert(transfert: string) {
    const isPermistted = await this.roleService.isPermitted('Transfert', 'add');
    if(isPermistted) {
         this.transfert = new TransfertDto();
         this.createTransfertDialog = true;
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
    get transfert(): TransfertDto {
        return this.transfertService.item;
    }
    set transfert(value: TransfertDto) {
        this.transfertService.item = value;
    }
    get transferts(): Array<TransfertDto> {
        return this.transfertService.items;
    }
    set transferts(value: Array<TransfertDto>) {
        this.transfertService.items = value;
    }
    get createTransfertDialog(): boolean {
       return this.transfertService.createDialog;
    }
    set createTransfertDialog(value: boolean) {
        this.transfertService.createDialog= value;
    }



    get validTransfertItemQuantite(): boolean {
        return this._validTransfertItemQuantite;
    }

    set validTransfertItemQuantite(value: boolean) {
         this._validTransfertItemQuantite = value;
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
    get validTransfertDateTransfert(): boolean {
        return this._validTransfertDateTransfert;
    }
    set validTransfertDateTransfert(value: boolean) {
        this._validTransfertDateTransfert = value;
    }


}
