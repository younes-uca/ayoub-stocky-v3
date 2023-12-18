import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DepotDto} from '../commun/Depot.model';
import {FournisseurDto} from '../commun/Fournisseur.model';
import {EntreeProduitItemDto} from '../stock/EntreeProduitItem.model';

export class EntreeProduitDto extends BaseDto{

    public reference: string;

   public dateEntreeProduit: Date;

    public description: string;

    public fournisseur: FournisseurDto ;
    public depot: DepotDto ;
     public entreeProduitItems: Array<EntreeProduitItemDto>;
    

    constructor() {
        super();

        this.reference = '';
        this.dateEntreeProduit = null;
        this.description = '';
        this.fournisseur = new FournisseurDto() ;
        this.depot = new DepotDto() ;
        this.entreeProduitItems = new Array<EntreeProduitItemDto>();

        }

}
