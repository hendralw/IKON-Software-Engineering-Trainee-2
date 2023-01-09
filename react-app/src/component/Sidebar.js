import { useState } from "react"
import Button from 'react-bootstrap/Button'
import Offcanvas from 'react-bootstrap/Offcanvas'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBars, faHouse, faInfoCircle, faCheckCircle } from '@fortawesome/free-solid-svg-icons'
import { Link } from 'react-router-dom'

export default function Sidebar() {

    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return (
        <div className="float-lg-start button-nav">
            <Button style={{}} variant="" onClick={handleShow} >
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
                            <Link to="/form" style={{ color: "black", textDecoration: "none" }}>Form</Link>
                        </li>
                    </ul>
                </Offcanvas.Body>
            </Offcanvas>
        </div>
    )
}