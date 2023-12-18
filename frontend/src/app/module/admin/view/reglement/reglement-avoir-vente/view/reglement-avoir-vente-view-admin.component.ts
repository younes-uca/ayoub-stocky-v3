import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReglementAvoirVenteAdminService} from 'src/app/controller/service/admin/reglement/ReglementAvoirVenteAdmin.service';
import {ReglementAvoirVenteDto} from 'src/app/controller/model/reglement/ReglementAvoirVente.model';
import {ReglementAvoirVenteCriteria} from 'src/app/controller/criteria/reglement/ReglementAvoirVenteCriteria.model';

import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
@Component({
  selector: 'app-reglement-avoir-vente-view-admin',
  templateUrl: './reglement-avoir-vente-view-admin.component.html'
})
export class ReglementAvoirVenteViewAdminComponent extends AbstractViewController<ReglementAvoirVenteDto, ReglementAvoirVenteCriteria, ReglementAvoirVenteAdminService> implements OnInit {


    constructor(private reglementAvoirVenteService: ReglementAvoirVenteAdminService, private avoirVenteService: AvoirVenteAdminService, private modeReglementService: ModeReglementAdminService, private venteService: VenteAdminService){
        super(reglementAvoirVenteService);
    }

    ngOnInit(): void {
    }


    get modeReglement(): ModeReglementDto {
       return this.modeReglementService.item;
    }
    set modeReglement(value: ModeReglementDto) {
        this.modeReglementService.item = value;
    }
    get modeReglements(): Array<ModeReglementDto> {
       return this.modeReglementService.items;
    }
    set modeReglements(value: Array<ModeReglementDto>) {
        this.modeReglementService.items = value;
    }
    get avoirVente(): AvoirVenteDto {
       return this.avoirVenteService.item;
    }
    set avoirVente(value: AvoirVenteDto) {
        this.avoirVenteService.item = value;
    }
    get avoirVentes(): Array<AvoirVenteDto> {
       return this.avoirVenteService.items;
    }
    set avoirVentes(value: Array<AvoirVenteDto>) {
        this.avoirVenteService.items = value;
    }
    get vente(): VenteDto {
       return this.venteService.item;
    }
    set vente(value: VenteDto) {
        this.venteService.item = value;
    }
    get ventes(): Array<VenteDto> {
       return this.venteService.items;
    }
    set ventes(value: Array<VenteDto>) {
        this.venteService.items = value;
    }


}
