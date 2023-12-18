import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireCriteria.model';

@Component({
  selector: 'app-proprietaire-view-admin',
  templateUrl: './proprietaire-view-admin.component.html'
})
export class ProprietaireViewAdminComponent extends AbstractViewController<ProprietaireDto, ProprietaireCriteria, ProprietaireAdminService> implements OnInit {


    constructor(private proprietaireService: ProprietaireAdminService){
        super(proprietaireService);
    }

    ngOnInit(): void {
    }




}
