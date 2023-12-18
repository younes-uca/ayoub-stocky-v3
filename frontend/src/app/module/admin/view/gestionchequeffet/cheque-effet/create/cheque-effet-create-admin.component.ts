import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ChequeEffetAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ChequeEffetAdmin.service';
import {ChequeEffetDto} from 'src/app/controller/model/gestionchequeffet/ChequeEffet.model';
import {ChequeEffetCriteria} from 'src/app/controller/criteria/gestionchequeffet/ChequeEffetCriteria.model';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
@Component({
  selector: 'app-cheque-effet-create-admin',
  templateUrl: './cheque-effet-create-admin.component.html'
})
export class ChequeEffetCreateAdminComponent extends AbstractCreateController<ChequeEffetDto, ChequeEffetCriteria, ChequeEffetAdminService>  implements OnInit {



   private _validChequeEffetNumero = true;
   private _validChequeEffetDateEmission = true;
   private _validChequeEffetMontant = true;
    private _validFournisseurIce = true;
    private _validFournisseurNom = true;
    private _validFournisseurTelephone = true;

    constructor( private chequeEffetService: ChequeEffetAdminService , private fournisseurService: FournisseurAdminService) {
        super(chequeEffetService);
    }

    ngOnInit(): void {
        this.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
    }





    public setValidation(value: boolean){
        this.validChequeEffetNumero = value;
        this.validChequeEffetDateEmission = value;
        this.validChequeEffetMontant = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateChequeEffetNumero();
        this.validateChequeEffetDateEmission();
        this.validateChequeEffetMontant();
    }

    public validateChequeEffetNumero(){
        if (this.stringUtilService.isEmpty(this.item.numero)) {
        this.errorMessages.push('Numero non valide');
        this.validChequeEffetNumero = false;
        } else {
            this.validChequeEffetNumero = true;
        }
    }
    public validateChequeEffetDateEmission(){
        if (this.stringUtilService.isEmpty(this.item.dateEmission)) {
        this.errorMessages.push('Date emission non valide');
        this.validChequeEffetDateEmission = false;
        } else {
            this.validChequeEffetDateEmission = true;
        }
    }
    public validateChequeEffetMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
        this.errorMessages.push('Montant non valide');
        this.validChequeEffetMontant = false;
        } else {
            this.validChequeEffetMontant = true;
        }
    }



    get fournisseur(): FournisseurDto {
        return this.fournisseurService.item;
    }
    set fournisseur(value: FournisseurDto) {
        this.fournisseurService.item = value;
    }
    get fournisseurs(): Array<FournisseurDto> {
        return this.fournisseurService.items;
    }
    set fournisseurs(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
    }
    get createFournisseurDialog(): boolean {
       return this.fournisseurService.createDialog;
    }
    set createFournisseurDialog(value: boolean) {
        this.fournisseurService.createDialog= value;
    }



    get validChequeEffetNumero(): boolean {
        return this._validChequeEffetNumero;
    }

    set validChequeEffetNumero(value: boolean) {
         this._validChequeEffetNumero = value;
    }
    get validChequeEffetDateEmission(): boolean {
        return this._validChequeEffetDateEmission;
    }

    set validChequeEffetDateEmission(value: boolean) {
         this._validChequeEffetDateEmission = value;
    }
    get validChequeEffetMontant(): boolean {
        return this._validChequeEffetMontant;
    }

    set validChequeEffetMontant(value: boolean) {
         this._validChequeEffetMontant = value;
    }

    get validFournisseurIce(): boolean {
        return this._validFournisseurIce;
    }
    set validFournisseurIce(value: boolean) {
        this._validFournisseurIce = value;
    }
    get validFournisseurNom(): boolean {
        return this._validFournisseurNom;
    }
    set validFournisseurNom(value: boolean) {
        this._validFournisseurNom = value;
    }
    get validFournisseurTelephone(): boolean {
        return this._validFournisseurTelephone;
    }
    set validFournisseurTelephone(value: boolean) {
        this._validFournisseurTelephone = value;
    }


}
