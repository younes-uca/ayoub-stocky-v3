
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ReglementVenteListAdminComponent } from './reglement-vente/list/reglement-vente-list-admin.component';
import { ReglementAvoirAchatListAdminComponent } from './reglement-avoir-achat/list/reglement-avoir-achat-list-admin.component';
import { ReglementAchatListAdminComponent } from './reglement-achat/list/reglement-achat-list-admin.component';
import { ReglementAvoirVenteListAdminComponent } from './reglement-avoir-vente/list/reglement-avoir-vente-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'reglement-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: ReglementVenteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'reglement-avoir-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: ReglementAvoirAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'reglement-achat',
                            children: [
                                {
                                    path: 'list',
                                    component: ReglementAchatListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'reglement-avoir-vente',
                            children: [
                                {
                                    path: 'list',
                                    component: ReglementAvoirVenteListAdminComponent ,
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
export class ReglementAdminRoutingModule { }
