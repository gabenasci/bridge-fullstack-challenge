import React, { useState, useEffect } from "react";
import logo from "./logo-bridge.png";
import "./App.css";
import CalculatorForm from "./components/CalculatorForm";
// import CalculatedResult from "./components/CalculatedResult";
import CalculatedResult from './components/CalculatedResult';

function App() {
  const [result, setResult] = useState(null);

  const onCalculateHandler = (k) => {
    console.log("BUTTON PRESS")
    fetch("http://localhost:8080/getresult?input="+k, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((data) => setResult(data));
  };

  return (
    <div className="App">
      <body className="App-body">
        <img src={logo} className="App-logo" alt="logo" />
        <h3>Desafio Fullstack Developer</h3>
        <div className="Calculation">
          <p>
            Calcule abaixo o número de inteiros positivos <em>n</em> menores que{" "}
            <em>k</em> para os quais <em>n</em> e <em>n+1</em> têm o mesmo
            número de divisores positivos
          </p>
          <CalculatorForm onCalculate={onCalculateHandler}></CalculatorForm>
          <p>Resultado: {result}</p>
        </div>
      </body>
    </div>
  );
}

export default App;
