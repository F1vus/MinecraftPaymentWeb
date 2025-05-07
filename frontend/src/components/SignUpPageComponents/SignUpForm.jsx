import Background from "../Background.jsx";
import './SignUpForm.css'

export default function SignUpForm(){

    function sendSignUpRequest(){
        //TODO
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
                            <input type="text" required/>
                            <label>Email Address</label>
                        </div>
                        <div className="field">
                            <input type="password" required/>
                            <label>Password</label>
                        </div>
                        <div className="field">
                            <input type="password-confirm" required/>
                            <label>Confirm you password </label>
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