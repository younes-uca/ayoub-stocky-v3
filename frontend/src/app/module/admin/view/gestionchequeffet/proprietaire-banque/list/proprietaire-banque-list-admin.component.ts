import {Component, OnInit} from '@angular/core';
import {ProprietaireBanqueAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireBanqueAdmin.service';
import {ProprietaireBanqueDto} from 'src/app/controller/model/gestionchequeffet/ProprietaireBanque.model';
import {ProprietaireBanqueCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireBanqueCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {BanqueDto} from 'src/app/controller/model/gestionchequeffet/Banque.model';
import {BanqueAdminService} from 'src/app/controller/service/admin/gestionchequeffet/BanqueAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';


@Component({
  selector: 'app-proprietaire-banque-list-admin',
  templateUrl: './proprietaire-banque-list-admin.component.html'
})
export class ProprietaireBanqueListAdminComponent extends AbstractListController<ProprietaireBanqueDto, ProprietaireBanqueCriteria, ProprietaireBanqueAdminService>  implements OnInit {

    fileName = 'ProprietaireBanque';

    proprietaires: Array<ProprietaireDto>;
    banques: Array<BanqueDto>;
    comptes: Array<CompteDto>;


    constructor( private proprietaireBanqueService: ProprietaireBanqueAdminService  , private banqueService: BanqueAdminService, private proprietaireService: ProprietaireAdminService, private compteService: CompteAdminService) {
        super(proprietaireBanqueService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProprietaire();
        this.loadBanque();
        this.loadCompte();
    }


    public initCol() {
        this.cols = [
            {field: 'proprietaire?.telephone', header: 'Proprietaire'},
            {field: 'banque?.libelle', header: 'Banque'},
            {field: 'compte?.numeroCompte', header: 'Compte'},
        ];
    }


    public async loadProprietaire(){
       this.proprietaireService.findAllOptimized().subscribe(proprietaires => this.proprietaires = proprietaires, error => console.log(error))
    }
    public async loadBanque(){
       this.banqueService.findAllOptimized().subscribe(banques => this.banques = banques, error => console.log(error))
    }
    public async loadCompte(){
       this.compteService.findAllOptimized().subscribe(comptes => this.comptes = comptes, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Proprietaire': e.proprietaire?.telephone ,
                'Banque': e.banque?.libelle ,
                'Compte': e.compte?.numeroCompte ,
            }
        });

        this.criteriaData = [{
        //'Proprietaire': this.criteria.proprietaire?.telephone ? this.criteria.proprietaire?.telephone : environment.emptyForExport ,
        //'Banque': this.criteria.banque?.libelle ? this.criteria.banque?.libelle : environment.emptyForExport ,
        //'Compte': this.criteria.compte?.numeroCompte ? this.criteria.compte?.numeroCompte : environment.emptyForExport ,
        }];
      }
}
