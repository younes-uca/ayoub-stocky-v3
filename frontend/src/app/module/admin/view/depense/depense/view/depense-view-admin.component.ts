import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DepenseAdminService} from 'src/app/controller/service/admin/depense/DepenseAdmin.service';
import {DepenseDto} from 'src/app/controller/model/depense/Depense.model';
import {DepenseCriteria} from 'src/app/controller/criteria/depense/DepenseCriteria.model';

@Component({
  selector: 'app-depense-view-admin',
  templateUrl: './depense-view-admin.component.html'
})
export class DepenseViewAdminComponent extends AbstractViewController<DepenseDto, DepenseCriteria, DepenseAdminService> implements OnInit {


    constructor(private depenseService: DepenseAdminService){
        super(depenseService);
    }

    ngOnInit(): void {
    }




}
