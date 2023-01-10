import LogoAtas from "../asset/img/logo-ALTA@2x.png"
import "../asset/css/main.css"
import "../asset/css/form.css"
import "../asset/css/bootstrap.min.css"
import { Link } from "react-router-dom"
import Sidebar from "./Sidebar"

export default function Header() {
    return (
        <div>
            <header>
                <div className="container">
                    <Sidebar />
                    <div className="row align-items-center">
                        <div className="col-lg-8 col-md-12 col-sm-12 col-12">
                            <div className="alterra">
                                <Link to={'/'}><img className="logo-atas" src={LogoAtas} /></Link>
                            </div>
                        </div>
                        <div className="col-lg-4 col-md-12 col-sm-12 col-12">
                            {/* <div class="container"> */}
                            <div className="row align-items-center navig">
                                <div className="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-right"><Link to={'/'} className="aktif">HOME</Link></div>
                                <div className="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-center"><Link to={'/about'}>ABOUT</Link></div>
                                <div className="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-left"><Link to={'/todos'}>TODOS</Link></div>
                                <div className="col-lg-3 col-md-3 col-sm-3 text-md-center text-sm-center text-lg-right"><Link to={'/form'}>FORM</Link></div>
                            </div>
                            {/* </div> */}
                        </div>
                    </div>
                </div>
            </header >
        </div>
    )
}