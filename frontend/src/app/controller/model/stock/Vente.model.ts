import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatVenteDto} from '../commun/EtatVente.model';
import {ClientDto} from '../commun/Client.model';
import {VenteItemDto} from './VenteItem.model';
import {AvoirVenteDto} from './AvoirVente.model';
import {ReglementVenteDto} from '../reglement/ReglementVente.model';
import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';

export class VenteDto extends BaseDto{

    public barCode: string;

    public codeVente: string;

   public dateFacture: Date;

    public numeroFacture: string;

    public montantHt: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public client: ClientDto ;
    public etatVente: EtatVenteDto ;
     public venteItems: Array<VenteItemDto>;
     public avoirVentes: Array<AvoirVenteDto>;
     public reglementVentes: Array<ReglementVenteDto>;
    

    constructor() {
        super();

        this.barCode = '';
        this.codeVente = '';
        this.dateFacture = null;
        this.numeroFacture = '';
        this.montantHt = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.client = new ClientDto() ;
        this.etatVente = new EtatVenteDto() ;
        this.venteItems = new Array<VenteItemDto>();
        this.avoirVentes = new Array<AvoirVenteDto>();
        this.reglementVentes = new Array<ReglementVenteDto>();

        }

}
