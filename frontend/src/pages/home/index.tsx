import NavBarLateral from 'components/NavBarLateral';
import './styles.css';
import { Switch } from "react-router-dom";
import PrivateRoute from "components/PrivateRoute";
import Dash from 'pages/Dash';

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
            <h1>Configurações</h1>
          </PrivateRoute>
        </Switch>
      </div>
    </div>

  );
}; export default Home;
