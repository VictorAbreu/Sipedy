import './styles.css';

type Props = {
    icon: string;
    tituloArea: string;
}

const CardArea = ({ icon, tituloArea }: Props) => {

    return (
        <div className="cardarea-container">
            <img src={icon} alt="Icon" />
            <h6>{tituloArea}</h6>
        </div>

    );
};

export default CardArea;