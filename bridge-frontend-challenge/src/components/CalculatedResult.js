import React, {useState} from 'react';
import spinner from '../assets/spinner.gif'

const CalculatedResult = (props) => {
  // return props.loading ? <p>Calculating...</p> : <p>Resultado: { props.result }</p>
  if(props.loading) {
    return (
      <div className='Loading-wrapper'>
        <img src={spinner} alt='loading...' className='Spinner'></img>
        <p>Calculando...</p>
      </div>
    )
  }
  else if (!props.loading && props.result){
    return (
      <div className='Result-wrapper'>
        <h4>Resultado:</h4>
        <h4 className='Result'>{ props.result }</h4>
        <p>Tempo do cálculo: <p className='Time'><strong>{ props.time } ms</strong></p></p>
        
      </div>
    )
  }
};
export default CalculatedResult;