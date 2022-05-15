import './styles.css';
import { ReactComponent as IconHome } from '../../assets/images/home.svg';
import { ReactComponent as IconCliente } from '../../assets/images/clientes.svg';
import { ReactComponent as IconFornecedor } from '../../assets/images/fornecedor.svg';
import { ReactComponent as IconProduto } from '../../assets/images/produto.svg';
import { ReactComponent as IconPedido } from '../../assets/images/pedidos.svg';
import { ReactComponent as IconTarefa } from '../../assets/images/tarefas.svg';
import { ReactComponent as IconFinanceiro } from '../../assets/images/financeiro.svg';
import { ReactComponent as IconLembrete } from '../../assets/images/lembrete.svg';
import { ReactComponent as IconMensagem } from '../../assets/images/mensagens.svg';
import { ReactComponent as IconConfig } from '../../assets/images/config.svg';
import { NavLink } from 'react-router-dom';

const NavBarLateral = () => {
    return (
        <nav className="bar-container">

            <ul>

                <li>
                    <NavLink to="/home/dash" className="item-menu-container">
                        <IconHome />
                        <h5> Home</h5>
                    </NavLink>

                </li>

                <li className="item-menu-container">
                    <IconCliente />
                    <h5> Clientes</h5>
                </li>

                <li className="item-menu-container">
                    <IconFornecedor />
                    <h5> Fornecedores</h5>
                </li>

                <li className="item-menu-container">
                    <IconProduto />
                    <h5> Produtos</h5>
                </li>

                <li className="item-menu-container">
                    <IconPedido />
                    <h5> Pedidos</h5>
                </li>

                <li className="item-menu-container">
                    <IconTarefa />
                    <h5> Tarefas</h5>
                </li>

                <li className="item-menu-container">
                    <IconFinanceiro />
                    <h5> Financeiro</h5>
                </li>

                <li className="item-menu-container">
                    <IconLembrete />
                    <h5> Lembretes</h5>
                </li>

                <li className="item-menu-container">
                    <IconMensagem />
                    <h5> Mensagens</h5>
                </li>

                <li>
                    <NavLink to="/home/config" className="item-menu-container">
                        <IconConfig />
                        <h5> Configurações</h5>
                    </NavLink>
                </li>

            </ul>

        </nav>
    );
};

export default NavBarLateral;