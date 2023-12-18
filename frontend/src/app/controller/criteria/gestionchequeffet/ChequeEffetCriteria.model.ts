import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {FournisseurCriteria} from '../commun/FournisseurCriteria.model';

export class ChequeEffetCriteria  extends BaseCriteria  {

    public id: number;
    public numero: string;
    public numeroLike: string;
    public dateEmission: Date;
    public dateEmissionFrom: Date;
    public dateEmissionTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
  public fournisseur: FournisseurCriteria ;
  public fournisseurs: Array<FournisseurCriteria> ;

}
