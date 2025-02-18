import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import { toast } from "react-toastify"


function Search() {

  const [stationFrom, setStationFrom] = useState("")
  const [stationTo, setStationTo] = useState("")
  const [tClass, setTClass] = useState("")
  const [quota, setQuota] = useState("")
  const [date, setDate] = useState("")

  const navigate = useNavigate();

  const onSearch = () => {
    if(stationFrom.length === 0)
      toast.warning("Please enter source")
    else if(stationTo.length === 0)
      toast.warning("Please enter destination")
    else if(tClass === "")
      toast.warning("Please enter train class")
    else if(quota === "")
      toast.warning("Please enter quota")
    else if(date === "")
      toast.warning("Please enter date")
    else{
      const searchData = {stationFrom, stationTo, date}
      sessionStorage.setItem("searchData", JSON.stringify(searchData));
      navigate('/train-list')
    }
  }

  useEffect(() => {
    sessionStorage.removeItem("searchData")

    return () => {}
  }, [])

  const getCurrentDate = () => {
    const today = new Date();
    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, "0");
    const day = String(today.getDate()).padStart(2, "0");
    return `${year}-${month}-${day}`;
  };

  return (
    <div className="container">
      <div class="shadow rounded" style={{ backgroundColor:"rgb(235, 235, 235)", padding:"15px"}}>
        <div className="row mb-4">
          <div className="col">
            <h1 style={{ textAlign:"center", color:"#1c1c84"}}>Book Tickets</h1>
          </div>
        </div>
        <div className="row mb-4">
          <div className="col">
            <div className="form-floating">
              <input type="text" name="from" className="form-control" placeholder="" 
              onChange={(e) => setStationFrom(e.target.value)} />
              <label>From*</label>
            </div>
          </div>
          <div className="col">
            <div className="form-floating">
              <input type="text" name="to" className="form-control" placeholder="" 
              onChange={(e) => setStationTo(e.target.value)} />
              <label>To*</label>
            </div>
          </div>
        </div>
        <div className="row mb-4">
          <div className="col">
            <div className="form-floating">
              <select name="allClasses" className="form-select" onChange={(e) => setTClass(e.target.value)} >
                <option selected>select class</option>
                <option value="allClasses">All Classes</option>
                <option value="acFirstClass">AC First Class (1A)</option>
                <option value="acSecondClass">AC Second Class (2A)</option>
                <option value="acThirdClass">AC Third Class (3A)</option>
                <option value="acChairCar">AC Chair Car</option>
                <option value="nonAcChairCar">Non-AC Chair Car</option>
                <option value="sleeper">Sleeper</option>
              </select>
              <label>Class</label>
            </div>
          </div>
          <div className="col">
            <div className="form-floating">
              <select name="quota" className="form-select" onChange={(e) => setQuota(e.target.value)} >
                <option selected>select quota</option>
                <option value="general">General</option>
                <option value="ladies">Ladies</option>
                <option value="seniorCitizen">Senior Citizen</option>
                <option value="personWithDisability">Person With Disability</option>
                <option value="dutyPass">Duty Pass</option>
                <option value="tatkal">Tatkal</option>
                <option value="premiumTatkal">Premium Tatkal</option>
              </select>
              <label>Quota</label>
            </div>
          </div>
        </div>
        <div className="row mb-4">
          <div className="col-3"></div>
          <div className="col">
            <div className="form-floating">
              <input type="date" name="date" className='form-control' min={getCurrentDate()} 
              onChange={(e) => setDate(e.target.value)} />
              <label>Date*</label>
            </div>
          </div>
          <div className="col-3"></div>
        </div>
        <div className="row mb-4">
          <div style={{textAlign:"center"}}>
            <button className="btn" style={{backgroundColor:"#1c1c84", color:"white", width:"120px"}} 
            onClick={onSearch} >Search</button>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Search