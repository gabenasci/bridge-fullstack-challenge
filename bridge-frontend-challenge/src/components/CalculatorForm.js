import React, {useState} from "react";

const NumberInput = (props) => {
  const [k, setK] = useState(0);

  const calculateHandler = (event) => {
    event.preventDefault();
    setK(null);
    props.onCalculate(k)

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
        // HTML event
        onChange={inputChangeHandler}
      />
      <button className="Button" type="submit">
        Calcular
      </button>
    </form>
  );
};

export default NumberInput;
