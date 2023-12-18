import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {RaisonDto} from 'src/app/controller/model/Transfert/Raison.model';
import {RaisonCriteria} from 'src/app/controller/criteria/Transfert/RaisonCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class RaisonAdminService extends AbstractService<RaisonDto, RaisonCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/raison/');
    }

    public constrcutDto(): RaisonDto {
        return new RaisonDto();
    }

    public constrcutCriteria(): RaisonCriteria {
        return new RaisonCriteria();
    }
}
