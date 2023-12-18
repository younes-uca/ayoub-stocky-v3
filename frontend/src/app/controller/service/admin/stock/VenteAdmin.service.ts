import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/stock/VenteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class VenteAdminService extends AbstractService<VenteDto, VenteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/vente/');
    }

    public constrcutDto(): VenteDto {
        return new VenteDto();
    }

    public constrcutCriteria(): VenteCriteria {
        return new VenteCriteria();
    }
}
