import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {MarqueAdminService} from 'src/app/controller/service/admin/commun/MarqueAdmin.service';
import {MarqueDto} from 'src/app/controller/model/commun/Marque.model';
import {MarqueCriteria} from 'src/app/controller/criteria/commun/MarqueCriteria.model';

@Component({
  selector: 'app-marque-view-admin',
  templateUrl: './marque-view-admin.component.html'
})
export class MarqueViewAdminComponent extends AbstractViewController<MarqueDto, MarqueCriteria, MarqueAdminService> implements OnInit {


    constructor(private marqueService: MarqueAdminService){
        super(marqueService);
    }

    ngOnInit(): void {
    }




}
