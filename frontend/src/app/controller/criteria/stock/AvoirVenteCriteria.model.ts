import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ClientCriteria} from '../commun/ClientCriteria.model';
import {AvoirVenteItemCriteria} from './AvoirVenteItemCriteria.model';
import {EtatAvoirVenteCriteria} from '../commun/EtatAvoirVenteCriteria.model';
import {EntrepriseSocieteCriteria} from '../commun/EntrepriseSocieteCriteria.model';
import {VenteCriteria} from './VenteCriteria.model';

export class AvoirVenteCriteria  extends BaseCriteria  {

    public id: number;
    public barCode: string;
    public barCodeLike: string;
    public codeAvoirVente: string;
    public codeAvoirVenteLike: string;
    public numeroFactureAvoirVente: string;
    public numeroFactureAvoirVenteLike: string;
    public dateFactureAvoirVente: Date;
    public dateFactureAvoirVenteFrom: Date;
    public dateFactureAvoirVenteTo: Date;
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
  public etatAvoirVente: EtatAvoirVenteCriteria ;
  public etatAvoirVentes: Array<EtatAvoirVenteCriteria> ;
  public vente: VenteCriteria ;
  public ventes: Array<VenteCriteria> ;
      public avoirVenteItems: Array<AvoirVenteItemCriteria>;

}
