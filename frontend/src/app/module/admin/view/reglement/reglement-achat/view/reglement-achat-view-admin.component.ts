import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReglementAchatAdminService} from 'src/app/controller/service/admin/reglement/ReglementAchatAdmin.service';
import {ReglementAchatDto} from 'src/app/controller/model/reglement/ReglementAchat.model';
import {ReglementAchatCriteria} from 'src/app/controller/criteria/reglement/ReglementAchatCriteria.model';

import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ModeReglementAdmin.service';
@Component({
  selector: 'app-reglement-achat-view-admin',
  templateUrl: './reglement-achat-view-admin.component.html'
})
export class ReglementAchatViewAdminComponent extends AbstractViewController<ReglementAchatDto, ReglementAchatCriteria, ReglementAchatAdminService> implements OnInit {


    constructor(private reglementAchatService: ReglementAchatAdminService, private achatService: AchatAdminService, private modeReglementService: ModeReglementAdminService){
        super(reglementAchatService);
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
