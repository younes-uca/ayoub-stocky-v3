import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {CommandeDto} from 'src/app/controller/model/stock/Commande.model';
import {CommandeCriteria} from 'src/app/controller/criteria/stock/CommandeCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CommandeAdminService extends AbstractService<CommandeDto, CommandeCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/commande/');
    }

    public constrcutDto(): CommandeDto {
        return new CommandeDto();
    }

    public constrcutCriteria(): CommandeCriteria {
        return new CommandeCriteria();
    }
}
