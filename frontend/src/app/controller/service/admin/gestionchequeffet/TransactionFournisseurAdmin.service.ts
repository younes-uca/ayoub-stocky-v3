import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {TransactionFournisseurDto} from 'src/app/controller/model/gestionchequeffet/TransactionFournisseur.model';
import {TransactionFournisseurCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransactionFournisseurCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TransactionFournisseurAdminService extends AbstractService<TransactionFournisseurDto, TransactionFournisseurCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/transactionFournisseur/');
    }

    public constrcutDto(): TransactionFournisseurDto {
        return new TransactionFournisseurDto();
    }

    public constrcutCriteria(): TransactionFournisseurCriteria {
        return new TransactionFournisseurCriteria();
    }
}
