import React, {createContext, useState} from 'react';
import classNames from 'classnames'


type MenuMode = 'horizontal' | 'vertical'
type SelectCallback = (selectedIndex: number) => void;

interface MenuProps {
  defaultIndex?: number;
  className?: string;
  mode?: MenuMode;
  style?: React.CSSProperties;
  children?: React.ReactNode;
  onSelect?: SelectCallback;
}
interface IMemnuContext {
  index: number;
  onSelect?: SelectCallback;
}

export const MenuContext = createContext<IMemnuContext>({index: 0})
const Menu: React.FC<MenuProps> = (props) => {
  const {className, mode, style, children, defaultIndex, onSelect} = props;
  const [currentActive, setCurrentActive] = useState<any>(defaultIndex);

  const classes = classNames('viking-menu', className, {
    'menu-vertical': mode === 'vertical'
  })
  const handleClick = (index: number) => {
    setCurrentActive(index)
    if (onSelect)
      onSelect(index)
  }
  const passedContext: IMemnuContext = {
    index: currentActive ? currentActive : 0,
    onSelect: handleClick,
  }
  return (
    <ul className={classes} style={style} >
      <MenuContext.Provider value={passedContext}>
        {children}
      </MenuContext.Provider>
    </ul>
  )
}

Menu.defaultProps = {
  defaultIndex: 0,
  mode: 'horizontal'
}
export default Menu;
