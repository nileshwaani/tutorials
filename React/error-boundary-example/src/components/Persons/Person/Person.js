import React from 'react';
import styles from './Person.module.css'

const person = (props) => {

  const random = Math.random();

  if(random > 0.7) {
    throw new Error('Something went wrong!');
  }

  return <div className={styles.Person}>
    <p>I am {props.name}. I am {props.age} years old.</p>
    <input type="text" onChange={props.changed} value={props.name}/>
    <button className={styles.button} onClick={props.click}>Delete</button>
  </div>
}

export default person;