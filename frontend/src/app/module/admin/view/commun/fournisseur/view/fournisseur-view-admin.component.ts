import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/commun/FournisseurCriteria.model';

@Component({
  selector: 'app-fournisseur-view-admin',
  templateUrl: './fournisseur-view-admin.component.html'
})
export class FournisseurViewAdminComponent extends AbstractViewController<FournisseurDto, FournisseurCriteria, FournisseurAdminService> implements OnInit {


    constructor(private fournisseurService: FournisseurAdminService){
        super(fournisseurService);
    }

    ngOnInit(): void {
    }




}
