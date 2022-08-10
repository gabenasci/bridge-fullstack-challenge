import React, { useState, useEffect } from "react";
import logo from "./logo-bridge.png";
import "./App.css";
import CalculatorForm from "./components/CalculatorForm";
import CalculatedResult from "./components/CalculatedResult";

function Home() {
  const [result, setResult] = useState(null);
  const [loadingResult, setLoadingResult] = useState(false);
  const [responseTime, setResponseTime] = useState(null);
  const [error, setError] = useState(null);

  const resetLoadingResult = () => {
    setLoadingResult(false);
  }

  const onCalculateHandler = (k) => {
    let request = { 
      "k" : k,
      "result": null,
      "time": null
    };
    console.log(JSON.stringify(request));
    setLoadingResult(true);
    fetch("http://localhost:8080/calculate?input=" + k, {
      method: "POST",
      body: JSON.stringify(request),
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
        setLoadingResult(false);
        setError(null);
        if (!k) {
          throw Error('Insira um valor válido para k.');
        }
      })
      .catch(err => {
        setLoadingResult(false);
        setError(err.message);
      })
  };

  return (
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
          <CalculatedResult result={result} loading={loadingResult} onResult={resetLoadingResult} time={responseTime} />
          { error && <div>{ error }</div>}
        </div>
      </body>
  );
}

export default Home;
