import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {StockDto} from 'src/app/controller/model/stock/Stock.model';
import {StockCriteria} from 'src/app/controller/criteria/stock/StockCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class StockAdminService extends AbstractService<StockDto, StockCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/stock/');
    }

    public constrcutDto(): StockDto {
        return new StockDto();
    }

    public constrcutCriteria(): StockCriteria {
        return new StockCriteria();
    }
}
