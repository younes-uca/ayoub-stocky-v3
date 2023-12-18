import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class EtatTransactionDto extends BaseDto{

    public libelle: string;

    

    constructor() {
        super();

        this.libelle = '';

        }

}
