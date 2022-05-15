import NavBarLateral from 'components/NavBarLateral';
import './styles.css';
import { Switch } from "react-router-dom";
import PrivateRoute from "components/PrivateRoute";
import Dash from 'pages/Dash';
import Config from 'pages/Config';

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

          <PrivateRoute path="/home/caduser">
            <h1>Cadastro de usuários</h1>
          </PrivateRoute>

        </Switch>
      </div>
    </div>

  );
}; export default Home;
