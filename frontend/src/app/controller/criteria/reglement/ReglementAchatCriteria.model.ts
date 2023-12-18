import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {AchatCriteria} from '../stock/AchatCriteria.model';
import {ModeReglementCriteria} from '../gestionchequeffet/ModeReglementCriteria.model';

export class ReglementAchatCriteria  extends BaseCriteria  {

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
  public achat: AchatCriteria ;
  public achats: Array<AchatCriteria> ;
  public modeReglement: ModeReglementCriteria ;
  public modeReglements: Array<ModeReglementCriteria> ;

}
