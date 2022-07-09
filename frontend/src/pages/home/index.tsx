import NavBarLateral from 'components/NavBarLateral';
import './styles.css';
import { Switch } from "react-router-dom";
import PrivateRoute from "components/PrivateRoute";
import Dash from 'pages/Dash';
import Config from 'pages/Config';
import Users from 'pages/Config/User';
import ListUser from 'pages/Config/User/ListUser';

const Home = () => {

  return (

    <div className="home-container">
      <NavBarLateral />
      <div>
        <Switch>
          <PrivateRoute path="/home/dash">
            <Dash />
          </PrivateRoute>

          <PrivateRoute path="/home/config">
            <Config />
          </PrivateRoute>

          <PrivateRoute path="/home/caduser/:userId">
            <Users />
          </PrivateRoute>

          <PrivateRoute path="/home/listuser">
            <ListUser />
          </PrivateRoute>

        </Switch>
      </div>
    </div>

  );
}; export default Home;
