import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AvoirVenteDto} from '../stock/AvoirVente.model';
import {ModeReglementDto} from '../gestionchequeffet/ModeReglement.model';
import {VenteDto} from '../stock/Vente.model';

export class ReglementAvoirVenteDto extends BaseDto{

    public reference: string;

   public dateReglement: Date;

    public montant: null | number;

    public description: string;

    public vente: VenteDto ;
    public modeReglement: ModeReglementDto ;
    public avoirVente: AvoirVenteDto ;
    

    constructor() {
        super();

        this.reference = '';
        this.dateReglement = null;
        this.montant = null;
        this.description = '';
        this.vente = new VenteDto() ;
        this.modeReglement = new ModeReglementDto() ;
        this.avoirVente = new AvoirVenteDto() ;

        }

}
