import './styles.css';
import Eu from 'assets/images/eu.png'
import { ReactComponent as IconEmail } from 'assets/images/email.svg';
import { ReactComponent as IconCel } from 'assets/images/cel.svg';
import { ReactComponent as IconView } from 'assets/images/olho.svg';

const CardListUser = () => {

    return (
        <div className="base-card carduser-container">
            <div className="carduser-img-container">
                <img src={Eu} alt="Sipedy" className="navbar-img-container" />
            </div>

            <div className="carduser-desc-container">
                <h6>Victor Luiz de Abreu</h6>
                <div className="carduser-contato">
                    <IconEmail />
                    <p>vlabreu@outlook.com</p>
                </div>
                <div className="carduser-contato">
                    <IconCel />
                    <p>37-99131-3225</p>
                </div>
            </div>
            <div>
                <button className="carduser-bt-container">
                    <IconView />
                </button>
            </div>

        </div>
    );
};

export default CardListUser;