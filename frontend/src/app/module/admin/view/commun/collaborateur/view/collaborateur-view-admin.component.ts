import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurCriteria} from 'src/app/controller/criteria/commun/CollaborateurCriteria.model';

@Component({
  selector: 'app-collaborateur-view-admin',
  templateUrl: './collaborateur-view-admin.component.html'
})
export class CollaborateurViewAdminComponent extends AbstractViewController<CollaborateurDto, CollaborateurCriteria, CollaborateurAdminService> implements OnInit {


    constructor(private collaborateurService: CollaborateurAdminService){
        super(collaborateurService);
    }

    ngOnInit(): void {
    }




}
