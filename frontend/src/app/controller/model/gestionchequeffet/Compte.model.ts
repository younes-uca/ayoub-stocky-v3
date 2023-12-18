import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {BanqueDto} from './Banque.model';
import {ProprietaireDto} from './Proprietaire.model';

export class CompteDto extends BaseDto{

    public numeroCompte: string;

    public solde: null | number;

    public banque: BanqueDto ;
    public proprietaire: ProprietaireDto ;
    

    constructor() {
        super();

        this.numeroCompte = '';
        this.solde = null;
        this.banque = new BanqueDto() ;
        this.proprietaire = new ProprietaireDto() ;

        }

}
