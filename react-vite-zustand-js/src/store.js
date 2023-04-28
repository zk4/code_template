import create from "zustand";

const useArrayStore = create((set) => ({
	arr: [],
	updateArr: (newArr) => set({ arr: newArr }),
	updateValue: (index, newValue) =>
		set((state) => {
      const newList = [...state.arr];
      newList[index] = `updated item ${index + 1} ${newValue}`;
			return  { arr: newList };
		}),
}));
export default useArrayStore;
