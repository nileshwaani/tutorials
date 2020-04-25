import React from 'react';

const authContext = React.createContext({
  authenticated: false,
  login: null
});

export default authContext;