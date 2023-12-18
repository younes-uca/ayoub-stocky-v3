import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AchatDto} from '../stock/Achat.model';
import {ModeReglementDto} from '../gestionchequeffet/ModeReglement.model';

export class ReglementAchatDto extends BaseDto{

    public reference: string;

   public dateReglement: Date;

    public montant: null | number;

    public description: string;

    public achat: AchatDto ;
    public modeReglement: ModeReglementDto ;
    

    constructor() {
        super();

        this.reference = '';
        this.dateReglement = null;
        this.montant = null;
        this.description = '';
        this.achat = new AchatDto() ;
        this.modeReglement = new ModeReglementDto() ;

        }

}
