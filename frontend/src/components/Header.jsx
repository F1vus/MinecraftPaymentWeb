import './css_components/Header.css'
import logo from '/second_logo.png'

function Header(){
    return(
        <header id='navigation'>
            <div className='blure'></div>
            <img className='logo' src={logo} alt='minecraft logo'/>
            <div>
                <p>Towary</p>
            </div>
        </header>
    )
}

export default Header;