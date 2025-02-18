import { toast } from "react-toastify"
import { deleteProfile } from "../services/user"


function DeleteProfile(props) {
  
  const onDelete = async () => {
    const result = await deleteProfile()
    if(result.status === 410) {
      toast.success(result.message)
      toast.success("Plese wait, redirecting...")
        setTimeout(() => {
          props.handleClose()
          props.handleLogout()
        }, 5000)
    }
  }

  const onNo = () => {
    props.handleClose()
  }

  return (
    <div className="delete-profile">
      <div>
        <h3 style={{color:"#1c1c84", marginBottom:"30px"}}>Are you sure you want to delete your account?</h3>
      </div>
      <div className="delete-prof-btn" style={{textAlign:"center"}}>
        <button className="btn btn-danger" style={{width:"100px"}} onClick={onNo}>No</button>
        <button className="btn btn-success" style={{width:"100px"}} onClick={onDelete} >Yes</button>
      </div>
    </div>
  )
}

export default DeleteProfile