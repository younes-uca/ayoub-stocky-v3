import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {InventaireCriteria} from './InventaireCriteria.model';

export class InventaireItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantiteEstime: number;
     public quantiteEstimeMin: number;
     public quantiteEstimeMax: number;
     public quantiteReelle: number;
     public quantiteReelleMin: number;
     public quantiteReelleMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public inventaire: InventaireCriteria ;
  public inventaires: Array<InventaireCriteria> ;

}
