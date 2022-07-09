import './styles.css';
import { ReactComponent as IconBack } from 'assets/images/voltar.svg';
import { ReactComponent as IconList } from 'assets/images/lista.svg';

const ActionBar = () => {

    return (

        <div className="base-card baruserlist-nav-container">

            <IconList />
            <h5>Lista de usuários</h5>
            <input type="text" placeholder="Pesquisa nome" className="base-input" />

            <div className="adduser-action">
                <div className="adduser-action-item">
                    <button className="button-input">
                        <IconBack className="bar-icon" />
                        <h5>Voltar</h5>
                    </button>
                </div>

            </div>
        </div>

    );
};

export default ActionBar;