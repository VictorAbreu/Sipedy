import './styles.css';

import { AxiosRequestConfig } from 'axios';
import { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import { useHistory, useParams } from 'react-router-dom';
import { requestBackend } from 'util/requests';
import { toast } from 'react-toastify';

import { ReactComponent as IconAddUser } from '../../../assets/images/addusuario.svg';
import { ReactComponent as IconBack } from '../../../assets/images/voltar.svg';
import { ReactComponent as IconClear } from '../../../assets/images/limpar.svg';
import { ReactComponent as IconDel } from '../../../assets/images/excluir.svg';
import { ReactComponent as IconSave } from '../../../assets/images/salvar.svg';
import BottonBar from 'components/BottonBar';
import { Cliente } from 'type/cliente';

type UrlParams = {
    clienteId: string;
};

const CadCliente = () => {

    const { clienteId } = useParams<UrlParams>();
    const [id, setId] = useState("");
    const isEditing = clienteId !== 'create';
    const history = useHistory();
    const {
        register,
        handleSubmit,
        formState: { errors },
        setValue,
    } = useForm<Cliente>();

    useEffect(() => {
        if (isEditing) {
            requestBackend({
                url: `/clientes/${clienteId}`,
                withCredentials: true,
            }).then((response) => {
                const cliente = response.data as Cliente;
                setValue('nomeRazao', cliente.nomeRazao);
                setValue('contato', cliente.contato);
                setValue('cpfCnpj', cliente.cpfCnpj);
                setValue('rgIe', cliente.rgIe)
                setValue('cep', cliente.cep);
                setValue('endereco', cliente.endereco);
                setValue('cidade', cliente.cidade);
                setValue('estado', cliente.estado);
                setValue('telefone', cliente.telefone);
                setValue('celular', cliente.celular);
                setValue('email', cliente.email);
            });
        }
    }, [isEditing, clienteId, setValue]);

    const onSubmit = (formData: Cliente) => {
        const data = {
            ...formData,
            roles: [{ "id": parseInt(id) }],
        };
        const config: AxiosRequestConfig = {
            method: isEditing ? 'PUT' : 'POST',
            url: isEditing ? `/clientes/${clienteId}` : '/clientes',
            data: data,
            withCredentials: true,
        };

        requestBackend(config)
            .then(() => {
                toast.info('Cliente cadastrado com sucesso!')
                console.log('Dados', data);
                history.push('/home/cliente');
            }).catch((error) => {
                toast.error('Erro ao cadastrar cliente');
            });
    };

    const handleCancel = () => {
        history.push('/home/cliente');
    };

    const handleClean = () => {
        setValue('nomeRazao', "");
        setValue('contato', "");
        setValue('cpfCnpj', "");
        setValue('rgIe', "");
        setValue('cep', "");
        setValue('endereco', "");
        setValue('cidade', "");
        setValue('estado', "");
        setValue('telefone', "");
        setValue('celular', "");
        setValue('email', "");
        setId("");
    };

    return (
        <div className="cadcliente-page">
            <div className="base-card actionbar-container">
                <div className="infobar-container">
                    <IconAddUser className="bar-icon" />
                    <h5>Cadastro de clientes</h5>
                </div>

                <div className="adduser-action">
                    <div className="adduser-action-item">
                        <button className="button-input" onClick={handleCancel}>
                            <IconBack className="bar-icon" />
                            <h5>Voltar</h5>
                        </button>
                    </div>
                    <div className="adduser-action-item">
                        <button className="button-input" onClick={handleClean}>
                            <IconClear className="bar-icon" />
                            <h5>Limpar</h5>
                        </button>
                    </div>
                    <div className="adduser-action-item">
                        <IconDel className="bar-icon" />
                        <h5>Excluir</h5>
                    </div>
                    <div className="adduser-action-item">
                        <button className="button-input" onClick={handleSubmit(onSubmit)}>
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

                        <form onSubmit={handleSubmit(onSubmit)}>
                            <input
                                {...register('nomeRazao', {
                                    required: 'Campo obrigatório',
                                })}
                                type="text"
                                className={`base-input input-full ${errors.nomeRazao ? 'is-invalid' : ''
                                    }`}
                                placeholder="Nome / Razão social"
                                name="nomeRazao"
                            />

                            <div className="group-three">

                                <input
                                    {...register('cpfCnpj', {
                                        required: 'Campo obrigatório',
                                    })}
                                    type="text"
                                    className={`base-input input-three ${errors.cpfCnpj ? 'is-invalid' : ''
                                        }`}
                                    placeholder="CPF / CNPJ"
                                    name="cpfCnpj"
                                />

                                <input
                                    {...register('rgIe', {
                                        required: 'Campo obrigatório',
                                    })}
                                    type="text"
                                    className={`base-input input-three ${errors.rgIe ? 'is-invalid' : ''
                                        }`}
                                    placeholder="RG / Insc. estadual"
                                    name="rgIe"
                                />

                                <input
                                    {...register('cep', {
                                        required: 'Campo obrigatório',
                                    })}
                                    type="text"
                                    className={`base-input ${errors.cep ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Cep"
                                    name="cep"
                                />
                            </div>

                            <div className="group-three">

                                <input
                                    {...register('endereco', {
                                        required: 'Campo obrigatório',
                                    })}
                                    type="text"
                                    className={`base-input input-three ${errors.endereco ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Endereço"
                                    name="endereco"
                                />

                                <input
                                    {...register('cidade', {
                                        required: 'Campo obrigatório',
                                    })}
                                    type="text"
                                    className={`base-input input-three ${errors.cidade ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Cidade"
                                    name="cidade"
                                />

                                <input
                                    {...register('estado', {
                                        required: 'Campo obrigatório',
                                    })}
                                    type="text"
                                    className={`base-input ${errors.estado ? 'is-invalid' : ''
                                        }`}
                                    placeholder="Estado"
                                    name="estado"
                                />
                            </div>

                            <input
                                {...register('contato', {
                                    required: 'Campo obrigatório',
                                })}
                                type="text"
                                className={`base-input input-full ${errors.contato ? 'is-invalid' : ''
                                    }`}
                                placeholder="Contato"
                                name="contato"
                            />

                            <div className="group-three">

                                <input
                                    {...register('telefone', {})}
                                    type="text"
                                    className="base-input input-three"
                                    placeholder="Telefone"
                                    name="telefone"
                                />

                                <input
                                    {...register('celular', {})}
                                    type="text"
                                    className="base-input input-three"
                                    placeholder="Celular"
                                    name="celular"
                                />

                                <input
                                    {...register('email', {
                                        required: 'Campo obrigatório',
                                    })}
                                    type="text"
                                    className={`base-input ${errors.email ? 'is-invalid' : ''
                                        }`}
                                    placeholder="E-mail"
                                    name="email"
                                />
                            </div>
                        </form>

                    </div>
                </div>
            </div>
            <BottonBar />
        </div>
    );
};

export default CadCliente;