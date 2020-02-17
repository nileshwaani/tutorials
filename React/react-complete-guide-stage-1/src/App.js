import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person'

/* This is a class-based component. Also called smart component or container. */
class App extends Component {

  // Only class-based component can have 'state'
  state = {
    persons: [
      {name: 'Nilesh', age: 39},
      {name: 'Milind', age: 38},
      {name: 'Swati', age: 33}
    ]
  }

  // Variable holding a method that takes one parameter
  switchNameHandler = (newName) => {
    // DON'T DO THIS: this.state.persons[0].name='Nilesh Wani';
    this.setState( {
        persons: [
          {name: newName, age: 39},
          {name: 'Milind', age: 38},
          {name: 'Swati Wani', age: 33}
        ]
      })
  }

  // Another variable holding a method that takes an event
  nameChangedHandler = (event) => {
    /* You update the state using this.setState function */
    this.setState( {
        persons: [
          {name: 'Nilesh', age: 39},
          {name: event.target.value, age: 38},
          {name: 'Swati', age: 33}
        ]
      })
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

    // Returns JSX expression
    return (
      <div className="App">
        <h1>Hi, I am a React App.</h1>
        <p>This is really working!</p>
        <button
          /* Applying inline styling */
          style={buttonStyle}
          /* Setting the onClick handler by setting props */
          /* You can use arrow function to pass parameter to the function */
          onClick={() => this.switchNameHandler('Nilesh Wani!!!')}>Switch Name</button>
        <Person 
          /* This is how you access the state */
          name={this.state.persons[0].name}
          age={this.state.persons[0].age}/>
        <Person 
          name={this.state.persons[1].name} 
          age={this.state.persons[1].age}
          /* Passing method reference to another component through props */
          /* This is another way to to pass parameter to the method, using 'bind' function */
          click={this.switchNameHandler.bind(this, 'Nilesh!!')}
          changed={this.nameChangedHandler}>
          My Hobbies: Racing
        </Person>
        <Person 
          name={this.state.persons[2].name}
          age={this.state.persons[2].age}/>
      </div>
    );
  }
}

export default App;
