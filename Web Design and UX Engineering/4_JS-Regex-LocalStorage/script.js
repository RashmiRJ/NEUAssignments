var isSubmitted = false;

var rowObj = { name: '', phone: '', email: '', zip: '', howDidYouHear: '', favDrink: '', splInst: '', comments: '' }
var rowList = [];

//on load set display conditions and reset form
document.getElementById('emailIdValid').style.display = "none";
document.getElementById('phoneNumberValid').style.display = "none";
document.getElementById('zipcodeValid').style.display = "none";
document.getElementById('checkMandatory').style.display = "none";
document.getElementById('dynText').style.display = "none";
document.getElementById('feedbackForm').reset();

//regex phone validation
function isValidTelephoneNumber(telephoneNumber) {
    var telRegExp = /^(\+\d{1,3} ?)?(\(\d{1,5}\)|\d{1,5}) ?\d{3} ?\d{0,7}( (x|xtn|ext|extn|pax|pbx|extension)?\.? ?\d{2-5})?$/i
    if (!telRegExp.test(telephoneNumber) && isSubmitted) {
        document.getElementById('phoneNumber').style.color = "red";
        document.getElementById('phoneNumberValid').style.display = "inline";
        document.getElementById('phoneNumberValid').style.color = "red";
        return false;
    } else {
        document.getElementById('phoneNumber').style.color = "black";
        document.getElementById('phoneNumberValid').style.display = "none";
        return true;
    }
};

