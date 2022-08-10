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
    setLoadingHistory(true);
    fetch('http://localhost:8080/results')
      .then(response => {
        if(!response.ok){
          throw Error('Não foi possível comunicar com a API.')
        }
        return response.json()
      })
      .then(data => {
        setCalculations(data);
        setLoadingHistory(false);
      })
      .catch(err => {
        setError(err.message)
        setLoadingHistory(false);
      })   
  }, [])

  if (!loadingHistory) {
    return (
      <div className="History-body">
        <h2>Histórico</h2>
        {error && <div>{ error }</div>}
        <div className="History">
          {calculations.map((calculation) => (
            <div key={calculation.k} className="Calc">
              <div className="Row">K: {calculation.k}</div>
              <div className="Row">Resultado: {calculation.result}</div>
              <div className="Row">Tempo: {calculation.time} ms</div>
              
            </div>
          ))}
        </div>
      </div>
    );
  } else {
    return (
      <div className="History-body">
        <div className="Loading-wrapper">
          <img src={spinner} alt="loading..." className="Spinner"></img>
          <p>Carregando...</p>
        </div>
      </div>
    )

  }
};

export default CalculationList;
