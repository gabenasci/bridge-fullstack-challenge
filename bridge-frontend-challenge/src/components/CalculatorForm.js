import React, {useState} from "react";

const NumberInput = (props) => {
  const [k, setK] = useState(null);

  const calculateHandler = (event) => {
    event.preventDefault();
    props.onCalculate(k);
  };

  const inputChangeHandler = (event) => {
    setK(event.target.value);
  };

  return (
    <form className="Input-wrapper" onSubmit={calculateHandler}>
      <input
        className="Number-input"
        type="number"
        placeholder="Digite um valor para k"
        min='1'
        onChange={inputChangeHandler}
      />
      <button className="Button" type="submit">
        Calcular
      </button>
    </form>
  );
};

export default NumberInput;
