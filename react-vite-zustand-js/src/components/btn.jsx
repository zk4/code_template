import useArrayStore from "../store";
function Btn() {
	const { updateValue } = useArrayStore();

	return <button onClick={() => updateValue(2, 4)}>Update Value</button>;
}
export default Btn;
