import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {DepotCriteria} from '../commun/DepotCriteria.model';
import {ProduitCriteria} from '../stock/ProduitCriteria.model';
import {TransfertCriteria} from './TransfertCriteria.model';

export class TransfertItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
  public depot: DepotCriteria ;
  public depots: Array<DepotCriteria> ;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public transfert: TransfertCriteria ;
  public transferts: Array<TransfertCriteria> ;

}
