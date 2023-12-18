import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteCriteria} from 'src/app/controller/criteria/gestionchequeffet/CompteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CompteAdminService extends AbstractService<CompteDto, CompteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/compte/');
    }

    public constrcutDto(): CompteDto {
        return new CompteDto();
    }

    public constrcutCriteria(): CompteCriteria {
        return new CompteCriteria();
    }
}
