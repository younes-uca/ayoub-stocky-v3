
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { CategorieListAdminComponent } from './categorie/list/categorie-list-admin.component';
import { EtatAvoirVenteListAdminComponent } from './etat-avoir-vente/list/etat-avoir-vente-list-admin.component';
import { EtatAvoirAchatListAdminComponent } from './etat-avoir-achat/list/etat-avoir-achat-list-admin.component';
import { DepotListAdminComponent } from './depot/list/depot-list-admin.component';
import { FournisseurListAdminComponent } from './fournisseur/list/fournisseur-list-admin.component';
import { UniteMesureListAdminComponent } from './unite-mesure/list/unite-mesure-list-admin.component';
import { EtatCommandeListAdminComponent } from './etat-commande/list/etat-commande-list-admin.component';
import { ClientListAdminComponent } from './client/list/client-list-admin.component';
import { EtatAchatListAdminComponent } from './etat-achat/list/etat-achat-list-admin.component';
import { MarqueListAdminComponent } from './marque/list/marque-list-admin.component';
import { EntrepriseSocieteListAdminComponent } from './entreprise-societe/list/entreprise-societe-list-admin.component';
import { CollaborateurListAdminComponent } from './collaborateur/list/collaborateur-list-admin.component';
import { EtatVenteListAdminComponent } from './etat-vente/list/etat-vente-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'categorie',
                            children: [
                                {
                                    path: 'list',
                                    component: CategorieListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-avoir-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatAvoirVenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-avoir-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatAvoirAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'depot',
                            children: [
                                {
                                    path: 'list',
                                    component: DepotListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'fournisseur',
                            children: [
                                {
                                    path: 'list',
                                    component: FournisseurListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'unite-mesure',
                            children: [
                                {
                                    path: 'list',
                                    component: UniteMesureListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-commande',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatCommandeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'client',
                            children: [
                                {
                                    path: 'list',
                                    component: ClientListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'marque',
                            children: [
                                {
                                    path: 'list',
                                    component: MarqueListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'entreprise-societe',
                            children: [
                                {
                                    path: 'list',
                                    component: EntrepriseSocieteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'collaborateur',
                            children: [
                                {
                                    path: 'list',
                                    component: CollaborateurListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatVenteListAdminComponent ,
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
export class CommunAdminRoutingModule { }
