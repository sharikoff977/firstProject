import React from 'react';
import PropTypes from 'prop-types';
import logo from '../../logo.svg';
import './Home.css';

const Home = () => (
  <div className="Home">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
          </header>
  </div>
);

Home.propTypes = {};

Home.defaultProps = {};

export default Home;
