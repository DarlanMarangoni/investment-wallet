import './App.css';
import 'primereact/resources/themes/lara-dark-blue/theme.css';
import 'primeicons/primeicons.css';
import 'bootstrap/dist/css/bootstrap-grid.min.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Stock from './pages/Stock';
import RealStateFund from './pages/RealStateFund';
import { Menu } from './components/Menu';


function App() {
    return (
        <BrowserRouter>
            <Menu/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/Stock" element={<Stock/>}/>
                <Route path="/RealStateFund" element={<RealStateFund/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
