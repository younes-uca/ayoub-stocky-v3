import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SortieProduitDto} from '../entree/SortieProduit.model';
import {ProduitDto} from './Produit.model';

export class SortieProduitItemDto extends BaseDto{

    public quantite: null | number;

    public description: string;

    public produit: ProduitDto ;
    public sortieProduit: SortieProduitDto ;
    

    constructor() {
        super();

        this.quantite = null;
        this.description = '';
        this.produit = new ProduitDto() ;
        this.sortieProduit = new SortieProduitDto() ;

        }

}
