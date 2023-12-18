import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatCommandeAdminService} from 'src/app/controller/service/admin/commun/EtatCommandeAdmin.service';
import {EtatCommandeDto} from 'src/app/controller/model/commun/EtatCommande.model';
import {EtatCommandeCriteria} from 'src/app/controller/criteria/commun/EtatCommandeCriteria.model';

@Component({
  selector: 'app-etat-commande-view-admin',
  templateUrl: './etat-commande-view-admin.component.html'
})
export class EtatCommandeViewAdminComponent extends AbstractViewController<EtatCommandeDto, EtatCommandeCriteria, EtatCommandeAdminService> implements OnInit {


    constructor(private etatCommandeService: EtatCommandeAdminService){
        super(etatCommandeService);
    }

    ngOnInit(): void {
    }




}
