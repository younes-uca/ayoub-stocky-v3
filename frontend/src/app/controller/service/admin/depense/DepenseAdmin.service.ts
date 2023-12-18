import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {DepenseDto} from 'src/app/controller/model/depense/Depense.model';
import {DepenseCriteria} from 'src/app/controller/criteria/depense/DepenseCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class DepenseAdminService extends AbstractService<DepenseDto, DepenseCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/depense/');
    }

    public constrcutDto(): DepenseDto {
        return new DepenseDto();
    }

    public constrcutCriteria(): DepenseCriteria {
        return new DepenseCriteria();
    }
}
