const mongoose = require('mongoose');

var userSchema = new mongoose.Schema({
    email: {
        type: String,
        validate: {
            validator: function(v) {
              return /^([^<>()\[\],;:@"\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i.test(v);
            },
            message: props => 'This is not a valid email!'
          },
        required: 'This field is required.'
    },
    password: {
        type: String,
        validate: {
            validator: function(v) {
              return /^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8}$/.test(v);
            },
            message: props => 'This is not a strong Password!\r Please enter a password that is Maximum of 8 characters, contains atleast 1 Number, atleast one capital letter, atleast one lower case and atleast one speacial character'
          },
        required: 'This field is required.'
    }
});

mongoose.model('user', userSchema);