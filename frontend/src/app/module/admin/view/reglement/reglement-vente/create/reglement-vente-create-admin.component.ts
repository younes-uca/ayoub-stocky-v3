import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ReglementVenteAdminService} from 'src/app/controller/service/admin/reglement/ReglementVenteAdmin.service';
import {ReglementVenteDto} from 'src/app/controller/model/reglement/ReglementVente.model';
import {ReglementVenteCriteria} from 'src/app/controller/criteria/reglement/ReglementVenteCriteria.model';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
@Component({
  selector: 'app-reglement-vente-create-admin',
  templateUrl: './reglement-vente-create-admin.component.html'
})
export class ReglementVenteCreateAdminComponent extends AbstractCreateController<ReglementVenteDto, ReglementVenteCriteria, ReglementVenteAdminService>  implements OnInit {



   private _validReglementVenteReference = true;
   private _validReglementVenteDateReglement = true;
   private _validReglementVenteMontant = true;
   private _validReglementVenteVente = true;
   private _validReglementVenteModeReglement = true;
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

    constructor( private reglementVenteService: ReglementVenteAdminService , private modeReglementService: ModeReglementAdminService, private venteService: VenteAdminService) {
        super(reglementVenteService);
    }

    ngOnInit(): void {
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
        this.modeReglement = new ModeReglementDto();
        this.modeReglementService.findAll().subscribe((data) => this.modeReglements = data);
    }





    public setValidation(value: boolean){
        this.validReglementVenteReference = value;
        this.validReglementVenteDateReglement = value;
        this.validReglementVenteMontant = value;
        this.validReglementVenteVente = value;
        this.validReglementVenteModeReglement = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateReglementVenteReference();
        this.validateReglementVenteDateReglement();
        this.validateReglementVenteMontant();
        this.validateReglementVenteVente();
        this.validateReglementVenteModeReglement();
    }

    public validateReglementVenteReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validReglementVenteReference = false;
        } else {
            this.validReglementVenteReference = true;
        }
    }
    public validateReglementVenteDateReglement(){
        if (this.stringUtilService.isEmpty(this.item.dateReglement)) {
        this.errorMessages.push('Date reglement non valide');
        this.validReglementVenteDateReglement = false;
        } else {
            this.validReglementVenteDateReglement = true;
        }
    }
    public validateReglementVenteMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
        this.errorMessages.push('Montant non valide');
        this.validReglementVenteMontant = false;
        } else {
            this.validReglementVenteMontant = true;
        }
    }
    public validateReglementVenteVente(){
        if (this.stringUtilService.isEmpty(this.item.vente)) {
        this.errorMessages.push('Vente non valide');
        this.validReglementVenteVente = false;
        } else {
            this.validReglementVenteVente = true;
        }
    }
    public validateReglementVenteModeReglement(){
        if (this.stringUtilService.isEmpty(this.item.modeReglement)) {
        this.errorMessages.push('Mode reglement non valide');
        this.validReglementVenteModeReglement = false;
        } else {
            this.validReglementVenteModeReglement = true;
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



    get validReglementVenteReference(): boolean {
        return this._validReglementVenteReference;
    }

    set validReglementVenteReference(value: boolean) {
         this._validReglementVenteReference = value;
    }
    get validReglementVenteDateReglement(): boolean {
        return this._validReglementVenteDateReglement;
    }

    set validReglementVenteDateReglement(value: boolean) {
         this._validReglementVenteDateReglement = value;
    }
    get validReglementVenteMontant(): boolean {
        return this._validReglementVenteMontant;
    }

    set validReglementVenteMontant(value: boolean) {
         this._validReglementVenteMontant = value;
    }
    get validReglementVenteVente(): boolean {
        return this._validReglementVenteVente;
    }

    set validReglementVenteVente(value: boolean) {
         this._validReglementVenteVente = value;
    }
    get validReglementVenteModeReglement(): boolean {
        return this._validReglementVenteModeReglement;
    }

    set validReglementVenteModeReglement(value: boolean) {
         this._validReglementVenteModeReglement = value;
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


}
