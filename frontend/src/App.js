import 'bootstrap/dist/css/bootstrap.css';
import $ from 'jquery';
import Popper from 'popper.js';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import './App.css';
import Nav from './components/Nav/Nav.js';
import Home from './components/Home/Home.js';
import SchoolBook from './components/SchoolBook/SchoolBook.js';

function App() {

  return (

    <div className="App">
    <Nav/>
      <Routes>
        <Route path="school-book/:clazz" element={<SchoolBook />} />
        <Route path="/" element={<Home />} />
      </Routes>
    </div>
  );
}

export default App;
