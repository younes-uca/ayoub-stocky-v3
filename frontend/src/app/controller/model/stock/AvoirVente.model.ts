import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ClientDto} from '../commun/Client.model';
import {AvoirVenteItemDto} from './AvoirVenteItem.model';
import {EtatAvoirVenteDto} from '../commun/EtatAvoirVente.model';
import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';
import {VenteDto} from './Vente.model';

export class AvoirVenteDto extends BaseDto{

    public barCode: string;

    public codeAvoirVente: string;

    public numeroFactureAvoirVente: string;

   public dateFactureAvoirVente: Date;

    public montantHt: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public client: ClientDto ;
    public etatAvoirVente: EtatAvoirVenteDto ;
    public vente: VenteDto ;
     public avoirVenteItems: Array<AvoirVenteItemDto>;
    

    constructor() {
        super();

        this.barCode = '';
        this.codeAvoirVente = '';
        this.numeroFactureAvoirVente = '';
        this.dateFactureAvoirVente = null;
        this.montantHt = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.client = new ClientDto() ;
        this.etatAvoirVente = new EtatAvoirVenteDto() ;
        this.vente = new VenteDto() ;
        this.avoirVenteItems = new Array<AvoirVenteItemDto>();

        }

}
