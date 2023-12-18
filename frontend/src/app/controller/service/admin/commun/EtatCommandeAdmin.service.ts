import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {EtatCommandeDto} from 'src/app/controller/model/commun/EtatCommande.model';
import {EtatCommandeCriteria} from 'src/app/controller/criteria/commun/EtatCommandeCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EtatCommandeAdminService extends AbstractService<EtatCommandeDto, EtatCommandeCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/etatCommande/');
    }

    public constrcutDto(): EtatCommandeDto {
        return new EtatCommandeDto();
    }

    public constrcutCriteria(): EtatCommandeCriteria {
        return new EtatCommandeCriteria();
    }
}
