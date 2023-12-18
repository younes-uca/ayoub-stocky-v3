import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class TaxeDto extends BaseDto{

    public libelle: string;

    public montant: null | number;

    

    constructor() {
        super();

        this.libelle = '';
        this.montant = null;

        }

}
