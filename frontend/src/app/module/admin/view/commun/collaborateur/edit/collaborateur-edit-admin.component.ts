import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CollaborateurAdminService} from 'src/app/controller/service/admin/commun/CollaborateurAdmin.service';
import {CollaborateurDto} from 'src/app/controller/model/commun/Collaborateur.model';
import {CollaborateurCriteria} from 'src/app/controller/criteria/commun/CollaborateurCriteria.model';



@Component({
  selector: 'app-collaborateur-edit-admin',
  templateUrl: './collaborateur-edit-admin.component.html'
})
export class CollaborateurEditAdminComponent extends AbstractEditController<CollaborateurDto, CollaborateurCriteria, CollaborateurAdminService>   implements OnInit {


    private _validCollaborateurNom = true;
    private _validCollaborateurPrenom = true;
    private _validCollaborateurTelephone = true;




    constructor( private collaborateurService: CollaborateurAdminService ) {
        super(collaborateurService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validCollaborateurNom = value;
        this.validCollaborateurPrenom = value;
        this.validCollaborateurTelephone = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCollaborateurNom();
        this.validateCollaborateurPrenom();
        this.validateCollaborateurTelephone();
    }
    public validateCollaborateurNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
            this.errorMessages.push('Nom non valide');
            this.validCollaborateurNom = false;
        } else {
            this.validCollaborateurNom = true;
        }
    }
    public validateCollaborateurPrenom(){
        if (this.stringUtilService.isEmpty(this.item.prenom)) {
            this.errorMessages.push('Prenom non valide');
            this.validCollaborateurPrenom = false;
        } else {
            this.validCollaborateurPrenom = true;
        }
    }
    public validateCollaborateurTelephone(){
        if (this.stringUtilService.isEmpty(this.item.telephone)) {
            this.errorMessages.push('Telephone non valide');
            this.validCollaborateurTelephone = false;
        } else {
            this.validCollaborateurTelephone = true;
        }
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
