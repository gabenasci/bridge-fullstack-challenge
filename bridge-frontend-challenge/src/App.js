import {useState} from 'react';
import Home from './Home.js';
import NavBar from './components/NavBar';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import CalculationList from './components/CalculationList';

function App() {

  return (
    <div className="App">
      <Router>
        <NavBar />
        <Switch>
          <Route 
            exact path="/"
          >
            <Home />
          </Route>
          <Route exact path="/history">
            <CalculationList className="History" />
          </Route>
        </Switch>
      </Router>
    </div>

  )
}

export default App;
