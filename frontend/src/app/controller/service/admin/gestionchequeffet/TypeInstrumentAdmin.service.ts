import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentCriteria} from 'src/app/controller/criteria/gestionchequeffet/TypeInstrumentCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TypeInstrumentAdminService extends AbstractService<TypeInstrumentDto, TypeInstrumentCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/typeInstrument/');
    }

    public constrcutDto(): TypeInstrumentDto {
        return new TypeInstrumentDto();
    }

    public constrcutCriteria(): TypeInstrumentCriteria {
        return new TypeInstrumentCriteria();
    }
}
