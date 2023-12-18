import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurCriteria} from 'src/app/controller/criteria/commun/CollaborateurCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CollaborateurAdminService extends AbstractService<CollaborateurDto, CollaborateurCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/collaborateur/');
    }

    public constrcutDto(): CollaborateurDto {
        return new CollaborateurDto();
    }

    public constrcutCriteria(): CollaborateurCriteria {
        return new CollaborateurCriteria();
    }
}
