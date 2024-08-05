import './App.css';
import 'primereact/resources/themes/lara-dark-blue/theme.css';
import 'primeicons/primeicons.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import { Menubar } from 'primereact/menubar';
import Stock from './pages/Stock';
import RealStateFund from './pages/RealStateFund';

function App() {
    const items = [
        {label: 'Home', icon: 'pi pi-fw pi-home'},
        {label: 'Ações', icon: 'pi pi-fw pi-dollar'},
        {label: 'Fundos imobiliários', icon: 'pi pi-fw pi-building'}
    ]
    return (
            <BrowserRouter>
                <Menubar model={ items }/>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/Stock" element={<Stock />} />
                    <Route path="/RealStateFund" element={<RealStateFund />} />
                </Routes>
            </BrowserRouter>
    );
}

export default App;
