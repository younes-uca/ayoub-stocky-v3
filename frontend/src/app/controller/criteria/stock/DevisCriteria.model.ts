import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ClientCriteria} from '../commun/ClientCriteria.model';
import {DevisItemCriteria} from './DevisItemCriteria.model';

export class DevisCriteria  extends BaseCriteria  {

    public id: number;
    public numero: string;
    public numeroLike: string;
    public dateDevis: Date;
    public dateDevisFrom: Date;
    public dateDevisTo: Date;
     public montantHt: number;
     public montantHtMin: number;
     public montantHtMax: number;
     public montantTva: number;
     public montantTvaMin: number;
     public montantTvaMax: number;
     public montantTtc: number;
     public montantTtcMin: number;
     public montantTtcMax: number;
    public description: string;
    public descriptionLike: string;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
      public devisItems: Array<DevisItemCriteria>;

}
