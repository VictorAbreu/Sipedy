
import { AxiosRequestConfig } from 'axios';
import Pagination from 'components/Pagination';
import { useCallback, useEffect, useState } from 'react';
import { SpringPage } from 'type/spring';
import { requestBackend } from 'util/requests';
import ActionBarList from 'components/ActionBarList';
import './styles.css';
import TabCliente from '../Components/TabClienteItem';
import { FilterData } from 'components/ActionBarList';
import { Cliente } from 'type/cliente';

type ControlComponentsData = {
    activepage: number;
    filterData: FilterData;
};

const ListCliente = () => {

    const [page, setPage] = useState<SpringPage<Cliente>>();
    const [controlComponentsData, setControlComponentsData] =
        useState<ControlComponentsData>({
            activepage: 0,
            filterData: { name: "" }
        });

    const handlePageChange = (pageNumber: number) => {
        setControlComponentsData({ activepage: pageNumber, filterData: controlComponentsData.filterData });
    };

    const handleSubmitFilter = (data: FilterData) => {
        setControlComponentsData({ activepage: 0, filterData: data });
    }

    const getCliente = useCallback(() => {
        const params: AxiosRequestConfig = {
            method: 'GET',
            url: '/clientes',
            withCredentials: true,
            params: {
                page: controlComponentsData.activepage,
                size: 12,
                name: controlComponentsData.filterData.name,
            },
        };
        requestBackend(params)
            .then((response) => {
                setPage(response.data);
            });
    }, [controlComponentsData]);

    useEffect(() => {
        getCliente();
    }, [getCliente]);

    return (
        <div className="listuser-container">
            <ActionBarList onSubmitFilter={handleSubmitFilter} paginaRetorno="cliente" titulo="Lista de clientes" placeHolder="Pesquisa de cliente" />
            <div className="listuser-container-cards" >
                {page?.content.map((cliente) => {
                    return (
                        <div className="cards-list" key={cliente.id}>
                            <TabCliente cliente={cliente} />
                        </div>
                    );
                })
                }

            </div>

            <Pagination
                forcePage={page?.number}
                pageCount={page ? page.totalPages : 0}
                range={3}
                onChange={handlePageChange}
            />
        </div>
    );
};

export default ListCliente;