import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ClientDto} from '../commun/Client.model';
import {BonPourItemDto} from './BonPourItem.model';

export class BonPourDto extends BaseDto{

    public numero: string;

   public dateBonPour: Date;

    public montantHt: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public client: ClientDto ;
     public bonPourItems: Array<BonPourItemDto>;
    

    constructor() {
        super();

        this.numero = '';
        this.dateBonPour = null;
        this.montantHt = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.client = new ClientDto() ;
        this.bonPourItems = new Array<BonPourItemDto>();

        }

}
