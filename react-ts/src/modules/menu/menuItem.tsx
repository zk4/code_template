import React, {useContext} from 'react';
import classNames from 'classnames'
import {MenuContext} from './menu';



interface MenuItemProps {
  index: number;
  disabled?: boolean;
  className?: string;
  style?: React.CSSProperties;
  children?: React.ReactNode;
}
// Partial 可将属性都设置为可选

const MenuItem: React.FC<MenuItemProps> = (props) => {
  const { index, disabled, className, style, children } = props;
  const context = useContext(MenuContext)
  const classes = classNames('menu-item',classNames,{
    'is-disabled':disabled,
    'is-active': context.index === index
  })

  const handleClick = ()=>{
    if(context.onSelect && !disabled){
      context.onSelect(index)
    }
  }
  return (
    <li className ={classes} style = {style}  onClick={handleClick}>
      {children}
    </li>
  )
}

export default MenuItem;
