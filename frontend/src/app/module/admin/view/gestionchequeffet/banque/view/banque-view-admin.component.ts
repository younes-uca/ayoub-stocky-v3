import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BanqueAdminService} from 'src/app/controller/service/admin/gestionchequeffet/BanqueAdmin.service';
import {BanqueDto} from 'src/app/controller/model/gestionchequeffet/Banque.model';
import {BanqueCriteria} from 'src/app/controller/criteria/gestionchequeffet/BanqueCriteria.model';

@Component({
  selector: 'app-banque-view-admin',
  templateUrl: './banque-view-admin.component.html'
})
export class BanqueViewAdminComponent extends AbstractViewController<BanqueDto, BanqueCriteria, BanqueAdminService> implements OnInit {


    constructor(private banqueService: BanqueAdminService){
        super(banqueService);
    }

    ngOnInit(): void {
    }




}
