import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAchatAdmin.service';
import {EtatAchatDto} from 'src/app/controller/model/commun/EtatAchat.model';
import {EtatAchatCriteria} from 'src/app/controller/criteria/commun/EtatAchatCriteria.model';

@Component({
  selector: 'app-etat-achat-view-admin',
  templateUrl: './etat-achat-view-admin.component.html'
})
export class EtatAchatViewAdminComponent extends AbstractViewController<EtatAchatDto, EtatAchatCriteria, EtatAchatAdminService> implements OnInit {


    constructor(private etatAchatService: EtatAchatAdminService){
        super(etatAchatService);
    }

    ngOnInit(): void {
    }




}
