import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReglementVenteAdminService} from 'src/app/controller/service/admin/reglement/ReglementVenteAdmin.service';
import {ReglementVenteDto} from 'src/app/controller/model/reglement/ReglementVente.model';
import {ReglementVenteCriteria} from 'src/app/controller/criteria/reglement/ReglementVenteCriteria.model';

import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
@Component({
  selector: 'app-reglement-vente-view-admin',
  templateUrl: './reglement-vente-view-admin.component.html'
})
export class ReglementVenteViewAdminComponent extends AbstractViewController<ReglementVenteDto, ReglementVenteCriteria, ReglementVenteAdminService> implements OnInit {


    constructor(private reglementVenteService: ReglementVenteAdminService, private modeReglementService: ModeReglementAdminService, private venteService: VenteAdminService){
        super(reglementVenteService);
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
