import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ClientCriteria} from '../commun/ClientCriteria.model';
import {CommandeItemCriteria} from './CommandeItemCriteria.model';
import {EtatCommandeCriteria} from '../commun/EtatCommandeCriteria.model';

export class CommandeCriteria  extends BaseCriteria  {

    public id: number;
    public barCode: string;
    public barCodeLike: string;
    public numeroCommande: string;
    public numeroCommandeLike: string;
    public dateCommande: Date;
    public dateCommandeFrom: Date;
    public dateCommandeTo: Date;
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
  public etatCommande: EtatCommandeCriteria ;
  public etatCommandes: Array<EtatCommandeCriteria> ;
      public commandeItems: Array<CommandeItemCriteria>;

}
