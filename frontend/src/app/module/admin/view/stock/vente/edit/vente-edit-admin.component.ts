import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/stock/VenteCriteria.model';


import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {ReglementVenteDto} from 'src/app/controller/model/reglement/ReglementVente.model';
import {ReglementVenteAdminService} from 'src/app/controller/service/admin/reglement/ReglementVenteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
import {VenteItemDto} from 'src/app/controller/model/stock/VenteItem.model';
import {VenteItemAdminService} from 'src/app/controller/service/admin/stock/VenteItemAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {EtatVenteDto} from 'src/app/controller/model/commun/EtatVente.model';
import {EtatVenteAdminService} from 'src/app/controller/service/admin/commun/EtatVenteAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirVenteAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';

@Component({
  selector: 'app-vente-edit-admin',
  templateUrl: './vente-edit-admin.component.html'
})
export class VenteEditAdminComponent extends AbstractEditController<VenteDto, VenteCriteria, VenteAdminService>   implements OnInit {

    private _venteItemsElement = new VenteItemDto();
    private _avoirVentesElement = new AvoirVenteDto();
    private _reglementVentesElement = new ReglementVenteDto();

    private _validVenteBarCode = true;
    private _validVenteEntrepriseSociete = true;
    private _validVenteCodeVente = true;
    private _validVenteDateFacture = true;
    private _validVenteNumeroFacture = true;
    private _validVenteClient = true;
    private _validVenteMontantHt = true;
    private _validVenteMontantTva = true;
    private _validVenteMontantTtc = true;

    private _validEntrepriseSocieteNom = true;
    private _validClientCin = true;
    private _validClientNom = true;
    private _validClientTelephone = true;
    private _validEtatVenteLibelle = true;
    private _validVenteItemsBarCode = true;
    private _validVenteItemsQuantite = true;
    private _validVenteItemsQuantiteVendue = true;
    private _validVenteItemsPrixUnitaireHt = true;
    private _validVenteItemsPrixUnitaireTtc = true;
    private _validVenteItemsRemise = true;
    private _validVenteItemsMontantHt = true;
    private _validVenteItemsMontantTtc = true;
    private _validAvoirVentesBarCode = true;
    private _validAvoirVentesEntrepriseSociete = true;
    private _validAvoirVentesCodeAvoirVente = true;
    private _validAvoirVentesNumeroFactureAvoirVente = true;
    private _validAvoirVentesDateFactureAvoirVente = true;
    private _validAvoirVentesClient = true;
    private _validAvoirVentesMontantTtc = true;
    private _validReglementVentesReference = true;
    private _validReglementVentesDateReglement = true;
    private _validReglementVentesMontant = true;
    private _validReglementVentesVente = true;
    private _validReglementVentesModeReglement = true;



    constructor( private venteService: VenteAdminService , private etatVenteService: EtatVenteAdminService, private clientService: ClientAdminService, private depotService: DepotAdminService, private venteItemService: VenteItemAdminService, private avoirVenteService: AvoirVenteAdminService, private reglementVenteService: ReglementVenteAdminService, private produitService: ProduitAdminService, private etatAvoirVenteService: EtatAvoirVenteAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private modeReglementService: ModeReglementAdminService, private taxeService: TaxeAdminService) {
        super(venteService);
    }

    ngOnInit(): void {
        this.venteItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.venteItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.venteItemsElement.taxe = new TaxeDto();
        this.taxeService.findAll().subscribe((data) => this.taxes = data);

        this.avoirVentesElement.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.avoirVentesElement.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.avoirVentesElement.etatAvoirVente = new EtatAvoirVenteDto();
        this.etatAvoirVenteService.findAll().subscribe((data) => this.etatAvoirVentes = data);

        this.reglementVentesElement.modeReglement = new ModeReglementDto();
        this.modeReglementService.findAll().subscribe((data) => this.modeReglements = data);

        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.etatVente = new EtatVenteDto();
        this.etatVenteService.findAll().subscribe((data) => this.etatVentes = data);
    }
    public prepareEdit() {
        this.item.dateFacture = this.venteService.format(this.item.dateFacture);
    }



