import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {FournisseurDto} from '../commun/Fournisseur.model';

export class ChequeEffetDto extends BaseDto{

    public numero: string;

   public dateEmission: Date;

    public montant: null | number;

    public fournisseur: FournisseurDto ;
    

    constructor() {
        super();

        this.numero = '';
        this.dateEmission = null;
        this.montant = null;
        this.fournisseur = new FournisseurDto() ;

        }

}
