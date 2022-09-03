import CardArea from 'components/CardArea';
import './styles.css';
import iconCad from '../../assets/images/addusuario.svg';
import iconList from '../../assets/images/lista.svg';
import iconAgenda from '../../assets/images/agenda.svg';
import iconAnota from '../../assets/images/notas.svg';

const Cliente = () => {

    return (
        <div className="cliente-page">
            <div className="row cliente-container">
                <CardArea icon={iconCad} tituloArea="Cadastro de clientes" to="/home/cadcliente/create" />
                <CardArea icon={iconList} tituloArea="Lista de clientes" to="/home/cadcliente/create" />
                <CardArea icon={iconAgenda} tituloArea="Agenda de visitas" to="/home/cadcliente/create" />
                <CardArea icon={iconAnota} tituloArea="Anotações de clientes" to="/home/cadcliente/create" />
            </div>
        </div>
    );
};

export default Cliente;