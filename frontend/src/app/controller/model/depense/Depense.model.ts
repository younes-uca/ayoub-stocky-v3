import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DepenseDto extends BaseDto{

   public dateDepense: Date;

    public libelle: string;

    public montant: null | number;

    public description: string;

    

    constructor() {
        super();

        this.dateDepense = null;
        this.libelle = '';
        this.montant = null;
        this.description = '';

        }

}
