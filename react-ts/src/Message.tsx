import React from 'react'

interface iMessageProps {
  msg?: string;
}

const Message: React.FC<iMessageProps> = (props) => {
  return <h1>{props.msg}</h1>
}
Message.defaultProps = {
  msg: "hell,world"
}

export default Message;



