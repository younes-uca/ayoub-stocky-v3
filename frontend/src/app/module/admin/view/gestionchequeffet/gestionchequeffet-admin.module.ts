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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';

import { ProprietaireCreateAdminComponent } from './proprietaire/create/proprietaire-create-admin.component';
import { ProprietaireEditAdminComponent } from './proprietaire/edit/proprietaire-edit-admin.component';
import { ProprietaireViewAdminComponent } from './proprietaire/view/proprietaire-view-admin.component';
import { ProprietaireListAdminComponent } from './proprietaire/list/proprietaire-list-admin.component';
import { EtatTransactionCreateAdminComponent } from './etat-transaction/create/etat-transaction-create-admin.component';
import { EtatTransactionEditAdminComponent } from './etat-transaction/edit/etat-transaction-edit-admin.component';
import { EtatTransactionViewAdminComponent } from './etat-transaction/view/etat-transaction-view-admin.component';
import { EtatTransactionListAdminComponent } from './etat-transaction/list/etat-transaction-list-admin.component';
import { ProprietaireBanqueCreateAdminComponent } from './proprietaire-banque/create/proprietaire-banque-create-admin.component';
import { ProprietaireBanqueEditAdminComponent } from './proprietaire-banque/edit/proprietaire-banque-edit-admin.component';
import { ProprietaireBanqueViewAdminComponent } from './proprietaire-banque/view/proprietaire-banque-view-admin.component';
import { ProprietaireBanqueListAdminComponent } from './proprietaire-banque/list/proprietaire-banque-list-admin.component';
import { ModeReglementCreateAdminComponent } from './mode-reglement/create/mode-reglement-create-admin.component';
import { ModeReglementEditAdminComponent } from './mode-reglement/edit/mode-reglement-edit-admin.component';
import { ModeReglementViewAdminComponent } from './mode-reglement/view/mode-reglement-view-admin.component';
import { ModeReglementListAdminComponent } from './mode-reglement/list/mode-reglement-list-admin.component';
import { TypeTransactionCreateAdminComponent } from './type-transaction/create/type-transaction-create-admin.component';
import { TypeTransactionEditAdminComponent } from './type-transaction/edit/type-transaction-edit-admin.component';
import { TypeTransactionViewAdminComponent } from './type-transaction/view/type-transaction-view-admin.component';
import { TypeTransactionListAdminComponent } from './type-transaction/list/type-transaction-list-admin.component';
import { CompteCreateAdminComponent } from './compte/create/compte-create-admin.component';
import { CompteEditAdminComponent } from './compte/edit/compte-edit-admin.component';
import { CompteViewAdminComponent } from './compte/view/compte-view-admin.component';
import { CompteListAdminComponent } from './compte/list/compte-list-admin.component';
import { ChequeEffetCreateAdminComponent } from './cheque-effet/create/cheque-effet-create-admin.component';
import { ChequeEffetEditAdminComponent } from './cheque-effet/edit/cheque-effet-edit-admin.component';
import { ChequeEffetViewAdminComponent } from './cheque-effet/view/cheque-effet-view-admin.component';
import { ChequeEffetListAdminComponent } from './cheque-effet/list/cheque-effet-list-admin.component';
import { TransactionFournisseurCreateAdminComponent } from './transaction-fournisseur/create/transaction-fournisseur-create-admin.component';
import { TransactionFournisseurEditAdminComponent } from './transaction-fournisseur/edit/transaction-fournisseur-edit-admin.component';
import { TransactionFournisseurViewAdminComponent } from './transaction-fournisseur/view/transaction-fournisseur-view-admin.component';
import { TransactionFournisseurListAdminComponent } from './transaction-fournisseur/list/transaction-fournisseur-list-admin.component';
import { TransfertCreateAdminComponent } from './transfert/create/transfert-create-admin.component';
import { TransfertEditAdminComponent } from './transfert/edit/transfert-edit-admin.component';
import { TransfertViewAdminComponent } from './transfert/view/transfert-view-admin.component';
import { TransfertListAdminComponent } from './transfert/list/transfert-list-admin.component';
import { TransfertItemCreateAdminComponent } from './transfert-item/create/transfert-item-create-admin.component';
import { TransfertItemEditAdminComponent } from './transfert-item/edit/transfert-item-edit-admin.component';
import { TransfertItemViewAdminComponent } from './transfert-item/view/transfert-item-view-admin.component';
import { TransfertItemListAdminComponent } from './transfert-item/list/transfert-item-list-admin.component';
import { TypeInstrumentCreateAdminComponent } from './type-instrument/create/type-instrument-create-admin.component';
import { TypeInstrumentEditAdminComponent } from './type-instrument/edit/type-instrument-edit-admin.component';
import { TypeInstrumentViewAdminComponent } from './type-instrument/view/type-instrument-view-admin.component';
import { TypeInstrumentListAdminComponent } from './type-instrument/list/type-instrument-list-admin.component';
import { BanqueCreateAdminComponent } from './banque/create/banque-create-admin.component';
import { BanqueEditAdminComponent } from './banque/edit/banque-edit-admin.component';
import { BanqueViewAdminComponent } from './banque/view/banque-view-admin.component';
import { BanqueListAdminComponent } from './banque/list/banque-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    ProprietaireCreateAdminComponent,
    ProprietaireListAdminComponent,
    ProprietaireViewAdminComponent,
    ProprietaireEditAdminComponent,
    EtatTransactionCreateAdminComponent,
    EtatTransactionListAdminComponent,
    EtatTransactionViewAdminComponent,
    EtatTransactionEditAdminComponent,
    ProprietaireBanqueCreateAdminComponent,
    ProprietaireBanqueListAdminComponent,
    ProprietaireBanqueViewAdminComponent,
    ProprietaireBanqueEditAdminComponent,
    ModeReglementCreateAdminComponent,
    ModeReglementListAdminComponent,
    ModeReglementViewAdminComponent,
    ModeReglementEditAdminComponent,
    TypeTransactionCreateAdminComponent,
    TypeTransactionListAdminComponent,
    TypeTransactionViewAdminComponent,
    TypeTransactionEditAdminComponent,
    CompteCreateAdminComponent,
    CompteListAdminComponent,
    CompteViewAdminComponent,
    CompteEditAdminComponent,
    ChequeEffetCreateAdminComponent,
    ChequeEffetListAdminComponent,
    ChequeEffetViewAdminComponent,
    ChequeEffetEditAdminComponent,
    TransactionFournisseurCreateAdminComponent,
    TransactionFournisseurListAdminComponent,
    TransactionFournisseurViewAdminComponent,
    TransactionFournisseurEditAdminComponent,
    TransfertCreateAdminComponent,
    TransfertListAdminComponent,
    TransfertViewAdminComponent,
    TransfertEditAdminComponent,
    TransfertItemCreateAdminComponent,
    TransfertItemListAdminComponent,
    TransfertItemViewAdminComponent,
    TransfertItemEditAdminComponent,
    TypeInstrumentCreateAdminComponent,
    TypeInstrumentListAdminComponent,
    TypeInstrumentViewAdminComponent,
    TypeInstrumentEditAdminComponent,
    BanqueCreateAdminComponent,
    BanqueListAdminComponent,
    BanqueViewAdminComponent,
    BanqueEditAdminComponent,
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
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,

  ],
  exports: [
  ProprietaireCreateAdminComponent,
  ProprietaireListAdminComponent,
  ProprietaireViewAdminComponent,
  ProprietaireEditAdminComponent,
  EtatTransactionCreateAdminComponent,
  EtatTransactionListAdminComponent,
  EtatTransactionViewAdminComponent,
  EtatTransactionEditAdminComponent,
  ProprietaireBanqueCreateAdminComponent,
  ProprietaireBanqueListAdminComponent,
  ProprietaireBanqueViewAdminComponent,
  ProprietaireBanqueEditAdminComponent,
  ModeReglementCreateAdminComponent,
  ModeReglementListAdminComponent,
  ModeReglementViewAdminComponent,
  ModeReglementEditAdminComponent,
  TypeTransactionCreateAdminComponent,
  TypeTransactionListAdminComponent,
  TypeTransactionViewAdminComponent,
  TypeTransactionEditAdminComponent,
  CompteCreateAdminComponent,
  CompteListAdminComponent,
  CompteViewAdminComponent,
  CompteEditAdminComponent,
  ChequeEffetCreateAdminComponent,
  ChequeEffetListAdminComponent,
  ChequeEffetViewAdminComponent,
  ChequeEffetEditAdminComponent,
  TransactionFournisseurCreateAdminComponent,
  TransactionFournisseurListAdminComponent,
  TransactionFournisseurViewAdminComponent,
  TransactionFournisseurEditAdminComponent,
  TransfertCreateAdminComponent,
  TransfertListAdminComponent,
  TransfertViewAdminComponent,
  TransfertEditAdminComponent,
  TransfertItemCreateAdminComponent,
  TransfertItemListAdminComponent,
  TransfertItemViewAdminComponent,
  TransfertItemEditAdminComponent,
  TypeInstrumentCreateAdminComponent,
  TypeInstrumentListAdminComponent,
  TypeInstrumentViewAdminComponent,
  TypeInstrumentEditAdminComponent,
  BanqueCreateAdminComponent,
  BanqueListAdminComponent,
  BanqueViewAdminComponent,
  BanqueEditAdminComponent,
  ],
  entryComponents: [],
})
export class GestionchequeffetAdminModule { }
