import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {RaisonAdminService} from 'src/app/controller/service/admin/Transfert/RaisonAdmin.service';
import {RaisonDto} from 'src/app/controller/model/Transfert/Raison.model';
import {RaisonCriteria} from 'src/app/controller/criteria/Transfert/RaisonCriteria.model';

@Component({
  selector: 'app-raison-view-admin',
  templateUrl: './raison-view-admin.component.html'
})
export class RaisonViewAdminComponent extends AbstractViewController<RaisonDto, RaisonCriteria, RaisonAdminService> implements OnInit {


    constructor(private raisonService: RaisonAdminService){
        super(raisonService);
    }

    ngOnInit(): void {
    }




}
