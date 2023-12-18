import {Component, OnInit} from '@angular/core';
import {TransactionFournisseurAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransactionFournisseurAdmin.service';
import {TransactionFournisseurDto} from 'src/app/controller/model/gestionchequeffet/TransactionFournisseur.model';
import {TransactionFournisseurCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransactionFournisseurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EtatTransactionDto} from 'src/app/controller/model/gestionchequeffet/EtatTransaction.model';
import {EtatTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/EtatTransactionAdmin.service';
import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeTransactionAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';


@Component({
  selector: 'app-transaction-fournisseur-list-admin',
  templateUrl: './transaction-fournisseur-list-admin.component.html'
})
export class TransactionFournisseurListAdminComponent extends AbstractListController<TransactionFournisseurDto, TransactionFournisseurCriteria, TransactionFournisseurAdminService>  implements OnInit {

    fileName = 'TransactionFournisseur';

    typeInstruments: Array<TypeInstrumentDto>;
    typeTransactions: Array<TypeTransactionDto>;
    comptes: Array<CompteDto>;
    etatTransactions: Array<EtatTransactionDto>;


    constructor( private transactionFournisseurService: TransactionFournisseurAdminService  , private etatTransactionService: EtatTransactionAdminService, private typeTransactionService: TypeTransactionAdminService, private compteService: CompteAdminService, private typeInstrumentService: TypeInstrumentAdminService) {
        super(transactionFournisseurService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadTypeInstrument();
        this.loadTypeTransaction();
        this.loadCompte();
        this.loadEtatTransaction();
    }


    public initCol() {
        this.cols = [
            {field: 'typeInstrument?.libelle', header: 'Type instrument'},
            {field: 'dateEmission', header: 'Date emission'},
            {field: 'montant', header: 'Montant'},
            {field: 'dateTransaction', header: 'Date transaction'},
            {field: 'typeTransaction?.libelle', header: 'Type transaction'},
            {field: 'compte?.numeroCompte', header: 'Compte'},
            {field: 'dateEncaissement', header: 'Date encaissement'},
            {field: 'pathPhoto', header: 'Path photo'},
            {field: 'etatTransaction?.libelle', header: 'Etat transaction'},
        ];
    }


    public async loadTypeInstrument(){
       this.typeInstrumentService.findAllOptimized().subscribe(typeInstruments => this.typeInstruments = typeInstruments, error => console.log(error))
    }
    public async loadTypeTransaction(){
       this.typeTransactionService.findAllOptimized().subscribe(typeTransactions => this.typeTransactions = typeTransactions, error => console.log(error))
    }
    public async loadCompte(){
       this.compteService.findAllOptimized().subscribe(comptes => this.comptes = comptes, error => console.log(error))
    }
    public async loadEtatTransaction(){
       this.etatTransactionService.findAllOptimized().subscribe(etatTransactions => this.etatTransactions = etatTransactions, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Type instrument': e.typeInstrument?.libelle ,
                'Date emission': this.datePipe.transform(e.dateEmission , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Date transaction': this.datePipe.transform(e.dateTransaction , 'dd/MM/yyyy hh:mm'),
                'Type transaction': e.typeTransaction?.libelle ,
                'Compte': e.compte?.numeroCompte ,
                'Date encaissement': this.datePipe.transform(e.dateEncaissement , 'dd/MM/yyyy hh:mm'),
                 'Path photo': e.pathPhoto ,
                 'Description': e.description ,
                'Etat transaction': e.etatTransaction?.libelle ,
            }
        });

        this.criteriaData = [{
        //'Type instrument': this.criteria.typeInstrument?.libelle ? this.criteria.typeInstrument?.libelle : environment.emptyForExport ,
            'Date emission Min': this.criteria.dateEmissionFrom ? this.datePipe.transform(this.criteria.dateEmissionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date emission Max': this.criteria.dateEmissionTo ? this.datePipe.transform(this.criteria.dateEmissionTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
            'Date transaction Min': this.criteria.dateTransactionFrom ? this.datePipe.transform(this.criteria.dateTransactionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date transaction Max': this.criteria.dateTransactionTo ? this.datePipe.transform(this.criteria.dateTransactionTo , this.dateFormat) : environment.emptyForExport ,
        //'Type transaction': this.criteria.typeTransaction?.libelle ? this.criteria.typeTransaction?.libelle : environment.emptyForExport ,
        //'Compte': this.criteria.compte?.numeroCompte ? this.criteria.compte?.numeroCompte : environment.emptyForExport ,
            'Date encaissement Min': this.criteria.dateEncaissementFrom ? this.datePipe.transform(this.criteria.dateEncaissementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date encaissement Max': this.criteria.dateEncaissementTo ? this.datePipe.transform(this.criteria.dateEncaissementTo , this.dateFormat) : environment.emptyForExport ,
            'Path photo': this.criteria.pathPhoto ? this.criteria.pathPhoto : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Etat transaction': this.criteria.etatTransaction?.libelle ? this.criteria.etatTransaction?.libelle : environment.emptyForExport ,
        }];
      }
}
