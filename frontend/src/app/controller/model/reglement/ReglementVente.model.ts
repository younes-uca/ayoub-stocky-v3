import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ModeReglementDto} from '../gestionchequeffet/ModeReglement.model';
import {VenteDto} from '../stock/Vente.model';

export class ReglementVenteDto extends BaseDto{

    public reference: string;

   public dateReglement: Date;

    public montant: null | number;

    public description: string;

    public vente: VenteDto ;
    public modeReglement: ModeReglementDto ;
    

    constructor() {
        super();

        this.reference = '';
        this.dateReglement = null;
        this.montant = null;
        this.description = '';
        this.vente = new VenteDto() ;
        this.modeReglement = new ModeReglementDto() ;

        }

}
