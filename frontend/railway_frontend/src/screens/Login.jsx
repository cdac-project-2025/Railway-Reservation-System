import { Link, useNavigate } from "react-router-dom"
import Navbar from "../components/Navbar"
import { useDispatch, useSelector } from "react-redux"
import { login } from "../slices/authSlice"
import { useState } from "react"
import { toast } from "react-toastify"
import { userLogin } from "../services/user"


function Login() {
  
  const [userName, setUserName] = useState("")
  const [password, setPassword] = useState("")

  const navigate = useNavigate()

  const dispatcher = useDispatch()

  const onLogin = async () => {

    if(userName.length === 0)
      toast.warning("Please enter username")
    else if(password.length === 0)
      toast.warning("Please enter password")
    else {
      const result = await userLogin(userName, password)
      if(result.status === 200) {
        sessionStorage.setItem("userId", result.data.userId)
        toast.success(result.data.message)
        dispatcher(login())
        navigate("/dashboard")
      }
      else
        toast.error(result.message)
    }
  }

  return (
    <div className="view bg-img">
      <Navbar />
      <div className="row" style={{width:"100%"}}>
        <div className="col"></div>
        <div className="col" style={{marginTop:"80px"}}>
          <div class="shadow-lg p-4 rounded" style={{ backgroundColor:"rgb(235, 235, 235)"}}>
            <div className="row mb-4">
              <div className="col">
                <h1 style={{textAlign:"center", color:"#1c1c84"}}>Sign in</h1>
              </div>
            </div>
            <div className="row mb-4">
              <div className="col">
                <div className="form-floating">
                  <input type="text" className="form-control" placeholder="" 
                  onChange={(e) => setUserName(e.target.value)} />
                  <label>Username*</label>
                </div>
              </div>
            </div>
            <div className="row mb-4">
              <div className="col">
                <div className="form-floating">
                  <input type="password" className="form-control" placeholder="" 
                  onChange={(e) => setPassword(e.target.value)} />
                  <label>Password*</label>
                </div>
              </div>
            </div>
            <div className="row mb-4">
              <div style={{ marginLeft:"2px"}} className="mb-2">
                <Link to="/register" style={{textDecoration:"none"}}>Don't have an accout? Register</Link>
              </div>
              <div>
                <button className="btn btn-primary" style={{width:"120px"}} onClick={onLogin}>Login</button>
              </div>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  )
}

export default Login