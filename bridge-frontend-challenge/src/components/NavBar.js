import { Link, useHistory, NavLink } from "react-router-dom";
import React, { useState, useEffect } from 'react';

const NavBar = (props) => {
  const currentRoute = useHistory().location.pathname.toLowerCase();
  return (
    <nav className="Navbar">
      <div className="Links">
        <NavLink exact activeClassName="active" to="/">
          Principal
        </NavLink>
        <NavLink exact activeClassName="active" to="/history">
          Histórico
        </NavLink>
      </div>
    </nav>
  );
};

export default NavBar;
