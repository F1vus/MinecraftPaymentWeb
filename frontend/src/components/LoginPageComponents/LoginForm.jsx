import Background from "../Background.jsx";
import {Link, useNavigate} from "react-router-dom";
import './LoginForm.css'
import axios from "axios";

export default function LoginForm(){

    const navigate = useNavigate();

    async function sendLoginpRequest(){
        const usenameDoc = document.getElementById("username");
        const passwordDoc = document.getElementById("password");



        await axios({
            method: 'post',
            url: 'http://localhost:8080/auth/signin',
            data: {
                username: usenameDoc.value,
                password: passwordDoc.value
            }
        }).then( (response) => {
            console.log(response.data)
            if(response.status === 200){
                localStorage.setItem("token", response.data);
                navigate("/");
            }
        }).catch((error) => {
            console.log(error.data)
        });
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
                            <input id="username" type="text" required/>
                            <label>Username</label>
                        </div>
                        <div className="field">
                            <input id="password" type="password" required/>
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
                            <input type="button" onClick={sendLoginpRequest} value="Signin"/>
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