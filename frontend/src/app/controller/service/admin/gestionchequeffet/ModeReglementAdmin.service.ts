import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {ModeReglementDto} from 'src/app/controller/model/gestionchequeffet/ModeReglement.model';
import {ModeReglementCriteria} from 'src/app/controller/criteria/gestionchequeffet/ModeReglementCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ModeReglementAdminService extends AbstractService<ModeReglementDto, ModeReglementCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/modeReglement/');
    }

    public constrcutDto(): ModeReglementDto {
        return new ModeReglementDto();
    }

    public constrcutCriteria(): ModeReglementCriteria {
        return new ModeReglementCriteria();
    }
}
