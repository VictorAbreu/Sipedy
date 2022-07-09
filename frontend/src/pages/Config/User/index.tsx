import './styles.css';

import { AxiosRequestConfig } from 'axios';
import { useEffect, useState } from 'react';
import { Controller, useForm } from 'react-hook-form';
import { useHistory, useParams } from 'react-router-dom';
import { User } from '../../../type/user'
import { requestBackend } from 'util/requests';
import { toast } from 'react-toastify';

import { ReactComponent as IconAddUser } from '../../../assets/images/addusuario.svg';
import { ReactComponent as IconBack } from '../../../assets/images/voltar.svg';
import { ReactComponent as IconClear } from '../../../assets/images/limpar.svg';
import { ReactComponent as IconDel } from '../../../assets/images/excluir.svg';
import { ReactComponent as IconSave } from '../../../assets/images/salvar.svg';

type UrlParams = {
    userId: string;
};

const Users = () => {

    const { userId } = useParams<UrlParams>();
    const [id, setId] = useState("");
    const isEditing = userId !== 'create';
    const history = useHistory();
    const {
        register,
        handleSubmit,
        formState: { errors },
        setValue,
        control,
    } = useForm<User>();

    useEffect(() => {
        if (isEditing) {
            requestBackend({ url: `/users/${userId}` }).then((response) => {
                const user = response.data as User;
                setValue('firstName', user.firstName);
                setValue('lastName', user.lastName);
                setValue('email', user.email);
                setValue('password', user.password)
                setValue('celular', user.celular);
                setValue('cpf', user.cpf);
                setValue('roles', user.roles);
            });
        }
    }, [isEditing, userId, setValue]);

    const onSubmit = (formData: User) => {
        const data = {
            ...formData,
            roles: [{ "id": parseInt(id) }],
        };
        const config: AxiosRequestConfig = {
            method: isEditing ? 'PUT' : 'POST',
            url: isEditing ? `/users/${userId}` : '/users',
            data: data,
            withCredentials: true,
        };

        requestBackend(config)
            .then(() => {
                toast.info('Usuario cadastrado com sucesso!')
                console.log('Dados', data);
                history.push('/home/config');
            }).catch((error) => {
                toast.error('Erro ao cadastrar usuário');
            });
    };

    const handleCancel = () => {
        history.push('/home/config');
    };

    const handleClean = () => {
        setValue('firstName', "");
        setValue('lastName', "");
        setValue('email', "");
        setValue('password', "")
        setValue('celular', "");
        setValue('cpf', "");
        setId("");
    };

    return (
        <div className="user-container">
            <form onSubmit={handleSubmit(onSubmit)}>
                <div className="base-card bar-nav-container">
                    <div className="bar-description">
                        <IconAddUser className="bar-icon" />
                        <h5>Cadastro de usuários</h5>
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
                            <button className="button-input">
                                <IconSave className="bar-icon" />
                                <h5>Salvar</h5>
                            </button>
                        </div>

                    </div>
                </div>



                <div className="base-card formcad-container">

                    <div className="inputs-card-container">
                        <div className="input-container">
                            <input
                                {...register('firstName', {
                                    required: 'Campo obrigatório',
                                })}
                                type="text"
                                className={`${errors.firstName ? 'is-invalid' : ''
                                    }`}
                                placeholder="Nome"
                                name="firstName"
                            />
                            <input
                                {...register('lastName', {

                                })}
                                type="text"
                                placeholder="Sobrenome"
                                name="lastName"
                            />
                        </div>
                        <div className="input-container">
                            <Controller
                                name="roles"
                                control={control}
                                render={({ field }) => (
                                    <select
                                        {...field}
                                        id='rolesId'
                                        value={id}
                                        onChange={e => setId(e.target.value)}
                                        placeholder="Selecionar"
                                        className="input-select"
                                    >
                                        <option value="">Selecionar</option>
                                        <option value="2">Administrador</option>
                                        <option value="3">Gerente</option>
                                        <option value="1">Operador</option>
                                    </select>
                                )}
                            />
                            <input
                                {...register('password', {

                                })}
                                type="password"
                                placeholder="Senha"
                                name="password" />
                        </div>

                        <div className="input-container">
                            <input {...register('email', {})} type="text" placeholder="Email" name="email" />
                            <input {...register('celular', {})} type="text" placeholder="Celular" name="celular" />
                            <input {...register('cpf', {})} type="text" placeholder="CPF" name="cpf" />
                        </div>
                    </div>
                    <div className="input-image-container">

                    </div>

                </div>
            </form>
        </div>
    );
};

export default Users;