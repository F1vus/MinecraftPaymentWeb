import './css_components/Header.css'
import logo from '/second_logo.png'
import {Link} from "react-router-dom";
import {useEffect, useState} from "react";

function Header(){

    const [token, setToken] = useState('');

    useEffect(() => {
        console.log("use effect "+localStorage.getItem("token"));
        setToken(localStorage.getItem("token"));
    }, []);

    function logout(){
        localStorage.removeItem("token");
    }

    return(
        <header id='navigation'>
            <div className='blure'></div>
            <Link id="link-logo" to="/"><img className='logo' src={logo} alt='minecraft logo'/></Link>
            <div>
                <p>Towary</p>
            </div>
            {
                token !== null ?
                    <div className="div-user-login-buttons">
                        <div>
                            <Link className="a-signup" to='/user'>
                                user
                            </Link>
                        </div>
                        <div>
                            <Link onClick={logout} className="a-login" to='/'>
                                logout
                            </Link>
                        </div>
                    </div>
                    : null
            }
            {
                token === null ?
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
                    : null
            }

        </header>
    )
}

export default Header;