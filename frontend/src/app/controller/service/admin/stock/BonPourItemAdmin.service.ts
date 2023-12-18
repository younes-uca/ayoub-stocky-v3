import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {BonPourItemDto} from 'src/app/controller/model/stock/BonPourItem.model';
import {BonPourItemCriteria} from 'src/app/controller/criteria/stock/BonPourItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class BonPourItemAdminService extends AbstractService<BonPourItemDto, BonPourItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/bonPourItem/');
    }

    public constrcutDto(): BonPourItemDto {
        return new BonPourItemDto();
    }

    public constrcutCriteria(): BonPourItemCriteria {
        return new BonPourItemCriteria();
    }
}
