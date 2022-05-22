import './styles.css';
import { ReactComponent as IconAddUser } from '../../assets/images/addusuario.svg';
import { ReactComponent as IconList } from '../../assets/images/lista.svg';
import { ReactComponent as IconKey } from '../../assets/images/chave.svg';
import { ReactComponent as IconCompany } from '../../assets/images/predio.svg';
import { ReactComponent as IconConfig } from '../../assets/images/configg.svg';
import { NavLink } from 'react-router-dom';

const Config = () => {

    return (

        <div className="row config-container">

            <NavLink to="/home/caduser/create" className="carditem-config-container">
                <IconAddUser />
                <h6>Cadastro de usuários</h6>
            </NavLink>


            <div className="carditem-config-container">
                <IconList />
                <h6>Lista de usuários</h6>
            </div>

            <div className="carditem-config-container">
                <IconKey />
                <h6>Controle de acesso</h6>
            </div>

            <div className="carditem-config-container">
                <IconCompany />
                <h6>Cadastro empresa</h6>
            </div>

            <div className="carditem-config-container">
                <IconConfig />
                <h6>Configurações gerais</h6>
            </div>

        </div>

    );
};

export default Config;