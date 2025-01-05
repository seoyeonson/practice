import { useRef, useState } from 'react';
import './App.css'
import TodoInsert from './components/TodoInsert';
import TodoList from './components/TodoList';

function App() {
  // 로직
  const [todos, setTodos] = useState([
    {
        id:1, 
        text: "공부", 
        checked: true,
    }, 
    {
        id:2, 
        text: "운동", 
        checked: true,
    }, 
    {
        id:3, 
        text: "명상", 
        checked: false,
    }
  ]);

  const nextId = useRef(4);

  const onInsert = (text)=> {
    setTodos(
        todos.concat([{
          id: nextId.current, 
          text: text, 
          checked: false,
        },
      ])
    );
    nextId.current++;
  };

  const onDelete = (id) => {
    setTodos(todos.filter(todo => todo.id !== id));
  };

  const onToggle = (id) => {
    setTodos(todos.map(todo =>
      todo.id === id ? {...todo, checked: !todo.checked} : todo
    ))
  };

  // view
  return (
  <div>
    <TodoInsert onInsert={onInsert} />
    <TodoList todos={todos} onDelete={onDelete} onToggle={onToggle}/>
  </div>
  );
}

export default App;
