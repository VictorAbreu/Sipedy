import './styles.css';
import { ReactComponent as IconAddUser } from '../../../assets/images/addusuario.svg';
import { ReactComponent as IconBack } from '../../../assets/images/voltar.svg';
import { ReactComponent as IconClear } from '../../../assets/images/limpar.svg';
import { ReactComponent as IconDel } from '../../../assets/images/excluir.svg';
import { ReactComponent as IconSave } from '../../../assets/images/salvar.svg';
import BottonBar from 'components/BottonBar';

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

            <div className="inputs-area-container">
                <div className="base-card form-container">
                    <div className="form-container-bar">
                        <h6>Dados do cliente</h6>
                    </div>

                    <div>
                        <input className="base-input input-full" type="text" placeholder="Nome / Razão social" />
                        <div className="group-three">
                            <input className="base-input input-three" type="text" placeholder="CPF / CNPJ" />
                            <input className="base-input input-three" type="text" placeholder="RG / Insc. estadual" />
                            <input className="base-input" type="text" placeholder="CEP" />
                        </div>
                        <div className="group-three">
                            <input className="base-input input-three" type="text" placeholder="Endereço" />
                            <input className="base-input input-three" type="text" placeholder="Cidade" />
                            <input className="base-input" type="text" placeholder="Estado" />
                        </div>
                        <input className="base-input input-full" type="text" placeholder="Contato" />
                        <div className="group-three">
                            <input className="base-input input-three" type="text" placeholder="Telefone" />
                            <input className="base-input input-three" type="text" placeholder="Celular" />
                            <input className="base-input" type="text" placeholder="E-mail" />
                        </div>
                    </div>
                </div>
            </div>
            <BottonBar />
        </div>
    );
};

export default CadCliente;