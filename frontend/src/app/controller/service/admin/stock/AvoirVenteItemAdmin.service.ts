import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemCriteria} from 'src/app/controller/criteria/stock/AvoirVenteItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class AvoirVenteItemAdminService extends AbstractService<AvoirVenteItemDto, AvoirVenteItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/avoirVenteItem/');
    }

    public constrcutDto(): AvoirVenteItemDto {
        return new AvoirVenteItemDto();
    }

    public constrcutCriteria(): AvoirVenteItemCriteria {
        return new AvoirVenteItemCriteria();
    }
}
