import React from 'react';
import {useEffect, useRef, useContext} from 'react';

import styles from './Cockpit.module.css';
import AuthContext from '../../context/auth-context'

const Cockpit = (props) => {

  const toggleButtonRef = useRef(null);
  const authContext = useContext(AuthContext);

  useEffect(() => {
    console.log('[Cockpit.js] - useEffect every render cycle')
    return () => {
      console.log('[Cockpit.js] - useEffect every render cycle - BEFORE MAIN & BEFORE REMOVING')
    }
  });

  useEffect(() => {
    console.log('[Cockpit.js] - useEffect only once during creation')
    toggleButtonRef.current.click();
    return () => {
      console.log('[Cockpit.js] - useEffect only once during creation - AFTER MAIN & BEFORE REMOVING')
    }
  }, []);

  useEffect(() => {
    console.log('[Cockpit.js] - useEffect when persons in props changes')
    return () => {
      console.log('[Cockpit.js] - useEffect when persons in props changes - BEFORE MAIN & BEFORE REMOVING')
    }
  }, [props.persons]);

  const classes = [];

  let buttonClasses = [styles.button];

  if(props.showPersons) {
    buttonClasses.push(styles.redButton);
  }

  if(props.persons.length <= 2) {
    classes.push(styles.red);

    if(props.persons.length <= 1) {
      classes.push(styles.bold);
    }
  }

  return(
    <div>
    <p className={classes.join(' ')}>{props.title}</p>
    <button 
      ref={toggleButtonRef}
      className={buttonClasses.join(' ')}
      onClick={props.clicked}>
      Toggle Persons
    </button>
    <button 
      className={buttonClasses.join(' ')}
      onClick={authContext.login}>
      Log-in
    </button>      
    </div>
  );
};

export default React.memo(Cockpit);