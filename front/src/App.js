import './App.css';
import getToken from './Util/ApiMethods.js'

function App() {
  getToken()
  return (
    <div className="App">
      <form>
        <input type="text" name="username"></input>
        <input type='password' name="password"></input>
      </form>
    </div>
  );
}

export default App;
