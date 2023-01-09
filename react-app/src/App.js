import './App.css'
import 'bootstrap/dist/css/bootstrap.css'
import Home from './pages/Home.js'
import About from './pages/About'
import Todo from './pages/Todo.js'
import Error from './pages/Error'
import Form from './pages/Form'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function App() {
  return (
    <BrowserRouter>
      <div>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/todos" element={<Todo />} />
          <Route path="/form" element={<Form />} />
          <Route path="*" element={<Error />} />
        </Routes>
      </div >
    </BrowserRouter >
  );
}

export default App;