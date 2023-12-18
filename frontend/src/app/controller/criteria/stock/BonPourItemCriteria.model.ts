import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {BonPourCriteria} from './BonPourCriteria.model';
import {TaxeCriteria} from './TaxeCriteria.model';

export class BonPourItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
     public prixUnitaireHt: number;
     public prixUnitaireHtMin: number;
     public prixUnitaireHtMax: number;
     public prixUnitaireTtc: number;
     public prixUnitaireTtcMin: number;
     public prixUnitaireTtcMax: number;
     public remise: number;
     public remiseMin: number;
     public remiseMax: number;
     public montantHt: number;
     public montantHtMin: number;
     public montantHtMax: number;
     public montantTtc: number;
     public montantTtcMin: number;
     public montantTtcMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public taxe: TaxeCriteria ;
  public taxes: Array<TaxeCriteria> ;
  public bonPour: BonPourCriteria ;
  public bonPours: Array<BonPourCriteria> ;

}
