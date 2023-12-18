import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AvoirAchatDto} from '../stock/AvoirAchat.model';
import {AchatDto} from '../stock/Achat.model';
import {ModeReglementDto} from '../gestionchequeffet/ModeReglement.model';

export class ReglementAvoirAchatDto extends BaseDto{

    public reference: string;

   public dateReglement: Date;

    public montant: null | number;

    public description: string;

    public achat: AchatDto ;
    public modeReglement: ModeReglementDto ;
    public avoirAchat: AvoirAchatDto ;
    

    constructor() {
        super();

        this.reference = '';
        this.dateReglement = null;
        this.montant = null;
        this.description = '';
        this.achat = new AchatDto() ;
        this.modeReglement = new ModeReglementDto() ;
        this.avoirAchat = new AvoirAchatDto() ;

        }

}
