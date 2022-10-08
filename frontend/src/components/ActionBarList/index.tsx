import './styles.css';
import { ReactComponent as IconBack } from 'assets/images/voltar.svg';
import { ReactComponent as IconList } from 'assets/images/lista.svg';
import { NavLink } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import { ReactComponent as SearchIcon } from 'assets/images/pesquisa.svg';

export type FilterData = {
    name: string;
};

type Props = {
    onSubmitFilter: (data: FilterData) => void;
    placeHolder: string;
    titulo: string;
    paginaRetorno: string;
};

const ActionBarList = ({ onSubmitFilter, placeHolder, titulo, paginaRetorno }: Props) => {

    const { register, handleSubmit, setValue } =
        useForm<FilterData>();

    const onSubmit = (formData: FilterData) => {
        onSubmitFilter(formData);
        handleFormClear();
    };

    const handleFormClear = () => {
        setValue('name', '');
    };


    return (

        <div className="base-card baruserlist-nav-container">

            <IconList className="icon-list" />
            <h5>{titulo}</h5>
            <form onSubmit={handleSubmit(onSubmit)}>
                <div className="form-search-container">
                    <input
                        {...register('name')}
                        type="text"
                        className="base-input"
                        placeholder={placeHolder}
                        name="name"
                    />

                    <div className="adduser-action">
                        <div className="search-area">
                            <button className="button-input button-search" >
                                <SearchIcon />
                            </button>
                        </div>

                    </div>
                </div>
            </form>
            <div className="adduser-action">
                <div className="adduser-action-item">
                    <button className="button-input">
                        <NavLink to={`/home/${paginaRetorno}`} className="button-input">
                            <IconBack className="bar-icon" />
                            <h5>Voltar</h5>
                        </NavLink>
                    </button>
                </div>

            </div>
        </div>

    );
};

export default ActionBarList;