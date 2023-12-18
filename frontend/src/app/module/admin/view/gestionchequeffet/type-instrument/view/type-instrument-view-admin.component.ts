import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentCriteria} from 'src/app/controller/criteria/gestionchequeffet/TypeInstrumentCriteria.model';

@Component({
  selector: 'app-type-instrument-view-admin',
  templateUrl: './type-instrument-view-admin.component.html'
})
export class TypeInstrumentViewAdminComponent extends AbstractViewController<TypeInstrumentDto, TypeInstrumentCriteria, TypeInstrumentAdminService> implements OnInit {


    constructor(private typeInstrumentService: TypeInstrumentAdminService){
        super(typeInstrumentService);
    }

    ngOnInit(): void {
    }




}
