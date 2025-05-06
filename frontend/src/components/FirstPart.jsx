import './css_components/FirstPart.css'
import point from '/point.png'
import shop_car from '/icon/shopping-cart.svg'

export default function FirstPart(){

    return (
        <div className="bg">
            <div className="overlay">
                <main className="main-center">
                    <h1>MINECRAFT_SHOP.FIV</h1>
                    <p>Online on the server</p>
                    <p id="p-online">
                        <img className="green-point" src={point} alt="green point"/>
                        0 from 999 Players
                    </p>
                    <div className="div-button-shop">
                        <a className="a-button-shop" href="#shop">
                            <img className="shop_car" src={shop_car} alt="green point" width="16" height="16"/>
                            To shop
                        </a>
                    </div>
                </main>
            </div>

        </div>
    )

}