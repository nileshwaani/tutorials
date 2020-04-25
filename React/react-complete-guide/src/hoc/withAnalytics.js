import React from 'react';

const withAnalytics = (WrappedComponent, componentName) => {
  return (props) => {
    console.log('Sending analytics to Google Analytics for ' + componentName);
    
    return <WrappedComponent {...props}/>
  }
};

export default withAnalytics;