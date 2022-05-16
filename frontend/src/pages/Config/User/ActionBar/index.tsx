import './styles.css';
import { ReactComponent as IconAddUser } from '../../../../assets/images/addusuario.svg';
import { ReactComponent as IconBack } from '../../../../assets/images/voltar.svg';
import { ReactComponent as IconClear } from '../../../../assets/images/limpar.svg';
import { ReactComponent as IconDel } from '../../../../assets/images/excluir.svg';
import { ReactComponent as IconSave } from '../../../../assets/images/salvar.svg';

const ActionBar = () => {

    return (

        <div className="base-card bar-nav-container">
            <div className="bar-description">
                <IconAddUser className="bar-icon" />
                <h5>Cadastro de usuários</h5>
            </div>
            <div className="adduser-action">
                <div className="adduser-action-item">
                    <IconBack className="bar-icon" />
                    <h5>Voltar</h5>
                </div>
                <div className="adduser-action-item">
                    <IconClear className="bar-icon" />
                    <h5>Limpar</h5>
                </div>
                <div className="adduser-action-item">
                    <IconDel className="bar-icon" />
                    <h5>Excluir</h5>
                </div>
                <div className="adduser-action-item">
                    <IconSave className="bar-icon" />
                    <h5>Salvar</h5>
                </div>

            </div>
        </div>

    );
};

export default ActionBar;