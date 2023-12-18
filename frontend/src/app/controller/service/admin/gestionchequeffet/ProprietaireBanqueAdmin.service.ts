import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {ProprietaireBanqueDto} from 'src/app/controller/model/gestionchequeffet/ProprietaireBanque.model';
import {ProprietaireBanqueCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireBanqueCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ProprietaireBanqueAdminService extends AbstractService<ProprietaireBanqueDto, ProprietaireBanqueCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/proprietaireBanque/');
    }

    public constrcutDto(): ProprietaireBanqueDto {
        return new ProprietaireBanqueDto();
    }

    public constrcutCriteria(): ProprietaireBanqueCriteria {
        return new ProprietaireBanqueCriteria();
    }
}
