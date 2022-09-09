import React from 'react';
// import styles from './index.module.css'
import classNames from 'classnames'

export enum ButtonSize {
  Large = 'lg',
  Small  = 'sm'
}


export enum ButtonType {
  Primary = 'primary',
  Default = 'default',
  Danger = 'danger',
  Link = 'link'
}


interface BaseButtonProps {
  className?: string;
  disabled?: boolean;
  size?: ButtonSize;
  href?: string;
  btnType?: ButtonType;
  children?: React.ReactNode;
}
// & 符号可指定 ts 里的交叉类型 intersection Types，合并属性用
type  NativeButtonProps =  BaseButtonProps & React.ButtonHTMLAttributes<HTMLElement>;
type  AnchorButtonProps =  BaseButtonProps & React.AnchorHTMLAttributes<HTMLElement>;

// Partial 可将属性都设置为可选
export type ButtonProps = Partial<NativeButtonProps & AnchorButtonProps>;

const Button: React.FC<ButtonProps> = (props) => {
  const {
    className,
    disabled,
    size,
    btnType,
    href,
    children,
    ...restProps

  } = props;

  const classes = classNames('btn', className, {
    [`btn-${btnType}`]: btnType,
    [`btn-${size}`]: size,
    'disabled': (btnType === ButtonType.Link) && disabled
  })
  if( btnType === ButtonType.Link && href){
    return (
      <a
      className = {classes}
      href = {href}
      {... restProps}
      > 
      {children} 
      </a>
    )
  }else
  {
    return <button className={classes}
    disabled ={disabled}
    {... restProps}
    >{children}</button>
  }
}

Button.defaultProps = {
  disabled : false,
  btnType: ButtonType.Default
}
export default Button;
