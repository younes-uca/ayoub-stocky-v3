import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {ReglementVenteDto} from 'src/app/controller/model/reglement/ReglementVente.model';
import {ReglementVenteCriteria} from 'src/app/controller/criteria/reglement/ReglementVenteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ReglementVenteAdminService extends AbstractService<ReglementVenteDto, ReglementVenteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/reglementVente/');
    }

    public constrcutDto(): ReglementVenteDto {
        return new ReglementVenteDto();
    }

    public constrcutCriteria(): ReglementVenteCriteria {
        return new ReglementVenteCriteria();
    }
}
