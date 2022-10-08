import { ReactComponent as IconEmail } from 'assets/images/email.svg';
import { ReactComponent as IconCel } from 'assets/images/cel.svg';
import { ReactComponent as IconView } from 'assets/images/olho.svg';
import { ReactComponent as IconLista } from 'assets/images/clienteslista.svg';
import { ReactComponent as IconContato } from 'assets/images/cracha1.svg';
import './styles.css';
import { NavLink } from 'react-router-dom';
import { Cliente } from 'type/cliente';

type Props = {
    cliente: Cliente
}

const TabUser = ({ cliente }: Props) => {


    return (
        <div className="base-card tab-container">
            <div className="container-img-desc">
                <IconLista className="tab-img" />
                <div>
                    <div className="tab-container-desc">
                        <h6>{`${cliente.nomeRazao}`}</h6>
                        <div className="tab-desc">
                            <IconContato />
                            <p>{cliente.contato}</p>
                        </div>
                        <div className="tab-desc">
                            <IconEmail />
                            <p>{cliente.email}</p>
                        </div>
                        <div className="tab-desc">
                            <IconCel />
                            <p>{cliente.celular}</p>
                        </div>

                    </div>
                </div>
            </div>

            <div>

                <NavLink to={`/home/cadcliente/${cliente.id}`}>
                    <button className="btn btn-primary tab-container-bt">
                        <IconView />
                        Visualizar
                    </button>
                </NavLink>


            </div>

        </div>
    );
};

export default TabUser;