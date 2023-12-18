import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotCriteria} from 'src/app/controller/criteria/commun/DepotCriteria.model';

@Component({
  selector: 'app-depot-view-admin',
  templateUrl: './depot-view-admin.component.html'
})
export class DepotViewAdminComponent extends AbstractViewController<DepotDto, DepotCriteria, DepotAdminService> implements OnInit {


    constructor(private depotService: DepotAdminService){
        super(depotService);
    }

    ngOnInit(): void {
    }




}
