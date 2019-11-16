import { Component, Input,
  HostBinding} from '@angular/core';
  
  import { Product } from '../product.model';

@Component({
  selector: 'product-popup',
  templateUrl: './product-popup.component.html'
})
export class ProductPopupComponent {
  @Input() product: string;
  dataPassed = '';
  @HostBinding('attr.class') cssClass = 'item';

  openMyDialog(data) {
    let myDialog:any = <any>document.getElementById("exampleModal");
    this.dataPassed = data;
    console.log(this.dataPassed);
};
mdlSampleIsOpen : boolean = false;
openModal(open : boolean) : void {
    this.mdlSampleIsOpen = open;
}
}