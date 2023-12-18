import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ReglementAvoirAchatAdminService} from 'src/app/controller/service/admin/reglement/ReglementAvoirAchatAdmin.service';
import {ReglementAvoirAchatDto} from 'src/app/controller/model/reglement/ReglementAvoirAchat.model';
import {ReglementAvoirAchatCriteria} from 'src/app/controller/criteria/reglement/ReglementAvoirAchatCriteria.model';


import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';

@Component({
  selector: 'app-reglement-avoir-achat-edit-admin',
  templateUrl: './reglement-avoir-achat-edit-admin.component.html'
})
export class ReglementAvoirAchatEditAdminComponent extends AbstractEditController<ReglementAvoirAchatDto, ReglementAvoirAchatCriteria, ReglementAvoirAchatAdminService>   implements OnInit {


    private _validReglementAvoirAchatReference = true;
    private _validReglementAvoirAchatDateReglement = true;
    private _validReglementAvoirAchatMontant = true;
    private _validReglementAvoirAchatModeReglement = true;

    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;
    private _validAchatMontantHt = true;
    private _validAchatMontantTva = true;
    private _validAchatMontantTtc = true;
    private _validModeReglementLibelle = true;
    private _validAvoirAchatBarCode = true;
    private _validAvoirAchatEntrepriseSociete = true;
    private _validAvoirAchatCodeAvoirAchat = true;
    private _validAvoirAchatNumeroFactureAvoirFournisseur = true;
    private _validAvoirAchatDateFactureAvoirFournisseur = true;
    private _validAvoirAchatFournisseur = true;
    private _validAvoirAchatMontantTtc = true;



    constructor( private reglementAvoirAchatService: ReglementAvoirAchatAdminService , private avoirAchatService: AvoirAchatAdminService, private achatService: AchatAdminService, private modeReglementService: ModeReglementAdminService) {
        super(reglementAvoirAchatService);
    }

    ngOnInit(): void {
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
        this.modeReglement = new ModeReglementDto();
        this.modeReglementService.findAll().subscribe((data) => this.modeReglements = data);
        this.avoirAchat = new AvoirAchatDto();
        this.avoirAchatService.findAll().subscribe((data) => this.avoirAchats = data);
    }
    public prepareEdit() {
        this.item.dateReglement = this.reglementAvoirAchatService.format(this.item.dateReglement);
    }



    public setValidation(value: boolean){
        this.validReglementAvoirAchatReference = value;
        this.validReglementAvoirAchatDateReglement = value;
        this.validReglementAvoirAchatMontant = value;
        this.validReglementAvoirAchatModeReglement = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateReglementAvoirAchatReference();
        this.validateReglementAvoirAchatDateReglement();
        this.validateReglementAvoirAchatMontant();
        this.validateReglementAvoirAchatModeReglement();
    }
    public validateReglementAvoirAchatReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validReglementAvoirAchatReference = false;
        } else {
            this.validReglementAvoirAchatReference = true;
        }
    }
    public validateReglementAvoirAchatDateReglement(){
        if (this.stringUtilService.isEmpty(this.item.dateReglement)) {
            this.errorMessages.push('Date reglement non valide');
            this.validReglementAvoirAchatDateReglement = false;
        } else {
            this.validReglementAvoirAchatDateReglement = true;
        }
    }
    public validateReglementAvoirAchatMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validReglementAvoirAchatMontant = false;
        } else {
            this.validReglementAvoirAchatMontant = true;
        }
    }
    public validateReglementAvoirAchatModeReglement(){
        if (this.stringUtilService.isEmpty(this.item.modeReglement)) {
            this.errorMessages.push('Mode reglement non valide');
            this.validReglementAvoirAchatModeReglement = false;
        } else {
            this.validReglementAvoirAchatModeReglement = true;
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
   get avoirAchat(): AvoirAchatDto {
       return this.avoirAchatService.item;
   }
  set avoirAchat(value: AvoirAchatDto) {
        this.avoirAchatService.item = value;
   }
   get avoirAchats(): Array<AvoirAchatDto> {
        return this.avoirAchatService.items;
   }
   set avoirAchats(value: Array<AvoirAchatDto>) {
        this.avoirAchatService.items = value;
   }
   get createAvoirAchatDialog(): boolean {
       return this.avoirAchatService.createDialog;
   }
  set createAvoirAchatDialog(value: boolean) {
       this.avoirAchatService.createDialog= value;
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


    get validReglementAvoirAchatReference(): boolean {
        return this._validReglementAvoirAchatReference;
    }
    set validReglementAvoirAchatReference(value: boolean) {
        this._validReglementAvoirAchatReference = value;
    }
    get validReglementAvoirAchatDateReglement(): boolean {
        return this._validReglementAvoirAchatDateReglement;
    }
    set validReglementAvoirAchatDateReglement(value: boolean) {
        this._validReglementAvoirAchatDateReglement = value;
    }
    get validReglementAvoirAchatMontant(): boolean {
        return this._validReglementAvoirAchatMontant;
    }
    set validReglementAvoirAchatMontant(value: boolean) {
        this._validReglementAvoirAchatMontant = value;
    }
    get validReglementAvoirAchatModeReglement(): boolean {
        return this._validReglementAvoirAchatModeReglement;
    }
    set validReglementAvoirAchatModeReglement(value: boolean) {
        this._validReglementAvoirAchatModeReglement = value;
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
    get validAvoirAchatBarCode(): boolean {
        return this._validAvoirAchatBarCode;
    }
    set validAvoirAchatBarCode(value: boolean) {
        this._validAvoirAchatBarCode = value;
    }
    get validAvoirAchatEntrepriseSociete(): boolean {
        return this._validAvoirAchatEntrepriseSociete;
    }
    set validAvoirAchatEntrepriseSociete(value: boolean) {
        this._validAvoirAchatEntrepriseSociete = value;
    }
    get validAvoirAchatCodeAvoirAchat(): boolean {
        return this._validAvoirAchatCodeAvoirAchat;
    }
    set validAvoirAchatCodeAvoirAchat(value: boolean) {
        this._validAvoirAchatCodeAvoirAchat = value;
    }
    get validAvoirAchatNumeroFactureAvoirFournisseur(): boolean {
        return this._validAvoirAchatNumeroFactureAvoirFournisseur;
    }
    set validAvoirAchatNumeroFactureAvoirFournisseur(value: boolean) {
        this._validAvoirAchatNumeroFactureAvoirFournisseur = value;
    }
    get validAvoirAchatDateFactureAvoirFournisseur(): boolean {
        return this._validAvoirAchatDateFactureAvoirFournisseur;
    }
    set validAvoirAchatDateFactureAvoirFournisseur(value: boolean) {
        this._validAvoirAchatDateFactureAvoirFournisseur = value;
    }
    get validAvoirAchatFournisseur(): boolean {
        return this._validAvoirAchatFournisseur;
    }
    set validAvoirAchatFournisseur(value: boolean) {
        this._validAvoirAchatFournisseur = value;
    }
    get validAvoirAchatMontantTtc(): boolean {
        return this._validAvoirAchatMontantTtc;
    }
    set validAvoirAchatMontantTtc(value: boolean) {
        this._validAvoirAchatMontantTtc = value;
    }
}
