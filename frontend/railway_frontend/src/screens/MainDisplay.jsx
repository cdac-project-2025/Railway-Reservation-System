import Search from '../components/Search'
import Navbar from '../components/Navbar';


function MainDisplay() {
  return (
    <div className="bg-img view">
      <Navbar />
      <div className="container cont1">
        <div>
          <Search />
        </div>
        <div className="shadow p-2 rounded" style={{backgroundColor:"#141E61"}}>
          <h1 className="head">Indian Railways</h1>
        </div>
      </div>
    </div>
  )
}

export default MainDisplay