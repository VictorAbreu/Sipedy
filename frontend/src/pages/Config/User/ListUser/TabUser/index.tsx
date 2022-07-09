import Eu from 'assets/images/eu.png'
import { ReactComponent as IconEmail } from 'assets/images/email.svg';
import { ReactComponent as IconCel } from 'assets/images/cel.svg';
import { ReactComponent as IconView } from 'assets/images/olho.svg';
import './styles.css';

const TabUser = () => {

    return (
        <div className="base-card tab-container">
            <div className="container-img-desc">
                <img src={Eu} alt="Sipedy" className="tab-img" />
                <div>
                    <div className="tab-container-desc">
                        <h6>Victor Luiz de Abreu</h6>
                        <div className="tab-desc">
                            <IconEmail />
                            <p>vlabreu@outlook.com</p>
                        </div>
                        <div className="tab-desc">
                            <IconCel />
                            <p>37-99131-3225</p>
                        </div>

                    </div>
                </div>
            </div>

            <div>

                <button className="btn btn-primary tab-container-bt">
                    <IconView />
                    Visualizar
                </button>

            </div>

        </div>
    );
};

export default TabUser;