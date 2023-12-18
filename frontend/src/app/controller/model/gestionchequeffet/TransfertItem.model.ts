import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DepotDto} from '../commun/Depot.model';
import {ProduitDto} from '../stock/Produit.model';
import {TransfertDto} from './Transfert.model';

export class TransfertItemDto extends BaseDto{

    public quantite: null | number;

    public depot: DepotDto ;
    public produit: ProduitDto ;
    public transfert: TransfertDto ;
    

    constructor() {
        super();

        this.quantite = null;
        this.depot = new DepotDto() ;
        this.produit = new ProduitDto() ;
        this.transfert = new TransfertDto() ;

        }

}
