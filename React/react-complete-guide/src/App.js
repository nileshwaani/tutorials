import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person'

/* This is a class-based component. Also called smart component or container. */
class App extends Component {

  // Only class-based component can have 'state'
  state = {
    persons: [
      { name: 'Nilesh', age: 39 },
      { name: 'Milind', age: 38 },
      { name: 'Swati', age: 33 }
    ]
  }

  deletePersonHandler = (personIndex) => {
    // The slice() function creates a copy of the original array.
    // const persons = this.state.persons.slice();
    // ES6 provides spread operator to copy the elements of orginal array.
    const persons = [...this.state.persons];
    // The function splice() deletes the given number of elements from the array
    // starting from given index.
    persons.splice(personIndex, 1);
    this.setState(persons);
  }

  // Another variable holding a method that takes an event
  nameChangedHandler = (event) => {
    /* You update the state using this.setState function */
    this.setState({
      persons: [
        { name: 'Nilesh', age: 39 },
        { name: event.target.value, age: 38 },
        { name: 'Swati', age: 33 }
      ],
      showPersons: false
    })
  }

  togglePersonsHandler = () => {
    const doesShow = this.state.showPersons;
    this.setState({ showPersons: !doesShow });
  }

  // React calls this method when it wants to render the screen
  render() {

    // A method can have variables / constants
    // Inline styling, whose scope is limited to this block only
    // background-color becomes backgroundColor
    // The values are given inside single quotes
    const buttonStyle = {
      backgroundColor: 'white',
      font: 'inherit',
      border: '1px solid blue',
      padding: '8px',
      cursor: 'pointer'
    };

    let persons = null;

    // Conditionally hiding / showing components
    if (this.state.showPersons) {
      persons = (
        <div>
          {/* Using map() function, we are mapping each element in the array
              to Person component (or JSX).
              The map() function receives the element from the array and the index of that element.
          */}
          {this.state.persons.map((person, index) => {
            return <Person 
                      click={() => this.deletePersonHandler(index)}
                      name={person.name} 
                      age={person.age}/>
          })}
        </div>
      );
    }

  // Returns JSX expression
  return(
      <div className = "App" >
      <h1>Hi, I am a React App.</h1>
      <p>This is really working!</p>
      <button
        /* Applying inline styling */
        style={buttonStyle}
        /* Setting the onClick handler by setting props */
        /* You can use arrow function to pass parameter to the function */
        onClick={this.togglePersonsHandler}>Switch Name</button>
        {persons}
      </div>
    );
  }
}

export default App;
