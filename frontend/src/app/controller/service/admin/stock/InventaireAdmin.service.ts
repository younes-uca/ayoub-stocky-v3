import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {InventaireDto} from 'src/app/controller/model/stock/Inventaire.model';
import {InventaireCriteria} from 'src/app/controller/criteria/stock/InventaireCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class InventaireAdminService extends AbstractService<InventaireDto, InventaireCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/inventaire/');
    }

    public constrcutDto(): InventaireDto {
        return new InventaireDto();
    }

    public constrcutCriteria(): InventaireCriteria {
        return new InventaireCriteria();
    }
}
