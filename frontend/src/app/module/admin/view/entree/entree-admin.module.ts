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

import { EntreeProduitCreateAdminComponent } from './entree-produit/create/entree-produit-create-admin.component';
import { EntreeProduitEditAdminComponent } from './entree-produit/edit/entree-produit-edit-admin.component';
import { EntreeProduitViewAdminComponent } from './entree-produit/view/entree-produit-view-admin.component';
import { EntreeProduitListAdminComponent } from './entree-produit/list/entree-produit-list-admin.component';
import { SortieProduitCreateAdminComponent } from './sortie-produit/create/sortie-produit-create-admin.component';
import { SortieProduitEditAdminComponent } from './sortie-produit/edit/sortie-produit-edit-admin.component';
import { SortieProduitViewAdminComponent } from './sortie-produit/view/sortie-produit-view-admin.component';
import { SortieProduitListAdminComponent } from './sortie-produit/list/sortie-produit-list-admin.component';

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

    EntreeProduitCreateAdminComponent,
    EntreeProduitListAdminComponent,
    EntreeProduitViewAdminComponent,
    EntreeProduitEditAdminComponent,
    SortieProduitCreateAdminComponent,
    SortieProduitListAdminComponent,
    SortieProduitViewAdminComponent,
    SortieProduitEditAdminComponent,
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
  EntreeProduitCreateAdminComponent,
  EntreeProduitListAdminComponent,
  EntreeProduitViewAdminComponent,
  EntreeProduitEditAdminComponent,
  SortieProduitCreateAdminComponent,
  SortieProduitListAdminComponent,
  SortieProduitViewAdminComponent,
  SortieProduitEditAdminComponent,
  ],
  entryComponents: [],
})
export class EntreeAdminModule { }
