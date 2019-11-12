import React, { Component } from 'react';
import './WeatherApp.css';
import PropTypes from 'prop-types';

class FiveDayForecast extends Component {
  state = {}
  getDayOfWeek = (date) => {
    var dayOfWeek = new Date(date).getDay();
    return isNaN(dayOfWeek) ? null : ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'][dayOfWeek];
  }

  formatDate = (d) => {
    let date = new Date(d);
    if (isNaN(date.getTime())) {
      return d;
    }
    else {

      let month = new Array();
      month[0] = "Jan";
      month[1] = "Feb";
      month[2] = "Mar";
      month[3] = "Apr";
      month[4] = "May";
      month[5] = "Jun";
      month[6] = "Jul";
      month[7] = "Aug";
      month[8] = "Sept";
      month[9] = "Oct";
      month[10] = "Nov";
      month[11] = "Dec";
      let day = d.split(' ')[0].split('-')[2];
      
      return day + " " + month[date.getMonth()];
    }
  }


  render() {

    let styles = {
      padding: '10px 10px 0px 10px'
    };

    let colStyle = {
      paddingLeft: 0
    };

    return this.props.apiData.map((day) => (
      <div className="card bg-info text-white" style={styles} onClick={this.props.selectedDay.bind(this, day.date)}>
        <div className="card-title"><h5 className="text-center">{this.getDayOfWeek(day.date)}</h5><h6 className="text-center">{this.formatDate(day.date)}</h6></div>
        <div className="row">
          <div className="col" style={colStyle}>    <img src={day.icon} width="100" height="100" alt="Weather" />
          </div><div className="col" style={colStyle}>
            <p className="card-text"><small>Min: {day.min}<span className="">°C</span> <br />Max: {day.max}<span className="">°C</span>
              <br />{day.weather}</small></p></div>
        </div>

      </div>
    ))
  };
}
// PropTypes
FiveDayForecast.propTypes = {
  apiData: PropTypes.array.isRequired
}

export default FiveDayForecast;
