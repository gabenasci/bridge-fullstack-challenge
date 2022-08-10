import React, { useState, useEffect } from "react";
import spinner from "../assets/spinner.gif";

const CalculationList = () => {
  const [calculations, setCalculations] = useState([]);
  const [loadingHistory, setLoadingHistory] = useState(false);
  const [error, setError] = useState(null);

  const resetLoadingHistory = () => {
    setLoadingHistory(false);
  }

  useEffect(() => {
    fetch('http://localhost:8080/results')
      .then(response => {
        if(!response.ok){
          throw Error('Não foi possível comunicar com a API.')
        }
        return response.json()
      })
      .then(data => {
        setCalculations(data);
      })
      .catch(err => {
        setError(err.message)
      })
      
  }, [calculations])

  if (!loadingHistory) {
    return (
      <body className="History-body">
        <h2>Histórico</h2>
        <div className="History">
          {calculations.map((calculation) => (
            <div key={calculation.k} className="Calc">
              <div className="Row">K: {calculation.k}</div>
              <div className="Row">Resultado: {calculation.result}</div>
              <div className="Row">Tempo: {calculation.time}</div>
              
            </div>
          ))}
        </div>
      </body>
    );
  } else {
    <div className="Loading-wrapper">
      <img src={spinner} alt="loading..." className="Spinner"></img>
      <p>Carregando...</p>
    </div>;
  }
};

export default CalculationList;