//regex email validation
function isValidEmail(emailAddress) {
    var emailRegExp = /^([^<>()\[\],;:@"\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i
    if (!(emailRegExp.test(emailAddress)) && isSubmitted) {
        document.getElementById('emailId').style.color = "red";
        document.getElementById('emailIdValid').style.display = "inline";
        document.getElementById('emailIdValid').style.color = "red";
        return false;
    } else {
        document.getElementById('emailId').style.color = "black";
        document.getElementById('emailIdValid').style.display = "none";
        return true;
    }
};

//regex zip validation
function isValidPostalCode(postalCode) {
    var pcodeRegExp = /^(\d{5}(-\d{4})?|([a-z][a-z]?\d\d?|[a-z{2}\d[a-z]) ?\d[a-z][a-z])$/i
    if (!(pcodeRegExp.test(postalCode)) && isSubmitted) {
        document.getElementById('zipcode').style.color = "red";
        document.getElementById('zipcodeValid').style.display = "inline";
        document.getElementById('zipcodeValid').style.color = "red";
        return false;
    } else {
        document.getElementById('zipcode').style.color = "black";
        document.getElementById('zipcodeValid').style.display = "none";
        return true;
    }
};

//get rado button value for title
function getNamePrefix() {
    var radios = document.getElementsByName('title');
    for (var i = 0, length = radios.length; i < length; i++) {
        if (radios[i].checked) {
            return radios[i].value;
        }
    }
}

//get all checkbox values
function getHearFroms() {
    var checkboxes = document.getElementsByName('source');
    var val = "";
    for (var i = 0, length = checkboxes.length; i < length; i++) {
        if (checkboxes[i].checked) {
            val = val + ',' + checkboxes[i].value;
        }
    }
    return val;
}

//check if checkbox is checked or not
function isAllEntered() {
    var chekboxes = document.getElementsByName('source');
    var ch = false;
    for (var i = 0, length = chekboxes.length; i < length; i++) {
        if (chekboxes[i].checked) {
            ch = true;
            break;
        }
    }
    if (!ch) {
        document.getElementById('checkMandatory').style.color = "red";
        document.getElementById('checkMandatory').style.display = "block";
    }
    return ch;
}

//on submit check validation and add to local storage
function checkValid(zip, email, phone) {
    isSubmitted = true;
    var checkMandatory = isAllEntered();
    var zipChk = isValidPostalCode(zip);
    var phoneChk = isValidTelephoneNumber(phone);
    var emailChk = isValidEmail(email);
    if (zipChk && phoneChk && emailChk && checkMandatory) {
        var title = getNamePrefix();
        var fNm = document.getElementById('firstName').value;
        var lNm = document.getElementById('lastName').value;
        var name = title + (' ') + fNm + (' ') + lNm;
        var e = document.getElementById('selectPosition');

        rowObj.name = name;
        rowObj.phone = phone;
        rowObj.email = email;
        rowObj.zip = zip;
        rowObj.howDidYouHear = getHearFroms();
        rowObj.favDrink = e.options[e.selectedIndex].value;
        rowObj.splInst = document.getElementById('dynText').value;
        rowObj.comments = document.getElementById('comments').value;
        rowList.push(rowObj);
        if (localStorage.getItem('name')) {
            var currName = localStorage.getItem('name');
            localStorage.setItem('name', currName + ';' + name);
        } else localStorage.setItem('name', name);

        if (localStorage.getItem('phone')) {
            var currphone = localStorage.getItem('phone');
            localStorage.setItem('phone', currphone + ';' + phone);
        } else localStorage.setItem('phone', phone);


        if (localStorage.getItem('email')) {
            var curr = localStorage.getItem('email');
            localStorage.setItem('email', curr + ';' + email);
        } else localStorage.setItem('email', email);

        if (localStorage.getItem('zip')) {
            var czip = localStorage.getItem('zip');
            localStorage.setItem('zip', czip + ';' + zip);
        } else localStorage.setItem('zip', zip);

        if (localStorage.getItem('howDidYouHear')) {
            var ch = localStorage.getItem('howDidYouHear');
            localStorage.setItem('howDidYouHear', ch + ';' + getHearFroms());
        } else localStorage.setItem('howDidYouHear', getHearFroms());

        if (localStorage.getItem('favDrink')) {
            var cf = localStorage.getItem('favDrink');
            localStorage.setItem('favDrink', cf + ';' + e.options[e.selectedIndex].value);
        } else localStorage.setItem('favDrink', e.options[e.selectedIndex].value);

        if (localStorage.getItem('splInst')) {
            var cs = localStorage.getItem('splInst');
            localStorage.setItem('splInst', cs + ';' + document.getElementById('dynText').value);
        } else localStorage.setItem('splInst', document.getElementById('dynText').value);


        if (localStorage.getItem('comments')) {
            var cc = localStorage.getItem('comments');
            localStorage.setItem('comments', cc + ';' + document.getElementById('comments').value);
        } else localStorage.setItem('comments', document.getElementById('comments').value);

        return true;
    } else {
        event.preventDefault();
        return false;
    }
};

//checkbox values check, remove validation message
function toggleHw(item) {
    var chekboxes = document.getElementsByName('source');
    var ch = false;
    for (var i = 0, length = chekboxes.length; i < length; i++) {
        if (chekboxes[i].checked) {
            document.getElementById('checkMandatory').style.display = "none";
            ch = true;
            break;
        }
    }
    if (!ch && isSubmitted) {
        document.getElementById('checkMandatory').style.color = "red";
        document.getElementById('checkMandatory').style.display = "block";
    }
    // return ch;
}

//additional checkbox validation, show or hide special instructions text field
function toggleCheckbox(item) {
    if (item.checked) {
        document.getElementById('dynText').style.display = "block";
        document.getElementById('dynText').required = true;
    } else {
        document.getElementById('dynText').style.display = "none";
        document.getElementById('dynText').required = false;
    }
}

//change additional checkbox value based on selected option
function toggleSelect(item) {
    switch (item.value) {
        case 'Just Java':
            document.getElementById('dynLbl').innerHTML = " Endless Cup $2.00";
            break;
        case 'Cafe au Lait':
            document.getElementById('dynLbl').innerHTML = " Single $2.00 Double $3.00";
            break;
        case 'Iced Cappucino':
            document.getElementById('dynLbl').innerHTML = " Single $4.75 Double $5.75";
            break;
        case 'Mocha Latte':
            document.getElementById('dynLbl').innerHTML = " Double $3.00";
            break;
        case 'Lite Latte':
            document.getElementById('dynLbl').innerHTML = " Single $2.00";
            break;
    }
}