import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteCriteria} from 'src/app/controller/criteria/commun/EtatAvoirVenteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatAvoirVenteAdminService extends AbstractService<EtatAvoirVenteDto, EtatAvoirVenteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatAvoirVente/');
    }

    public constrcutDto(): EtatAvoirVenteDto {
        return new EtatAvoirVenteDto();
    }

    public constrcutCriteria(): EtatAvoirVenteCriteria {
        return new EtatAvoirVenteCriteria();
    }
}
