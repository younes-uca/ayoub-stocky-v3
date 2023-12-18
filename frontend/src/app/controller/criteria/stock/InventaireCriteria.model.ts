import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {DepotCriteria} from '../commun/DepotCriteria.model';
import {InventaireItemCriteria} from './InventaireItemCriteria.model';
import {EntrepriseSocieteCriteria} from '../commun/EntrepriseSocieteCriteria.model';

export class InventaireCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateInventaire: Date;
    public dateInventaireFrom: Date;
    public dateInventaireTo: Date;
    public description: string;
    public descriptionLike: string;
  public entrepriseSociete: EntrepriseSocieteCriteria ;
  public entrepriseSocietes: Array<EntrepriseSocieteCriteria> ;
  public depot: DepotCriteria ;
  public depots: Array<DepotCriteria> ;
      public inventaireItems: Array<InventaireItemCriteria>;

}
