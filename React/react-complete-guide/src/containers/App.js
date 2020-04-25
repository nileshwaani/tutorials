import React, { Component } from 'react';
import styles from './App.module.css';
import Persons from '../components/Persons/Persons';
import Cockpit from '../components/Cockpit/Cockpit';
import WithAnalytics from '../hoc/withAnalytics';
import AuthContext from '../context/auth-context';

class App extends Component {

  constructor(props) {
    super(props);
    this.referenceElement = React.createRef();
  }

  static contextType = AuthContext;

  state = {
    persons: [
      {id: 10, name: "Nilesh", age: 39},
      {id: 20, name: "Milind", age: 38},
      {id: 30, name: "Jay", age: 40}
    ],
    showCockpit: true,
    authenticated: false
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

  toggleCockpitHandler = () => {
    this.setState((prevState, props) => {
      return ({showCockpit: !prevState.showCockpit}); 
    });
  }

  loginHandler = () => {
    this.setState({authenticated: true});
  }

  componentDidMount() {
    console.log('[App.js] - componentDidMount');
    this.inputElement.focus();
    this.referenceElement.current.click();
    console.log('[App.js] - context.authenticated : ' + this.context.authenticated);
  }

  render() {
    let persons = null;
    if(this.state.showPersons) {
      persons = <Persons
                  persons={this.state.persons}
                  clicked={this.deletePersonhandler}
                  changed={this.nameChangedHandler} />;
    }

    let cockpit = null;
    if(this.state.showCockpit) {
      cockpit = <Cockpit 
                  title={this.props.appTitle}
                  showPersons={this.state.showPersons}
                  persons={this.state.persons}
                  clicked={this.togglePersonHandler} />
    }

    return (
      <div className={styles.App}>
        <button 
          ref={this.referenceElement} 
          onClick={this.toggleCockpitHandler}>Toggle Cockpit</button>
        <input ref={(inputEl) => {this.inputElement = inputEl}}/>
        <AuthContext.Provider 
          value={{authenticated: this.state.authenticated, login: this.loginHandler}}>
          {cockpit}
          {persons}
        </AuthContext.Provider>
      </div>
    );
  }
}

export default WithAnalytics(App, 'App');