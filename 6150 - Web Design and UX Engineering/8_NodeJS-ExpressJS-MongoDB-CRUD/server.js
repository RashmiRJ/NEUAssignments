require('./models/db');

const express = require('express');
const bodyParser= require('body-parser');
const path = require('path');
const exphbs = require('express-handlebars');

const userCtrl = require('./controllers/userCtrl');

const app = express();

app.use(bodyParser.urlencoded({extended: true}));
app.set('views', path.join(__dirname, '/views/'));
app.engine('hbs', exphbs({ extname: 'hbs', defaultLayout: 'mainLayout', layoutsDir: __dirname + '/views/' }));
app.set('view engine', 'hbs');

app.listen(3000, function () {
    console.log('listening on 3000')
})

app.use('/user',userCtrl);