import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ModeReglementCriteria} from '../gestionchequeffet/ModeReglementCriteria.model';
import {VenteCriteria} from '../stock/VenteCriteria.model';

export class ReglementVenteCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateReglement: Date;
    public dateReglementFrom: Date;
    public dateReglementTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
    public description: string;
    public descriptionLike: string;
  public vente: VenteCriteria ;
  public ventes: Array<VenteCriteria> ;
  public modeReglement: ModeReglementCriteria ;
  public modeReglements: Array<ModeReglementCriteria> ;

}
