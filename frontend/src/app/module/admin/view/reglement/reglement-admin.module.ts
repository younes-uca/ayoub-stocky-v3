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

import { ReglementVenteCreateAdminComponent } from './reglement-vente/create/reglement-vente-create-admin.component';
import { ReglementVenteEditAdminComponent } from './reglement-vente/edit/reglement-vente-edit-admin.component';
import { ReglementVenteViewAdminComponent } from './reglement-vente/view/reglement-vente-view-admin.component';
import { ReglementVenteListAdminComponent } from './reglement-vente/list/reglement-vente-list-admin.component';
import { ReglementAvoirAchatCreateAdminComponent } from './reglement-avoir-achat/create/reglement-avoir-achat-create-admin.component';
import { ReglementAvoirAchatEditAdminComponent } from './reglement-avoir-achat/edit/reglement-avoir-achat-edit-admin.component';
import { ReglementAvoirAchatViewAdminComponent } from './reglement-avoir-achat/view/reglement-avoir-achat-view-admin.component';
import { ReglementAvoirAchatListAdminComponent } from './reglement-avoir-achat/list/reglement-avoir-achat-list-admin.component';
import { ReglementAchatCreateAdminComponent } from './reglement-achat/create/reglement-achat-create-admin.component';
import { ReglementAchatEditAdminComponent } from './reglement-achat/edit/reglement-achat-edit-admin.component';
import { ReglementAchatViewAdminComponent } from './reglement-achat/view/reglement-achat-view-admin.component';
import { ReglementAchatListAdminComponent } from './reglement-achat/list/reglement-achat-list-admin.component';
import { ReglementAvoirVenteCreateAdminComponent } from './reglement-avoir-vente/create/reglement-avoir-vente-create-admin.component';
import { ReglementAvoirVenteEditAdminComponent } from './reglement-avoir-vente/edit/reglement-avoir-vente-edit-admin.component';
import { ReglementAvoirVenteViewAdminComponent } from './reglement-avoir-vente/view/reglement-avoir-vente-view-admin.component';
import { ReglementAvoirVenteListAdminComponent } from './reglement-avoir-vente/list/reglement-avoir-vente-list-admin.component';

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

    ReglementVenteCreateAdminComponent,
    ReglementVenteListAdminComponent,
    ReglementVenteViewAdminComponent,
    ReglementVenteEditAdminComponent,
    ReglementAvoirAchatCreateAdminComponent,
    ReglementAvoirAchatListAdminComponent,
    ReglementAvoirAchatViewAdminComponent,
    ReglementAvoirAchatEditAdminComponent,
    ReglementAchatCreateAdminComponent,
    ReglementAchatListAdminComponent,
    ReglementAchatViewAdminComponent,
    ReglementAchatEditAdminComponent,
    ReglementAvoirVenteCreateAdminComponent,
    ReglementAvoirVenteListAdminComponent,
    ReglementAvoirVenteViewAdminComponent,
    ReglementAvoirVenteEditAdminComponent,
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
  ReglementVenteCreateAdminComponent,
  ReglementVenteListAdminComponent,
  ReglementVenteViewAdminComponent,
  ReglementVenteEditAdminComponent,
  ReglementAvoirAchatCreateAdminComponent,
  ReglementAvoirAchatListAdminComponent,
  ReglementAvoirAchatViewAdminComponent,
  ReglementAvoirAchatEditAdminComponent,
  ReglementAchatCreateAdminComponent,
  ReglementAchatListAdminComponent,
  ReglementAchatViewAdminComponent,
  ReglementAchatEditAdminComponent,
  ReglementAvoirVenteCreateAdminComponent,
  ReglementAvoirVenteListAdminComponent,
  ReglementAvoirVenteViewAdminComponent,
  ReglementAvoirVenteEditAdminComponent,
  ],
  entryComponents: [],
})
export class ReglementAdminModule { }
