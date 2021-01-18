import React from 'react'
import Todo from './Todo'
import './styles.css'

const TodoList = (props) => {
    return (
        <div className="todo-container">
            <ul className="todo-list">
                {props.todos.map((todo) =>(
                    <Todo text={todo.text} key={todo.id} todo={todo} todos={props.todos} setTodos={props.setTodos}/>
                ))}
            </ul>
        </div>
    );
};

export default TodoList;