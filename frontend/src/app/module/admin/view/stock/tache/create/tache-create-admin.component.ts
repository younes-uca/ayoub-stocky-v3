import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TacheAdminService} from 'src/app/controller/service/admin/stock/TacheAdmin.service';
import {TacheDto} from 'src/app/controller/model/stock/Tache.model';
import {TacheCriteria} from 'src/app/controller/criteria/stock/TacheCriteria.model';
import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
@Component({
  selector: 'app-tache-create-admin',
  templateUrl: './tache-create-admin.component.html'
})
export class TacheCreateAdminComponent extends AbstractCreateController<TacheDto, TacheCriteria, TacheAdminService>  implements OnInit {



    private _validCollaborateurNom = true;
    private _validCollaborateurPrenom = true;
    private _validCollaborateurTelephone = true;

    constructor( private tacheService: TacheAdminService , private collaborateurService: CollaborateurAdminService) {
        super(tacheService);
    }

    ngOnInit(): void {
        this.collaborateur = new CollaborateurDto();
        this.collaborateurService.findAll().subscribe((data) => this.collaborateurs = data);
    }





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }




    get collaborateur(): CollaborateurDto {
        return this.collaborateurService.item;
    }
    set collaborateur(value: CollaborateurDto) {
        this.collaborateurService.item = value;
    }
    get collaborateurs(): Array<CollaborateurDto> {
        return this.collaborateurService.items;
    }
    set collaborateurs(value: Array<CollaborateurDto>) {
        this.collaborateurService.items = value;
    }
    get createCollaborateurDialog(): boolean {
       return this.collaborateurService.createDialog;
    }
    set createCollaborateurDialog(value: boolean) {
        this.collaborateurService.createDialog= value;
    }




    get validCollaborateurNom(): boolean {
        return this._validCollaborateurNom;
    }
    set validCollaborateurNom(value: boolean) {
        this._validCollaborateurNom = value;
    }
    get validCollaborateurPrenom(): boolean {
        return this._validCollaborateurPrenom;
    }
    set validCollaborateurPrenom(value: boolean) {
        this._validCollaborateurPrenom = value;
    }
    get validCollaborateurTelephone(): boolean {
        return this._validCollaborateurTelephone;
    }
    set validCollaborateurTelephone(value: boolean) {
        this._validCollaborateurTelephone = value;
    }


}
