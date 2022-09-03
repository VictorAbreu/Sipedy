import { NavLink } from 'react-router-dom';
import './styles.css';

type Props = {
    icon: string;
    tituloArea: string;
    to: string;
}

const CardArea = ({ icon, tituloArea, to }: Props) => {

    return (
        <NavLink to={to} className="cardarea-container">
            <img src={icon} alt="Icon" />
            <h6>{tituloArea}</h6>
        </NavLink>
    );
};

export default CardArea;