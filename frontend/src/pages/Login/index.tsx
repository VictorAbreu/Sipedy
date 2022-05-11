import NavBarLogin from './components/NavBarLogin';
import './styles.css';
import Logo from 'assets/images/Sipedy.png'

const Login = () => {

    return (

        <div>
            <NavBarLogin />
            <div className="base-card login-form-container">
                <img src={Logo} alt="Sipedy" className="login-img-container" />
                <h4>Acesso ao sistema</h4>
            </div>
        </div>

    );
};

export default Login;