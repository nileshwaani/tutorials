import React from 'react';
import PropTypes from 'prop-types';

import styles from './Person.module.css'
import Aux from '../../../hoc/Auxiliary';
import AuthContext from '../../../context/auth-context';

const person = (props) => {

  const random = Math.random();

  if (random > 1) {
    throw new Error('Something went wrong!');
  }

  return <Aux>
    <AuthContext.Consumer>
      {(context) => context.authenticated ? <p>Authenticated</p> : <p>Please log in</p>}
    </AuthContext.Consumer>
    <div className={styles.Person}>
      <p key='i1'>I am {props.name}. I am {props.age} years old.</p>
      <input 
        key='i2'
        type="text" 
        onChange={props.changed} 
        value={props.name} />
      <button key='i3' className={styles.button} onClick={props.click}>Delete</button>
    </div>
  </Aux>
}

person.propTypes = {
  name: PropTypes.string,
  age: PropTypes.number,
  changed: PropTypes.func,
  click: PropTypes.func
} 

export default person;