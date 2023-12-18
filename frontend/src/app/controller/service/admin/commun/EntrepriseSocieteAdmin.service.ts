import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteCriteria} from 'src/app/controller/criteria/commun/EntrepriseSocieteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EntrepriseSocieteAdminService extends AbstractService<EntrepriseSocieteDto, EntrepriseSocieteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/entrepriseSociete/');
    }

    public constrcutDto(): EntrepriseSocieteDto {
        return new EntrepriseSocieteDto();
    }

    public constrcutCriteria(): EntrepriseSocieteCriteria {
        return new EntrepriseSocieteCriteria();
    }
}
