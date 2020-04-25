import React from 'react';
import styles from './Cockpit.module.css';

const Cockpit = (props) => {
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
      className={buttonClasses.join(' ')}
      onClick={props.clicked}>Toggle Persons</button>
    </div>
  );
};

export default Cockpit;