import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatAvoirAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirAchatAdmin.service';
import {EtatAvoirAchatDto} from 'src/app/controller/model/commun/EtatAvoirAchat.model';
import {EtatAvoirAchatCriteria} from 'src/app/controller/criteria/commun/EtatAvoirAchatCriteria.model';

@Component({
  selector: 'app-etat-avoir-achat-view-admin',
  templateUrl: './etat-avoir-achat-view-admin.component.html'
})
export class EtatAvoirAchatViewAdminComponent extends AbstractViewController<EtatAvoirAchatDto, EtatAvoirAchatCriteria, EtatAvoirAchatAdminService> implements OnInit {


    constructor(private etatAvoirAchatService: EtatAvoirAchatAdminService){
        super(etatAvoirAchatService);
    }

    ngOnInit(): void {
    }




}
