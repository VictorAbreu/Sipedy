import './styles.css';
import Logo from 'assets/images/Sipedy.png'
import { useContext, useEffect } from 'react';
import history from 'util/history';
import { AuthContext } from 'AuthContext';
import { getTokenData, isAuthenticated } from 'util/auth';
import { removeAuthData } from 'util/storage';

const NavBar = () => {

    const { authContextData, setAuthContextData } = useContext(AuthContext);

    useEffect(() => {
        if (isAuthenticated()) {
            setAuthContextData({
                authenticated: true,
                tokenData: getTokenData(),
            });
        } else {
            setAuthContextData({
                authenticated: false,
            });
        }
    }, [setAuthContextData]);

    const handleLogoutClick = (event: React.MouseEvent<HTMLAnchorElement>) => {
        event.preventDefault();
        removeAuthData();
        setAuthContextData({
            authenticated: false,
        });
        history.replace('/');
    };

    return (
        <div className="navbarlogin-container">
            <div className="navbar-container-imagem">
                <img src={Logo} alt="Sipedy" className="navbar-img-container" />
            </div>

            <div className="nav-login-logout">
                {authContextData.authenticated ? (
                    <>
                        <span className="nav-username">{authContextData.tokenData?.user_name}</span>
                        <a href="#logout" onClick={handleLogoutClick}>
                            SAIR
                        </a>
                    </>
                ) : (
                    <></>
                )}
            </div>
        </div>


    );
};

export default NavBar;