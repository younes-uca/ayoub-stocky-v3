import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import { ReglementAdminModule } from './view/reglement/reglement-admin.module';
import { ReglementAdminRoutingModule } from './view/reglement/reglement-admin-routing.module';
import { GestionchequeffetAdminModule } from './view/gestionchequeffet/gestionchequeffet-admin.module';
import { GestionchequeffetAdminRoutingModule } from './view/gestionchequeffet/gestionchequeffet-admin-routing.module';
import { TransfertAdminModule } from './view/Transfert/Transfert-admin.module';
import { TransfertAdminRoutingModule } from './view/Transfert/Transfert-admin-routing.module';
import { EntreeAdminModule } from './view/entree/entree-admin.module';
import { EntreeAdminRoutingModule } from './view/entree/entree-admin-routing.module';
import { DepenseAdminModule } from './view/depense/depense-admin.module';
import { DepenseAdminRoutingModule } from './view/depense/depense-admin-routing.module';
import { CommunAdminModule } from './view/commun/commun-admin.module';
import { CommunAdminRoutingModule } from './view/commun/commun-admin-routing.module';
import { StockAdminModule } from './view/stock/stock-admin.module';
import { StockAdminRoutingModule } from './view/stock/stock-admin-routing.module';


import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';


@NgModule({
  declarations: [
   LoginAdminComponent,
   RegisterAdminComponent
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
  ReglementAdminModule,
  ReglementAdminRoutingModule,
  GestionchequeffetAdminModule,
  GestionchequeffetAdminRoutingModule,
  TransfertAdminModule,
  TransfertAdminRoutingModule,
  EntreeAdminModule,
  EntreeAdminRoutingModule,
  DepenseAdminModule,
  DepenseAdminRoutingModule,
  CommunAdminModule,
  CommunAdminRoutingModule,
  StockAdminModule,
  StockAdminRoutingModule,
  ],
  exports: [
  LoginAdminComponent,
  RegisterAdminComponent,

    ReglementAdminModule,
    GestionchequeffetAdminModule,
    TransfertAdminModule,
    EntreeAdminModule,
    DepenseAdminModule,
    CommunAdminModule,
    StockAdminModule,
  ],
  entryComponents: [],
})
export class AdminModule { }
