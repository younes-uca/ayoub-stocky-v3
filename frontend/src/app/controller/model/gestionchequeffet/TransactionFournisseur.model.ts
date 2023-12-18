import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatTransactionDto} from './EtatTransaction.model';
import {TypeTransactionDto} from './TypeTransaction.model';
import {CompteDto} from './Compte.model';
import {TypeInstrumentDto} from './TypeInstrument.model';

export class TransactionFournisseurDto extends BaseDto{

   public dateEmission: Date;

    public montant: null | number;

   public dateTransaction: Date;

   public dateEncaissement: Date;

    public pathPhoto: string;

    public description: string;

    public typeInstrument: TypeInstrumentDto ;
    public typeTransaction: TypeTransactionDto ;
    public compte: CompteDto ;
    public etatTransaction: EtatTransactionDto ;
    

    constructor() {
        super();

        this.dateEmission = null;
        this.montant = null;
        this.dateTransaction = null;
        this.dateEncaissement = null;
        this.pathPhoto = '';
        this.description = '';
        this.typeInstrument = new TypeInstrumentDto() ;
        this.typeTransaction = new TypeTransactionDto() ;
        this.compte = new CompteDto() ;
        this.etatTransaction = new EtatTransactionDto() ;

        }

}
