import { useState } from "react";
import TodoListItem from "./TodoListItem";

function TodoList({ todos, onDelete, onToggle }) {
    return ( 
        <>
            <ul>
                {todos.map((todo) => (
                    <TodoListItem key={todo.id} todo={todo} onDelete={onDelete} onToggle={onToggle}/>
                ))}
            </ul>
        </> 
    );
}

export default TodoList;