import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class FournisseurDto extends BaseDto{

    public ice: string;

    public nom: string;

    public telephone: string;

    public adresse: string;

    public creance: null | number;

    public description: string;

   public credentialsNonExpired: null | boolean;

   public enabled: null | boolean;

   public accountNonExpired: null | boolean;

   public accountNonLocked: null | boolean;

   public passwordChanged: null | boolean;

    public username: string;

    public password: string;

    

    constructor() {
        super();

        this.ice = '';
        this.nom = '';
        this.telephone = '';
        this.adresse = '';
        this.creance = null;
        this.description = '';
        this.credentialsNonExpired = null;
        this.enabled = null;
        this.accountNonExpired = null;
        this.accountNonLocked = null;
        this.passwordChanged = null;
        this.username = '';
        this.password = '';

        }

}
