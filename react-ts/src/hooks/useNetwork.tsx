import React, {useEffect, useState} from 'react'
import axios from 'axios'


function useNetwork(url: string, deps: any[]=[]) {
  const [data, setData] = useState<any>(null);
  const [loading, setLoading] = useState(false);
  useEffect(() => {
    setLoading(true)
    axios.get(url)
      .then(result => {
        setData(result.data)
        setLoading(false)
      })

  }, deps)
  return [data, loading]
}

export default useNetwork;
