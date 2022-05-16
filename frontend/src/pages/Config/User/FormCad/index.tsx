import './styles.css';

const FormCad = () => {

    return (
        <div className="base-card formcad-container">

            <div className="inputs-card-container">
                <div className="input-container">
                    <input type="text" placeholder="Nome" />
                </div>

                <div className="input-container">
                    <input type="text" placeholder="Email" />
                    <input type="password" placeholder="Senha" />
                </div>

                <div className="input-container">
                    <input type="text" placeholder="Celular" />
                    <input type="text" placeholder="CPF" />
                    <input type="text" placeholder="CEP" />
                </div>

                <div className="input-container">
                    <input type="text" placeholder="Nº" className="input-numero" />
                    <input type="text" placeholder="Rua" />
                    <input type="text" placeholder="Bairro" className="input-bairro" />
                </div>

                <div className="input-container">
                    <input type="text" placeholder="Cidade" />
                    <input type="text" placeholder="Estado" className="input-estado" />
                </div>
            </div>
            <div className="input-image-container">

            </div>

        </div>
    );
};

export default FormCad;