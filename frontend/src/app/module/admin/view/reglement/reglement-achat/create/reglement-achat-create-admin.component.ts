import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ReglementAchatAdminService} from 'src/app/controller/service/admin/reglement/ReglementAchatAdmin.service';
import {ReglementAchatDto} from 'src/app/controller/model/reglement/ReglementAchat.model';
import {ReglementAchatCriteria} from 'src/app/controller/criteria/reglement/ReglementAchatCriteria.model';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
@Component({
  selector: 'app-reglement-achat-create-admin',
  templateUrl: './reglement-achat-create-admin.component.html'
})
export class ReglementAchatCreateAdminComponent extends AbstractCreateController<ReglementAchatDto, ReglementAchatCriteria, ReglementAchatAdminService>  implements OnInit {



   private _validReglementAchatReference = true;
   private _validReglementAchatDateReglement = true;
   private _validReglementAchatMontant = true;
   private _validReglementAchatModeReglement = true;
    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;
    private _validAchatMontantHt = true;
    private _validAchatMontantTva = true;
    private _validAchatMontantTtc = true;
    private _validModeReglementLibelle = true;

    constructor( private reglementAchatService: ReglementAchatAdminService , private achatService: AchatAdminService, private modeReglementService: ModeReglementAdminService) {
        super(reglementAchatService);
    }

    ngOnInit(): void {
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
        this.modeReglement = new ModeReglementDto();
        this.modeReglementService.findAll().subscribe((data) => this.modeReglements = data);
    }





    public setValidation(value: boolean){
        this.validReglementAchatReference = value;
        this.validReglementAchatDateReglement = value;
        this.validReglementAchatMontant = value;
        this.validReglementAchatModeReglement = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateReglementAchatReference();
        this.validateReglementAchatDateReglement();
        this.validateReglementAchatMontant();
        this.validateReglementAchatModeReglement();
    }

    public validateReglementAchatReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validReglementAchatReference = false;
        } else {
            this.validReglementAchatReference = true;
        }
    }
    public validateReglementAchatDateReglement(){
        if (this.stringUtilService.isEmpty(this.item.dateReglement)) {
        this.errorMessages.push('Date reglement non valide');
        this.validReglementAchatDateReglement = false;
        } else {
            this.validReglementAchatDateReglement = true;
        }
    }
    public validateReglementAchatMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
        this.errorMessages.push('Montant non valide');
        this.validReglementAchatMontant = false;
        } else {
            this.validReglementAchatMontant = true;
        }
    }
    public validateReglementAchatModeReglement(){
        if (this.stringUtilService.isEmpty(this.item.modeReglement)) {
        this.errorMessages.push('Mode reglement non valide');
        this.validReglementAchatModeReglement = false;
        } else {
            this.validReglementAchatModeReglement = true;
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
    get achat(): AchatDto {
        return this.achatService.item;
    }
    set achat(value: AchatDto) {
        this.achatService.item = value;
    }
    get achats(): Array<AchatDto> {
        return this.achatService.items;
    }
    set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
    }
    get createAchatDialog(): boolean {
       return this.achatService.createDialog;
    }
    set createAchatDialog(value: boolean) {
        this.achatService.createDialog= value;
    }



    get validReglementAchatReference(): boolean {
        return this._validReglementAchatReference;
    }

    set validReglementAchatReference(value: boolean) {
         this._validReglementAchatReference = value;
    }
    get validReglementAchatDateReglement(): boolean {
        return this._validReglementAchatDateReglement;
    }

    set validReglementAchatDateReglement(value: boolean) {
         this._validReglementAchatDateReglement = value;
    }
    get validReglementAchatMontant(): boolean {
        return this._validReglementAchatMontant;
    }

    set validReglementAchatMontant(value: boolean) {
         this._validReglementAchatMontant = value;
    }
    get validReglementAchatModeReglement(): boolean {
        return this._validReglementAchatModeReglement;
    }

    set validReglementAchatModeReglement(value: boolean) {
         this._validReglementAchatModeReglement = value;
    }

    get validAchatDateFacture(): boolean {
        return this._validAchatDateFacture;
    }
    set validAchatDateFacture(value: boolean) {
        this._validAchatDateFacture = value;
    }
    get validAchatFournisseur(): boolean {
        return this._validAchatFournisseur;
    }
    set validAchatFournisseur(value: boolean) {
        this._validAchatFournisseur = value;
    }
    get validAchatMontantHt(): boolean {
        return this._validAchatMontantHt;
    }
    set validAchatMontantHt(value: boolean) {
        this._validAchatMontantHt = value;
    }
    get validAchatMontantTva(): boolean {
        return this._validAchatMontantTva;
    }
    set validAchatMontantTva(value: boolean) {
        this._validAchatMontantTva = value;
    }
    get validAchatMontantTtc(): boolean {
        return this._validAchatMontantTtc;
    }
    set validAchatMontantTtc(value: boolean) {
        this._validAchatMontantTtc = value;
    }
    get validModeReglementLibelle(): boolean {
        return this._validModeReglementLibelle;
    }
    set validModeReglementLibelle(value: boolean) {
        this._validModeReglementLibelle = value;
    }


}
