import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {TransfertItemCriteria} from './TransfertItemCriteria.model';
import {RaisonCriteria} from '../Transfert/RaisonCriteria.model';

export class TransfertCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateTransfert: Date;
    public dateTransfertFrom: Date;
    public dateTransfertTo: Date;
    public description: string;
    public descriptionLike: string;
  public raison: RaisonCriteria ;
  public raisons: Array<RaisonCriteria> ;
      public transfertItems: Array<TransfertItemCriteria>;

}
