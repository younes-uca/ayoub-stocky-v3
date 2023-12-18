import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ReglementAvoirVenteAdminService} from 'src/app/controller/service/admin/reglement/ReglementAvoirVenteAdmin.service';
import {ReglementAvoirVenteDto} from 'src/app/controller/model/reglement/ReglementAvoirVente.model';
import {ReglementAvoirVenteCriteria} from 'src/app/controller/criteria/reglement/ReglementAvoirVenteCriteria.model';


import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';

@Component({
  selector: 'app-reglement-avoir-vente-edit-admin',
  templateUrl: './reglement-avoir-vente-edit-admin.component.html'
})
export class ReglementAvoirVenteEditAdminComponent extends AbstractEditController<ReglementAvoirVenteDto, ReglementAvoirVenteCriteria, ReglementAvoirVenteAdminService>   implements OnInit {


    private _validReglementAvoirVenteReference = true;
    private _validReglementAvoirVenteDateReglement = true;
    private _validReglementAvoirVenteMontant = true;

    private _validVenteBarCode = true;
    private _validVenteEntrepriseSociete = true;
    private _validVenteCodeVente = true;
    private _validVenteDateFacture = true;
    private _validVenteNumeroFacture = true;
    private _validVenteClient = true;
    private _validVenteMontantHt = true;
    private _validVenteMontantTva = true;
    private _validVenteMontantTtc = true;
    private _validModeReglementLibelle = true;
    private _validAvoirVenteBarCode = true;
    private _validAvoirVenteEntrepriseSociete = true;
    private _validAvoirVenteCodeAvoirVente = true;
    private _validAvoirVenteNumeroFactureAvoirVente = true;
    private _validAvoirVenteDateFactureAvoirVente = true;
    private _validAvoirVenteClient = true;
    private _validAvoirVenteMontantTtc = true;



    constructor( private reglementAvoirVenteService: ReglementAvoirVenteAdminService , private avoirVenteService: AvoirVenteAdminService, private modeReglementService: ModeReglementAdminService, private venteService: VenteAdminService) {
        super(reglementAvoirVenteService);
    }

    ngOnInit(): void {
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
        this.modeReglement = new ModeReglementDto();
        this.modeReglementService.findAll().subscribe((data) => this.modeReglements = data);
        this.avoirVente = new AvoirVenteDto();
        this.avoirVenteService.findAll().subscribe((data) => this.avoirVentes = data);
    }
    public prepareEdit() {
        this.item.dateReglement = this.reglementAvoirVenteService.format(this.item.dateReglement);
    }



    public setValidation(value: boolean){
        this.validReglementAvoirVenteReference = value;
        this.validReglementAvoirVenteDateReglement = value;
        this.validReglementAvoirVenteMontant = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateReglementAvoirVenteReference();
        this.validateReglementAvoirVenteDateReglement();
        this.validateReglementAvoirVenteMontant();
    }
    public validateReglementAvoirVenteReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validReglementAvoirVenteReference = false;
        } else {
            this.validReglementAvoirVenteReference = true;
        }
    }
    public validateReglementAvoirVenteDateReglement(){
        if (this.stringUtilService.isEmpty(this.item.dateReglement)) {
            this.errorMessages.push('Date reglement non valide');
            this.validReglementAvoirVenteDateReglement = false;
        } else {
            this.validReglementAvoirVenteDateReglement = true;
        }
    }
    public validateReglementAvoirVenteMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validReglementAvoirVenteMontant = false;
        } else {
            this.validReglementAvoirVenteMontant = true;
        }
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
   get avoirVente(): AvoirVenteDto {
       return this.avoirVenteService.item;
   }
  set avoirVente(value: AvoirVenteDto) {
        this.avoirVenteService.item = value;
   }
   get avoirVentes(): Array<AvoirVenteDto> {
        return this.avoirVenteService.items;
   }
   set avoirVentes(value: Array<AvoirVenteDto>) {
        this.avoirVenteService.items = value;
   }
   get createAvoirVenteDialog(): boolean {
       return this.avoirVenteService.createDialog;
   }
  set createAvoirVenteDialog(value: boolean) {
       this.avoirVenteService.createDialog= value;
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


    get validReglementAvoirVenteReference(): boolean {
        return this._validReglementAvoirVenteReference;
    }
    set validReglementAvoirVenteReference(value: boolean) {
        this._validReglementAvoirVenteReference = value;
    }
    get validReglementAvoirVenteDateReglement(): boolean {
        return this._validReglementAvoirVenteDateReglement;
    }
    set validReglementAvoirVenteDateReglement(value: boolean) {
        this._validReglementAvoirVenteDateReglement = value;
    }
    get validReglementAvoirVenteMontant(): boolean {
        return this._validReglementAvoirVenteMontant;
    }
    set validReglementAvoirVenteMontant(value: boolean) {
        this._validReglementAvoirVenteMontant = value;
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
    get validModeReglementLibelle(): boolean {
        return this._validModeReglementLibelle;
    }
    set validModeReglementLibelle(value: boolean) {
        this._validModeReglementLibelle = value;
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
}
