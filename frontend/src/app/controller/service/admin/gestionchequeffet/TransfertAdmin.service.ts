import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {TransfertDto} from 'src/app/controller/model/gestionchequeffet/Transfert.model';
import {TransfertCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransfertCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TransfertAdminService extends AbstractService<TransfertDto, TransfertCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/transfert/');
    }

    public constrcutDto(): TransfertDto {
        return new TransfertDto();
    }

    public constrcutCriteria(): TransfertCriteria {
        return new TransfertCriteria();
    }
}
