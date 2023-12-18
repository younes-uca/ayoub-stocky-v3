import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EtatVenteCriteria} from '../commun/EtatVenteCriteria.model';
import {ClientCriteria} from '../commun/ClientCriteria.model';
import {VenteItemCriteria} from './VenteItemCriteria.model';
import {AvoirVenteCriteria} from './AvoirVenteCriteria.model';
import {ReglementVenteCriteria} from '../reglement/ReglementVenteCriteria.model';
import {EntrepriseSocieteCriteria} from '../commun/EntrepriseSocieteCriteria.model';

export class VenteCriteria  extends BaseCriteria  {

    public id: number;
    public barCode: string;
    public barCodeLike: string;
    public codeVente: string;
    public codeVenteLike: string;
    public dateFacture: Date;
    public dateFactureFrom: Date;
    public dateFactureTo: Date;
    public numeroFacture: string;
    public numeroFactureLike: string;
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
  public entrepriseSociete: EntrepriseSocieteCriteria ;
  public entrepriseSocietes: Array<EntrepriseSocieteCriteria> ;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public etatVente: EtatVenteCriteria ;
  public etatVentes: Array<EtatVenteCriteria> ;
      public venteItems: Array<VenteItemCriteria>;
      public avoirVentes: Array<AvoirVenteCriteria>;
      public reglementVentes: Array<ReglementVenteCriteria>;

}
