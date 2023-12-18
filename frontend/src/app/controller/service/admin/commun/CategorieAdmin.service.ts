import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {CategorieDto} from 'src/app/controller/model/commun/Categorie.model';
import {CategorieCriteria} from 'src/app/controller/criteria/commun/CategorieCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CategorieAdminService extends AbstractService<CategorieDto, CategorieCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/categorie/');
    }

    public constrcutDto(): CategorieDto {
        return new CategorieDto();
    }

    public constrcutCriteria(): CategorieCriteria {
        return new CategorieCriteria();
    }
}
