import Background from "../Background.jsx";
import './SignUpForm.css'
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {useState} from "react";
import {Toast} from "bootstrap";
import ToastPinup from "../Toast/ToastPinup.jsx";

export default function SignUpForm(){
    const [account, setAccount] = useState({
        username: '',
        email: '',
        password: ''
    });

    const [errors, setErrors] = useState({});

    const navigate = useNavigate();


    const validate = () => {
        const validationErrors = {};
        if (account.username.trim() === '') {
            validationErrors.username = 'Username is required!';
        }
        if (account.email.trim() === '') {
            validationErrors.email = 'Email is required!';
        }
        if (account.password.trim() === '') {
            validationErrors.password = 'Password is required!';
        }
        return Object.keys(validationErrors).length === 0 ? null :
            validationErrors;
    };

    async function sendSignUpRequest(event){
        event.preventDefault();
        const validationErrors = validate();
        setErrors(validationErrors || {});

        if (validationErrors) {
            showToast();
            return
        }


        await axios({
            method: 'post',
            url: 'http://localhost:8080/api/auth/register',
            data: {
                username: account.username,
                email: account.email,
                password: account.password
            }
        }).then( (response) => {
            console.log(response.data)
            if(response.status === 200){
                navigate("/")
            }
        }).catch((error) => {
            console.log(error.data)
        });
    }

    const handleChange = (event) => {
        const {name, value} = event.target;
        setAccount((prevAccount) => ({
            ...prevAccount,
            [name]: value
        }));
    };

    const showToast = () => {
        const toastElement = document.getElementById("liveToast");
        const toast = Toast.getOrCreateInstance(toastElement);
        toast.show();
    };

    console.log(errors)
    return (
        <>
            <Background>
                <div className="wrapper">
                    <div className="title">
                        Sign up form
                    </div>
                    <form onSubmit={sendSignUpRequest}>
                        <div className="field">
                            <input
                                value={account.username}
                                name="username"
                                onChange={handleChange}
                                type="text"
                                className="form-control"
                                id="username"
                                aria-describedby="emailHelp"
                                placeholder="Username"/>
                            <label>Your username</label>
                        </div>
                        <div className="field">
                            <input
                                value={account.email}
                                name="email"
                                onChange={handleChange}
                                type="email"
                                className="form-control"
                                id="email"
                                aria-describedby="emailHelp"
                                placeholder="Email"/>
                            <label>Your email</label>
                        </div>
                        <div className="field">
                            <input
                                value={account.password}
                                name="password"
                                onChange={handleChange}
                                type="password"
                                className="form-control"
                                id="password"
                                placeholder="Password"/>
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
                            <input type="submit" value="Sign up now"/>
                        </div>
                    </form>
                </div>
                <ToastPinup/>
            </Background>
        </>
    )
}