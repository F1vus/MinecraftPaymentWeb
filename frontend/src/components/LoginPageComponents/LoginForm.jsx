import Background from "../Background.jsx";
import {Link} from "react-router-dom";
import './LoginForm.css'

export default function LoginForm(){



    function sendLoginpRequest(){
        //TODO
    }

    return (
        <>
            <Background>
                <div className="wrapper">
                    <div className="title">
                        Login form
                    </div>
                    <form>
                        <div className="field">
                            <input type="text" required/>
                            <label>Email Address</label>
                        </div>
                        <div className="field">
                            <input type="password" required/>
                            <label>Password</label>
                        </div>
                        <div className="content">
                            <div className="checkbox">
                                <input type="checkbox" id="remember-me"/>
                                <label htmlFor="remember-me">Remember me</label>
                            </div>
                            <div className="pass-link">
                                <a href="#">Forgot password?</a>
                            </div>
                        </div>
                        <div className="field">
                            <input type="button" onClick={sendLoginpRequest} value="Login"/>
                        </div>
                        <div className="signup-link">
                            Not a member? <Link to="/signup">Signup now</Link>
                        </div>
                    </form>
                </div>
            </Background>
        </>
    )
}