import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EtatTransactionCriteria} from './EtatTransactionCriteria.model';
import {TypeTransactionCriteria} from './TypeTransactionCriteria.model';
import {CompteCriteria} from './CompteCriteria.model';
import {TypeInstrumentCriteria} from './TypeInstrumentCriteria.model';

export class TransactionFournisseurCriteria  extends BaseCriteria  {

    public id: number;
    public dateEmission: Date;
    public dateEmissionFrom: Date;
    public dateEmissionTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
    public dateTransaction: Date;
    public dateTransactionFrom: Date;
    public dateTransactionTo: Date;
    public dateEncaissement: Date;
    public dateEncaissementFrom: Date;
    public dateEncaissementTo: Date;
    public pathPhoto: string;
    public pathPhotoLike: string;
    public description: string;
    public descriptionLike: string;
  public typeInstrument: TypeInstrumentCriteria ;
  public typeInstruments: Array<TypeInstrumentCriteria> ;
  public typeTransaction: TypeTransactionCriteria ;
  public typeTransactions: Array<TypeTransactionCriteria> ;
  public compte: CompteCriteria ;
  public comptes: Array<CompteCriteria> ;
  public etatTransaction: EtatTransactionCriteria ;
  public etatTransactions: Array<EtatTransactionCriteria> ;

}
