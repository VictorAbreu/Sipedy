import './styles.css';
import { ReactComponent as Youtube } from 'assets/images/youtube.svg';
import { ReactComponent as Insta } from 'assets/images/insta.svg';

const NavBarLogin = () => {

    return (
        <div className="navbarlogin-container">
            <div className="navbarlogin-container-sociais">
                <h5>Siga-nos</h5>
                <Youtube />
                <Insta />
            </div>
            <div className="navbarlogin-container-contato">
                <h5>Contato</h5>
            </div>
        </div>
    );
};

export default NavBarLogin;