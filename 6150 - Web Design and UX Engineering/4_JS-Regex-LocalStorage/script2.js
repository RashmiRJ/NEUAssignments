var isSubmitted = false;


var table = document.getElementById("myTable");

//on load fetch local storage and loop thru all values

var names = localStorage.getItem('name').split(';');
var phones = localStorage.getItem('phone').split(';');
var emails = localStorage.getItem('email').split(';');
var zips = localStorage.getItem('zip').split(';');
var hows = localStorage.getItem('howDidYouHear').split(';');
var favs = localStorage.getItem('favDrink').split(';');
var spls = localStorage.getItem('splInst').split(';');
var comms = localStorage.getItem('comments').split(';');

for (var i = 0; i < names.length; i++) {
    var row = table.insertRow(-1); // add to the last
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    var cell7 = row.insertCell(6);
    var cell8 = row.insertCell(7);

    cell1.innerHTML = names[i];
    cell2.innerHTML = phones[i];
    cell3.innerHTML = emails[i];
    cell4.innerHTML = zips[i];
    cell5.innerHTML = hows[i];
    cell6.innerHTML = favs[i];
    cell7.innerHTML = spls[i];
    cell8.innerHTML = comms[i];
}

//clear table data and remove values from local storage
function clearTable() {
    var table = document.getElementById("myTable");
    var len = table.rows.length;
    for (var i = len - 1; i > 0; i--) {
        table.deleteRow(i);
    }
    localStorage.removeItem('name');
    localStorage.removeItem('phone');
    localStorage.removeItem('email');
    localStorage.removeItem('zip');
    localStorage.removeItem('howDidYouHear');
    localStorage.removeItem('favDrink');
    localStorage.removeItem('splInst');
    localStorage.removeItem('comments');
}