import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProduitDto} from './Produit.model';
import {EntreeProduitDto} from '../entree/EntreeProduit.model';

export class EntreeProduitItemDto extends BaseDto{

    public quantite: null | number;

    public description: string;

    public produit: ProduitDto ;
    public entreeProduit: EntreeProduitDto ;
    

    constructor() {
        super();

        this.quantite = null;
        this.description = '';
        this.produit = new ProduitDto() ;
        this.entreeProduit = new EntreeProduitDto() ;

        }

}
