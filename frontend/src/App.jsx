import 'bootstrap/dist/css/bootstrap.min.css'

import './App.css'
import Header from "./components/Header.jsx";
import Signup from "./pages/Signup.jsx"
import { Routes, Route } from 'react-router-dom';
import Home from "./pages/Home.jsx";

function App() {

  return (
      <>
          <Header/>
          <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/signup" element={<Signup />} />
          </Routes>
      </>
  )
}

export default App
