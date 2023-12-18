import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TaxeAdminService} from 'src/app/controller/service/admin/stock/TaxeAdmin.service';
import {TaxeDto} from 'src/app/controller/model/stock/Taxe.model';
import {TaxeCriteria} from 'src/app/controller/criteria/stock/TaxeCriteria.model';

@Component({
  selector: 'app-taxe-view-admin',
  templateUrl: './taxe-view-admin.component.html'
})
export class TaxeViewAdminComponent extends AbstractViewController<TaxeDto, TaxeCriteria, TaxeAdminService> implements OnInit {


    constructor(private taxeService: TaxeAdminService){
        super(taxeService);
    }

    ngOnInit(): void {
    }




}
