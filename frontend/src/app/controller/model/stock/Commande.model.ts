import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ClientDto} from '../commun/Client.model';
import {CommandeItemDto} from './CommandeItem.model';
import {EtatCommandeDto} from '../commun/EtatCommande.model';

export class CommandeDto extends BaseDto{

    public barCode: string;

    public numeroCommande: string;

   public dateCommande: Date;

    public montantHt: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public client: ClientDto ;
    public etatCommande: EtatCommandeDto ;
     public commandeItems: Array<CommandeItemDto>;
    

    constructor() {
        super();

        this.barCode = '';
        this.numeroCommande = '';
        this.dateCommande = null;
        this.montantHt = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.client = new ClientDto() ;
        this.etatCommande = new EtatCommandeDto() ;
        this.commandeItems = new Array<CommandeItemDto>();

        }

}
