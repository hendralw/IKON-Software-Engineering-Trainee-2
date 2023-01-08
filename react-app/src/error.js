import { Link } from "react-router-dom"
import "./error.scss"
export default function error() {
    return (
        <div>
            <div className="face">
                <div className="band">
                    <div className="red" />
                    <div className="white" />
                    <div className="blue" />
                </div>
                <div className="eyes" />
                <div className="dimples" />
                <div className="mouth" />
            </div>
            <h1 className="h1-error">Oops! Something went wrong!</h1>

            <Link to={'/'} style={{ color: "black", textDecoration: "none" }}>
                <div className="btn-error">
                    Return to Home
                </div>
            </Link>
        </div>
    )


}
