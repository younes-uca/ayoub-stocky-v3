import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EtatAvoirAchatCriteria} from '../commun/EtatAvoirAchatCriteria.model';
import {AvoirAchatItemCriteria} from './AvoirAchatItemCriteria.model';
import {EntrepriseSocieteCriteria} from '../commun/EntrepriseSocieteCriteria.model';
import {FournisseurCriteria} from '../commun/FournisseurCriteria.model';
import {AchatCriteria} from './AchatCriteria.model';

export class AvoirAchatCriteria  extends BaseCriteria  {

    public id: number;
    public barCode: string;
    public barCodeLike: string;
    public codeAvoirAchat: string;
    public codeAvoirAchatLike: string;
    public numeroFactureAvoirFournisseur: string;
    public numeroFactureAvoirFournisseurLike: string;
    public dateFactureAvoirFournisseur: Date;
    public dateFactureAvoirFournisseurFrom: Date;
    public dateFactureAvoirFournisseurTo: Date;
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
  public fournisseur: FournisseurCriteria ;
  public fournisseurs: Array<FournisseurCriteria> ;
  public etatAvoirAchat: EtatAvoirAchatCriteria ;
  public etatAvoirAchats: Array<EtatAvoirAchatCriteria> ;
  public achat: AchatCriteria ;
  public achats: Array<AchatCriteria> ;
      public avoirAchatItems: Array<AvoirAchatItemCriteria>;

}
