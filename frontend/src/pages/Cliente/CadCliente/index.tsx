import './styles.css';
import { ReactComponent as IconAddUser } from '../../../assets/images/addusuario.svg';
import { ReactComponent as IconBack } from '../../../assets/images/voltar.svg';
import { ReactComponent as IconClear } from '../../../assets/images/limpar.svg';
import { ReactComponent as IconDel } from '../../../assets/images/excluir.svg';
import { ReactComponent as IconSave } from '../../../assets/images/salvar.svg';

const CadCliente = () => {

    return (
        <div className="cadcliente-page">
            <div className="base-card actionbar-container">
                <div className="infobar-container">
                    <IconAddUser className="bar-icon" />
                    <h5>Cadastro de clientes</h5>
                </div>

                <div className="adduser-action">
                    <div className="adduser-action-item">
                        <button className="button-input">
                            <IconBack className="bar-icon" />
                            <h5>Voltar</h5>
                        </button>
                    </div>
                    <div className="adduser-action-item">
                        <button className="button-input">
                            <IconClear className="bar-icon" />
                            <h5>Limpar</h5>
                        </button>
                    </div>
                    <div className="adduser-action-item">
                        <IconDel className="bar-icon" />
                        <h5>Excluir</h5>
                    </div>
                    <div className="adduser-action-item">
                        <button className="button-input">
                            <IconSave className="bar-icon" />
                            <h5>Salvar</h5>
                        </button>
                    </div>

                </div>
            </div>
        </div>
    );
};

export default CadCliente;