import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {ReglementAvoirAchatDto} from 'src/app/controller/model/reglement/ReglementAvoirAchat.model';
import {ReglementAvoirAchatCriteria} from 'src/app/controller/criteria/reglement/ReglementAvoirAchatCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ReglementAvoirAchatAdminService extends AbstractService<ReglementAvoirAchatDto, ReglementAvoirAchatCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/reglementAvoirAchat/');
    }

    public constrcutDto(): ReglementAvoirAchatDto {
        return new ReglementAvoirAchatDto();
    }

    public constrcutCriteria(): ReglementAvoirAchatCriteria {
        return new ReglementAvoirAchatCriteria();
    }
}
