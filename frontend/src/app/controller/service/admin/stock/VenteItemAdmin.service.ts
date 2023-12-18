import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {VenteItemDto} from 'src/app/controller/model/stock/VenteItem.model';
import {VenteItemCriteria} from 'src/app/controller/criteria/stock/VenteItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class VenteItemAdminService extends AbstractService<VenteItemDto, VenteItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/venteItem/');
    }

    public constrcutDto(): VenteItemDto {
        return new VenteItemDto();
    }

    public constrcutCriteria(): VenteItemCriteria {
        return new VenteItemCriteria();
    }
}
