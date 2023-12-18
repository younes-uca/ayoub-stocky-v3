import {Component, OnInit} from '@angular/core';
import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteCriteria} from 'src/app/controller/criteria/gestionchequeffet/CompteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {BanqueDto} from 'src/app/controller/model/gestionchequeffet/Banque.model';
import {BanqueAdminService} from 'src/app/controller/service/admin/gestionchequeffet/BanqueAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';


@Component({
  selector: 'app-compte-list-admin',
  templateUrl: './compte-list-admin.component.html'
})
export class CompteListAdminComponent extends AbstractListController<CompteDto, CompteCriteria, CompteAdminService>  implements OnInit {

    fileName = 'Compte';

    banques: Array<BanqueDto>;
    proprietaires: Array<ProprietaireDto>;


    constructor( private compteService: CompteAdminService  , private banqueService: BanqueAdminService, private proprietaireService: ProprietaireAdminService) {
        super(compteService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadBanque();
        this.loadProprietaire();
    }


    public initCol() {
        this.cols = [
            {field: 'numeroCompte', header: 'Numero compte'},
            {field: 'banque?.libelle', header: 'Banque'},
            {field: 'proprietaire?.telephone', header: 'Proprietaire'},
            {field: 'solde', header: 'Solde'},
        ];
    }


    public async loadBanque(){
       this.banqueService.findAllOptimized().subscribe(banques => this.banques = banques, error => console.log(error))
    }
    public async loadProprietaire(){
       this.proprietaireService.findAllOptimized().subscribe(proprietaires => this.proprietaires = proprietaires, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Numero compte': e.numeroCompte ,
                'Banque': e.banque?.libelle ,
                'Proprietaire': e.proprietaire?.telephone ,
                 'Solde': e.solde ,
            }
        });

        this.criteriaData = [{
            'Numero compte': this.criteria.numeroCompte ? this.criteria.numeroCompte : environment.emptyForExport ,
        //'Banque': this.criteria.banque?.libelle ? this.criteria.banque?.libelle : environment.emptyForExport ,
        //'Proprietaire': this.criteria.proprietaire?.telephone ? this.criteria.proprietaire?.telephone : environment.emptyForExport ,
            'Solde Min': this.criteria.soldeMin ? this.criteria.soldeMin : environment.emptyForExport ,
            'Solde Max': this.criteria.soldeMax ? this.criteria.soldeMax : environment.emptyForExport ,
        }];
      }
}
