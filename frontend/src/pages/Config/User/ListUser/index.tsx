
import ActionBar from './ActionBar';
import Pagination from './Pagination';
import './styles.css';
import TabUser from './TabUser';

const ListUser = () => {

    return (
        <div className="listuser-container">
            <ActionBar />
            <div className="listuser-container-cards">
                <div className="cards-list">
                    <TabUser />
                </div>

                <div className="cards-list">
                    <TabUser />
                </div>

                <div className="cards-list">
                    <TabUser />
                </div>

                <div className="cards-list">
                    <TabUser />
                </div>

                <div className="cards-list">
                    <TabUser />
                </div>

                <div className="cards-list">
                    <TabUser />
                </div>

                <div className="cards-list">
                    <TabUser />
                </div>

                <div className="cards-list">
                    <TabUser />
                </div>

            </div>

            <Pagination />
        </div>
    );
};

export default ListUser;