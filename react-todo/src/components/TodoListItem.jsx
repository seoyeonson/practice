function TodoListItem({ todo, onDelete, onToggle }) {
    return (
        <div style={{ textDecoration: todo.checked ? "line-through" : "none" }}>
        <input
          type="checkbox"
          checked={todo.checked}
          onChange={() => onToggle(todo.id)}
        />
        <span>
          {todo.id}. {todo.text}
        </span>
        <button onClick={() => onDelete(todo.id)}>삭제</button>
      </div>
    );
}

export default TodoListItem;