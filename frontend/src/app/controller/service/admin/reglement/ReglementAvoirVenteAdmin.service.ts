import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {ReglementAvoirVenteDto} from 'src/app/controller/model/reglement/ReglementAvoirVente.model';
import {ReglementAvoirVenteCriteria} from 'src/app/controller/criteria/reglement/ReglementAvoirVenteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ReglementAvoirVenteAdminService extends AbstractService<ReglementAvoirVenteDto, ReglementAvoirVenteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/reglementAvoirVente/');
    }

    public constrcutDto(): ReglementAvoirVenteDto {
        return new ReglementAvoirVenteDto();
    }

    public constrcutCriteria(): ReglementAvoirVenteCriteria {
        return new ReglementAvoirVenteCriteria();
    }
}
