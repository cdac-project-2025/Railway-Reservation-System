import { Link, useNavigate } from "react-router-dom"
import Navbar from "../components/Navbar"
import { useState } from "react"
import { toast } from "react-toastify";
import { userRegister } from "../services/user";


function Register() {

  const [name, setName] = useState("");
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNo, setPhoneNo] = useState("");

  const navigate = useNavigate()

  const onRegister = async () => {
    if(name.length === 0)
      toast.warning("Plese enter name!")
    else if(userName.length === 0)
      toast.warning("Plese enter user name!")
    else if(password.length === 0)
      toast.warning("Plese enter password!")
    else if(password.length < 4)
      toast.warning("Password must be at least 4 characters!")
    else if(email.length === 0)
      toast.warning("Plese enter email!")
    else if(phoneNo.length === 0)
      toast.warning("Plese enter phone number!")
    else if(phoneNo.length < 10 || phoneNo.length > 10)
      toast.warning("Phone number must be 10 digits!")
    else {
      const userDetails = {name, userName, password, email, phoneNo}
      const result = await userRegister(userDetails)

      if(result.status === 201){
        toast.success(result.data.message)
        navigate("/login")
      }
      else {
        toast.error(result.message)
      }
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
                <h1 style={{textAlign:"center", color:"#1c1c84"}}>Register User</h1>
              </div>
            </div>
            <div className="row mb-4">
              <div className="col">
                <div className="form-floating">
                  <input type="text" name="name" className="form-control" placeholder="" 
                  onChange={(e) => setName(e.target.value)} />
                  <label>Name*</label>
                </div>
              </div>
              <div className="col">
                <div className="form-floating">
                  <input type="text" name="userName" className="form-control" placeholder="" 
                  onChange={(e) => setUserName(e.target.value)} />
                  <label>Username*</label>
                </div>
              </div>
            </div>
            <div className="row mb-4">
              <div className="col">
                <div className="form-floating">
                  <input type="email" name="email" className="form-control" placeholder="" 
                  onChange={(e) => setEmail(e.target.value)} />
                  <label>Email*</label>
                </div>
              </div>
              <div className="col">
                <div className="form-floating">
                  <input type="password" name="password" className="form-control" placeholder="" 
                  onChange={(e) => setPassword(e.target.value)} />
                  <label>Password*</label>
                </div>
              </div>
            </div>
            <div className="row mb-4">
              <div className="col">
                <div className="form-floating">
                  <input type="text" name="phoneNumber" className="form-control" placeholder="" 
                  onChange={(e) => setPhoneNo(e.target.value)} />
                  <label>Phone Number*</label>
                </div>
              </div>
            </div>
            <div className="row mb-4">
              <div style={{ marginLeft: "2px" }} className="mb-2">
                <Link to="/login" style={{textDecoration:"none"}}>Already have an accout? Login</Link>
              </div>
              <div>
                <button className="btn btn-primary" style={{width:"120px"}} onClick={onRegister}>Register</button>
              </div>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  )
}

export default Register