import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Bonus from './components/Bonus/Bonus';
import WeatherApp from './components/WeatherApp/WeatherApp';
import FiveDayForecast from './components/WeatherApp/FiveDayForecast';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { Route, BrowserRouter as Router } from 'react-router-dom'

const routing = (
  <Router>
    <div>
      <Route path="/" component={App} />
      <Route path="/weatherApp" component={WeatherApp} />
      <Route path="/bonus" component={Bonus} />
      <Route path="/day" component={WeatherApp} />
    </div>
  </Router>
)


ReactDOM.render(routing, document.getElementById('root'));