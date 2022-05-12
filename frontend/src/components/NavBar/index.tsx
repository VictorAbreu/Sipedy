import './styles.css';
import Logo from 'assets/images/Sipedy.png'

const NavBar = () => {

    return (
        <div className="navbarlogin-container">
            <div className="navbar-container-imagem">
                <img src={Logo} alt="Sipedy" className="navbar-img-container" />
            </div>
        </div>
    );
};

export default NavBar;