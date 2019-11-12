import React, { Component } from 'react';
import './WeatherApp.css';
import PropTypes from 'prop-types';

class ThreeHourForecast extends Component {
  state = {}
  getDayOfWeek = (date) => {
    var dayOfWeek = new Date(date).getDay();
    return isNaN(dayOfWeek) ? null : ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][dayOfWeek];
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
      let day = date.getDate();
      if (day < 10) {
        day = "0" + day;
      }
      return day + " " + month[date.getMonth()];
    }
  }


  render() {

    let styles = {
      
    };

    return this.props.apiData.map((day) => (
      <span className="border border-info">
      <div className="col text-dark" style={styles}>
        <img src={day.icon} width="100" height="100" alt="Weather" /><br />
         <small>Min: {day.min}<span className="">°C</span> <br />Max: {day.max}<span className="">°C</span>
              <br />{day.weather} </small><hr />
              <p className="text-center">{day.time}</p>
             
        </div>
        </span>
    ))
  };
}
// PropTypes
ThreeHourForecast.propTypes = {
  apiData: PropTypes.array.isRequired
}

export default ThreeHourForecast;
