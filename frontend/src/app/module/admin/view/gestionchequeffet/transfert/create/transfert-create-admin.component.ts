import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TransfertAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertAdmin.service';
import {TransfertDto} from 'src/app/controller/model/gestionchequeffet/Transfert.model';
import {TransfertCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransfertCriteria.model';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {TransfertItemDto} from 'src/app/controller/model/gestionchequeffet/TransfertItem.model';
import {TransfertItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransfertItemAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {RaisonDto} from 'src/app/controller/model/Transfert/Raison.model';
import {RaisonAdminService} from 'src/app/controller/service/admin/Transfert/RaisonAdmin.service';
@Component({
  selector: 'app-transfert-create-admin',
  templateUrl: './transfert-create-admin.component.html'
})
export class TransfertCreateAdminComponent extends AbstractCreateController<TransfertDto, TransfertCriteria, TransfertAdminService>  implements OnInit {

    private _transfertItemsElement = new TransfertItemDto();


   private _validTransfertDateTransfert = true;
    private _validRaisonLibelle = true;
    private _validTransfertItemsQuantite = true;

    constructor( private transfertService: TransfertAdminService , private depotService: DepotAdminService, private transfertItemService: TransfertItemAdminService, private produitService: ProduitAdminService, private raisonService: RaisonAdminService) {
        super(transfertService);
    }

    ngOnInit(): void {
        this.transfertItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.transfertItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.raison = new RaisonDto();
        this.raisonService.findAll().subscribe((data) => this.raisons = data);
    }



    validateTransfertItems(){
        this.errorMessages = new Array();
        this.validateTransfertItemsQuantite();
    }


    public setValidation(value: boolean){
        this.validTransfertDateTransfert = value;
        this.validTransfertItemsQuantite = value;
    }

    public addTransfertItems() {
        if( this.item.transfertItems == null )
            this.item.transfertItems = new Array<TransfertItemDto>();
       this.validateTransfertItems();
       if (this.errorMessages.length === 0) {
              this.item.transfertItems.push({... this.transfertItemsElement});
              this.transfertItemsElement = new TransfertItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletetransfertItems(p: TransfertItemDto) {
        this.item.transfertItems.forEach((element, index) => {
            if (element === p) { this.item.transfertItems.splice(index, 1); }
        });
    }

    public edittransfertItems(p: TransfertItemDto) {
        this.transfertItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTransfertDateTransfert();
    }

    public validateTransfertDateTransfert(){
        if (this.stringUtilService.isEmpty(this.item.dateTransfert)) {
        this.errorMessages.push('Date transfert non valide');
        this.validTransfertDateTransfert = false;
        } else {
            this.validTransfertDateTransfert = true;
        }
    }

    public validateTransfertItemsQuantite(){
        if (this.transfertItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la transfertItem est  invalide');
            this.validTransfertItemsQuantite = false;
        } else {
            this.validTransfertItemsQuantite = true;
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
    get raison(): RaisonDto {
        return this.raisonService.item;
    }
    set raison(value: RaisonDto) {
        this.raisonService.item = value;
    }
    get raisons(): Array<RaisonDto> {
        return this.raisonService.items;
    }
    set raisons(value: Array<RaisonDto>) {
        this.raisonService.items = value;
    }
    get createRaisonDialog(): boolean {
       return this.raisonService.createDialog;
    }
    set createRaisonDialog(value: boolean) {
        this.raisonService.createDialog= value;
    }



    get validTransfertDateTransfert(): boolean {
        return this._validTransfertDateTransfert;
    }

    set validTransfertDateTransfert(value: boolean) {
         this._validTransfertDateTransfert = value;
    }

    get validRaisonLibelle(): boolean {
        return this._validRaisonLibelle;
    }
    set validRaisonLibelle(value: boolean) {
        this._validRaisonLibelle = value;
    }
    get validTransfertItemsQuantite(): boolean {
        return this._validTransfertItemsQuantite;
    }
    set validTransfertItemsQuantite(value: boolean) {
        this._validTransfertItemsQuantite = value;
    }

    get transfertItemsElement(): TransfertItemDto {
        if( this._transfertItemsElement == null )
            this._transfertItemsElement = new TransfertItemDto();
        return this._transfertItemsElement;
    }

    set transfertItemsElement(value: TransfertItemDto) {
        this._transfertItemsElement = value;
    }

}
