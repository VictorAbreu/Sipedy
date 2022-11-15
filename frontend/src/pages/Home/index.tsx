import NavBarLateral from 'components/NavBarLateral';
import './styles.css';
import { Switch } from "react-router-dom";
import PrivateRoute from "components/PrivateRoute";
import Dash from 'pages/Dash';
import Config from 'pages/Config';
import Users from 'pages/Config/User';
import ListUser from 'pages/Config/User/ListUser';
import Cliente from 'pages/Cliente';
import CadCliente from 'pages/Cliente/CadCliente';
import ListCliente from 'pages/Cliente/ListCliente';

const Home = () => {

  return (

    <div className="home-container">
      <NavBarLateral />
      <div>
        <Switch>
          <PrivateRoute path="/home/dash">
            <Dash />
          </PrivateRoute>

          <PrivateRoute path="/home/cliente">
            <Cliente />
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

          <PrivateRoute path="/home/cadcliente/:clienteId">
            <CadCliente />
          </PrivateRoute>

          <PrivateRoute path="/home/listcliente">
            <ListCliente />
          </PrivateRoute>

        </Switch>
      </div>
    </div>

  );
}; export default Home;
