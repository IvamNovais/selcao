import './App.css';
import {useState} from "react"
import api from "./Util/Api.js"
// const [logado, setlogado]=useState(false)
async function getToken(credenciais){
  const token = await api.post("/oauth/token",{
  auth: {
      Username: 'Bam',
      Password: '123'
   },
   grant_type: "password",
   credenciais

})
}
function App() {
  return (
    <div className="App">
      false?
      <div>
      <form method="post" id="login">
        <input type="text" name="username"></input>
        <input type='password' name="password"></input>
      </form>
      <button onClick={getToken(document.getElementById("login").values)}>login</button>
      </div>:null
    </div>

  );
}

export default App;
 