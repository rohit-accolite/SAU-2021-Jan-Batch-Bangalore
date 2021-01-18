import React from 'react';
import './styles.css'

const Todo = (props) => {

    const deleteHandler = () => {
        props.setTodos(props.todos.filter((el) => el.id !== props.todo.id));
        // console.log(props.todo); 
    };

    const completeHandler = () => {
        props.setTodos(props.todos.map((item, index) => {
            if(item.id === props.todo.id) {
                
                return (
                    {...item, completed: !item.completed}
                );
            }
            return item;
        }));
    };

    return(
        <div className="todo">
            <div className="item">
                <button onClick={completeHandler} className="clickables">Done</button>
                <button onClick={deleteHandler} id="delete" className="clickables">Delete</button>
                <div className="divider"/>
                <li className={`todo-item ${props.todo.completed ? "completed" : ""}`}>{props.text}</li>
            </div>
        </div>
    );
};

export default Todo;
