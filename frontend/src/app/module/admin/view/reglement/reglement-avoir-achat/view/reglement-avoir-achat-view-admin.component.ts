import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReglementAvoirAchatAdminService} from 'src/app/controller/service/admin/reglement/ReglementAvoirAchatAdmin.service';
import {ReglementAvoirAchatDto} from 'src/app/controller/model/reglement/ReglementAvoirAchat.model';
import {ReglementAvoirAchatCriteria} from 'src/app/controller/criteria/reglement/ReglementAvoirAchatCriteria.model';

import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
@Component({
  selector: 'app-reglement-avoir-achat-view-admin',
  templateUrl: './reglement-avoir-achat-view-admin.component.html'
})
export class ReglementAvoirAchatViewAdminComponent extends AbstractViewController<ReglementAvoirAchatDto, ReglementAvoirAchatCriteria, ReglementAvoirAchatAdminService> implements OnInit {


    constructor(private reglementAvoirAchatService: ReglementAvoirAchatAdminService, private avoirAchatService: AvoirAchatAdminService, private achatService: AchatAdminService, private modeReglementService: ModeReglementAdminService){
        super(reglementAvoirAchatService);
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
    get avoirAchat(): AvoirAchatDto {
       return this.avoirAchatService.item;
    }
    set avoirAchat(value: AvoirAchatDto) {
        this.avoirAchatService.item = value;
    }
    get avoirAchats(): Array<AvoirAchatDto> {
       return this.avoirAchatService.items;
    }
    set avoirAchats(value: Array<AvoirAchatDto>) {
        this.avoirAchatService.items = value;
    }
    get achat(): AchatDto {
       return this.achatService.item;
    }
    set achat(value: AchatDto) {
        this.achatService.item = value;
    }
    get achats(): Array<AchatDto> {
       return this.achatService.items;
    }
    set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
    }


}
