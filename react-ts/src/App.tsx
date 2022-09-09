import React, {useRef, useState} from 'react';
import './App.css';
import useMouseMove from './hooks/useMouseMove';
import Button,{ButtonType,ButtonSize} from './modules/button/button';
import Demo from './demo/demo'
import useNetwork from './hooks/useNetwork';
import Menu from './modules/menu/menu';
import MenuItem from './modules/menu/menuItem';
interface iShowResult {
  message: string;
  status: string;
}
const App: React.FC = () => {

  const position = useMouseMove();
  const [show, setShow] = useState<boolean>(true);
  const [data, loading] = useNetwork('https://dog.ceo/api/breeds/image/random', [show]);
  const dogResult = data as iShowResult;
  const a = "123"
  if(a == "123"){
    
  }


  return (
    <div className="App">
    <Menu onSelect={index => alert(index)}>
      <MenuItem index={0}>
          menu 1
      </MenuItem>
      <MenuItem  index={1}>
          menu 2
      </MenuItem>
    </Menu>
      <Button autoFocus onClick={e=>{e.preventDefault();alert(123);}}> Hello</Button>
      <Button disabled btnType={ButtonType.Link} href="http://www.baidu.com"> Baidu disabled</Button>
      <Button  btnType={ButtonType.Link} href="http://www.baidu.com"> Baidu</Button>
      <Button  onClick={e=>{alert(1);}}> normal</Button>
      <Button btnType={ButtonType.Primary}> primary</Button>
      <Button btnType={ButtonType.Primary} disabled> primary disabled</Button>

      <Button btnType={ButtonType.Danger}> danger</Button>
      <Button btnType={ButtonType.Danger} disabled> danger disabled</Button>

      <Button onClick={() => {setShow(b => !b)}}>refresh dog image</Button>
      <br />
      { loading ? 
        <p>image loading...</p> 
        :
       <img src={dogResult && dogResult.message} ></img> }

      <br />
      useMouseMove Demo:{position.x}, {position.y}
      <br />
      css Component Demo:<Demo />
    </div>
  );
}

export default App;
