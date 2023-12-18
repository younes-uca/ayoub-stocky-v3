import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class EntrepriseSocieteCriteria  extends BaseCriteria  {

    public id: number;
    public nom: string;
    public nomLike: string;
    public ice: string;
    public iceLike: string;
     public capital: number;
     public capitalMin: number;
     public capitalMax: number;

}
