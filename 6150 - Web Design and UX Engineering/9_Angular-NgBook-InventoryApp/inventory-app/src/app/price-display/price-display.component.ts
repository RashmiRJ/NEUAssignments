import {
  Component,
  Input
} from '@angular/core';

/**
 * @PriceDisplay: A component to show the price of a
 * Product
 */
@Component({
  selector: 'price-display',
  template: `
  <div>\${{ price }}</div>
  `
})
export class PriceDisplayComponent {
  @Input() price: number;
}
