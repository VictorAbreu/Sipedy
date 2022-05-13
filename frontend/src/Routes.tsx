import NavBar from "components/NavBar";
import PrivateRoute from 'components/PrivateRoute'
import Home from "pages/Home";
import Login from "pages/Login";
import { Route, Router, Switch } from "react-router-dom";
import history from 'util/history';

const Routes = () => (
    <Router history={history}>
        <NavBar />
        <Switch>
            <Route path="/" exact>
                <Login />
            </Route>

            <PrivateRoute path="/home">
                <Route path="/home" exact>
                    <Home />
                </Route>
            </PrivateRoute>
        </Switch>
    </Router>
);

export default Routes;