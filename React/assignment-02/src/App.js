import React, { Component } from 'react';
import './App.css';
import Validation from './Validation/Validation';
import Char from './Char/Char';

class App extends Component {

  state = {
    userInput: ''
  }

  inputChangeHandler = (event) => {
    this.setState({
      userInput: event.target.value
    });
  }

  deleteCharHandler = (index) => {
    const initialText = this.state.userInput.split('');
    initialText.splice(index, 1);
    const updatedText = initialText.join('');
    this.setState({
      userInput: updatedText
    });
  }

  render() {

    let charList = this.state.userInput.split('').map((ch, index) => {
      return <Char 
              char={ch} 
              key={index}
              clicked={this.deleteCharHandler.bind(this, index)}/>
    });

    return (
      <div className="App">
        <input type="text" onChange={this.inputChangeHandler} value={this.state.userInput}/>
        <p>Text Entered: {this.state.userInput}</p>
        <Validation textLength={this.state.userInput.length}/>
        {charList}
      </div>
    );
  }
}

export default App;