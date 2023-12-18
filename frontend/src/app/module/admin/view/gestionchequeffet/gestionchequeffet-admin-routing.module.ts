
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ProprietaireListAdminComponent } from './proprietaire/list/proprietaire-list-admin.component';
import { EtatTransactionListAdminComponent } from './etat-transaction/list/etat-transaction-list-admin.component';
import { ProprietaireBanqueListAdminComponent } from './proprietaire-banque/list/proprietaire-banque-list-admin.component';
import { ModeReglementListAdminComponent } from './mode-reglement/list/mode-reglement-list-admin.component';
import { TypeTransactionListAdminComponent } from './type-transaction/list/type-transaction-list-admin.component';
import { CompteListAdminComponent } from './compte/list/compte-list-admin.component';
import { ChequeEffetListAdminComponent } from './cheque-effet/list/cheque-effet-list-admin.component';
import { TransactionFournisseurListAdminComponent } from './transaction-fournisseur/list/transaction-fournisseur-list-admin.component';
import { TransfertListAdminComponent } from './transfert/list/transfert-list-admin.component';
import { TransfertItemListAdminComponent } from './transfert-item/list/transfert-item-list-admin.component';
import { TypeInstrumentListAdminComponent } from './type-instrument/list/type-instrument-list-admin.component';
import { BanqueListAdminComponent } from './banque/list/banque-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'proprietaire',
                            children: [
                                {
                                    path: 'list',
                                    component: ProprietaireListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-transaction',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatTransactionListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'proprietaire-banque',
                            children: [
                                {
                                    path: 'list',
                                    component: ProprietaireBanqueListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'mode-reglement',
                            children: [
                                {
                                    path: 'list',
                                    component: ModeReglementListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'type-transaction',
                            children: [
                                {
                                    path: 'list',
                                    component: TypeTransactionListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'compte',
                            children: [
                                {
                                    path: 'list',
                                    component: CompteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'cheque-effet',
                            children: [
                                {
                                    path: 'list',
                                    component: ChequeEffetListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'transaction-fournisseur',
                            children: [
                                {
                                    path: 'list',
                                    component: TransactionFournisseurListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'transfert',
                            children: [
                                {
                                    path: 'list',
                                    component: TransfertListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'transfert-item',
                            children: [
                                {
                                    path: 'list',
                                    component: TransfertItemListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'type-instrument',
                            children: [
                                {
                                    path: 'list',
                                    component: TypeInstrumentListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'banque',
                            children: [
                                {
                                    path: 'list',
                                    component: BanqueListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class GestionchequeffetAdminRoutingModule { }
