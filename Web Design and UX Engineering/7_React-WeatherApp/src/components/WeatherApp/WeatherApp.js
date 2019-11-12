import React, { Component } from 'react';
import FiveDayForecast from './FiveDayForecast';
import ThreeHourForecast from './ThreeHourForecast';
import './WeatherApp.css';

const API_KEY = "799e07831e2b5f38c0899d8a23e0e9dd";

class WeatherApp extends Component {
  state = {
    form: {
      city: "Boston",
      country: "US"
    },
    weatherData: [],
    hourlyData: [],
    apiResponse: [],
    viewForm: false,
    viewHr: false
  }
  clearHrData = () => {
    this.state.hourlyData.splice(0, this.state.hourlyData.length);
    this.setState({
      viewHr: false,
      hourlyData: this.state.hourlyData
    });
  }

  clearWeatherData = () => {
    this.state.weatherData.splice(0, this.state.weatherData.length);
    this.setState({
      viewForm: false,
      weatherData: this.state.weatherData
    });
    this.clearHrData();
  }

  selectedDay = (date) => {
    this.clearHrData();
    this.state.apiResponse.map(row => {
      const thisDay = row.dt_txt.split(' ')[0];
      if (thisDay === date) {
        var data = {
          time: row.dt_txt.split(' ')[1],
          min: row.main.temp_min,
          max: row.main.temp_max,
          weather: row.weather[0].main,
          icon: "http://openweathermap.org/img/wn/" + row.weather[0].icon + "@2x.png"
        }


        this.state.hourlyData.push(data)
        this.setState({
          viewHr: true,
          hourlyData: this.state.hourlyData
        });
      }
      return null;
    });
  }


  getWeather = async (e) => {
    e.preventDefault();
    this.clearWeatherData();
    const city = e.target.elements.city.value;
    const country = "US";
    let lastday = "";
    const api_call = await fetch(`https://api.openweathermap.org/data/2.5/forecast?q=${city},${country}&appid=${API_KEY}&units=metric`);
    const data = await api_call.json();
    if (data) {
      this.setState({
        viewForm: true,
        apiResponse: data.list
      });
      data.list.map(row => {
        const thisDay = row.dt_txt.split(' ')[0];
        if (thisDay !== lastday) {
          lastday = thisDay;
          var dayData = {
            date: row.dt_txt.split(' ')[0],
            min: row.main.temp_min,
            max: row.main.temp_max,
            weather: row.weather[0].main,
            icon: "http://openweathermap.org/img/wn/" + row.weather[0].icon + "@2x.png"
          }


          this.state.weatherData.push(dayData)
          this.setState({
            weatherData: this.state.weatherData
          });
        }

        return null;
      });

    } else {
      this.setState({
        //something
      });
    }
  }

  render() {
    return (
      <div className="wrapper">
        <div className="main">
          <div>
            <form onSubmit={this.getWeather}>
              <label> Select City: </label>
              <select defaultValue="Boston" name="city" onChange={this.handleChange}>
                <option value="Boston">Boston</option>
                <option value="New York">New York</option>
                <option value="Atlanta">Atlanta</option>
                <option value="Austin">Austin</option>
                <option value="Florida">Florida</option>
              </select>
              <br /><br />
              <button className="btn-dark">Get Weather</button>
            </form> </div><br /><br />
          <div className="card-deck">
            {(this.state.viewForm) ?
              (<FiveDayForecast apiData={this.state.weatherData} selectedDay={this.selectedDay} />)
              : ''}
          </div>
          <br /><br />
          <div className="row">
            {(this.state.viewHr) ?
              (<ThreeHourForecast apiData={this.state.hourlyData} />)
              : ''}
          </div>
        </div>
      </div>
    );
  }
}

export default WeatherApp;