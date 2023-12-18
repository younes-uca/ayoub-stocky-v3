import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class EtatVenteDto extends BaseDto{

    public libelle: string;

    

    constructor() {
        super();

        this.libelle = '';

        }

}
