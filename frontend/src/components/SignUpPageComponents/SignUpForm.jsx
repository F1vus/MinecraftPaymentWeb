import Background from "../Background.jsx";
import './SignUpForm.css'
import axios from "axios";
import { redirect } from "react-router-dom";

export default function SignUpForm(){


    async function sendSignUpRequest(){
        const usernameDoc = document.getElementById("username");
        const emailDoc = document.getElementById("email");
        const passwordDoc = document.getElementById("password");

        await axios({
            method: 'post',
            url: 'http://localhost:8080/auth/signup',
            data: {
                username: usernameDoc.value,
                email: emailDoc.value,
                password: passwordDoc.value
            }
        }).then( (response) => {
            console.log(response.data)
            if(response.status === 200){
                redirect("/")
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
                        Sign up form
                    </div>
                    <form>
                        <div className="field">
                            <input id="username" type="text" required/>
                            <label>Your username</label>
                        </div>
                        <div className="field">
                            <input id="email" type="email" required/>
                            <label>Your email</label>
                        </div>
                        <div className="field">
                            <input id="password" type="password" required/>
                            <label>Create your password </label>
                        </div>
                        {/*<div className="content">*/}
                        {/*    <div className="checkbox">*/}
                        {/*        <input type="checkbox" id="remember-me"/>*/}
                        {/*        <label htmlFor="remember-me">Remember me</label>*/}
                        {/*    </div>*/}
                        {/*    <div className="pass-link">*/}
                        {/*        <a href="#">Forgot password?</a>*/}
                        {/*    </div>*/}
                        {/*</div>*/}
                        <div className="field">
                            <input type="button" onClick={sendSignUpRequest} value="Sign up"/>
                        </div>
                    </form>
                </div>
            </Background>
        </>
    )
}