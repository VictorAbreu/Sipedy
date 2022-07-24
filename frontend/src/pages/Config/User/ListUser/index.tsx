
import { AxiosRequestConfig } from 'axios';
import Pagination from 'components/Pagination';
import { useCallback, useEffect, useState } from 'react';
import { SpringPage } from 'type/spring';
import { User } from 'type/user';
import { requestBackend } from 'util/requests';
import ActionBar from './ActionBar';
import './styles.css';
import TabUser from './TabUser';
import { UserFilterData } from 'pages/Config/User/ListUser/ActionBar';

type ControlComponentsData = {
    activepage: number;
    filterData: UserFilterData;
};

const ListUser = () => {

    const [page, setPage] = useState<SpringPage<User>>();
    const [controlComponentsData, setControlComponentsData] =
        useState<ControlComponentsData>({
            activepage: 0,
            filterData: { name: "" }
        });

    const handlePageChange = (pageNumber: number) => {
        setControlComponentsData({ activepage: pageNumber, filterData: controlComponentsData.filterData });
    };

    const handleSubmitFilter = (data: UserFilterData) => {
        setControlComponentsData({ activepage: 0, filterData: data });
    }

    const getUser = useCallback(() => {
        const params: AxiosRequestConfig = {
            method: 'GET',
            url: '/users',
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
        getUser();
    }, [getUser]);

    return (
        <div className="listuser-container">
            <ActionBar onSubmitFilter={handleSubmitFilter} />
            <div className="listuser-container-cards" >
                {page?.content.map((user) => {
                    return (
                        <div className="cards-list" key={user.id}>
                            <TabUser user={user} />
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

export default ListUser;