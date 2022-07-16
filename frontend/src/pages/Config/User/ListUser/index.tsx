
import { AxiosRequestConfig } from 'axios';
import Pagination from 'components/Pagination';
import { useCallback, useEffect, useState } from 'react';
import { SpringPage } from 'type/spring';
import { User } from 'type/user';
import { requestBackend } from 'util/requests';
import ActionBar from './ActionBar';
import './styles.css';
import TabUser from './TabUser';

type ControlComponentsData = {
    activepage: number;
};

const ListUser = () => {

    const [page, setPage] = useState<SpringPage<User>>();
    const [controlComponentsData, setControlComponentsData] =
        useState<ControlComponentsData>({
            activepage: 0
        });

    const handlePageChange = (pageNumber: number) => {
        setControlComponentsData({ activepage: pageNumber });
    };

    const getUser = useCallback(() => {
        const params: AxiosRequestConfig = {
            method: 'GET',
            url: '/users',
            withCredentials: true,
            params: {
                page: controlComponentsData.activepage,
                size: 12,
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
            <ActionBar />
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