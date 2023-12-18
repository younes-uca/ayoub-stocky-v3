import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemCriteria} from 'src/app/controller/criteria/stock/AvoirAchatItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class AvoirAchatItemAdminService extends AbstractService<AvoirAchatItemDto, AvoirAchatItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/avoirAchatItem/');
    }

    public constrcutDto(): AvoirAchatItemDto {
        return new AvoirAchatItemDto();
    }

    public constrcutCriteria(): AvoirAchatItemCriteria {
        return new AvoirAchatItemCriteria();
    }
}
