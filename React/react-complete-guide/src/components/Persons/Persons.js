import React from 'react';
import {useEffect} from 'react';

import ErrorBoundary from '../ErrorBoundary/ErrorBoundary';
import Person from './Person/Person';

const Persons = (props) => {
  useEffect(() => {
    console.log('[Persons.js] - useEffect every render cycle')
    return () => {
      console.log('[Persons.js] - useEffect every render cycle - BEFORE MAIN & BEFORE REMOVING')
    }
  });

  useEffect(() => {
    console.log('[Persons.js] - useEffect only once during creation')
    return () => {
      console.log('[Persons.js] - useEffect only once during creation - AFTER MAIN & BEFORE REMOVING')
    }
  }, []);

  useEffect(() => {
    console.log('[Persons.js] - useEffect when persons in props changes')
    return () => {
      console.log('[Persons.js] - useEffect when persons in props changes - BEFORE MAIN & BEFORE REMOVING')
    }
  }, [props.persons]);

  return props.persons.map((person, index) => {
    return <ErrorBoundary key={person.id}>
      <Person 
        click={props.clicked.bind(this, index)}
        changed={(event) => props.changed(event, person.id)}
        name={person.name} 
        age={person.age}/>
      </ErrorBoundary>
  });
}


export default React.memo(Persons);