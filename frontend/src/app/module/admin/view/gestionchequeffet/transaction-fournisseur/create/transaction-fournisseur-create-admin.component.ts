import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TransactionFournisseurAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransactionFournisseurAdmin.service';
import {TransactionFournisseurDto} from 'src/app/controller/model/gestionchequeffet/TransactionFournisseur.model';
import {TransactionFournisseurCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransactionFournisseurCriteria.model';
import {EtatTransactionDto} from 'src/app/controller/model/gestionchequeffet/EtatTransaction.model';
import {EtatTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/EtatTransactionAdmin.service';
import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeTransactionAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';
@Component({
  selector: 'app-transaction-fournisseur-create-admin',
  templateUrl: './transaction-fournisseur-create-admin.component.html'
})
export class TransactionFournisseurCreateAdminComponent extends AbstractCreateController<TransactionFournisseurDto, TransactionFournisseurCriteria, TransactionFournisseurAdminService>  implements OnInit {



   private _validTransactionFournisseurDateEmission = true;
   private _validTransactionFournisseurMontant = true;
   private _validTransactionFournisseurDateTransaction = true;
   private _validTransactionFournisseurDateEncaissement = true;
    private _validTypeInstrumentLibelle = true;
    private _validTypeTransactionLibelle = true;
    private _validCompteNumeroCompte = true;
    private _validEtatTransactionLibelle = true;

    constructor( private transactionFournisseurService: TransactionFournisseurAdminService , private etatTransactionService: EtatTransactionAdminService, private typeTransactionService: TypeTransactionAdminService, private compteService: CompteAdminService, private typeInstrumentService: TypeInstrumentAdminService) {
        super(transactionFournisseurService);
    }

    ngOnInit(): void {
        this.typeInstrument = new TypeInstrumentDto();
        this.typeInstrumentService.findAll().subscribe((data) => this.typeInstruments = data);
        this.typeTransaction = new TypeTransactionDto();
        this.typeTransactionService.findAll().subscribe((data) => this.typeTransactions = data);
        this.compte = new CompteDto();
        this.compteService.findAll().subscribe((data) => this.comptes = data);
        this.etatTransaction = new EtatTransactionDto();
        this.etatTransactionService.findAll().subscribe((data) => this.etatTransactions = data);
    }





    public setValidation(value: boolean){
        this.validTransactionFournisseurDateEmission = value;
        this.validTransactionFournisseurMontant = value;
        this.validTransactionFournisseurDateTransaction = value;
        this.validTransactionFournisseurDateEncaissement = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTransactionFournisseurDateEmission();
        this.validateTransactionFournisseurMontant();
        this.validateTransactionFournisseurDateTransaction();
        this.validateTransactionFournisseurDateEncaissement();
    }

    public validateTransactionFournisseurDateEmission(){
        if (this.stringUtilService.isEmpty(this.item.dateEmission)) {
        this.errorMessages.push('Date emission non valide');
        this.validTransactionFournisseurDateEmission = false;
        } else {
            this.validTransactionFournisseurDateEmission = true;
        }
    }
    public validateTransactionFournisseurMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
        this.errorMessages.push('Montant non valide');
        this.validTransactionFournisseurMontant = false;
        } else {
            this.validTransactionFournisseurMontant = true;
        }
    }
    public validateTransactionFournisseurDateTransaction(){
        if (this.stringUtilService.isEmpty(this.item.dateTransaction)) {
        this.errorMessages.push('Date transaction non valide');
        this.validTransactionFournisseurDateTransaction = false;
        } else {
            this.validTransactionFournisseurDateTransaction = true;
        }
    }
    public validateTransactionFournisseurDateEncaissement(){
        if (this.stringUtilService.isEmpty(this.item.dateEncaissement)) {
        this.errorMessages.push('Date encaissement non valide');
        this.validTransactionFournisseurDateEncaissement = false;
        } else {
            this.validTransactionFournisseurDateEncaissement = true;
        }
    }


    public async openCreateTypeTransaction(typeTransaction: string) {
    const isPermistted = await this.roleService.isPermitted('TypeTransaction', 'add');
    if(isPermistted) {
         this.typeTransaction = new TypeTransactionDto();
         this.createTypeTransactionDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateEtatTransaction(etatTransaction: string) {
    const isPermistted = await this.roleService.isPermitted('EtatTransaction', 'add');
    if(isPermistted) {
         this.etatTransaction = new EtatTransactionDto();
         this.createEtatTransactionDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateTypeInstrument(typeInstrument: string) {
    const isPermistted = await this.roleService.isPermitted('TypeInstrument', 'add');
    if(isPermistted) {
         this.typeInstrument = new TypeInstrumentDto();
         this.createTypeInstrumentDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateCompte(compte: string) {
    const isPermistted = await this.roleService.isPermitted('Compte', 'add');
    if(isPermistted) {
         this.compte = new CompteDto();
         this.createCompteDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get typeTransaction(): TypeTransactionDto {
        return this.typeTransactionService.item;
    }
    set typeTransaction(value: TypeTransactionDto) {
        this.typeTransactionService.item = value;
    }
    get typeTransactions(): Array<TypeTransactionDto> {
        return this.typeTransactionService.items;
    }
    set typeTransactions(value: Array<TypeTransactionDto>) {
        this.typeTransactionService.items = value;
    }
    get createTypeTransactionDialog(): boolean {
       return this.typeTransactionService.createDialog;
    }
    set createTypeTransactionDialog(value: boolean) {
        this.typeTransactionService.createDialog= value;
    }
    get etatTransaction(): EtatTransactionDto {
        return this.etatTransactionService.item;
    }
    set etatTransaction(value: EtatTransactionDto) {
        this.etatTransactionService.item = value;
    }
    get etatTransactions(): Array<EtatTransactionDto> {
        return this.etatTransactionService.items;
    }
    set etatTransactions(value: Array<EtatTransactionDto>) {
        this.etatTransactionService.items = value;
    }
    get createEtatTransactionDialog(): boolean {
       return this.etatTransactionService.createDialog;
    }
    set createEtatTransactionDialog(value: boolean) {
        this.etatTransactionService.createDialog= value;
    }
    get typeInstrument(): TypeInstrumentDto {
        return this.typeInstrumentService.item;
    }
    set typeInstrument(value: TypeInstrumentDto) {
        this.typeInstrumentService.item = value;
    }
    get typeInstruments(): Array<TypeInstrumentDto> {
        return this.typeInstrumentService.items;
    }
    set typeInstruments(value: Array<TypeInstrumentDto>) {
        this.typeInstrumentService.items = value;
    }
    get createTypeInstrumentDialog(): boolean {
       return this.typeInstrumentService.createDialog;
    }
    set createTypeInstrumentDialog(value: boolean) {
        this.typeInstrumentService.createDialog= value;
    }
    get compte(): CompteDto {
        return this.compteService.item;
    }
    set compte(value: CompteDto) {
        this.compteService.item = value;
    }
    get comptes(): Array<CompteDto> {
        return this.compteService.items;
    }
    set comptes(value: Array<CompteDto>) {
        this.compteService.items = value;
    }
    get createCompteDialog(): boolean {
       return this.compteService.createDialog;
    }
    set createCompteDialog(value: boolean) {
        this.compteService.createDialog= value;
    }



    get validTransactionFournisseurDateEmission(): boolean {
        return this._validTransactionFournisseurDateEmission;
    }

    set validTransactionFournisseurDateEmission(value: boolean) {
         this._validTransactionFournisseurDateEmission = value;
    }
    get validTransactionFournisseurMontant(): boolean {
        return this._validTransactionFournisseurMontant;
    }

    set validTransactionFournisseurMontant(value: boolean) {
         this._validTransactionFournisseurMontant = value;
    }
    get validTransactionFournisseurDateTransaction(): boolean {
        return this._validTransactionFournisseurDateTransaction;
    }

    set validTransactionFournisseurDateTransaction(value: boolean) {
         this._validTransactionFournisseurDateTransaction = value;
    }
    get validTransactionFournisseurDateEncaissement(): boolean {
        return this._validTransactionFournisseurDateEncaissement;
    }

    set validTransactionFournisseurDateEncaissement(value: boolean) {
         this._validTransactionFournisseurDateEncaissement = value;
    }

    get validTypeInstrumentLibelle(): boolean {
        return this._validTypeInstrumentLibelle;
    }
    set validTypeInstrumentLibelle(value: boolean) {
        this._validTypeInstrumentLibelle = value;
    }
    get validTypeTransactionLibelle(): boolean {
        return this._validTypeTransactionLibelle;
    }
    set validTypeTransactionLibelle(value: boolean) {
        this._validTypeTransactionLibelle = value;
    }
    get validCompteNumeroCompte(): boolean {
        return this._validCompteNumeroCompte;
    }
    set validCompteNumeroCompte(value: boolean) {
        this._validCompteNumeroCompte = value;
    }
    get validEtatTransactionLibelle(): boolean {
        return this._validEtatTransactionLibelle;
    }
    set validEtatTransactionLibelle(value: boolean) {
        this._validEtatTransactionLibelle = value;
    }


}
