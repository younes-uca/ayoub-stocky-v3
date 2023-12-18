import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class TaxeCriteria  extends BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
     public montant: number;
     public montantMin: number;
     public montantMax: number;

}
