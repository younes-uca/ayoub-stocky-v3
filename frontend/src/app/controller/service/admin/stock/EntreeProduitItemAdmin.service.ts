import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {EntreeProduitItemDto} from 'src/app/controller/model/stock/EntreeProduitItem.model';
import {EntreeProduitItemCriteria} from 'src/app/controller/criteria/stock/EntreeProduitItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EntreeProduitItemAdminService extends AbstractService<EntreeProduitItemDto, EntreeProduitItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/entreeProduitItem/');
    }

    public constrcutDto(): EntreeProduitItemDto {
        return new EntreeProduitItemDto();
    }

    public constrcutCriteria(): EntreeProduitItemCriteria {
        return new EntreeProduitItemCriteria();
    }
}