    public validateVenteItems(){
        this.errorMessages = new Array();
        this.validateVenteItemsBarCode();
        this.validateVenteItemsQuantite();
        this.validateVenteItemsQuantiteVendue();
        this.validateVenteItemsPrixUnitaireHt();
        this.validateVenteItemsPrixUnitaireTtc();
        this.validateVenteItemsRemise();
        this.validateVenteItemsMontantHt();
        this.validateVenteItemsMontantTtc();
    }
    public validateAvoirVentes(){
        this.errorMessages = new Array();
        this.validateAvoirVentesBarCode();
        this.validateAvoirVentesEntrepriseSociete();
        this.validateAvoirVentesCodeAvoirVente();
        this.validateAvoirVentesNumeroFactureAvoirVente();
        this.validateAvoirVentesDateFactureAvoirVente();
        this.validateAvoirVentesClient();
        this.validateAvoirVentesMontantTtc();
    }
    public validateReglementVentes(){
        this.errorMessages = new Array();
        this.validateReglementVentesReference();
        this.validateReglementVentesDateReglement();
        this.validateReglementVentesMontant();
        this.validateReglementVentesVente();
        this.validateReglementVentesModeReglement();
    }
    public setValidation(value: boolean){
        this.validVenteBarCode = value;
        this.validVenteEntrepriseSociete = value;
        this.validVenteCodeVente = value;
        this.validVenteDateFacture = value;
        this.validVenteNumeroFacture = value;
        this.validVenteClient = value;
        this.validVenteMontantHt = value;
        this.validVenteMontantTva = value;
        this.validVenteMontantTtc = value;
        this.validVenteItemsBarCode = value;
        this.validVenteItemsQuantite = value;
        this.validVenteItemsQuantiteVendue = value;
        this.validVenteItemsPrixUnitaireHt = value;
        this.validVenteItemsPrixUnitaireTtc = value;
        this.validVenteItemsRemise = value;
        this.validVenteItemsMontantHt = value;
        this.validVenteItemsMontantTtc = value;
        this.validAvoirVentesBarCode = value;
        this.validAvoirVentesEntrepriseSociete = value;
        this.validAvoirVentesCodeAvoirVente = value;
        this.validAvoirVentesNumeroFactureAvoirVente = value;
        this.validAvoirVentesDateFactureAvoirVente = value;
        this.validAvoirVentesClient = value;
        this.validAvoirVentesMontantTtc = value;
        this.validReglementVentesReference = value;
        this.validReglementVentesDateReglement = value;
        this.validReglementVentesMontant = value;
        this.validReglementVentesVente = value;
        this.validReglementVentesModeReglement = value;
        }
   public addVenteItems() {
        if( this.item.venteItems == null )
            this.item.venteItems = new Array<VenteItemDto>();
       this.validateVenteItems();
       if (this.errorMessages.length === 0) {
            if(this.venteItemsElement.id == null){
                this.item.venteItems.push(this.venteItemsElement);
            }else{
                const index = this.item.venteItems.findIndex(e => e.id == this.venteItemsElement.id);
                this.item.venteItems[index] = this.venteItemsElement;
            }
          this.venteItemsElement = new VenteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteVenteItems(p: VenteItemDto) {
        this.item.venteItems.forEach((element, index) => {
            if (element === p) { this.item.venteItems.splice(index, 1); }
        });
    }

    public editVenteItems(p: VenteItemDto) {
        this.venteItemsElement = {... p};
        this.activeTab = 0;
    }
   public addAvoirVentes() {
        if( this.item.avoirVentes == null )
            this.item.avoirVentes = new Array<AvoirVenteDto>();
       this.validateAvoirVentes();
       if (this.errorMessages.length === 0) {
            if(this.avoirVentesElement.id == null){
                this.item.avoirVentes.push(this.avoirVentesElement);
            }else{
                const index = this.item.avoirVentes.findIndex(e => e.id == this.avoirVentesElement.id);
                this.item.avoirVentes[index] = this.avoirVentesElement;
            }
          this.avoirVentesElement = new AvoirVenteDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirVentes(p: AvoirVenteDto) {
        this.item.avoirVentes.forEach((element, index) => {
            if (element === p) { this.item.avoirVentes.splice(index, 1); }
        });
    }

    public editAvoirVentes(p: AvoirVenteDto) {
        this.avoirVentesElement = {... p};
        this.activeTab = 0;
    }
   public addReglementVentes() {
        if( this.item.reglementVentes == null )
            this.item.reglementVentes = new Array<ReglementVenteDto>();
       this.validateReglementVentes();
       if (this.errorMessages.length === 0) {
            if(this.reglementVentesElement.id == null){
                this.item.reglementVentes.push(this.reglementVentesElement);
            }else{
                const index = this.item.reglementVentes.findIndex(e => e.id == this.reglementVentesElement.id);
                this.item.reglementVentes[index] = this.reglementVentesElement;
            }
          this.reglementVentesElement = new ReglementVenteDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteReglementVentes(p: ReglementVenteDto) {
        this.item.reglementVentes.forEach((element, index) => {
            if (element === p) { this.item.reglementVentes.splice(index, 1); }
        });
    }

    public editReglementVentes(p: ReglementVenteDto) {
        this.reglementVentesElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateVenteBarCode();
        this.validateVenteEntrepriseSociete();
        this.validateVenteCodeVente();
        this.validateVenteDateFacture();
        this.validateVenteNumeroFacture();
        this.validateVenteClient();
        this.validateVenteMontantHt();
        this.validateVenteMontantTva();
        this.validateVenteMontantTtc();
    }
    public validateVenteBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
            this.errorMessages.push('Bar code non valide');
            this.validVenteBarCode = false;
        } else {
            this.validVenteBarCode = true;
        }
    }
    public validateVenteEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
            this.errorMessages.push('Entreprise societe non valide');
            this.validVenteEntrepriseSociete = false;
        } else {
            this.validVenteEntrepriseSociete = true;
        }
    }
    public validateVenteCodeVente(){
        if (this.stringUtilService.isEmpty(this.item.codeVente)) {
            this.errorMessages.push('Code vente non valide');
            this.validVenteCodeVente = false;
        } else {
            this.validVenteCodeVente = true;
        }
    }
    public validateVenteDateFacture(){
        if (this.stringUtilService.isEmpty(this.item.dateFacture)) {
            this.errorMessages.push('Date facture non valide');
            this.validVenteDateFacture = false;
        } else {
            this.validVenteDateFacture = true;
        }
    }
    public validateVenteNumeroFacture(){
        if (this.stringUtilService.isEmpty(this.item.numeroFacture)) {
            this.errorMessages.push('Numero facture non valide');
            this.validVenteNumeroFacture = false;
        } else {
            this.validVenteNumeroFacture = true;
        }
    }
    public validateVenteClient(){
        if (this.stringUtilService.isEmpty(this.item.client)) {
            this.errorMessages.push('Client non valide');
            this.validVenteClient = false;
        } else {
            this.validVenteClient = true;
        }
    }
    public validateVenteMontantHt(){
        if (this.stringUtilService.isEmpty(this.item.montantHt)) {
            this.errorMessages.push('Montant ht non valide');
            this.validVenteMontantHt = false;
        } else {
            this.validVenteMontantHt = true;
        }
    }
    public validateVenteMontantTva(){
        if (this.stringUtilService.isEmpty(this.item.montantTva)) {
            this.errorMessages.push('Montant tva non valide');
            this.validVenteMontantTva = false;
        } else {
            this.validVenteMontantTva = true;
        }
    }
    public validateVenteMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
            this.errorMessages.push('Montant ttc non valide');
            this.validVenteMontantTtc = false;
        } else {
            this.validVenteMontantTtc = true;
        }
    }


