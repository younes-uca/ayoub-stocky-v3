import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {TacheDto} from 'src/app/controller/model/stock/Tache.model';
import {TacheCriteria} from 'src/app/controller/criteria/stock/TacheCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TacheAdminService extends AbstractService<TacheDto, TacheCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/tache/');
    }

    public constrcutDto(): TacheDto {
        return new TacheDto();
    }

    public constrcutCriteria(): TacheCriteria {
        return new TacheCriteria();
    }
}
