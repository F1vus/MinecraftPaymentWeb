import React from 'react';
import AddProductForm from "../components/UserPageComponents/AddProduct.jsx";
import Header from "../components/Header.jsx";
import "../components/css_components/User.css"
import Background from "../components/Background.jsx";


const User = () => {

    return (
        <>
            <Header/>
            <Background>
                <div id="con" className="container-md">
                    <AddProductForm/>
                </div>
            </Background>

        </>

    );
};

export default User;