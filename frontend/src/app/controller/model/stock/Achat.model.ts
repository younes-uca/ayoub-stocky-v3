import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatAchatDto} from '../commun/EtatAchat.model';
import {AchatItemDto} from './AchatItem.model';
import {AvoirAchatDto} from './AvoirAchat.model';
import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';
import {FournisseurDto} from '../commun/Fournisseur.model';

export class AchatDto extends BaseDto{

   public dateFacture: Date;

    public referenceFacture: string;

    public montantHt: null | number;

    public montantTva: null | number;

    public montantTtc: null | number;

    public description: string;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public fournisseur: FournisseurDto ;
    public etatAchat: EtatAchatDto ;
     public achatItems: Array<AchatItemDto>;
     public avoirAchats: Array<AvoirAchatDto>;
    

    constructor() {
        super();

        this.dateFacture = null;
        this.referenceFacture = '';
        this.montantHt = null;
        this.montantTva = null;
        this.montantTtc = null;
        this.description = '';
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.fournisseur = new FournisseurDto() ;
        this.etatAchat = new EtatAchatDto() ;
        this.achatItems = new Array<AchatItemDto>();
        this.avoirAchats = new Array<AvoirAchatDto>();

        }

}
