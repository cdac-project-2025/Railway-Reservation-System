import { useEffect, useState } from "react"
import Navbar from "../components/Navbar"
import Search from "../components/Search"
import { getUserDetails } from "../services/user"
import { Link } from "react-router-dom";


function Dashboard() {
  const [userName, setUserName] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
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

  useEffect(() => {
    onLoadDetails()

    return () => {}
  }, [])

  return (
    <div className="view">
      <Navbar />
      <div className="main-disp">
        <div style={{backgroundColor:"rgb(235, 235, 235)", width:"97%"}}>
          <div style={{padding:"10px"}}>
            <h5><b>Welcome, {userName}</b></h5>
          </div>
          <div style={{backgroundColor:"#141E61", padding:"15px"}}>
            <h3 style={{color:"white"}}>{name}</h3>
            <h6 style={{color:"white"}}>Email: {email}</h6>
            <h6 style={{color:"white"}}>Contact No: {phoneNo}</h6>
            <div className="main-cont1">
              <div style={{width:"50%"}}>
                <Search />
              </div>
              <div className="rounded p-3" style={{backgroundColor:"rgb(235, 235, 235)", width:"50%", height:"423px"}}>
                <h3 style={{color:"#1c1c84"}}>Recent Searches</h3>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div style={{marginTop:"70px"}}>
        <h1 style={{textAlign:"center", color:"#1c1c84"}}>Find a service suitable for you here.</h1>
        <div className="service container">
          <div className="icons">
            <Link className="fa-solid fa-location-dot" to="/search-by-station-code"></Link>
            <p>Search By Station</p>
          </div>
          <div className="icons">
            <Link className="fa-solid fa-train-subway" to="/"></Link>
            <p>Search By Train Number</p>
          </div>
          <div className="icons">
            <Link className="fa-regular fa-clock"></Link>
            <p>Arrival Time Predictor</p>
          </div>
          <div className="icons">
            <Link className="fa-solid fa-ban"></Link>
            <p>Cancelled Trains</p>
          </div>
          <div className="icons">
            <Link className="fa-solid fa-train-tram"></Link>
            <p>Diverted Trains</p>
          </div>
          <div className="icons">
            <Link className="fa-regular fa-clock"></Link>
            <p>Train Schedules</p>
          </div>
          <div className="icons">
            <Link className="fa-solid fa-chair"></Link>
            <p>Seat Availability</p>
          </div>
          <div className="icons">
            <Link className="fa-solid fa-train"></Link>
            <p>Live Status</p>
          </div>
          <div className="icons">
            <Link className="fa-solid fa-headphones-simple"></Link>
            <p>Customer Service</p>
          </div>
          <div className="icons">
            <Link className="fa-regular fa-circle-question"></Link>
            <p>HelpDesk</p>
          </div>
        </div>
        <br />
        <br />
        <br />
        <br />
        <br />
      </div>
    </div>
  )
} 

export default Dashboard