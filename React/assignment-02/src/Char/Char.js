import React from 'react';
import './Char.css';

const char = (props) => {
  return (
    <div className="Char" onClick={props.clicked}>
      <p>{props.char}</p>
    </div>
  );
}

export default char;