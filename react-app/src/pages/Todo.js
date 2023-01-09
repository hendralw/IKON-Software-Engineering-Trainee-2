import '../App.css'
import 'bootstrap/dist/css/bootstrap.css'
import { useState } from 'react'
import Judul from '../component/TodoTitle.js'
import Header from '../component/Header'

let nextId = 3;

export default function Todo() {

  const [todo, setTodo] = useState('');
  const [listTodo, setListTodo] = useState(
    [
      {
        id: 1,
        title: "Mengerjakan Exercice",
        isComplete: false
      },
      {
        id: 2,
        title: "Mengerjakan Assesment",
        isComplete: false
      }
    ]
  );

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
            onClick={submitTodo}>
            Submit
          </button>
        </div>
        {
          listTodo.map(data => (
            <div className='container' key={data.id} >
              <ul className="list-group list-group-flush" >
                <li className="list-group-item" >
                  <input className="form-check-input me-1"
                    type="checkbox"
                    checked={data.isComplete}
                    defaultValue id="firstCheckboxStretched"
                    onChange={e => { edit(data.id, data.title, e.target.checked) }} />
                  <label className={data.isComplete ? 'strike-out' : 'none-strike-out'}>{data.title}</label>

                  <button type="button"
                    style={{ background: "#ffffff00", border: "none", position: "", float: 'right', fontSize: "13px" }}
                    onClick={() => remove(data)}>
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

  function submitTodo() {
    if (todo === "") {
      return alert("Please input todo!")
    }

    setTodo('');
    setListTodo([
      ...listTodo,
      { id: nextId++, title: todo, isComplete: false }
    ]);
  }

  function edit(id, title, isComplete) {
    const newTodo = listTodo.map((todo => todo.id === id ? { id, title, isComplete } : todo
    ));
    setListTodo(newTodo);
  }

  function remove(data) {
    console.log("clicked")
    setListTodo(
      listTodo.filter(x =>
        x.id !== data.id)
    );
  }
}
