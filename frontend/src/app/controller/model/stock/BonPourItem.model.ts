import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProduitDto} from './Produit.model';
import {BonPourDto} from './BonPour.model';
import {TaxeDto} from './Taxe.model';

export class BonPourItemDto extends BaseDto{

    public quantite: null | number;

    public prixUnitaireHt: null | number;

    public prixUnitaireTtc: null | number;

    public remise: null | number;

    public montantHt: null | number;

    public montantTtc: null | number;

    public produit: ProduitDto ;
    public taxe: TaxeDto ;
    public bonPour: BonPourDto ;
    

    constructor() {
        super();

        this.quantite = null;
        this.prixUnitaireHt = null;
        this.prixUnitaireTtc = null;
        this.remise = null;
        this.montantHt = null;
        this.montantTtc = null;
        this.produit = new ProduitDto() ;
        this.taxe = new TaxeDto() ;
        this.bonPour = new BonPourDto() ;

        }

}
