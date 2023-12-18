import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteCriteria} from 'src/app/controller/criteria/commun/EntrepriseSocieteCriteria.model';

@Component({
  selector: 'app-entreprise-societe-view-admin',
  templateUrl: './entreprise-societe-view-admin.component.html'
})
export class EntrepriseSocieteViewAdminComponent extends AbstractViewController<EntrepriseSocieteDto, EntrepriseSocieteCriteria, EntrepriseSocieteAdminService> implements OnInit {


    constructor(private entrepriseSocieteService: EntrepriseSocieteAdminService){
        super(entrepriseSocieteService);
    }

    ngOnInit(): void {
    }




}
