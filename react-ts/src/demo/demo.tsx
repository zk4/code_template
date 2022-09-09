import React from 'react'
import styles from './demo.module.css'

interface iDemoProps {
  msg?: string;
}

const Demo: React.FC<iDemoProps> = (props) => {
  return <h1 className={styles.demo} >{props.msg}</h1>
}

Demo.defaultProps = {
  msg: "css module demo"
}

export default Demo;
