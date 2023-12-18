import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatAvoirVenteAdminService} from 'src/app/controller/service/admin/commun/EtatAvoirVenteAdmin.service';
import {EtatAvoirVenteDto} from 'src/app/controller/model/commun/EtatAvoirVente.model';
import {EtatAvoirVenteCriteria} from 'src/app/controller/criteria/commun/EtatAvoirVenteCriteria.model';

@Component({
  selector: 'app-etat-avoir-vente-view-admin',
  templateUrl: './etat-avoir-vente-view-admin.component.html'
})
export class EtatAvoirVenteViewAdminComponent extends AbstractViewController<EtatAvoirVenteDto, EtatAvoirVenteCriteria, EtatAvoirVenteAdminService> implements OnInit {


    constructor(private etatAvoirVenteService: EtatAvoirVenteAdminService){
        super(etatAvoirVenteService);
    }

    ngOnInit(): void {
    }




}
