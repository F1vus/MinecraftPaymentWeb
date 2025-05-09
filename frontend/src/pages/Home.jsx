import React from 'react';
import FirstPart from "../components/FirstPart.jsx";
import SecondPart from "../components/SecondPart.jsx";
import Header from "../components/Header.jsx";

const Home = () => {
    return (
        <>
            <Header/>
            <FirstPart/>
            <SecondPart/>
        </>
    );
};

export default Home;