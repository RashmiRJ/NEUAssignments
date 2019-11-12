//defining a global var so that I can add ID for the toggle to show display to new rows easily
var detID = 3;

//on load of the page, the below executes. Function called at the end of JS
function onload() {
    //hide all sub regions
    x = document.getElementsByClassName("dropDownTextArea");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }

    //hides the delete buttons in the delete column
    hideDeleteColumn();
    //disable submit button
    disableSubmitButton();
};

//hides the delete buttons in the delete column
function hideDeleteColumn() {
    var allDelCols = document.getElementsByName("del");
    for (var j = 0; j < allDelCols.length; j++) {
        var delCol = allDelCols[j];
        delCol.childNodes[0].style.display = "none";
    }
}

//disables the submit button
function disableSubmitButton() {
    document.getElementById('button').disabled = true;
    document.getElementById('button').style.backgroundColor = "grey";
    document.getElementById('button').style.border = "grey";
}

//enables the save button
function enableSubmitButton() {
    document.getElementById('button').disabled = false;
    document.getElementById('button').style.backgroundColor = "orange";
    document.getElementById('button').style.border = "orange";
}

//show or hide the details part on press of the green arrow
function toggleDetails(id) {
    if (document.getElementById(id).style.display == "table-row") {
        document.getElementById(id).style.display = "none";
    } else {
        document.getElementById(id).style.display = "table-row";
        //added if condition as - 
        //1) Removing colspan in HTML for first three rows and setting attr here is not working as childnodes is not identifying TD. 
        //2) Adding colspan="\8\" in newly added row is somehow not getting applied
        //Hence, added a check, if row child is identifyable as TD, meaning new row, then add colspan.
        if (document.getElementById(id).childNodes[0].nodeName == "TD")
            document.getElementById(id).childNodes[0].setAttribute("colspan", "9");
    }
};

//when adding a new row, increment the global var and send the latest possible ID
function getLastDetID() {
    detID++;
    return detID;
}

//action on add new student
function addNewStudent() {
    //first get the latest possible ID
    var lastDetID = getLastDetID();

    //insert main row
    var table = document.getElementById("myTable");
    var row = table.insertRow(-1); // add to the last
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    var cell7 = row.insertCell(6);
    var cell8 = row.insertCell(7);
    var cell9 = row.insertCell(8);

    cell1.innerHTML = "<input type=\"checkbox\" onclick=\"toggleCheckBox(this)\" /><br /><br /><img src=\"down.png\" width=\"25px\" onclick=\"toggleDetails('det" + lastDetID + "')\" />";
    cell2.innerHTML = "NEW STUDENT";
    cell3.innerHTML = "NEW TEACHER";
    cell4.innerHTML = "NOT AWARDED";
    cell5.innerHTML = "FALL";
    cell6.innerHTML = "TA";
    cell7.innerHTML = "000000";
    cell8.innerHTML = "0%";
    cell9.innerHTML = "<button onclick=\"deleteRow(this,'det" + lastDetID + "')\">Delete</button>";
    cell9.setAttribute("name", "del")

    //insert details row
    var subrow = table.insertRow(-1); // add to the last
    subrow.setAttribute("class", "dropDownTextArea");
    subrow.setAttribute("id", "det" + lastDetID);
    var subrowcell1 = subrow.insertCell(0);
    subrowcell1.innerHTML = "<td>Advisor:<br /><br /> Award Details<br /> Summer 1-2014(TA)<br /> Budget Number: <br /> Tuition Number: <br /> Comments:<br /><br /><br /> Award Status:<br /><br /><br /></td>";

    //call onLoad so thar the details row is not shown asa it is added
    onload();
}

//on select or deselect of a checkbox
function toggleCheckBox(item) {
    var rowObject = item.parentNode.parentNode; //hold the row object
    var isRowSeleted = false; //flag used to universally check if all checkboxes are unchecked and disable submit button

    if (item.checked == true) {
        rowObject.style.backgroundColor = "orange";
        //show delete button
        rowObject.cells[8].childNodes[0].style.display = "block";
        enableSubmitButton();
    } else {
        rowObject.style.backgroundColor = "white";
        //hide delete button
        rowObject.cells[8].childNodes[0].style.display = "none";
        var table = document.getElementById("myTable");
        //loop through all table rows and check if there is any checkbox in 'checked' state
        //if any in 'checked' state, then set the flag to true so that the submit button remains enabled
        for (var i = 1; i < table.rows.length; i = i + 2) {
            var checkAll = table.rows[i].cells[0].childNodes[0];
            if (checkAll.checked == true) {
                //keep enabled even if one check box is checked.
                isRowSeleted = true;
            }
        }
        //if none are checked, then disable the button on the deselect of the checkbox. 
        if (isRowSeleted == false) {
            disableSubmitButton();
        }
    }
}

//delete row on click of the delete button
function deleteRow(item, id) {
    var row = item.parentNode.parentNode;
    //first set the checkbox to false so that it will take care of all the actions related to CSS and submit button
    row.cells[0].childNodes[0].checked = false;
    toggleCheckBox(row.cells[0].childNodes[0]);

    //finally delete the row

    if (document.getElementById(id).style.display == "table-row") {
        document.getElementById(id).style.display = "none";
    }
    row.parentNode.removeChild(row);
}

//on page load, run this function
onload();