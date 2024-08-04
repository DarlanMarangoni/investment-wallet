import './App.css';
import 'primereact/resources/themes/lara-dark-blue/theme.css';
import 'primeicons/primeicons.css';
import { Menubar } from 'primereact/menubar';

function App() {
    const items = [
        {label: 'Home', icon: 'pi pi-fw pi-home'},
        {label: 'Ações', icon: 'pi pi-fw pi-dollar'},
        {label: 'Fundos imobiliários', icon: 'pi pi-fw pi-building'}
    ]
    return (
        <div className="App">
            <Menubar model={items}/>
        </div>
    );
}

export default App;
