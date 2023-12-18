import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {SortieProduitDto} from 'src/app/controller/model/entree/SortieProduit.model';
import {SortieProduitCriteria} from 'src/app/controller/criteria/entree/SortieProduitCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class SortieProduitAdminService extends AbstractService<SortieProduitDto, SortieProduitCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/sortieProduit/');
    }

    public constrcutDto(): SortieProduitDto {
        return new SortieProduitDto();
    }

    public constrcutCriteria(): SortieProduitCriteria {
        return new SortieProduitCriteria();
    }
}
