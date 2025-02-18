import { useEffect, useState } from "react";
import { getUserDetails, updateProfile } from "../services/user";
import { toast } from "react-toastify";

function EditProfile(props) {

  const [userName, setUserName] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [phoneNo, setPhoneNo] = useState("");

  const onLoadDetails = async () => {
    const result = await getUserDetails();
    if(result.status === 200) {
      setUserName(result.data.data.userName);
      setName(result.data.data.name);
      setEmail(result.data.data.email);
      setPhoneNo(result.data.data.phoneNo);
    }
  }

  const onEdit = async () => {
    if(name.length === 0)
      toast.warning("Please enter name!")
    else if(userName.length === 0)
      toast.warning("Please enter user name!")
    else if(email.length === 0)
      toast.warning("Please enter email!")
    else if(phoneNo.length === 0)
      toast.warning("Please enter phone number!")
    else {
      const userDetails = {name, userName, email, password ,phoneNo}
      const result = await updateProfile(userDetails)
      if(result.status === 200) {
        toast.success(result.data.message)
        toast.success("Plese wait, redirecting...")
        setTimeout(() => {
          props.handleClose()
          window.location.href = "/dashboard"
        }, 5000)
      }
      else {
        toast.error(result.message)
      }
    }
  }

  useEffect(() => {
    onLoadDetails();

    return () => {}
  }, [])

  return (
    <div className="edit-profile">
      <div>
        <h1 style={{textAlign:"center", color:"#1c1c84"}}>Edit Profile</h1>
      </div>
      <div className="form-floating mt-4 mb-4">
        <input type="text" className="form-control" placeholder="" value={name} 
        onChange={(e) => setName(e.target.value)} />
        <label>Name*</label>
      </div>
      <div className="form-floating mb-4">
        <input type="text" className="form-control" placeholder="" value={userName} 
        onChange={(e) => setUserName(e.target.value)} />
        <label>Username*</label>
      </div>
      <div className="form-floating mb-4">
        <input type="text" className="form-control" placeholder="" value={email} 
        onChange={(e) => setEmail(e.target.value)} />
        <label>Email*</label>
      </div>
      <div className="form-floating mb-4">
        <input type="password" className="form-control" placeholder="" 
        onChange={(e) => setPassword(e.target.value)} />
        <label>New Password</label>
      </div>
      <div className="form-floating mb-4">
        <input type="text" className="form-control" placeholder="" value={phoneNo} 
        onChange={(e) => setEmail(e.target.value)} />
        <label>Phone Number*</label>
      </div>
      <div style={{textAlign:"center"}}>
        <button className="btn btn-primary" style={{width:"120px"}} onClick={onEdit}>Edit</button>
      </div>
    </div>
  )
}

export default EditProfile