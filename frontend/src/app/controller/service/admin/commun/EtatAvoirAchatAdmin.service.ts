import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {EtatAvoirAchatDto} from 'src/app/controller/model/commun/EtatAvoirAchat.model';
import {EtatAvoirAchatCriteria} from 'src/app/controller/criteria/commun/EtatAvoirAchatCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatAvoirAchatAdminService extends AbstractService<EtatAvoirAchatDto, EtatAvoirAchatCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatAvoirAchat/');
    }

    public constrcutDto(): EtatAvoirAchatDto {
        return new EtatAvoirAchatDto();
    }

    public constrcutCriteria(): EtatAvoirAchatCriteria {
        return new EtatAvoirAchatCriteria();
    }
}
