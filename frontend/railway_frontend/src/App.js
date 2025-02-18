import { Route, Routes } from 'react-router-dom'
import { ToastContainer } from 'react-toastify'
import Search from './components/Search';
import MainDisplay from './screens/MainDisplay';
import Register from './screens/Register';
import Login from './screens/Login';
import TrainList from './screens/TrainList';
import Dashboard from './screens/Dashboard';
import EditProfile from './screens/EditProfile';
import DeleteProfile from './screens/DeleteProfile';
import SearchByStationCode from './screens/SearchByStationCode';

function App() {
  return (
    <div>
      <Routes>
        <Route path='/' element={<MainDisplay />} />
        <Route path='/search' element={<Search />} />
        <Route path='/register' element={<Register />} />
        <Route path='/login' element={<Login />} />
        <Route path='/dashboard' element={<Dashboard />} />
        <Route path='/train-list' element={<TrainList />} />
        <Route path='/edit-profile' element={<EditProfile />} />
        <Route path='/delete-profile' element={<DeleteProfile />} />
        <Route path='/search-by-station-code' element={<SearchByStationCode />} />
      </Routes>
      <ToastContainer />
    </div>
  );
}

export default App;
