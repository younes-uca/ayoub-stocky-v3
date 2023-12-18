import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {InventaireItemDto} from 'src/app/controller/model/stock/InventaireItem.model';
import {InventaireItemCriteria} from 'src/app/controller/criteria/stock/InventaireItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class InventaireItemAdminService extends AbstractService<InventaireItemDto, InventaireItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/inventaireItem/');
    }

    public constrcutDto(): InventaireItemDto {
        return new InventaireItemDto();
    }

    public constrcutCriteria(): InventaireItemCriteria {
        return new InventaireItemCriteria();
    }
}
