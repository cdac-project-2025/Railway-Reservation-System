import { useState } from "react"
import Test from "./Test"
import { Dialog } from '@mui/material';


function Test2() {

  const [opens, setOpens] = useState(false);

  const onOpenDiag = () => {
    setOpens(true)
  }


  return (
    <div>
      <button onClick={onOpenDiag}>Open Dialog</button>
      <Dialog open={opens} onClose={() => setOpens(false)} >
        <Test />
      </Dialog>
    </div>
  )
}

export default Test2