import {useEffect,useState, useRef } from "react";

export default function Timer({interval}) {
  const timerRef = useRef(0);
  const [timerValue, setTimerValue] = useState(0);

  useEffect(() => {
    const intervalId = setInterval(() => {
      timerRef.current += interval || 1;
      setTimerValue(timerRef.current);
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  return <div>{timerValue} 秒</div>;
}
