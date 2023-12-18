import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TransfertItemDto} from './TransfertItem.model';
import {RaisonDto} from '../Transfert/Raison.model';

export class TransfertDto extends BaseDto{

    public reference: string;

   public dateTransfert: Date;

    public description: string;

    public raison: RaisonDto ;
     public transfertItems: Array<TransfertItemDto>;
    

    constructor() {
        super();

        this.reference = '';
        this.dateTransfert = null;
        this.description = '';
        this.raison = new RaisonDto() ;
        this.transfertItems = new Array<TransfertItemDto>();

        }

}
