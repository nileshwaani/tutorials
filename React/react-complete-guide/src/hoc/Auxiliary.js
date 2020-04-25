import React from 'react';

import styles from './Auxiliary.module.css';

const aux = (props) => { 
  return <div className={styles.auxiliary}>{props.children}</div> 
};

export default aux;