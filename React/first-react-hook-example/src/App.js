import React, { useState } from 'react';
import './App.css';
import Person from './Person/Person';

const app = props => {

  const [personsState, setPersonsState] = useState({
    persons: [
      {name: "Nilesh", age: 39},
      {name: "Milind", age: 38},
      {name: "Jay", age: 40}
    ]
  });

  const [otherState, setOtherState] = useState('some other state');

  const switchNameHandler = () => {
    setPersonsState({
      persons: [
        {name: "Nilesh Wani", age: 39},
        {name: "Milind", age: 38},
        {name: "Jay", age: 40}
      ]
    });
  }

  return (
    <div className="App">
      <h1>Hi, I am a React App!</h1>
      <button onClick={switchNameHandler}>Switch Name</button>
      <Person name={personsState.persons[0].name} age={personsState.persons[0].age}/>
      <Person name={personsState.persons[1].name} age={personsState.persons[1].age}/>
      <Person name={personsState.persons[2].name} age={personsState.persons[2].age}>My hobbies: Driving</Person>
    </div>
  );
}

export default app;