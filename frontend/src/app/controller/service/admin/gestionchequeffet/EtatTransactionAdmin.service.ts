import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {EtatTransactionDto} from 'src/app/controller/model/gestionchequeffet/EtatTransaction.model';
import {EtatTransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/EtatTransactionCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatTransactionAdminService extends AbstractService<EtatTransactionDto, EtatTransactionCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatTransaction/');
    }

    public constrcutDto(): EtatTransactionDto {
        return new EtatTransactionDto();
    }

    public constrcutCriteria(): EtatTransactionCriteria {
        return new EtatTransactionCriteria();
    }
}
