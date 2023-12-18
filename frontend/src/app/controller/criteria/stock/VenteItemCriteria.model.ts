import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {DepotCriteria} from '../commun/DepotCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {VenteCriteria} from './VenteCriteria.model';
import {TaxeCriteria} from './TaxeCriteria.model';

export class VenteItemCriteria  extends BaseCriteria  {

    public id: number;
    public barCode: string;
    public barCodeLike: string;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
     public quantiteAvoir: number;
     public quantiteAvoirMin: number;
     public quantiteAvoirMax: number;
     public quantiteVendue: number;
     public quantiteVendueMin: number;
     public quantiteVendueMax: number;
     public prixUnitaireHt: number;
     public prixUnitaireHtMin: number;
     public prixUnitaireHtMax: number;
     public prixUnitaireTtc: number;
     public prixUnitaireTtcMin: number;
     public prixUnitaireTtcMax: number;
     public remise: number;
     public remiseMin: number;
     public remiseMax: number;
     public montantHt: number;
     public montantHtMin: number;
     public montantHtMax: number;
     public montantTtc: number;
     public montantTtcMin: number;
     public montantTtcMax: number;
  public depot: DepotCriteria ;
  public depots: Array<DepotCriteria> ;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public taxe: TaxeCriteria ;
  public taxes: Array<TaxeCriteria> ;
  public vente: VenteCriteria ;
  public ventes: Array<VenteCriteria> ;

}
