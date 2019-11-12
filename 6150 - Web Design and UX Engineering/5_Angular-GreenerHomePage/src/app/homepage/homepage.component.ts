import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent implements OnInit {
  card1: String ;
  cardPortal: String;
  cardAnalysis: String;
  constructor() {
   }

  ngOnInit() {
    this.card1 = "assets/images/cardLayoutInfo.jpg";
    this.cardPortal = "assets/images/cardlayouteproducts.jpeg";
    this.cardAnalysis = "assets/images/cardlayouteanalysis.jpeg";
    //@ts-ignore
    twttr.widgets.load();
  }

}
