import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person';

class App extends Component {

  state = {
    persons: [
      {id: 10, name: "Nilesh", age: 39},
      {id: 20, name: "Milind", age: 38},
      {id: 30, name: "Jay", age: 40}
    ]
  };

  deletePersonhandler = (personIndex) => {
    // const persons = this.state.persons.slice();
    const persons = [...this.state.persons];
    persons.splice(personIndex, 1);
    this.setState({persons: persons});
  }

  nameChangedHandler = (event, id) => {
    const personIndex = this.state.persons.findIndex(p => {
      return p.id === id;
    });

    const person = {...this.state.persons[personIndex]};
    person.name = event.target.value;

    const persons = [...this.state.persons];
    persons[personIndex] = person;

    this.setState({persons: persons});
  }

  togglePersonHandler = () => {
    const doesShow = this.state.showPersons;
    this.setState({showPersons: !doesShow});
  }

  render() {
    const buttonStyle = {
      backgroundColor: 'green',
      color: 'white',
      font: 'inherit',
      border: '1px solid blue',
      padding: '8px',
      cursor: 'pointer'
    }

    let persons = null;

    if(this.state.showPersons) {
      persons = (
        <div>
          {
            this.state.persons.map((person, index) => {
              return <Person 
                      click={this.deletePersonhandler.bind(this, index)}
                      changed={(event) => this.nameChangedHandler(event, person.id)}
                      name={person.name} 
                      age={person.age}
                      key={person.id}/>
            })
          }
        </div>
      );

      buttonStyle.backgroundColor = 'red';
    }

    const classes = [];

    if(this.state.persons.length <= 2) {
      classes.push('red');

      if(this.state.persons.length <= 1) {
        classes.push('bold');
      }
    }

    return (
      <div className="App">
        <p className={classes.join(' ')}>Hi, I am a React App!</p>
        <button 
          style={buttonStyle}
          onClick={this.togglePersonHandler}>Toggle Persons</button>
        {persons}
      </div>
    );
  }
}

export default App;