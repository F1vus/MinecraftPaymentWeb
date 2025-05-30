import Background from "../Background.jsx";
import {Link, useNavigate} from "react-router-dom";
import './LoginForm.css'
import axios from "axios";
import {useState} from "react";
import {Toast} from "bootstrap";
import ToastPinup from "../Toast/ToastPinup.jsx";

export default function LoginForm(){

    const navigate = useNavigate();

    const [account, setAccount] = useState({
        username: "",
        password: ""
    });

    const [errors, setErrors] = useState({});

    const validate = () => {
        const errors = {};
        if (account.username.trim() === "") {
            errors.username = "Username is required!";
        }
        if (account.password.trim() === "") {
            errors.password = "Password is required!";
        }


        return Object.keys(errors).length === 0 ? null : errors;
    };

    async function sendLoginRequest(event){
        event.preventDefault();

        const errors = validate();
        setErrors(errors || {});

        showToast();
        if (errors) return;


        await axios({
            method: 'post',
            url: 'http://localhost:8080/auth/signin',
            data: {
                username: account.username,
                password: errors.password
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

    const handleChange = (event) => {
        const { name, value } = event.currentTarget;
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
                        Login form
                    </div>
                    <form onSubmit={sendLoginRequest}>
                        <div className="field">
                            <input
                                value={account.username}
                                name="username"
                                onChange={handleChange}
                                type="text"
                                className="form-control"
                                id="username"
                                aria-describedby="emailHelp"
                            />
                            <label>Username</label>
                        </div>
                        <div className="field">
                            <input
                                value={account.password}
                                name="password"
                                onChange={handleChange}
                                type="password"
                                className="form-control"
                                id="password"
                            />
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
                            <input
                                type="submit" value="Login"
                            />
                        </div>
                        <div className="signup-link">
                            Not a member? <Link to="/signup">Signup now</Link>
                        </div>
                    </form>
                </div>
                <ToastPinup/>
            </Background>
        </>
    )
}