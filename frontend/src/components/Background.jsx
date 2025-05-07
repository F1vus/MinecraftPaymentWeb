import './css_components/Background.css'

export default function Background({ children }){
    return (
        <div className="bg">
            <div className="overlay">
                {children}
            </div>
        </div>
    )
}