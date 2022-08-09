import React, { useState, useEffect } from "react";
import logo from "./logo-bridge.png";
import "./App.css";
import CalculatorForm from "./components/CalculatorForm";
// import CalculatedResult from "./components/CalculatedResult";
import CalculatedResult from "./components/CalculatedResult";

function App() {
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [responseTime, setResponseTime] = useState(null);
  const [error, setError] = useState(null);

  const resetLoading = () => {
    setLoading(false)
  }

  const onCalculateHandler = (k) => {
    setLoading(true);
    fetch("http://localhost:8080/result?input=" + k, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        // console.log(response);
        if(!response.ok && k) {
          throw Error('Não foi possível comunicar com a API de cálculo.');
        }
        return response.json();
      })
      .then((data) => {
        setResult(data.result); 
        setResponseTime(data.time);
        setLoading(false);
        setError(null);
        if (!k) {
          throw Error('Insira um valor válido para k.');
        }
      })
      .catch(err => {
        setLoading(false);
        setError(err.message);
      })
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
            número de divisores positivos.
          </p>
          <CalculatorForm onCalculate={onCalculateHandler}></CalculatorForm>
          <CalculatedResult result={result} loading={loading} onResult={resetLoading} time={responseTime} />
          { error && <div>{ error }</div>}
        </div>
      </body>
    </div>
  );
}

export default App;
