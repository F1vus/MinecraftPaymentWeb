import './css_components/FirstPart.css'
import point from '/point.png'
import shop_car from '/icon/shopping-cart.svg'
import Background from "./Background.jsx";
import {useEffect, useState} from "react";
import axios from "axios";

export default function FirstPart(){

    const [playerCount, setPlayerCount] = useState(0);
    const [serverStatus, setServerStatus] = useState(false);
    const [maxPlayerCount, setMaxPlayerCount] = useState(0);


    useEffect(() => {
        fetchInformationAboutServer()
    }, []);

    async function fetchInformationAboutServer(){
        await axios.get('https://api.mcsrvstat.us/3/mc.hypixel.net')
            .then((response) => {
                const data = response.data;

                if (data.online) {
                    setServerStatus(true);
                    setPlayerCount(data.players.online);
                    setMaxPlayerCount(data.players.max);
                } else {
                    setServerStatus(false);
                }
            })
            .catch((error) => {
                console.log(error);
                setServerStatus(false);
            });
    }

    return (
        <Background>
            <main className="main-center">
                <h1>MINECRAFT_SHOP.FIV</h1>
                {serverStatus && <>
                    <p>Online on the server</p>
                    <p id="p-online">
                        <img className="green-point" src={point} alt="green point"/>
                        {playerCount} from {maxPlayerCount} Players
                    </p>
                </>
                }
                {serverStatus === false && <span>Server offline niestiety</span>}
                <div className="div-button-shop">
                    <a className="a-button-shop" href="#shop">
                        <img className="shop_car" src={shop_car} alt="green point" width="16" height="16"/>
                        To shop
                    </a>
                </div>
            </main>
        </Background>
    )

}