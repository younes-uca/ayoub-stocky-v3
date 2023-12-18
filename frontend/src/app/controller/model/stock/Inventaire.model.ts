import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DepotDto} from '../commun/Depot.model';
import {InventaireItemDto} from './InventaireItem.model';
import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';

export class InventaireDto extends BaseDto{

    public reference: string;

   public dateInventaire: Date;

    public description: string;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public depot: DepotDto ;
     public inventaireItems: Array<InventaireItemDto>;
    

    constructor() {
        super();

        this.reference = '';
        this.dateInventaire = null;
        this.description = '';
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.depot = new DepotDto() ;
        this.inventaireItems = new Array<InventaireItemDto>();

        }

}
