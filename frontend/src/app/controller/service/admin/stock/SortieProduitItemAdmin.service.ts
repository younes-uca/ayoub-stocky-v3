import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {SortieProduitItemDto} from 'src/app/controller/model/stock/SortieProduitItem.model';
import {SortieProduitItemCriteria} from 'src/app/controller/criteria/stock/SortieProduitItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class SortieProduitItemAdminService extends AbstractService<SortieProduitItemDto, SortieProduitItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/sortieProduitItem/');
    }

    public constrcutDto(): SortieProduitItemDto {
        return new SortieProduitItemDto();
    }

    public constrcutCriteria(): SortieProduitItemCriteria {
        return new SortieProduitItemCriteria();
    }
}
