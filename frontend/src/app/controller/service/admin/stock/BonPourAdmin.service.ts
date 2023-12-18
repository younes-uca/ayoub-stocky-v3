import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {BonPourDto} from 'src/app/controller/model/stock/BonPour.model';
import {BonPourCriteria} from 'src/app/controller/criteria/stock/BonPourCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class BonPourAdminService extends AbstractService<BonPourDto, BonPourCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/bonPour/');
    }

    public constrcutDto(): BonPourDto {
        return new BonPourDto();
    }

    public constrcutCriteria(): BonPourCriteria {
        return new BonPourCriteria();
    }
}
