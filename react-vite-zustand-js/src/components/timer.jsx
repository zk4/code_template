import {useEffect,useState, useRef } from "react";

export default function Timer({interval}) {
  const timerRef = useRef(0);
  const [timerValue, setTimerValue] = useState(0);

  useEffect(() => {
    const intervalId = setInterval(() => {
      // 无闭包问题
      console.log(timerRef.current)
      timerRef.current += interval || 1;
      setTimerValue(timerRef.current);
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  // useEffect(() => {
  //   const intervalId = setInterval(() => {
       // Bad 有闭包问题
  //     console.log(timerValue)
  //     setTimerValue(t => (interval || 1) +t);
  //   }, 1000);
  //
  //   return () => clearInterval(intervalId);
  // }, []);
  //
  return <div>{timerValue} 秒</div>;
}
