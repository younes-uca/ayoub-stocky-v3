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

import { CategorieCreateAdminComponent } from './categorie/create/categorie-create-admin.component';
import { CategorieEditAdminComponent } from './categorie/edit/categorie-edit-admin.component';
import { CategorieViewAdminComponent } from './categorie/view/categorie-view-admin.component';
import { CategorieListAdminComponent } from './categorie/list/categorie-list-admin.component';
import { EtatAvoirVenteCreateAdminComponent } from './etat-avoir-vente/create/etat-avoir-vente-create-admin.component';
import { EtatAvoirVenteEditAdminComponent } from './etat-avoir-vente/edit/etat-avoir-vente-edit-admin.component';
import { EtatAvoirVenteViewAdminComponent } from './etat-avoir-vente/view/etat-avoir-vente-view-admin.component';
import { EtatAvoirVenteListAdminComponent } from './etat-avoir-vente/list/etat-avoir-vente-list-admin.component';
import { EtatAvoirAchatCreateAdminComponent } from './etat-avoir-achat/create/etat-avoir-achat-create-admin.component';
import { EtatAvoirAchatEditAdminComponent } from './etat-avoir-achat/edit/etat-avoir-achat-edit-admin.component';
import { EtatAvoirAchatViewAdminComponent } from './etat-avoir-achat/view/etat-avoir-achat-view-admin.component';
import { EtatAvoirAchatListAdminComponent } from './etat-avoir-achat/list/etat-avoir-achat-list-admin.component';
import { DepotCreateAdminComponent } from './depot/create/depot-create-admin.component';
import { DepotEditAdminComponent } from './depot/edit/depot-edit-admin.component';
import { DepotViewAdminComponent } from './depot/view/depot-view-admin.component';
import { DepotListAdminComponent } from './depot/list/depot-list-admin.component';
import { FournisseurCreateAdminComponent } from './fournisseur/create/fournisseur-create-admin.component';
import { FournisseurEditAdminComponent } from './fournisseur/edit/fournisseur-edit-admin.component';
import { FournisseurViewAdminComponent } from './fournisseur/view/fournisseur-view-admin.component';
import { FournisseurListAdminComponent } from './fournisseur/list/fournisseur-list-admin.component';
import { UniteMesureCreateAdminComponent } from './unite-mesure/create/unite-mesure-create-admin.component';
import { UniteMesureEditAdminComponent } from './unite-mesure/edit/unite-mesure-edit-admin.component';
import { UniteMesureViewAdminComponent } from './unite-mesure/view/unite-mesure-view-admin.component';
import { UniteMesureListAdminComponent } from './unite-mesure/list/unite-mesure-list-admin.component';
import { EtatCommandeCreateAdminComponent } from './etat-commande/create/etat-commande-create-admin.component';
import { EtatCommandeEditAdminComponent } from './etat-commande/edit/etat-commande-edit-admin.component';
import { EtatCommandeViewAdminComponent } from './etat-commande/view/etat-commande-view-admin.component';
import { EtatCommandeListAdminComponent } from './etat-commande/list/etat-commande-list-admin.component';
import { ClientCreateAdminComponent } from './client/create/client-create-admin.component';
import { ClientEditAdminComponent } from './client/edit/client-edit-admin.component';
import { ClientViewAdminComponent } from './client/view/client-view-admin.component';
import { ClientListAdminComponent } from './client/list/client-list-admin.component';
import { EtatAchatCreateAdminComponent } from './etat-achat/create/etat-achat-create-admin.component';
import { EtatAchatEditAdminComponent } from './etat-achat/edit/etat-achat-edit-admin.component';
import { EtatAchatViewAdminComponent } from './etat-achat/view/etat-achat-view-admin.component';
import { EtatAchatListAdminComponent } from './etat-achat/list/etat-achat-list-admin.component';
import { MarqueCreateAdminComponent } from './marque/create/marque-create-admin.component';
import { MarqueEditAdminComponent } from './marque/edit/marque-edit-admin.component';
import { MarqueViewAdminComponent } from './marque/view/marque-view-admin.component';
import { MarqueListAdminComponent } from './marque/list/marque-list-admin.component';
import { EntrepriseSocieteCreateAdminComponent } from './entreprise-societe/create/entreprise-societe-create-admin.component';
import { EntrepriseSocieteEditAdminComponent } from './entreprise-societe/edit/entreprise-societe-edit-admin.component';
import { EntrepriseSocieteViewAdminComponent } from './entreprise-societe/view/entreprise-societe-view-admin.component';
import { EntrepriseSocieteListAdminComponent } from './entreprise-societe/list/entreprise-societe-list-admin.component';
import { CollaborateurCreateAdminComponent } from './collaborateur/create/collaborateur-create-admin.component';
import { CollaborateurEditAdminComponent } from './collaborateur/edit/collaborateur-edit-admin.component';
import { CollaborateurViewAdminComponent } from './collaborateur/view/collaborateur-view-admin.component';
import { CollaborateurListAdminComponent } from './collaborateur/list/collaborateur-list-admin.component';
import { EtatVenteCreateAdminComponent } from './etat-vente/create/etat-vente-create-admin.component';
import { EtatVenteEditAdminComponent } from './etat-vente/edit/etat-vente-edit-admin.component';
import { EtatVenteViewAdminComponent } from './etat-vente/view/etat-vente-view-admin.component';
import { EtatVenteListAdminComponent } from './etat-vente/list/etat-vente-list-admin.component';

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

    CategorieCreateAdminComponent,
    CategorieListAdminComponent,
    CategorieViewAdminComponent,
    CategorieEditAdminComponent,
    EtatAvoirVenteCreateAdminComponent,
    EtatAvoirVenteListAdminComponent,
    EtatAvoirVenteViewAdminComponent,
    EtatAvoirVenteEditAdminComponent,
    EtatAvoirAchatCreateAdminComponent,
    EtatAvoirAchatListAdminComponent,
    EtatAvoirAchatViewAdminComponent,
    EtatAvoirAchatEditAdminComponent,
    DepotCreateAdminComponent,
    DepotListAdminComponent,
    DepotViewAdminComponent,
    DepotEditAdminComponent,
    FournisseurCreateAdminComponent,
    FournisseurListAdminComponent,
    FournisseurViewAdminComponent,
    FournisseurEditAdminComponent,
    UniteMesureCreateAdminComponent,
    UniteMesureListAdminComponent,
    UniteMesureViewAdminComponent,
    UniteMesureEditAdminComponent,
    EtatCommandeCreateAdminComponent,
    EtatCommandeListAdminComponent,
    EtatCommandeViewAdminComponent,
    EtatCommandeEditAdminComponent,
    ClientCreateAdminComponent,
    ClientListAdminComponent,
    ClientViewAdminComponent,
    ClientEditAdminComponent,
    EtatAchatCreateAdminComponent,
    EtatAchatListAdminComponent,
    EtatAchatViewAdminComponent,
    EtatAchatEditAdminComponent,
    MarqueCreateAdminComponent,
    MarqueListAdminComponent,
    MarqueViewAdminComponent,
    MarqueEditAdminComponent,
    EntrepriseSocieteCreateAdminComponent,
    EntrepriseSocieteListAdminComponent,
    EntrepriseSocieteViewAdminComponent,
    EntrepriseSocieteEditAdminComponent,
    CollaborateurCreateAdminComponent,
    CollaborateurListAdminComponent,
    CollaborateurViewAdminComponent,
    CollaborateurEditAdminComponent,
    EtatVenteCreateAdminComponent,
    EtatVenteListAdminComponent,
    EtatVenteViewAdminComponent,
    EtatVenteEditAdminComponent,
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
  CategorieCreateAdminComponent,
  CategorieListAdminComponent,
  CategorieViewAdminComponent,
  CategorieEditAdminComponent,
  EtatAvoirVenteCreateAdminComponent,
  EtatAvoirVenteListAdminComponent,
  EtatAvoirVenteViewAdminComponent,
  EtatAvoirVenteEditAdminComponent,
  EtatAvoirAchatCreateAdminComponent,
  EtatAvoirAchatListAdminComponent,
  EtatAvoirAchatViewAdminComponent,
  EtatAvoirAchatEditAdminComponent,
  DepotCreateAdminComponent,
  DepotListAdminComponent,
  DepotViewAdminComponent,
  DepotEditAdminComponent,
  FournisseurCreateAdminComponent,
  FournisseurListAdminComponent,
  FournisseurViewAdminComponent,
  FournisseurEditAdminComponent,
  UniteMesureCreateAdminComponent,
  UniteMesureListAdminComponent,
  UniteMesureViewAdminComponent,
  UniteMesureEditAdminComponent,
  EtatCommandeCreateAdminComponent,
  EtatCommandeListAdminComponent,
  EtatCommandeViewAdminComponent,
  EtatCommandeEditAdminComponent,
  ClientCreateAdminComponent,
  ClientListAdminComponent,
  ClientViewAdminComponent,
  ClientEditAdminComponent,
  EtatAchatCreateAdminComponent,
  EtatAchatListAdminComponent,
  EtatAchatViewAdminComponent,
  EtatAchatEditAdminComponent,
  MarqueCreateAdminComponent,
  MarqueListAdminComponent,
  MarqueViewAdminComponent,
  MarqueEditAdminComponent,
  EntrepriseSocieteCreateAdminComponent,
  EntrepriseSocieteListAdminComponent,
  EntrepriseSocieteViewAdminComponent,
  EntrepriseSocieteEditAdminComponent,
  CollaborateurCreateAdminComponent,
  CollaborateurListAdminComponent,
  CollaborateurViewAdminComponent,
  CollaborateurEditAdminComponent,
  EtatVenteCreateAdminComponent,
  EtatVenteListAdminComponent,
  EtatVenteViewAdminComponent,
  EtatVenteEditAdminComponent,
  ],
  entryComponents: [],
})
export class CommunAdminModule { }
