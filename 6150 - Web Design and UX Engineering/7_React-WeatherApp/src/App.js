import React from 'react';
import './App.css';
import { NavLink } from 'react-router-dom'

function App() {
  return (
    <div className="App-header">
      <ul className="nav justify-content-center">
        <li className="nav-item">
          <NavLink type="link" className="btn btn-dark" to="/weatherApp"> Weather App</NavLink>
        </li>
        <li className="nav-item">
          <NavLink type="link" className="btn btn-dark" to="/bonus">Bonus</NavLink>
        </li>


      </ul>
    </div>
  );
}

export default App;
