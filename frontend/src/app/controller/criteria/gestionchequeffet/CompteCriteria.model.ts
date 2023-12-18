import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {BanqueCriteria} from './BanqueCriteria.model';
import {ProprietaireCriteria} from './ProprietaireCriteria.model';

export class CompteCriteria  extends BaseCriteria  {

    public id: number;
    public numeroCompte: string;
    public numeroCompteLike: string;
     public solde: number;
     public soldeMin: number;
     public soldeMax: number;
  public banque: BanqueCriteria ;
  public banques: Array<BanqueCriteria> ;
  public proprietaire: ProprietaireCriteria ;
  public proprietaires: Array<ProprietaireCriteria> ;

}
