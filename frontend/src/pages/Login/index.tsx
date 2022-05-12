
import './styles.css';
import Logo from 'assets/images/Sipedy.png'

const Login = () => {

    return (

        <div className="login-container">
            <div className="base-card login-form-container">
                <div className="login-container-imagem">
                    <img src={Logo} alt="Sipedy" className="login-img-container" />
                </div>
                <div className="form-login-container">
                    <h6>Acesso ao sistema</h6>
                    <input type="text" placeholder="Digite seu email" />
                    <input type="password" placeholder="Digite sua senha" />
                    <button className="btn btn-primary btn-entrar">Entrar</button>
                    <a href="/"><p>Esqueci minha senha</p></a>
                    <h6 className="text-dev">Desenvolvido por Victor Abreu</h6>
                </div>
            </div>
        </div>

    );
};

export default Login;