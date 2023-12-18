import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {SortieProduitCriteria} from '../entree/SortieProduitCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';

export class SortieProduitItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
    public description: string;
    public descriptionLike: string;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public sortieProduit: SortieProduitCriteria ;
  public sortieProduits: Array<SortieProduitCriteria> ;

}
