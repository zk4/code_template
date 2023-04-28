import create from "zustand";

const useArrayStore = create((set) => ({
	arr: [],
	updateArr: (newArr) => set({ arr: newArr }),
	updateValue: (index, newValue) =>
		set((state) => {
      let newList = [...state.arr];

      // fix the empty slots problem
      for (var i = 0; i < index+1; i++) {
        if (!(i in newList)) {
          newList[i] = undefined;
        }
      }
      newList[index] = `updated item ${index + 1} ${newValue}`;
			return  { arr: newList };
		}),
}));
export default useArrayStore;
