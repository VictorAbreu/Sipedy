
import { useContext, useState } from "react";
import { useHistory, useLocation } from "react-router-dom";
import "./styles.css";
import { requestBackendLogin } from 'util/requests';
import { AuthContext } from 'AuthContext';
import { saveAuthData } from 'util/storage';
import { getTokenData } from 'util/auth';
import { useForm } from 'react-hook-form';
import Logo from 'assets/images/Sipedy.png'
import ButtonIcon from "components/ButtonIcon";

const Login = () => {

    type FormData = {
        username: string;
        password: string;
    };

    type LocationState = {
        from: string;
    }

    const location = useLocation<LocationState>();

    const { from } = location.state || { from: { pathname: '/home' } }

    const { setAuthContextData } = useContext(AuthContext);

    const [hasError, setHasError] = useState(false);

    const { register, handleSubmit, formState: { errors } } = useForm<FormData>();

    const history = useHistory();

    const onSubmit = (formData: FormData) => {
        requestBackendLogin(formData)
            .then((response) => {
                saveAuthData(response.data);
                setHasError(false);
                setAuthContextData({
                    authenticated: true,
                    tokenData: getTokenData(),
                })
                history.replace(from)
            })
            .catch((error) => {
                setHasError(true);
                console.log('ERRO', error);
            });
    };

    return (

        <div className="login-container">
            <div className="base-card login-form-container">
                <div className="login-container-imagem">
                    <img src={Logo} alt="Sipedy" className="login-img-container" />
                </div>
                <div className="form-login-container">
                    <h3>Acesso ao sistema</h3>
                    {hasError && (
                        <div className="alert alert-danger">
                            Usuário ou senha não foram encontrados!
                        </div>
                    )}
                    <form onSubmit={handleSubmit(onSubmit)}>
                        <input
                            {...register('username', {
                                required: 'Campo obrigatório',
                                pattern: {
                                    value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                                    message: 'Email inválido'
                                }
                            })}
                            type="text"
                            className={`form-control base-input input-custom`}
                            placeholder="Email"
                            name="username"
                        />
                        <div className="invalid-feedback d-block" >{errors.username?.message}</div>

                        <input
                            {...register('password', {
                                required: 'Campo obrigatório'
                            })}
                            type="password"
                            className={`form-control base-input`}
                            placeholder="Password"
                            name="password"
                        />
                        <div className="invalid-feedback d-block">{errors.password?.message}</div>
                        <ButtonIcon text="Entrar"></ButtonIcon>
                    </form>
                    <a href="/"><p>Esqueci minha senha</p></a>
                    <h6 className="text-dev">Desenvolvido por Victor Abreu</h6>
                </div>
            </div>
        </div>

    );
};

export default Login;