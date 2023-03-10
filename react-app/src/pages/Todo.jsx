import '../App.css'
import 'bootstrap/dist/css/bootstrap.css'
import { useEffect, useState } from 'react'
import Judul from '../component/TodoTitle'
import Header from '../component/Header'
import { useDispatch, useSelector } from 'react-redux'
import { addTodo, removeTodo, editTodo } from "../store/todo"
import { getTodos } from '../api/todos'

export default function Todo() {

  const dispatch = useDispatch();
  const listTodo = useSelector((s) => s.todo.lists);
  console.log(listTodo)
  const [todo, setTodo] = useState('');

  useEffect(() => {
    getTodos(dispatch);
  }, []);

  return (
    <div className="App">
      <Header />
      <header className="App-header container" style={{ width: "450px" }}>
        <Judul />
        <div className='todo-form'>

          <input type="text"
            value={todo}
            className='todo-form-input form-control'
            placeholder='Add todo...'
            onChange={e => setTodo(e.target.value)}
          />

          <button type="button"
            className='btn btn-primary btn-sm btn-block mt-2 mb-2'
            onClick={() =>
              dispatch(
                addTodo({
                  id: listTodo?.length + 1,
                  title: todo,
                  completed: false
                }),
                setTodo("")
              )}

          >
            Submit
          </button>
        </div>
        {
          listTodo?.map((data) => (
            <div className='container' key={data.id} >
              <ul className="list-group list-group-flush" >
                <li className="list-group-item" >
                  <input className="form-check-input me-1"
                    type="checkbox"
                    checked={data.isComplete}
                    defaultValue id="firstCheckboxStretched"
                    onChange={(e) => dispatch(editTodo({
                      id: data.id,
                      title: data.title,
                      completed: e.target.checked
                    }))} />
                  <label className={data.completed ? 'strike-out' : 'none-strike-out'}>{data.title}</label>

                  <button type="button"
                    style={{ background: "#ffffff00", border: "none", position: "", float: 'right', fontSize: "13px" }}
                    onClick={() => dispatch(removeTodo(data.id))}>
                    Delete
                  </button>
                </li>
              </ul>
            </div>
          ))
        }
      </header >
    </div >
  );
}
