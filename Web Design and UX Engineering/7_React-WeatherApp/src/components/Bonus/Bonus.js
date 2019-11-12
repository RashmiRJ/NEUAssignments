import React, { Component } from 'react';
import './Bonus.css';

class Bonus extends Component {
  constructor(props) {
    super(props);
    this.state = [{ fName: '' },
    { lName: '' },
    { email: '' },
    { ph: '' },
    { zip: '' },
    { favDrink: 'grapefruit' },
    { comments: '' },
    { fnErr: false },
    { lnErr: false },
    { ctsErr: false },
    { zipErr: false },
    { eErr: false },
    { phErr: false },
    { phRegexErr: false }];

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
    switch (name) {
      case "fName": {
        if (value.length < 1) { this.setState({ fnErr: true }); }
        else { this.setState({ fnErr: false }); }
        break;
      }
      case "lName": {
        if (value.length < 1) { this.setState({ lnErr: true }); }
        else { this.setState({ lnErr: false }); }
        break;
      }
      case "comments": {
        if (value.length < 1) { this.setState({ ctsErr: true }); }
        else { this.setState({ ctsErr: false }); }
        break;
      }
      case "zip": {
        var regEx = /^(\d{5}(-\d{4})?|([a-z][a-z]?\d\d?|[a-z{2}\d[a-z]) ?\d[a-z][a-z])$/i;
        var validzip = regEx.test(value);

        if ((value.length < 1) || (!validzip)) {
          this.setState({ zipErr: true });
        }
        else { this.setState({ zipErr: false }); }

        break;
      }
      case "ph": {
        let regEx1 = /^(\+\d{1,3} ?)?(\(\d{1,5}\)|\d{1,5}) ?\d{3} ?\d{0,7}( (x|xtn|ext|extn|pax|pbx|extension)?\.? ?\d{2-5})?$/i;
        let validPh = regEx1.test(value);

        if ((value.length < 1) || (!validPh)) {
          this.setState({ phErr: true });
        }
        else { this.setState({ phErr: false }); }
        break;
      }
      case "email": {
        var regEx2 = /^([^<>()\[\],;:@"\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i;
        var validEmail = regEx2.test(value);

        if ((value.length < 1) || (!validEmail)) {
          this.setState({ eErr: true });
        }
        else { this.setState({ eErr: false }); }
        break;
      }
      default: {
        //do nothing
        break;
      }
    }
  }

  handleSubmit(event) {
    event.preventDefault();
  }


  render() {
    return (
      <div className="container">
        <main>
          <h2>Feeback</h2>
          <h3>Love something? Hate something? Let us know!</h3>
          Note : Fields marked with an asterisk(*) are mandatory
            <br></br>
          <br></br>
          <form onSubmit={this.handleSubmit}>
            <label> First Name*: </label>
            <input type="text" value={this.state.fName} name="fName" onChange={this.handleChange} />
            {(this.state.fnErr) ?
              (<span className="error">This field is required</span>) : ''}
            <br></br>
            <br></br>
            <label> Last Name*: </label>
            <input type="text" value={this.state.lName} name="lName" onChange={this.handleChange} />
            {(this.state.lnErr) ?
              (<span className="error">This field is required</span>) : ''}
            <br></br>
            <br></br>
            <label> EMail*: </label>
            <input type="text" value={this.state.email} name="email" onChange={this.handleChange} />
            {(this.state.eErr) ?
              (<span className="error">Enter a valid EMail</span>) : ''}
            <br></br>
            <br></br>
            <label> Phone*: </label>
            <input type="text" value={this.state.ph} name="ph" onChange={this.handleChange} />
            {(this.state.phErr) ?
              (<span className="error">Enter a valid Phone number</span>) : ''}
            <br></br>
            <br></br>
            <label> ZipCode*: </label>
            <input type="text" value={this.state.zip} name="zip" onChange={this.handleChange} />
            {(this.state.zipErr) ?
              (<span className="error">Enter a valid Zip Code</span>) : ''}
            <br></br>
            <br></br>
            <label>Your favourite drink:</label>
            <select value={this.state.favDrink} name="favDrink" onChange={this.handleChange}>
              <option value="grapefruit">Grapefruit</option>
              <option value="lime">Lime</option>
              <option value="coconut">Coconut</option>
              <option value="mango">Mango</option>
              <option value="pineapple">Pineapple</option>
            </select>
            <br></br>
            <br></br><br></br>
            <label>Comments*:</label>
            <textarea value={this.state.comments} name="comments" onChange={this.handleChange} rows="5" cols="25"></textarea>
            {(this.state.ctsErr) ?
              (<span className="error">This field is required</span>) : ''}
            <br></br>
            <br></br>
            <input type="submit" value="Submit" className="btn-primary" />
          </form>
        </main>
      </div>

    );
  }
}

export default Bonus;