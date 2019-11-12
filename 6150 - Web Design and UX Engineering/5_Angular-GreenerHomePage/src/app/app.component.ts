import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'greener';


 showAlert(event: Event) {
    let x = document.getElementById("my-alert-box");
    x.style.display = "block";
    event.preventDefault();
  }
}
