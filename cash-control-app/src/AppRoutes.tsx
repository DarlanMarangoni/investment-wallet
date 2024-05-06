import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import IncomePage from './pages/IncomePage';

const AppRoutes = () => (
  <BrowserRouter>
    <Navbar />
    <Routes>
      <Route path="/" element={<Home />}/>
      <Route path="/income" element={<IncomePage />}/>
    </Routes>
  </BrowserRouter>
);

export default AppRoutes;