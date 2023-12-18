import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatVenteAdminService} from 'src/app/controller/service/admin/commun/EtatVenteAdmin.service';
import {EtatVenteDto} from 'src/app/controller/model/commun/EtatVente.model';
import {EtatVenteCriteria} from 'src/app/controller/criteria/commun/EtatVenteCriteria.model';

@Component({
  selector: 'app-etat-vente-view-admin',
  templateUrl: './etat-vente-view-admin.component.html'
})
export class EtatVenteViewAdminComponent extends AbstractViewController<EtatVenteDto, EtatVenteCriteria, EtatVenteAdminService> implements OnInit {


    constructor(private etatVenteService: EtatVenteAdminService){
        super(etatVenteService);
    }

    ngOnInit(): void {
    }




}
