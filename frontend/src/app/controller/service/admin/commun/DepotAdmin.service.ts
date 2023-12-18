import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotCriteria} from 'src/app/controller/criteria/commun/DepotCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class DepotAdminService extends AbstractService<DepotDto, DepotCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/depot/');
    }

    public constrcutDto(): DepotDto {
        return new DepotDto();
    }

    public constrcutCriteria(): DepotCriteria {
        return new DepotCriteria();
    }
}
