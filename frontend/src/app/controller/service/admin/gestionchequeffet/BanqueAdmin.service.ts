import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {BanqueDto} from 'src/app/controller/model/gestionchequeffet/Banque.model';
import {BanqueCriteria} from 'src/app/controller/criteria/gestionchequeffet/BanqueCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class BanqueAdminService extends AbstractService<BanqueDto, BanqueCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/banque/');
    }

    public constrcutDto(): BanqueDto {
        return new BanqueDto();
    }

    public constrcutCriteria(): BanqueCriteria {
        return new BanqueCriteria();
    }
}
