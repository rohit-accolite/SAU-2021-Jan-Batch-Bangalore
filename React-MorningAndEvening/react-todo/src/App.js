import './App.css';
import Forms from './components/Forms';
import TodoList from "./components/TodoList";
import React, { useState } from 'react';

function App() {
  const [inputText, setInputText] = useState("");
  const [todos, setTodos] = useState([]);
  
  return (
    <div className="App">
      <header>
        <h1 className="App-header">ToDo List </h1>
      </header>
      <Forms todos={todos} setTodos={setTodos} inputText={inputText} setInputText={setInputText}/>
      <TodoList todos={todos} setTodos={setTodos}/>
    </div>
  );
}

export default App;
