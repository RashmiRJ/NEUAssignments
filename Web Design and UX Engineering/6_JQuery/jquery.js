$(function() {
    $("#selectPosition").change(function() {
        var str = "";
        $("select option:selected").each(function() {
            str = $(this).text();
        });
        if (str == "Just Java")
            $('#dynLbl').html(" Endless Cup $2.00");
        else if (str == "Cafe au Lait") {
            $('#dynLbl').html(" Single $2.00 Double $3.00");
        } else if (str == 'Iced Cappucino')
            $('#dynLbl').html(" Single $4.75 Double $5.75");
        else if (str == 'Mocha Latte')
            $('#dynLbl').html(" Double $3.00");
        else if (str == 'Lite Latte')
            $('#dynLbl').html(" Single $2.00");
    });

    $('#dynText').hide();

    $("#dynChk").change(function() {
        var chk = $('#dynChk').is(':checked');
        if (chk) {
            $('#dynText').show();
        } else {
            $('#dynText').hide();
        }
    });


});


$(document).ready(function() {

    $('#form').submit(function(e) {
        e.preventDefault();
        var first_name = $('#firstName').val();
        var last_name = $('#lastName').val();
        var email = $('#emailId').val();
        var ph = $('#phoneNumber').val();
        var zip = $('#zipcode').val();
        var comments = $('#comments').val();
        var spl = $('#dynText').val();

        $(".error").remove();

        if (first_name.length < 1) {
            $('#firstName').after('<span class="error">This field is required</span>');
        }
        if (last_name.length < 1) {
            $('#lastName').after('<span class="error">This field is required</span>');
        }
        if (email.length < 1) {
            $('#emailId').after('<span class="error">This field is required</span>');
        } else {
            var regEx = /^([^<>()\[\],;:@"\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i;
            var validEmail = regEx.test(email);
            if (!validEmail) {
                $('#emailId').after('<span class="error">Enter a valid email</span>');
                $('#emailId').css('color', 'red');
            }
        }
        if (ph.length < 1) {
            $('#phoneNumber').after('<span class="error">This field is required</span>');
        } else {
            var regEx = /^(\+\d{1,3} ?)?(\(\d{1,5}\)|\d{1,5}) ?\d{3} ?\d{0,7}( (x|xtn|ext|extn|pax|pbx|extension)?\.? ?\d{2-5})?$/i;
            var validPh = regEx.test(ph);
            if (!validPh) {
                $('#phoneNumber').after('<span class="error">Enter a valid Phone number</span>');
                $('#phoneNumber').css('color', 'red');
            }
        }
        if (zip.length < 1) {
            $('#zipcode').after('<span class="error">This field is required</span>');
        } else {
            var regEx = /^(\d{5}(-\d{4})?|([a-z][a-z]?\d\d?|[a-z{2}\d[a-z]) ?\d[a-z][a-z])$/i;
            var validzip = regEx.test(zip);
            if (!validzip) {
                $('#zipcode').after('<span class="error">Enter a valid zipcode</span>');
                $('#zipcode').css('color', 'red');
            }
        }

        if (comments.length < 1) {
            $('#commentserror').after('<span class="error">This field is required</span>');
        }

        if (!($('#facebook').is(':checked')) && !($('#google').is(':checked')) && !($('#yelp').is(':checked'))) {
            // if (!checked) {
            $('#sourceerror').after('<span class="error">Select atleast one option</span>');
        }

        var radio = $('input:radio').is(':checked');
        if (!radio) {
            $('#title').after('<span class="error">Select atleast one option</span>');
        }

        var chk = $('#dynChk').is(':checked');
        if (chk) {
            if (spl.length < 1) {
                $('#dynText').after('<span class="error">This field is required</span>');
            }
        }

    });

});