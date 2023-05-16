import "./App.css";
import useArrayStore from "./store";
import Btn from "./components/btn";
import Timer from "./components/timer";

function App() {
  const { arr, updateArr, updateValue } = useArrayStore();

  return (
    <div>
      hello
      <button onClick={() => updateArr([])}>Reset Array to []</button>
      <button onClick={() => updateValue(1, 4)}>Update 2th Value</button>
      <Btn index={3} v={"hello"}>
        update 3th vaule to hello
      </Btn>
      <Timer interval={4}/>
      <Timer/>
      <Timer/>
      <Timer/>
      <Timer/>
      <ul>
        {arr.map((item, index) => {
          return <li key={index}>{item}</li>;
        })}
      </ul>
    </div>
  );
}
export default App;
