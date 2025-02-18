import Navbar from "../components/Navbar"
import { getTrainList } from "../services/train"
import { toast } from "react-toastify"
import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import { getAvailableSeats } from "../services/booking"


function TrainList() {

  const [trainList, setTrainList] = useState([])
  const [seats, setSeats] = useState([])
  const {stationFrom, stationTo, date} = JSON.parse(sessionStorage.getItem("searchData")) || {}

  const navigate = useNavigate()

  const onLoadList = async () => {
    const result = await getTrainList(stationFrom, stationTo, date)
    if(result.status === 200) {
      setTrainList(result.data)
    }
    else if(result.status === 500) {
      toast.error("Something went wrong!")
      navigate("/")
    }
    else {
      toast.error(result.message)
      navigate("/")
    }
  }

  const onLoadSeat = async (trainNumber) => {
    const result = await getAvailableSeats(trainNumber, date)
      if(result.status === 200) {
        setSeats(result.data)
      }
      else {
        toast.error(result.message)
      }
  }

  useEffect(() => {
      onLoadList()

    return () => {}
  })

  const formatTime = (time) => {
    return time ? time.split(":").slice(0, 2).join(":") : "--";
  };

  return (
    <div>
      <Navbar />
      <div className="below-nav-div">
        <h2 className="below-nav-head">Train List</h2>
      </div>
      {trainList.map((train, index) => {
        return (
          <div key={index} className="row mb-3">
            <div className="col-3"></div>
            <div className="col-6 p-3 shadow-sm rounded" style={{backgroundColor:"rgb(235, 235, 235)"}}>
              <p><b>{train.trainNumber} - {train.trainName}</b></p>
              <div className="train-list">
                <div>
                  <p><b>From:</b> {train.fromStation}</p>
                  <p className="trainList-para"><b>Arrival Time:</b> {formatTime(train.fromStationArrival)}</p>
                  <p className="trainList-para"><b>Departure Time:</b> {formatTime(train.fromStationDeparture)}</p>
                </div>
                <div>
                  <p><b>To:</b> {train.toStation}</p>
                  <p className="trainList-para"><b>Arrival Time:</b> {formatTime(train.toStationArrival) }</p>
                  <p className="trainList-para"><b>Departure Time:</b> {formatTime(train.toStationDeparture)}</p>
                </div>
              </div>
              <div class="collapse" id={index}>
                <hr style={{marginTop:"0px"}} />
                {seats.map((s, index1) => {
                  return (
                    <div key={index1}>
                      <div className="train-list1 mb-2 ">
                        <div>{s.className}</div>
                        <div>Available Seats: {s.availableSeats}</div>
                        <div>Fare: {s.fare}</div>
                        <button className="btn" style={{width:"80px", backgroundColor:"#B3CFF2", color:"black"}} 
                        >Book</button>
                      </div>
                    </div>
                  )
                })}
              </div>
              <div className="train-list">
                <button className="btn mt-2" style={{backgroundColor:"#1c1c84", color:"white"}}>Train Schedule</button>
                <button className="btn mt-2" style={{backgroundColor:"#1c1c84", color:"white"}} 
                type="button" data-bs-toggle="collapse" data-bs-target={`#${index}`} aria-expanded="false" aria-controls="collapseExample" 
                onClick={() => onLoadSeat(train.trainNumber)} >Check Seats</button>
              </div>
            </div>
            <div className="col-3"></div>
          </div>
        )
      })}

          {/* <div className="row mb-3">
            <div className="col-3"></div>
            <div className="col-6 p-3 shadow-sm rounded" style={{backgroundColor:"rgb(235, 235, 235)"}}>
              <p><b>22655 - TVC NZM EXPRESS</b></p>
              <div className="train-list">
                <div>
                  <p><b>From:</b> TVC</p>
                  <p className="trainList-para"><b>Arrival Time:</b> 00:00</p>
                  <p className="trainList-para"><b>Departure Time:</b> 00:00</p>
                </div>
                <div>
                  <p><b>To:</b> NZM</p>
                  <p className="trainList-para"><b>Arrival Time:</b> 00:00</p>
                  <p className="trainList-para"><b>Departure Time:</b> 00:00</p>
                </div>
              </div>
              <div class="collapse" id="seatAvailability">
                <hr style={{marginTop:"0px"}} />
                <div className="train-list1 mb-2 ">
                  <div>Sleeper</div>
                  <div>Available Seats: 40</div>
                  <div>Fare: 400</div>
                  <button className="btn" style={{width:"80px", backgroundColor:"#B3CFF2", color:"black"}}>Book</button>
                </div>
                <div className="train-list1  mb-2 ">
                  <div>Sleeper</div>
                  <div>Available Seats: 40</div>
                  <div>Fare: 400</div>
                  <button className="btn" style={{width:"80px", backgroundColor:"#B3CFF2", color:"black"}}>Book</button>
                </div>
              </div>
              <div className="train-list">
                <button className="btn mt-2" style={{backgroundColor:"#1c1c84", color:"white"}}>Train Schedule</button>
                <button className="btn mt-2" style={{backgroundColor:"#1c1c84", color:"white"}} 
                type="button" data-bs-toggle="collapse" data-bs-target="#seatAvailability" aria-expanded="false" aria-controls="collapseExample" >Check Seats</button>
              </div>
            </div>
            <div className="col-3"></div>
          </div> */}
          
    </div>
  )
}

export default TrainList