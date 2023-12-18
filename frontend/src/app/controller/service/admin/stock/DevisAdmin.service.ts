import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {DevisDto} from 'src/app/controller/model/stock/Devis.model';
import {DevisCriteria} from 'src/app/controller/criteria/stock/DevisCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class DevisAdminService extends AbstractService<DevisDto, DevisCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/devis/');
    }

    public constrcutDto(): DevisDto {
        return new DevisDto();
    }

    public constrcutCriteria(): DevisCriteria {
        return new DevisCriteria();
    }
}
