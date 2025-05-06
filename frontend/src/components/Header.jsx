import './css_components/Header.css'
import logo from '/second_logo.png'
import {Link} from "react-router-dom";

function Header(){
    return(
        <header id='navigation'>
            <div className='blure'></div>
            <Link id="link-logo" to="/"><img className='logo' src={logo} alt='minecraft logo'/></Link>
            <div>
                <p>Towary</p>
            </div>
            <div className="div-user-login-buttons">
                <div>
                    <Link className="a-signup" to='/signup'>
                        sign up
                    </Link>
                </div>
                <div>
                    <Link className="a-login" to='/login'>
                        login
                    </Link>
                </div>
            </div>

        </header>
    )
}

export default Header;