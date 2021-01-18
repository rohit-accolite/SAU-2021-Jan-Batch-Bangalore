import React from 'react'
import './styles.css'

const Form = (props) => {

    const inputTextHandler = (e) => {
        // console.log(e.target.value);
        props.setInputText(e.target.value);
    };

    const submitTodoHandler = (e) => {
        e.preventDefault();
        if (props.inputText !== "") {
            props.setTodos([...props.todos, {text: props.inputText, completed: false, id: Math.random()*1000}]);
            props.setInputText("");
        }
        else alert("Please enter a todo first");
        
    };

    return (
        <form className="App-header">
            <input value={props.inputText} type="text" placeholder="Add a ToDo" className="todo-input" onChange={inputTextHandler}></input>
            <button type="submit" className="clickables" onClick={submitTodoHandler}>Add</button>
        </form>
    );
};

export default Form;