import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class DepenseCriteria  extends BaseCriteria  {

    public id: number;
    public dateDepense: Date;
    public dateDepenseFrom: Date;
    public dateDepenseTo: Date;
    public libelle: string;
    public libelleLike: string;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
    public description: string;
    public descriptionLike: string;

}
