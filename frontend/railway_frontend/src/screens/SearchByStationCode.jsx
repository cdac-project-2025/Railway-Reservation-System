import Navbar from "../components/Navbar"


function SearchByStationCode() {



  return (
    <div>
      <Navbar />
      <div style={{backgroundColor:"rgb(235, 235, 235)"}}>
        <div className="row" style={{padding:"15px"}}>
          <div className="col"></div>
          <div className="col">
            <div className="search-bar">
            <div className="form-floating" style={{width:"350px"}}>
              <input type="text" name="from" className="form-control" placeholder=""  />
              <label>Station Code*</label>
            </div>
            <div style={{textAlign:"center"}}>
              <button className="btn" style={{backgroundColor:"#1c1c84", color:"white", width:"100px"}} 
              >Search</button>
            </div>
            </div>
            
          </div>
          <div className="col"></div>
          </div>
      </div>
      {/* <div className="container">
        <table style={{textAlign:"center"}}>
          <thead style={{backgroundColor:"aliceblue"}}> 
            <tr>
              <th>Train Number</th>
              <th>Train Name</th>
              <th>Arrival Time</th>
              <th>Departure Time</th>
              <th>Source</th>
              <th>Destination</th>
              <th>Halt</th>
            </tr>
          </thead>
          <tbody>
            <tr >
              <td>22655</td>
              <td>BPL NZM EXPRESS</td>
              <td>05:25</td>
              <td>05:40</td>
              <td>BPL</td>
              <td>NZM</td>
              <td>--</td>
            </tr>
            <tr>
              <td>22655</td>
              <td>BPL NZM EXPRESS</td>
              <td>05:25</td>
              <td>05:40</td>
              <td>BPL</td>
              <td>NZM</td>
              <td>--</td>
            </tr>
          </tbody>
        </table>
      </div> */}
    </div>
  )
}

export default SearchByStationCode