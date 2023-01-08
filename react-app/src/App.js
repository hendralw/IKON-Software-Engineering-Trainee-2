import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import { ReactDOM, useState } from 'react';
import Judul from './TodoTitle.js';
import Home from './home.js';
import About from './About.js';
import Todo from './Todo.js';
import Error from './error';
import { BrowserRouter, Link, Redirect, Route, Routes } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Offcanvas from 'react-bootstrap/Offcanvas';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBars, faHouse, faInfoCircle, faCheckCircle } from '@fortawesome/free-solid-svg-icons';
let nextId = 3;

function App() {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  return (
    <BrowserRouter>
      <div>
        <Button className='button-nav' variant="" onClick={handleShow} >
          <div className='scale-15'>
            <FontAwesomeIcon icon={faBars} />
          </div>
        </Button>

        <Offcanvas show={show} onHide={handleClose}>
          <Offcanvas.Header closeButton>
            <Offcanvas.Title>Menu</Offcanvas.Title>
          </Offcanvas.Header>
          <Offcanvas.Body>
            <ul >
              <li className='li-5'>
                <FontAwesomeIcon icon={faHouse} style={{ marginRight: "10px", color: "grey" }} />
                <Link to="/" style={{ color: "black", textDecoration: "none" }}>Home</Link>
              </li>
              <li className='li-5'>
                <FontAwesomeIcon icon={faInfoCircle} style={{ marginRight: "10px", color: "grey" }} />
                <Link to="/about" style={{ color: "black", textDecoration: "none" }}>About</Link>
              </li>
              <li className='li-5'>
                <FontAwesomeIcon icon={faCheckCircle} style={{ marginRight: "10px", color: "grey" }} />
                <Link to="/todos" style={{ color: "black", textDecoration: "none" }}>Todos App</Link>
              </li>
              <li className='li-5'>
                <FontAwesomeIcon icon={faCheckCircle} style={{ marginRight: "10px", color: "grey" }} />
                <Link to="/error" style={{ color: "black", textDecoration: "none" }}>Error</Link>
              </li>
              <li className='li-5'>
                <FontAwesomeIcon icon={faCheckCircle} style={{ marginRight: "10px", color: "grey" }} />
                <Link to="/error" style={{ color: "black", textDecoration: "none" }}>Form</Link>
              </li>
            </ul>
          </Offcanvas.Body>
        </Offcanvas>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/todos" element={<Todo />} />
          <Route path="/form" element={<Error />} />
          <Route path="*" element={<Error />} />
        </Routes>
      </div >
    </BrowserRouter >
  );
}

export default App;