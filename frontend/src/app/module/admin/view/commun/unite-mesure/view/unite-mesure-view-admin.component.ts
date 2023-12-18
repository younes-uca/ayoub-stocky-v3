import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {UniteMesureAdminService} from 'src/app/controller/service/admin/commun/UniteMesureAdmin.service';
import {UniteMesureDto} from 'src/app/controller/model/commun/UniteMesure.model';
import {UniteMesureCriteria} from 'src/app/controller/criteria/commun/UniteMesureCriteria.model';

@Component({
  selector: 'app-unite-mesure-view-admin',
  templateUrl: './unite-mesure-view-admin.component.html'
})
export class UniteMesureViewAdminComponent extends AbstractViewController<UniteMesureDto, UniteMesureCriteria, UniteMesureAdminService> implements OnInit {


    constructor(private uniteMesureService: UniteMesureAdminService){
        super(uniteMesureService);
    }

    ngOnInit(): void {
    }




}
