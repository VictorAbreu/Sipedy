
import { AxiosRequestConfig } from 'axios';
import { useEffect, useState } from 'react';
import { SpringPage } from 'type/spring';
import { User } from 'type/user';
import { requestBackend } from 'util/requests';
import ActionBar from './ActionBar';
import Pagination from './Pagination';
import './styles.css';
import TabUser from './TabUser';


const ListUser = () => {

    const [page, setPage] = useState<SpringPage<User>>();

    const getUser = (pageNumber: number) => {
        const params: AxiosRequestConfig = {
            method: 'GET',
            url: '/users',
            withCredentials: true,
            params: {
                page: pageNumber,
                size: 12,
            },
        };
        requestBackend(params)
            .then((response) => {
                setPage(response.data);
            })
            .finally(() => {

            });
    };

    useEffect(() => {
        getUser(0);
    }, []);

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

            <Pagination />
        </div>
    );
};

export default ListUser;