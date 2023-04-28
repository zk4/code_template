import useArrayStore from "../store";
function Btn({index,v,children}) {
	const { updateValue } = useArrayStore();
	return <button onClick={() => updateValue(index, v)}>{children }</button>;
}
export default Btn;
