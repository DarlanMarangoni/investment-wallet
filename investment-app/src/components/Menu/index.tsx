import { useNavigate } from 'react-router-dom';
import { Menubar } from 'primereact/menubar';

export const Menu = () => {
    const navigate = useNavigate();

    const items = [
        {
            label: 'Home', icon: 'pi pi-fw pi-home', command: () => {
                navigate('/')
            }
        },
        {
            label: 'Ações', icon: 'pi pi-fw pi-dollar', command: () => {
                navigate('/stock')
            }
        },
        {
            label: 'Fundos imobiliários', icon: 'pi pi-fw pi-building', command: () => {
                navigate('/RealStateFund')
            }
        }
    ]

    return <Menubar model={items} />;
};