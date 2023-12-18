import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/TypeTransactionCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TypeTransactionAdminService extends AbstractService<TypeTransactionDto, TypeTransactionCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/typeTransaction/');
    }

    public constrcutDto(): TypeTransactionDto {
        return new TypeTransactionDto();
    }

    public constrcutCriteria(): TypeTransactionCriteria {
        return new TypeTransactionCriteria();
    }
}
