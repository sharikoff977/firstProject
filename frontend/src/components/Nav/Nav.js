import React, {useEffect, useState} from 'react';
import { Link } from "react-router-dom";
import PropTypes from 'prop-types';
import './Nav.css';


const Nav = () => {
  const [isLoaded, setIsLoaded] = useState(false);
  const [classes, setClasses] = useState([]);

    useEffect(() => {
      fetch("/api/school-class")
        .then(res => res.json())
        .then(
          (result) => {
            setIsLoaded(true);
            setClasses(result);
          },
          // Note: it's important to handle errors here
          // instead of a catch() block so that we don't swallow
          // exceptions from actual bugs in components.
          (error) => {
          }
        )
    }, [])


  return (<nav class="Nav navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">School</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              School Book
            </a>
            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">

            {isLoaded ? (classes.map(clazz => (
                                                   <li>
                                                    <Link class="dropdown-item"

                                                               to={`/school-book/${clazz.number + clazz.letter}`}
                                                               key={clazz.number + clazz.letter}>{clazz.number + '-' + clazz.letter}</Link>
                                                   </li>
                                                   ))) : (<h1>2</h1>)}
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/swagger-ui/index.html">Swagger</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>);
};

Nav.propTypes = {};

Nav.defaultProps = {};

export default Nav;
