import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class EntrepriseSocieteDto extends BaseDto{

    public nom: string;

    public ice: string;

    public capital: null | number;

    

    constructor() {
        super();

        this.nom = '';
        this.ice = '';
        this.capital = null;

        }

}
