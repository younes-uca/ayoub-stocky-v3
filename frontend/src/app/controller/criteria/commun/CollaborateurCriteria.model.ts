import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class CollaborateurCriteria  extends BaseCriteria  {

    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;
    public telephone: string;
    public telephoneLike: string;
    public adresse: string;
    public adresseLike: string;
     public creance: number;
     public creanceMin: number;
     public creanceMax: number;
    public description: string;
    public descriptionLike: string;
    public credentialsNonExpired: null | boolean;
    public enabled: null | boolean;
    public accountNonExpired: null | boolean;
    public accountNonLocked: null | boolean;
    public passwordChanged: null | boolean;
    public username: string;
    public usernameLike: string;
    public password: string;
    public passwordLike: string;

}
