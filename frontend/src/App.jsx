import 'bootstrap/dist/css/bootstrap.min.css'

import './App.css'
import Header from "./components/Header.jsx";
import Signup from "./pages/Signup.jsx"
import { Routes, Route } from 'react-router-dom';
import Home from "./pages/Home.jsx";
import Login from "./pages/Login.jsx";

function App() {

  return (
      <>
          <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/signup" element={<Signup />} />
              <Route path="/login" element={<Login />} />
          </Routes>
      </>
  )
}

export default App
