import React, {useEffect, useState} from 'react'


function useMouseMove() {
  let [position, setPosition] = useState({x: 0, y: 0});
  useEffect(() => {
    const mouseMoveFn = (e: MouseEvent) => {
      setPosition({x: e.clientX, y: e.clientY})
    };
    window.addEventListener('mousemove', mouseMoveFn)

    return () => {
      window.removeEventListener('mousemove', mouseMoveFn);
    }
  }, [])
  return position;
}

export default useMouseMove;
