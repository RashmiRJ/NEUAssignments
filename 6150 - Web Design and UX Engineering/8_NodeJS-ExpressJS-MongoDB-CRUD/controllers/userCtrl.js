const express = require('express');
var router = express.Router();
const mongoose = require('mongoose');
const tblUser = mongoose.model('user');
/*
router.get('/',(req, res) => {
    res.json('sample');
});*/

router.get('/', (req, res) => {
    res.render("user/add", {
        viewTitle: "Create User"
    });
});

router.get('user/edit', (req, res) => {
    res.render("user/edit", {
        viewTitle: "Update User"
    });
});

router.post('/', (req, res) => {
    if (req.body._id == '')
        insertRecord(req, res);
        else
        updateRecord(req, res);
});


function insertRecord(req, res) {
    var user = new tblUser();
    //user.fullName = req.body.fullName;
    user.email = req.body.email;
    user.password = req.body.password;
    user.save((err, doc) => {
        if (!err)
            res.redirect('user/getAll');
        else {
            if (err.name == 'ValidationError') {
                handleValidationError(err, req.body);
                res.render("user/add", {
                    viewTitle: "Create User",
                    user: req.body
                });
            }
            else
                console.log('Error during record insertion : ' + err);
        }
    });
}

function updateRecord(req, res) {
    var emailRegExp = /^([^<>()\[\],;:@"\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i
    var pwRegExp = /^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8}$/
    var flag = true;
    if (!(emailRegExp.test(req.body.email))){
        req.body['emailError'] = "This is not a valid email!";
        flag = false;
    }
    if (!(pwRegExp.test(req.body.password))){
        req.body['passwordError'] = "This is not a strong Password!\r Please enter a password that is Maximum of 8 characters, contains atleast 1 Number, atleast one capital letter, atleast one lower case and atleast one speacial character";
        flag = false;
    }
    if(flag) {
    tblUser.findOneAndUpdate({ _id: req.body._id }, req.body, { new: true }, (err, doc) => {
        if (!err) { res.redirect('user/getAll'); }
        else {
            if (err.name == 'ValidationError') {
                handleValidationError(err, req.body);
                res.render("user/edit", {
                    viewTitle: 'Update User',
                    user: req.body
                });
            }
            else
                console.log('Error during record update : ' + err);
        }
    });}
    else {
        res.render("user/edit", {
            viewTitle: 'Update User',
            user: req.body
        });
    }
}

router.get('/getAll', (req, res) => {
    tblUser.find((err, docs) => {
        if (!err) {
            res.render("user/list", {
                list: docs
            });
        }
        else {
            console.log('Error in retrieving user list :' + err);
        }
    });
});


function handleValidationError(err, body) {
    for (field in err.errors) {
        switch (err.errors[field].path) {
            case 'email':
                body['emailError'] = err.errors[field].message;
                break;
            case 'password':
                body['passwordError'] = err.errors[field].message;
                break;
            default:
                break;
        }
    }
}

router.get('/:id', (req, res) => {
    tblUser.findById(req.params.id, (err, doc) => {
        if (!err) {
            res.render("user/edit", {
                viewTitle: "Update User",
                user: doc
            });
        }
    });
});

router.get('/delete/:id', (req, res) => {
    tblUser.findByIdAndRemove(req.params.id, (err, doc) => {
        if (!err) {
            res.redirect('/user/getAll');
        }
        else { console.log('Error in user delete :' + err); }
    });
});

module.exports = router;