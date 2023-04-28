import "./App.css";
import useArrayStore from "./store";
import Btn from './components/btn'

function App() {
	const { arr, updateArr, updateValue } = useArrayStore();

	return (
		<div>
			<button onClick={() => updateArr([1, 2, 3])}>Update Array</button>
			<button onClick={() => updateValue(1, 4)}>Update Value</button>
      <Btn/>
			<ul>
				{arr.map((item, index) => (
					<li key={index}>{item}</li>
				))}
			</ul>
		</div>
	);
}
export default App;
