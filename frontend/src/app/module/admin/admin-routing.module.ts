
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';

import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';

@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [
                        {
                            path: 'login',
                            children: [
                                {
                                    path: '',
                                    component: LoginAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {
                            path: 'register',
                            children: [
                                {
                                    path: '',
                                    component: RegisterAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {
                            path: 'reglement',
                            loadChildren: () => import('./view/reglement/reglement-admin-routing.module').then(x => x.ReglementAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'gestionchequeffet',
                            loadChildren: () => import('./view/gestionchequeffet/gestionchequeffet-admin-routing.module').then(x => x.GestionchequeffetAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'Transfert',
                            loadChildren: () => import('./view/Transfert/Transfert-admin-routing.module').then(x => x.TransfertAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'entree',
                            loadChildren: () => import('./view/entree/entree-admin-routing.module').then(x => x.EntreeAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'depense',
                            loadChildren: () => import('./view/depense/depense-admin-routing.module').then(x => x.DepenseAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'commun',
                            loadChildren: () => import('./view/commun/commun-admin-routing.module').then(x => x.CommunAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {
                            path: 'stock',
                            loadChildren: () => import('./view/stock/stock-admin-routing.module').then(x => x.StockAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class AdminRoutingModule { }
