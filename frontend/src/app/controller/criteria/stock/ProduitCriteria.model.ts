import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {MarqueCriteria} from '../commun/MarqueCriteria.model';
import {CategorieCriteria} from '../commun/CategorieCriteria.model';
import {EntrepriseSocieteCriteria} from '../commun/EntrepriseSocieteCriteria.model';
import {UniteMesureCriteria} from '../commun/UniteMesureCriteria.model';
import {StockCriteria} from './StockCriteria.model';

export class ProduitCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public barCode: string;
    public barCodeLike: string;
    public designation: string;
    public designationLike: string;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
     public prixAchatMoyen: number;
     public prixAchatMoyenMin: number;
     public prixAchatMoyenMax: number;
     public prixVente: number;
     public prixVenteMin: number;
     public prixVenteMax: number;
    public pathPhoto: string;
    public pathPhotoLike: string;
     public seuilAlerte: number;
     public seuilAlerteMin: number;
     public seuilAlerteMax: number;
    public description: string;
    public descriptionLike: string;
  public entrepriseSociete: EntrepriseSocieteCriteria ;
  public entrepriseSocietes: Array<EntrepriseSocieteCriteria> ;
  public categorie: CategorieCriteria ;
  public categories: Array<CategorieCriteria> ;
  public marque: MarqueCriteria ;
  public marques: Array<MarqueCriteria> ;
  public uniteMesure: UniteMesureCriteria ;
  public uniteMesures: Array<UniteMesureCriteria> ;
      public stocks: Array<StockCriteria>;

}
