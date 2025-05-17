import 'bootstrap/dist/css/bootstrap.min.css'

import './App.css'
import Signup from "./pages/Signup.jsx"
import { Routes, Route } from 'react-router-dom';
import Home from "./pages/Home.jsx";
import Login from "./pages/Login.jsx";
import User from "./pages/User.jsx";

function App() {

  return (
      <>
          <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/signup" element={<Signup />} />
              <Route path="/login" element={<Login />} />
              <Route path="/user" element={<User />} />
          </Routes>
      </>
  )
}

export default App
