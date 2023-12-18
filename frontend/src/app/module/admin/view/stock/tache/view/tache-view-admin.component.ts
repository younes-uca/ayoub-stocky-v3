import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TacheAdminService} from 'src/app/controller/service/admin/stock/TacheAdmin.service';
import {TacheDto} from 'src/app/controller/model/stock/Tache.model';
import {TacheCriteria} from 'src/app/controller/criteria/stock/TacheCriteria.model';

import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
@Component({
  selector: 'app-tache-view-admin',
  templateUrl: './tache-view-admin.component.html'
})
export class TacheViewAdminComponent extends AbstractViewController<TacheDto, TacheCriteria, TacheAdminService> implements OnInit {


    constructor(private tacheService: TacheAdminService, private collaborateurService: CollaborateurAdminService){
        super(tacheService);
    }

    ngOnInit(): void {
    }


    get collaborateur(): CollaborateurDto {
       return this.collaborateurService.item;
    }
    set collaborateur(value: CollaborateurDto) {
        this.collaborateurService.item = value;
    }
    get collaborateurs(): Array<CollaborateurDto> {
       return this.collaborateurService.items;
    }
    set collaborateurs(value: Array<CollaborateurDto>) {
        this.collaborateurService.items = value;
    }


}
