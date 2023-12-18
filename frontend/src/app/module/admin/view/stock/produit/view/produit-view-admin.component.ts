import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/stock/ProduitCriteria.model';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {MarqueDto} from 'src/app/controller/model/commun/Marque.model';
import {MarqueAdminService} from 'src/app/controller/service/admin/commun/MarqueAdmin.service';
import {CategorieDto} from 'src/app/controller/model/commun/Categorie.model';
import {CategorieAdminService} from 'src/app/controller/service/admin/commun/CategorieAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {UniteMesureDto} from 'src/app/controller/model/commun/UniteMesure.model';
import {UniteMesureAdminService} from 'src/app/controller/service/admin/commun/UniteMesureAdmin.service';
import {StockDto} from 'src/app/controller/model/stock/Stock.model';
import {StockAdminService} from 'src/app/controller/service/admin/stock/StockAdmin.service';
@Component({
  selector: 'app-produit-view-admin',
  templateUrl: './produit-view-admin.component.html'
})
export class ProduitViewAdminComponent extends AbstractViewController<ProduitDto, ProduitCriteria, ProduitAdminService> implements OnInit {

    stocks = new StockDto();
    stockss: Array<StockDto> = [];

    constructor(private produitService: ProduitAdminService, private depotService: DepotAdminService, private marqueService: MarqueAdminService, private categorieService: CategorieAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private uniteMesureService: UniteMesureAdminService, private stockService: StockAdminService){
        super(produitService);
    }

    ngOnInit(): void {
    }


    get depot(): DepotDto {
       return this.depotService.item;
    }
    set depot(value: DepotDto) {
        this.depotService.item = value;
    }
    get depots(): Array<DepotDto> {
       return this.depotService.items;
    }
    set depots(value: Array<DepotDto>) {
        this.depotService.items = value;
    }
    get marque(): MarqueDto {
       return this.marqueService.item;
    }
    set marque(value: MarqueDto) {
        this.marqueService.item = value;
    }
    get marques(): Array<MarqueDto> {
       return this.marqueService.items;
    }
    set marques(value: Array<MarqueDto>) {
        this.marqueService.items = value;
    }
    get uniteMesure(): UniteMesureDto {
       return this.uniteMesureService.item;
    }
    set uniteMesure(value: UniteMesureDto) {
        this.uniteMesureService.item = value;
    }
    get uniteMesures(): Array<UniteMesureDto> {
       return this.uniteMesureService.items;
    }
    set uniteMesures(value: Array<UniteMesureDto>) {
        this.uniteMesureService.items = value;
    }
    get entrepriseSociete(): EntrepriseSocieteDto {
       return this.entrepriseSocieteService.item;
    }
    set entrepriseSociete(value: EntrepriseSocieteDto) {
        this.entrepriseSocieteService.item = value;
    }
    get entrepriseSocietes(): Array<EntrepriseSocieteDto> {
       return this.entrepriseSocieteService.items;
    }
    set entrepriseSocietes(value: Array<EntrepriseSocieteDto>) {
        this.entrepriseSocieteService.items = value;
    }
    get categorie(): CategorieDto {
       return this.categorieService.item;
    }
    set categorie(value: CategorieDto) {
        this.categorieService.item = value;
    }
    get categories(): Array<CategorieDto> {
       return this.categorieService.items;
    }
    set categories(value: Array<CategorieDto>) {
        this.categorieService.items = value;
    }


}