    private validateVenteItemsBarCode(){
        if (this.venteItemsElement.barCode == null) {
        this.errorMessages.push('BarCode de la venteItem est  invalide');
            this.validVenteItemsBarCode = false;
        } else {
            this.validVenteItemsBarCode = true;
        }
    }
    private validateVenteItemsQuantite(){
        if (this.venteItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la venteItem est  invalide');
            this.validVenteItemsQuantite = false;
        } else {
            this.validVenteItemsQuantite = true;
        }
    }
    private validateVenteItemsQuantiteVendue(){
        if (this.venteItemsElement.quantiteVendue == null) {
        this.errorMessages.push('QuantiteVendue de la venteItem est  invalide');
            this.validVenteItemsQuantiteVendue = false;
        } else {
            this.validVenteItemsQuantiteVendue = true;
        }
    }
    private validateVenteItemsPrixUnitaireHt(){
        if (this.venteItemsElement.prixUnitaireHt == null) {
        this.errorMessages.push('PrixUnitaireHt de la venteItem est  invalide');
            this.validVenteItemsPrixUnitaireHt = false;
        } else {
            this.validVenteItemsPrixUnitaireHt = true;
        }
    }
    private validateVenteItemsPrixUnitaireTtc(){
        if (this.venteItemsElement.prixUnitaireTtc == null) {
        this.errorMessages.push('PrixUnitaireTtc de la venteItem est  invalide');
            this.validVenteItemsPrixUnitaireTtc = false;
        } else {
            this.validVenteItemsPrixUnitaireTtc = true;
        }
    }
    private validateVenteItemsRemise(){
        if (this.venteItemsElement.remise == null) {
        this.errorMessages.push('Remise de la venteItem est  invalide');
            this.validVenteItemsRemise = false;
        } else {
            this.validVenteItemsRemise = true;
        }
    }
    private validateVenteItemsMontantHt(){
        if (this.venteItemsElement.montantHt == null) {
        this.errorMessages.push('MontantHt de la venteItem est  invalide');
            this.validVenteItemsMontantHt = false;
        } else {
            this.validVenteItemsMontantHt = true;
        }
    }
    private validateVenteItemsMontantTtc(){
        if (this.venteItemsElement.montantTtc == null) {
        this.errorMessages.push('MontantTtc de la venteItem est  invalide');
            this.validVenteItemsMontantTtc = false;
        } else {
            this.validVenteItemsMontantTtc = true;
        }
    }
    private validateAvoirVentesBarCode(){
        if (this.avoirVentesElement.barCode == null) {
        this.errorMessages.push('BarCode de la avoirVente est  invalide');
            this.validAvoirVentesBarCode = false;
        } else {
            this.validAvoirVentesBarCode = true;
        }
    }
    private validateAvoirVentesEntrepriseSociete(){
        if (this.avoirVentesElement.entrepriseSociete == null) {
        this.errorMessages.push('EntrepriseSociete de la avoirVente est  invalide');
            this.validAvoirVentesEntrepriseSociete = false;
        } else {
            this.validAvoirVentesEntrepriseSociete = true;
        }
    }
    private validateAvoirVentesCodeAvoirVente(){
        if (this.avoirVentesElement.codeAvoirVente == null) {
        this.errorMessages.push('CodeAvoirVente de la avoirVente est  invalide');
            this.validAvoirVentesCodeAvoirVente = false;
        } else {
            this.validAvoirVentesCodeAvoirVente = true;
        }
    }
    private validateAvoirVentesNumeroFactureAvoirVente(){
        if (this.avoirVentesElement.numeroFactureAvoirVente == null) {
        this.errorMessages.push('NumeroFactureAvoirVente de la avoirVente est  invalide');
            this.validAvoirVentesNumeroFactureAvoirVente = false;
        } else {
            this.validAvoirVentesNumeroFactureAvoirVente = true;
        }
    }
    private validateAvoirVentesDateFactureAvoirVente(){
        if (this.avoirVentesElement.dateFactureAvoirVente == null) {
        this.errorMessages.push('DateFactureAvoirVente de la avoirVente est  invalide');
            this.validAvoirVentesDateFactureAvoirVente = false;
        } else {
            this.validAvoirVentesDateFactureAvoirVente = true;
        }
    }
    private validateAvoirVentesClient(){
        if (this.avoirVentesElement.client == null) {
        this.errorMessages.push('Client de la avoirVente est  invalide');
            this.validAvoirVentesClient = false;
        } else {
            this.validAvoirVentesClient = true;
        }
    }
    private validateAvoirVentesMontantTtc(){
        if (this.avoirVentesElement.montantTtc == null) {
        this.errorMessages.push('MontantTtc de la avoirVente est  invalide');
            this.validAvoirVentesMontantTtc = false;
        } else {
            this.validAvoirVentesMontantTtc = true;
        }
    }
    private validateReglementVentesReference(){
        if (this.reglementVentesElement.reference == null) {
        this.errorMessages.push('Reference de la reglementVente est  invalide');
            this.validReglementVentesReference = false;
        } else {
            this.validReglementVentesReference = true;
        }
    }
    private validateReglementVentesDateReglement(){
        if (this.reglementVentesElement.dateReglement == null) {
        this.errorMessages.push('DateReglement de la reglementVente est  invalide');
            this.validReglementVentesDateReglement = false;
        } else {
            this.validReglementVentesDateReglement = true;
        }
    }
    private validateReglementVentesMontant(){
        if (this.reglementVentesElement.montant == null) {
        this.errorMessages.push('Montant de la reglementVente est  invalide');
            this.validReglementVentesMontant = false;
        } else {
            this.validReglementVentesMontant = true;
        }
    }
    private validateReglementVentesVente(){
        if (this.reglementVentesElement.vente == null) {
        this.errorMessages.push('Vente de la reglementVente est  invalide');
            this.validReglementVentesVente = false;
        } else {
            this.validReglementVentesVente = true;
        }
    }
    private validateReglementVentesModeReglement(){
        if (this.reglementVentesElement.modeReglement == null) {
        this.errorMessages.push('ModeReglement de la reglementVente est  invalide');
            this.validReglementVentesModeReglement = false;
        } else {
            this.validReglementVentesModeReglement = true;
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
   get modeReglement(): ModeReglementDto {
       return this.modeReglementService.item;
   }
  set modeReglement(value: ModeReglementDto) {
        this.modeReglementService.item = value;
   }
   get modeReglements(): Array<ModeReglementDto> {
        return this.modeReglementService.items;
   }
   set modeReglements(value: Array<ModeReglementDto>) {
        this.modeReglementService.items = value;
   }
   get createModeReglementDialog(): boolean {
       return this.modeReglementService.createDialog;
   }
  set createModeReglementDialog(value: boolean) {
       this.modeReglementService.createDialog= value;
   }
   get etatVente(): EtatVenteDto {
       return this.etatVenteService.item;
   }
  set etatVente(value: EtatVenteDto) {
        this.etatVenteService.item = value;
   }
   get etatVentes(): Array<EtatVenteDto> {
        return this.etatVenteService.items;
   }
   set etatVentes(value: Array<EtatVenteDto>) {
        this.etatVenteService.items = value;
   }
   get createEtatVenteDialog(): boolean {
       return this.etatVenteService.createDialog;
   }
  set createEtatVenteDialog(value: boolean) {
       this.etatVenteService.createDialog= value;
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

    get venteItemsElement(): VenteItemDto {
        if( this._venteItemsElement == null )
            this._venteItemsElement = new VenteItemDto();
         return this._venteItemsElement;
    }

    set venteItemsElement(value: VenteItemDto) {
        this._venteItemsElement = value;
    }
    get avoirVentesElement(): AvoirVenteDto {
        if( this._avoirVentesElement == null )
            this._avoirVentesElement = new AvoirVenteDto();
         return this._avoirVentesElement;
    }

    set avoirVentesElement(value: AvoirVenteDto) {
        this._avoirVentesElement = value;
    }
    get reglementVentesElement(): ReglementVenteDto {
        if( this._reglementVentesElement == null )
            this._reglementVentesElement = new ReglementVenteDto();
         return this._reglementVentesElement;
    }

    set reglementVentesElement(value: ReglementVenteDto) {
        this._reglementVentesElement = value;
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
    get validEtatVenteLibelle(): boolean {
        return this._validEtatVenteLibelle;
    }
    set validEtatVenteLibelle(value: boolean) {
        this._validEtatVenteLibelle = value;
    }
    get validVenteItemsBarCode(): boolean {
        return this._validVenteItemsBarCode;
    }
    set validVenteItemsBarCode(value: boolean) {
        this._validVenteItemsBarCode = value;
    }
    get validVenteItemsQuantite(): boolean {
        return this._validVenteItemsQuantite;
    }
    set validVenteItemsQuantite(value: boolean) {
        this._validVenteItemsQuantite = value;
    }
    get validVenteItemsQuantiteVendue(): boolean {
        return this._validVenteItemsQuantiteVendue;
    }
    set validVenteItemsQuantiteVendue(value: boolean) {
        this._validVenteItemsQuantiteVendue = value;
    }
    get validVenteItemsPrixUnitaireHt(): boolean {
        return this._validVenteItemsPrixUnitaireHt;
    }
    set validVenteItemsPrixUnitaireHt(value: boolean) {
        this._validVenteItemsPrixUnitaireHt = value;
    }
    get validVenteItemsPrixUnitaireTtc(): boolean {
        return this._validVenteItemsPrixUnitaireTtc;
    }
    set validVenteItemsPrixUnitaireTtc(value: boolean) {
        this._validVenteItemsPrixUnitaireTtc = value;
    }
    get validVenteItemsRemise(): boolean {
        return this._validVenteItemsRemise;
    }
    set validVenteItemsRemise(value: boolean) {
        this._validVenteItemsRemise = value;
    }
    get validVenteItemsMontantHt(): boolean {
        return this._validVenteItemsMontantHt;
    }
    set validVenteItemsMontantHt(value: boolean) {
        this._validVenteItemsMontantHt = value;
    }
    get validVenteItemsMontantTtc(): boolean {
        return this._validVenteItemsMontantTtc;
    }
    set validVenteItemsMontantTtc(value: boolean) {
        this._validVenteItemsMontantTtc = value;
    }
    get validAvoirVentesBarCode(): boolean {
        return this._validAvoirVentesBarCode;
    }
    set validAvoirVentesBarCode(value: boolean) {
        this._validAvoirVentesBarCode = value;
    }
    get validAvoirVentesEntrepriseSociete(): boolean {
        return this._validAvoirVentesEntrepriseSociete;
    }
    set validAvoirVentesEntrepriseSociete(value: boolean) {
        this._validAvoirVentesEntrepriseSociete = value;
    }
    get validAvoirVentesCodeAvoirVente(): boolean {
        return this._validAvoirVentesCodeAvoirVente;
    }
    set validAvoirVentesCodeAvoirVente(value: boolean) {
        this._validAvoirVentesCodeAvoirVente = value;
    }
    get validAvoirVentesNumeroFactureAvoirVente(): boolean {
        return this._validAvoirVentesNumeroFactureAvoirVente;
    }
    set validAvoirVentesNumeroFactureAvoirVente(value: boolean) {
        this._validAvoirVentesNumeroFactureAvoirVente = value;
    }
    get validAvoirVentesDateFactureAvoirVente(): boolean {
        return this._validAvoirVentesDateFactureAvoirVente;
    }
    set validAvoirVentesDateFactureAvoirVente(value: boolean) {
        this._validAvoirVentesDateFactureAvoirVente = value;
    }
    get validAvoirVentesClient(): boolean {
        return this._validAvoirVentesClient;
    }
    set validAvoirVentesClient(value: boolean) {
        this._validAvoirVentesClient = value;
    }
    get validAvoirVentesMontantTtc(): boolean {
        return this._validAvoirVentesMontantTtc;
    }
    set validAvoirVentesMontantTtc(value: boolean) {
        this._validAvoirVentesMontantTtc = value;
    }
    get validReglementVentesReference(): boolean {
        return this._validReglementVentesReference;
    }
    set validReglementVentesReference(value: boolean) {
        this._validReglementVentesReference = value;
    }
    get validReglementVentesDateReglement(): boolean {
        return this._validReglementVentesDateReglement;
    }
    set validReglementVentesDateReglement(value: boolean) {
        this._validReglementVentesDateReglement = value;
    }
    get validReglementVentesMontant(): boolean {
        return this._validReglementVentesMontant;
    }
    set validReglementVentesMontant(value: boolean) {
        this._validReglementVentesMontant = value;
    }
    get validReglementVentesVente(): boolean {
        return this._validReglementVentesVente;
    }
    set validReglementVentesVente(value: boolean) {
        this._validReglementVentesVente = value;
    }
    get validReglementVentesModeReglement(): boolean {
        return this._validReglementVentesModeReglement;
    }
    set validReglementVentesModeReglement(value: boolean) {
        this._validReglementVentesModeReglement = value;
    }
}
