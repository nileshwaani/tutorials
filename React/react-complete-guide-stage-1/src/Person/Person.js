/* Do not forget to import React */
import React from 'react';

import './Person.css'

/* This is a functional component. Also called dumb or presentational component. */
/* React makes the props available to the component. */
/* You can access attributes through props. Example: props.name */
const person = (props) => {
  return (
    <div className="Person">
      <p className={props.className} onClick={props.click}>I am {props.name} and I am {props.age} years old!</p>
      <p>{props.children}</p>
      <input type="text" onChange={props.changed} value={props.name} />
    </div>
  )
};

/*
  Two way binding is defined as:
  <input type="text" onChange={props.changed} value={props.name} />
*/

export default person;