import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-transaction-fournisseur-view-admin',
  templateUrl: './transaction-fournisseur-view-admin.component.html'
})
export class TransactionFournisseurViewAdminComponent extends AbstractViewController<TransactionFournisseurDto, TransactionFournisseurCriteria, TransactionFournisseurAdminService> implements OnInit {


    constructor(private transactionFournisseurService: TransactionFournisseurAdminService, private etatTransactionService: EtatTransactionAdminService, private typeTransactionService: TypeTransactionAdminService, private compteService: CompteAdminService, private typeInstrumentService: TypeInstrumentAdminService){
        super(transactionFournisseurService);
    }

    ngOnInit(): void {
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


}
