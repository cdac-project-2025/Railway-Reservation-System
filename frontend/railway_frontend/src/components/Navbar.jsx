import { useDispatch, useSelector } from "react-redux"
import { Link, useNavigate } from "react-router-dom"
import { logout } from "../slices/authSlice"
import { Dialog } from "@mui/material"
import EditProfile from "../screens/EditProfile"
import { useState } from "react"
import DeleteProfile from "../screens/DeleteProfile"


function Navbar() {

	const isLoggedIn = useSelector((store) => store.auth.isLoggedIn)
	const navigate = useNavigate()
	const dispatcher = useDispatch()

	const onLogout = () => {
		sessionStorage.removeItem("userId")
		dispatcher(logout())
		navigate("/")
	}

	const [openEdit, setOpenEdit] = useState(false)
	const [openDelete, setOpenDelete] = useState(false)
	
	const onOpenEditDiag = () => {
		setOpenEdit(true)
	}

	const onCloseEditDiag = () => {
		setOpenEdit(false)
	}

	const onOpenDeleteDiag = () => {
		setOpenDelete(true)
	}

	const onCloseDeleteDiag = () => {
		setOpenDelete(false)
	}

	return (
		<div>
			<nav className="navbar navbar-expand-lg" data-bs-theme="dark" style={{ backgroundColor:"#141E61", height:"60px"}}>
				<div className="container-fluid">
					<Link class="navbar-brand mb-0 h1" to={isLoggedIn ? "/dashboard" : "/"}>
					<i className="fa-solid fa-train" style={{marginRight:"6px", marginLeft:"3px"}}></i>
						{isLoggedIn && ("Indian")} Railway
					</Link>
					<button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggler1" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
						<span className="navbar-toggler-icon"></span>
					</button>
					<div className="collapse navbar-collapse" id="navbarToggler1">
						<div className="navbar-nav">

							{!isLoggedIn && (
								<Link className="nav-link active" aria-current="page" to="/login">Sign in</Link>
							)}

							{!isLoggedIn && (
								<Link className="nav-link active" aria-current="page" to="/register">Sign up</Link>
							)}

							{isLoggedIn && (
								<div>
									<button className="nav-link active" aria-current="page"
									onClick={onOpenEditDiag}>Edit Profile</button>
									<Dialog open={openEdit} onClose={() => setOpenEdit(false)}>
										<EditProfile handleClose={onCloseEditDiag} />
									</Dialog>
								</div>
							)}

							{isLoggedIn && (
								<div>
									<button className="nav-link active" aria-current="page"
									onClick={onOpenDeleteDiag}>Delete Account</button>
									<Dialog open={openDelete} onClose={() => setOpenDelete(false)}>
										<DeleteProfile handleClose={onCloseDeleteDiag} handleLogout={onLogout} />
									</Dialog>
								</div>
							)}

							{isLoggedIn && (
								<button className="nav-link active" aria-current="page"
								onClick={onLogout}>Logout</button>
							)}
						</div>
					</div>
				</div>
			</nav>
		</div>
	)
}

export default Navbar